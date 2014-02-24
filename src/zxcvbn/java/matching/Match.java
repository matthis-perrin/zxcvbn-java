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

import java.util.ArrayList;

/**
 *
 * @author Matthis Perrin <matthis.perrin at gmail.com>
 */
public abstract class Match {
  
  
  /**
   * @return the <code>String</code> value of the <code>Match</code>
   */
  public abstract String getToken ();
  
  
  /**
   * Calculate the entropy for the current match
   * @return a <code>String</code> representing the entropy of the current match
   */
  public abstract double calculateEntropy ();
  
  
  /**
   * Take a password and extract all the matching sub-patterns.
   * @param password the password as a <code>String</code>
   * @return a collection of all the matching sub-patterns
   */
  public static ArrayList<Match> match (String password) {
    return new ArrayList<>();
  }
  
  
}