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
public class SequenceMatch extends BasicMatch {
  
  
  private final char firstCharacter;
  private final int length;
  private final boolean asc;
  
  
  /**
   * Create a new <code>SequenceMatch</code> which is a sequence of characters 
   * that are following each other (e.g. abcd, 987, RST...)
   * @param match a <code>String</code> that is a sequence of characters
   * @param asc determine if the sequence is ascending (true) or descending 
   *            (false)
   */
  public SequenceMatch (String match, boolean asc) {
    super(match);
    this.firstCharacter = match.charAt(0);
    this.length = match.length();
    this.asc = asc;
  }
  
  
  /**
   * Calculate the entropy for the current match
   * @return a <code>String</code> representing the entropy of the current match
   */
  @Override
  public double calculateEntropy () {
  char firstChar = getFirstCharacter();
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
    if (!isAscending()) {
      baseEntropy++;
    }
    
    return baseEntropy + log2(getLength());
  }

  
  
  /**
   * @return the first character of the sequence
   */
  public char getFirstCharacter () {
    return firstCharacter;
  }

  
  /**
   * @return the length of the sequence
   */
  public int getLength () {
    return length;
  }
  
  
  /**
   * @return <code>true</code> if the sequence is ascending, <code>flase</code>
   *         otherwise
   */
  public boolean isAscending () {
    return asc;
  }
  
  
}
