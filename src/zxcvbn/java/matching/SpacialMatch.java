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

import zxcvbn.java.resources.AdjacencyGraph;

/**
 *
 * @author Matthis Perrin <matthis.perrin at gmail.com>
 */
public class SpacialMatch extends BasicMatch {
  
  
  private final boolean isKeyboard;
  private final int turns;
  private final int shiftedCount;
  
  
  /**
   * Create a new <code>SpacialMatch</code> which is a sequence of characters
   * following themselves on the keyboard/keypad
   * @param match a <code>String</code> containing a sequence of characters
   * following themselves on the keyboard/keypad
   * @param isKeyboard defines if the user is using the keyboard (as opposed to
   * using the keypad)
   * @param turns
   * @param shiftedNumber
   */
  public SpacialMatch (String match, boolean isKeyboard, int turns, 
                       int shiftedNumber) {
    super(match);
    this.isKeyboard = isKeyboard;
    this.turns = turns;
    this.shiftedCount = shiftedNumber;
  }

  
  @Override
  public double calculateEntropy() {
    // Size of the keyboard used
    int size = isKeyboard ? AdjacencyGraph.qwerty.size() : 
                            AdjacencyGraph.keypad.size();
    
    // Average degree of the keyboard used
    double avgDegree = isKeyboard ? AdjacencyGraph.KEYBOARD_AVERAGE_DEGREE : 
                                    AdjacencyGraph.KEYPAD_AVERAGE_DEGREE;
    
    // Estimated the number of possible patterns for the password length and
    // the number of turn
    long possibilities = 0;
    int length = getToken().length();
    for (int i = 2; i <= length; i++) {
      int possibleTurns = Math.min(turns, i - 1);
      for (int j = 1; j <= possibleTurns; j++) {
        possibilities += nCk(i - 1, j - 1) * size * Math.pow(avgDegree, j);
      }
    }
    
    double entropy = log2(possibilities);
    
    // Add extra entropy for the shifted keys
    if (shiftedCount > 0) {
      int unshiftedCount = length - shiftedCount;
      int min = Math.min(shiftedCount, unshiftedCount);
      possibilities = 0;
      for (int i = 0; i <= min; i++) {
        possibilities += nCk(length, i);
      }
      entropy += log2(possibilities);
    }
    
    return entropy;
  }
  
  
  /**
   * @return true if the user is using the keyboard (as opposed to using the 
   * keypad), false otherwise
   */
  public boolean isIsKeypad() {
    return isKeyboard;
  }

  
  /**
   * @return the number of turns the user makes on the keyboard. 'zxcv' has a
   * turn of 1, 'zxcvfr' has a turn of 2, 'zxcvfrewq' has a turn of 3, etc.
   */
  public int getTurns() {
    return turns;
  }

  
  /**
   * @return the number of key that are shifted (% instead of 5, A instead of a)
   */
  public int getShiftedNumber() {
    return shiftedCount;
  }
  
  
  
}
