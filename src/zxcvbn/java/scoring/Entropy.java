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

package zxcvbn.java.scoring;

import zxcvbn.java.matching.DateMatch;
import zxcvbn.java.matching.DigitMatch;
import zxcvbn.java.matching.RepeatMatch;
import zxcvbn.java.matching.SequenceMatch;
import zxcvbn.java.matching.YearMatch;

/**
 *
 * @author Matthis Perrin <matthis.perrin at gmail.com>
 */
public class Entropy {
  
  
  /**
   * Calculate the base 2 logarithm of a value
   * @param value the <code>double</code> we are calculating the log from
   * @return 
   */
  public static double log2 (double value) {
    return Math.log(value) / LOG_2;
  }
  
  // Precomputed log value used during etropy calculation
  private static final double LOG_2 = Math.log(2d);
  private static final double LOG_10 = log2(10d);
  private static final double LOG_26 = log2(26d);
  private static final double LOG_119 = log2(119d);
  private static final double LOG_37200 = log2(37200d);
  private static final double LOG_44268 = log2(44268d);
  
  
  /**
   * Calculate the entropy of a repeated a character
   * @param match a <code>RepeatMatch</code>
   * @return the entropy of the match
   */
  public static double calculateRepeatEntropy (RepeatMatch match) {
    int cardinality = BruteForce.getBrutForceCardinality(match);
    return Math.max(0, log2(cardinality * match.getRepeat()));
  }
  
  
  /**
   * Calculate the entropy of a sequence of character that are following each
   * other (e.g. abcd, 1234, RST...)
   * @param match a <code>SequenceMatch</code>
   * @return the entropy of the match
   */
  public static double calculateSequenceEntropy (SequenceMatch match) {
    char firstChar = match.getFirstCharacter();
    double baseEntropy;
    
    // A sequence that starts with a 'a' or a '1' is very weak
    if (firstChar == 'a' || firstChar == '1') {
      baseEntropy = 1d;
    }
    // Digit sequence don't have a lot of entropy
    else if (Character.isDigit(firstChar)) {
      baseEntropy = LOG_10;
    }
    // Alpha sequence have more entropy
    else if (Character.isLowerCase(firstChar)) {
      baseEntropy = LOG_26;
    }
    // We give an extra bit of entropy for upper case sequence
    else {
      baseEntropy = LOG_26 + 1d;
    }
    
    // An other extra bit of entropy if the sequence is descending
    if (!match.isAscending()) {
      baseEntropy++;
    }
    
    return baseEntropy + log2(match.getLength());
  }
  
  
  /**
   * Calculate the entropy of a <code>DigitMatch</code> composed only of digits
   * @param match a <code>DigitMatch</code>
   * @return the entropy of the match
   */
  public static double calculateDigitsEntropy (DigitMatch match) {
    return log2(Math.pow(10, match.getLength()));
  }
  
  
  /**
   * Calculate the entropy of a <code>YearMatch</code> that represents a year
   * @param match a <code>YearMatch</code>
   * @return the entropy of the match
   */
  public static double calculateYearEntropy (YearMatch match) {
    return LOG_119;
  }
  
  
  /**
   * Calculate the entropy of a <code>DateMatch</code> which represents a date
   * @param match a <code>DateMatch</code>
   * @return the entropy of the match
   */
  public static double calculateDateEntropy (DateMatch match) {
    double entropy;
    
    // Two digits year
    if (match.getYear() < 100) {
      entropy = LOG_37200; // 31 * 12 * 100
    }
    // Four digits year
    else {
      entropy = LOG_44268; // 31 * 12 * 119
    }
    
    // Add two bits of entropy if there is a separator
    if (!match.getSeparator().isEmpty()) {
      entropy += 2;
    }
    
    return entropy;
  }
  
  
}
