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
public class YearMatch extends BasicMatch {

  
  /**
   * Create a new <code>YearMatch</code> which is a <code>String</code>
   * that represents a year.
   * @param match a <code>String</code> representing a year
   */
  public YearMatch (String match) {
    super(match);
  }
  
  
  /**
   * Calculate the entropy for the current match
   * @return a <code>String</code> representing the entropy of the current match
   */
  @Override
  public double calculateEntropy () {
    return LOG_119;
  }
  
  
}
