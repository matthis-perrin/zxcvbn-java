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

import zxcvbn.java.scoring.BruteForce;

/**
 *
 * @author Matthis Perrin <matthis.perrin at gmail.com>
 */
public class RepeatMatch extends BasicMatch {
  
  
  private final char character;
  private final int repeat;
  
  
  /**
   * Create a new <code>RepeatMatch</code> which is a <code>String</code>
   * repeating the same <code>char</code>
   * @param match a <code>String</code> repeating a <code>char</code>
   */
  public RepeatMatch (String match) {
    super(match);
    this.character = match.charAt(0);
    this.repeat = match.length();
  }
  
  
  @Override
  public double calculateEntropy () {
    int cardinality = BruteForce.getBrutForceCardinality(getToken());
    return Math.max(0, log2(cardinality * getRepeat()));
  }

  
  
  /**
   * @return the character that is repeated in the token
   */
  public char getCharacter () {
    return character;
  }

  
  /**
   * @return how many time the character is repeating in the token
   */
  public int getRepeat () {
    return repeat;
  }
  
  
}
