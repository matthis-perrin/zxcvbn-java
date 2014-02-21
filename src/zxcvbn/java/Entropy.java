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

package zxcvbn.java;

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
  private static final double LOG_2 = Math.log(2d);
  private static final double LOG_10 = log2(10d);
  private static final double LOG_26 = log2(26d);
  
  
  /**
   * Calculate the entropy of a repeated a character
   * @param match a <code>String</code> which is the same character repeated
   *              several times.
   * @return the entropy of the value
   */
  public static double calculateRepeatEntropy (String match) {
    int cardinality = BruteForce.getBrutForceCardinality(match);
    return Math.max(0, log2(cardinality * match.length()));
  }
  
  
  /**
   * Calculate the entropy of a sequence of character that are following each
   * other (e.g. abcd, 1234, RST...)
   * @param match the sequence of character
   * @param asc describes if the sequence is ascending (true) or descending 
   *            (false)
   * @return the entropy of the sequence
   */
  public static double calculateSequenceEntropy (String match, boolean asc) {
    if (match.isEmpty()) {
      return 0;
    }
    
    char firstChar = match.charAt(0);
    double baseEntropy;
    
    if (firstChar == 'a' || firstChar == '1') {
      baseEntropy = 1d;
    }
    else if (Character.isDigit(firstChar)) {
      baseEntropy = LOG_10;
    }
    else if (Character.isLowerCase(firstChar)) {
      baseEntropy = LOG_26;
    }
    else {
      baseEntropy = LOG_26 + 1d;
    }
    
    if (!asc) {
      baseEntropy++;
    }
    
    return baseEntropy + log2(match.length());
  }
  
  
  /**
   * Calculate the entropy a <code>String</code> composed only of digits
   * @param match a <code>String</code> composed only of digits
   * @return the entropy of the value
   */
  public static double calculateDigitsEntropy (String match) {
    return log2(Math.pow(10, match.length()));
  }
  
  
}
