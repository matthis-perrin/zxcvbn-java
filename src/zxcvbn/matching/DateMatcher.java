/*
 * Copyright 2014 Matthis Perrin <matthis.perrin at gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package zxcvbn.matching;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author Matthis Perrin <matthis.perrin at gmail.com>
 */
public class DateMatcher {
  
  
  private static final Pattern DATE_WITHOUT_SEPARATOR = Pattern.compile("^\\d{4,8}$");
  
  
  /**
   * Look for every part of the password that is a date
   * @param password the password that is analyzed
   * @return the list of all the date found
   */
  public static ArrayList<DateMatch> match (String password) {
  
    System.out.println(password);
    System.out.println("");
    
    ArrayList<DateMatch> dateMatches = matchDatesWithoutSeparator(password);
    
    for (DateMatch m : dateMatches) {
      System.out.println(m.getDay() + " " + m.getMonth() + " " + m.getYear());
    }
    
    return dateMatches;
    
  }
  
  
  /**
   * Extract all the possible dates without separator from a password
   * @param password the password that is analyzed
   * @return the list of all the date without separator found
   */
  private static ArrayList<DateMatch> matchDatesWithoutSeparator (String password) {
    
    // Initialize the list of matching dates
    ArrayList<DateMatch> dateMatches = new ArrayList<>();
    
    // Create all possible subsequences of the password
    for (int start = 0; start < password.length(); start++) {
      for (int end = start + 4; end <= password.length(); end++) {
        
        // Get the subsequence
        String passwordChunk = password.substring(start, end);
        
        // Quick verfication that it is made of numbers
        if (DATE_WITHOUT_SEPARATOR.matcher(passwordChunk).find()) {
          
          // Extract the possible combinaison of dateAndMonth/year from the 
          // subsequence (eg: 121234 => 1212/34 and 12/1234)
          ArrayList<PartialDateSplit> possiblePartialSplit = new ArrayList<>();
          int chunkLength = passwordChunk.length();
          if (chunkLength <= 6) {
            // start with a 2 digits year
            possiblePartialSplit.add(new PartialDateSplit(
              passwordChunk.substring(2), 
              passwordChunk.substring(0, 2)
            ));
            // end with a 2 digits year
            possiblePartialSplit.add(new PartialDateSplit(
              passwordChunk.substring(0, chunkLength - 2), 
              passwordChunk.substring(chunkLength - 2, chunkLength)
            ));
          }
          if (chunkLength >= 6) {
            // start with a 4 digits year
            possiblePartialSplit.add(new PartialDateSplit(
              passwordChunk.substring(4), 
              passwordChunk.substring(0, 4)
            ));
            // end with a 4 digits year
            possiblePartialSplit.add(new PartialDateSplit(
              passwordChunk.substring(0, chunkLength - 4), 
              passwordChunk.substring(chunkLength - 4, chunkLength)
            ));
          }
          
          // For each dateAndMonth/year extract the different possible full date
          // (eg: 123/1998 => 1/23/1998 and 12/3/1998)
          ArrayList<FullDateSplit> possibleFullSplit = new ArrayList<>();
          for (PartialDateSplit split : possiblePartialSplit) {
            int dateAndMonthLength = split.dateAndMonth.length();
            if (dateAndMonthLength == 2) {
              possibleFullSplit.add(new FullDateSplit(
                split.dateAndMonth.substring(0, 1), 
                split.dateAndMonth.substring(1, 2),
                split.year
              ));
            }
            else if (dateAndMonthLength == 3) {
              possibleFullSplit.add(new FullDateSplit(
                split.dateAndMonth.substring(0, 1), 
                split.dateAndMonth.substring(1, 2),
                split.year
              ));
              possibleFullSplit.add(new FullDateSplit(
                split.dateAndMonth.substring(0, 2), 
                split.dateAndMonth.substring(2, 3),
                split.year
              ));
            }
            else if (dateAndMonthLength == 4) {
              possibleFullSplit.add(new FullDateSplit(
                split.dateAndMonth.substring(0, 2), 
                split.dateAndMonth.substring(2, 4),
                split.year
              ));
            }
          }
          
          // Add to the final date list all the valid dates
          for (FullDateSplit split : possibleFullSplit) {
            ValidDateSplit vSplit = isDateValid(split.date, split.month, split.year);
            if (vSplit != null) {
              dateMatches.add(new DateMatch(vSplit.date, vSplit.month, vSplit.year, ""));
            }
          }
          
        }
      }
    }
    
    return dateMatches;
    
  }
  
  
  /**
   * Verify that a date is valid. Day and month can be swapped. year must be
   * two digit or four digit and between 1900 and 2020.
   * @param day the day of the date (or the month)
   * @param month the moth of the date (or the day)
   * @param year the year of the date
   * @return a valid date split object containing the date information if the
   * date is valid and <code>null</code> if the date is not valid.
   */
  private static ValidDateSplit isDateValid (String day, String month, String year) {
    try {
      int dayInt = Integer.parseInt(day);
      int monthInt = Integer.parseInt(month);
      int yearInt = Integer.parseInt(year);
      if (monthInt >= 12 && monthInt <= 31 && dayInt <= 12) {
        int save = dayInt;
        dayInt = monthInt;
        monthInt = save;
      }
      if (
        dayInt <= 0 || dayInt > 31 ||
        monthInt <= 0 || monthInt > 12 ||
        yearInt <= 0 || (yearInt >= 100 && (yearInt < 1900 || yearInt > 2019))
      ) {
        return null;
      }
      return new ValidDateSplit(dayInt, monthInt, yearInt);
    }
    catch (NumberFormatException e) {
      return null;
    }
  }
  
  
  // Represent a partial match during the parsing (contains the date and month
  // concatenated and the year)
  private static class PartialDateSplit {
    public String dateAndMonth;
    public String year;
    public PartialDateSplit(String dateAndMonth, String year) {
      this.dateAndMonth = dateAndMonth;
      this.year = year;
    }
  }
  
  // Represent a complete match during the parsing (date, month and year)
  private static class FullDateSplit {
    public String date;
    public String month;
    public String year;
    public FullDateSplit(String date, String month, String year) {
      this.date = date;
      this.month = month;
      this.year = year;
    }
  }
  
  // Represent a valid and parsed match (date, month and year as 
  // <code>int</code>)
  private static class ValidDateSplit {
    public int date;
    public int month;
    public int year;
    public ValidDateSplit(int date, int month, int year) {
      this.date = date;
      this.month = month;
      this.year = year;
    }
  }
  
  
}