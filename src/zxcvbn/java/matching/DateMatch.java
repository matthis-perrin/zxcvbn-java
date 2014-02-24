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

package zxcvbn.java.matching;

/**
 *
 * @author Matthis Perrin <matthis.perrin at gmail.com>
 */
public class DateMatch extends BasicMatch {
  
  
  private final int day;
  private final int month;
  private final int year;
  private final String separator;
  
  
  /**
   * Create a new <code>DateMatch</code> which is a <code>String</code> composed
   * of a day, a month, a year and a separator (that can be empty)
   * @param day the day of the date
   * @param month the month of the date
   * @param year the year of the date
   * @param separator the character between each date part
   */
  public DateMatch (int day, int month, int year, String separator) {
    super(String.valueOf(day) + separator + 
          String.valueOf(month) + separator + 
          String.valueOf(year));
    this.day = day;
    this.month = month;
    this.year = year;
    this.separator = separator;
  }
  
  
  @Override
  public double calculateEntropy () {
    double entropy;
    
    // Two digits year
    if (getYear() < 100) {
      entropy = LOG_37200; // 31 * 12 * 100
    }
    // Four digits year
    else {
      entropy = LOG_44268; // 31 * 12 * 119
    }
    
    // Add two bits of entropy if there is a separator
    if (!getSeparator().isEmpty()) {
      entropy += 2;
    }
    
    return entropy;
  }
  

  
  /**
   * @return the day of the date
   */
  public int getDay() {
    return day;
  }

  
  /**
   * @return the month of the date
   */
  public int getMonth() {
    return month;
  }

  
  /**
   * @return the year of the date
   */
  public int getYear() {
    return year;
  }

  
  /**
   * @return the character between each date component
   */
  public String getSeparator() {
    return separator;
  }
  
  
}
