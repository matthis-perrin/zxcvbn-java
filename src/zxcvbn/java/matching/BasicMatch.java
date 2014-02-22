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
public class BasicMatch extends Match {

  
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
  
  
}
