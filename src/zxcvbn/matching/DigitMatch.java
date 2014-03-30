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

/**
 *
 * @author Matthis Perrin <matthis.perrin at gmail.com>
 */
public class DigitMatch extends BasicMatch {
  
  
  private final int length;
  
  
  /**
   * Create a new <code>DigitMatch</code> which is a <code>String</code>
   * containing only digits
   * @param match a <code>String</code> containing only digits
   */
  public DigitMatch (String match) {
    super(match);
    this.length = match.length();
  }
  
  
  /**
   * Calculate the entropy for the current match
   * @return a <code>String</code> representing the entropy of the current match
   */
  @Override
  public double calculateEntropy () {
    return log2(Math.pow(10, getLength()));
  }

  
  
  /**
   * @return the length of the match
   */
  public int getLength () {
    return length;
  }
  
  
}
