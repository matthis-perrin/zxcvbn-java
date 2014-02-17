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
public class BruteForce {
  
  
  /**
   * Calculates the brut force cardinality of a given password.
   * The brut force cardinality is the estimated range of character a brut
   * force method would use to crack the password.
   * @param password the password we are estimating the brut force cardinality
   * @return the brut force cardinality
   */
  public static int calculateBrutForceCardinality (String password) {
    
    boolean lower   = false, 
            upper   = false, 
            digits  = false, 
            symbols = false, 
            unicode = false;
    
    for (char c : password.toCharArray()) {
      if (0x30 <= c && c <= 0x39) digits = true;
      else if (0x41 <= c && c <= 0x5a) upper = true;
      else if (0x61 <= c && c <= 0x7a) lower = true;
      else if (c <= 0x7f) symbols = true;
      else unicode = true;
    }
    
    int c = 0;
    if (digits) c += 10;
    if (upper) c += 26;
    if (lower) c += 26;
    if (symbols) c += 33;
    if (unicode) c += 100;
    
    return c;
    
  }
  
}
