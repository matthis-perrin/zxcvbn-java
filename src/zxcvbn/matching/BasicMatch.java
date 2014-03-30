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
public abstract class BasicMatch extends Match {

  
  private final String token;
  
  
  /**
   * Create a new <code>BasicMatch</code> from a simple <code>String</code>
   * @param match the <code>String</code> we are creating the 
   *              <code>BasicMatch</code> from
   */
  public BasicMatch (String match) {
    if (match == null) throw new IllegalArgumentException("Null String");
    if (match.isEmpty()) throw new IllegalArgumentException("Empty String");
    this.token = match;
  }
  
  
  /**
   * @return the <code>String</code> value of the <code>BasicMatch</code>
   */
  @Override
  public String getToken () {
    return token;
  }
  
  
  
  /**
   * Calculate the base 2 logarithm of a value
   * @param value the <code>double</code> we are calculating the log from
   * @return 
   */
  protected static double log2 (double value) {
    return Math.log(value) / LOG_2;
  }
  
  
  // Precomputed log values used during etropy calculation
  protected static final double LOG_2 = Math.log(2d);
  protected static final double LOG_10 = log2(10d);
  protected static final double LOG_26 = log2(26d);
  protected static final double LOG_119 = log2(119d);
  protected static final double LOG_37200 = log2(37200d);
  protected static final double LOG_44268 = log2(44268d);
  
  
  /**
   * Calculate binomial coefficients (the number of possible "choose k among n")
   * @param n the total size of the set
   * @param k the size of the selection
   * @return the binomial coefficient
   */
  protected static final long nCk (int n, int k) {
    if (k > n) return 0;
    long result = 1;
    for (int i = 1; i <= k; i++) {
      result *= n--;
      result /= i;
    }
    return result;
  }
  
  
}
