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

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Matthis Perrin <matthis.perrin at gmail.com>
 */
public class DictionnaryMatch extends BasicMatch {

  
  private final int rank;
  private final boolean isL33t;
  private final HashMap<Character, Character> l33tSubstitution;

  
  /**
   * Create a new <code>DictionnaryMatch</code> which is a password that is
   * registered in one of the dictionaries
   * @param match a <code>String</code> containing the password
   * @param rank the rank of the password in the dictionary
   * @param isL33t true if the password is written in l33t
   * @param l33tSubstitution hash map of the l33t substitution
   */
  public DictionnaryMatch (String match, int rank, boolean isL33t,
                           HashMap<Character, Character> l33tSubstitution) {
    super(match);
    this.rank = rank;
    this.isL33t = isL33t;
    this.l33tSubstitution = l33tSubstitution;
  }

  
  /**
   * Calculate the entropy for the current match
   * @return a <code>String</code> representing the entropy of the current match
   */
  @Override
  public double calculateEntropy () {
    // First the base entropy based on the rank
    double baseEntropy = log2(rank);
    
    // Then the extra entropy provided by uppercase
    double uppercaseEntropy = uppercaseEntropy();
    
    // Finally the extra entropy provided by l33t character
    double l33tEntropy = l33tEntropy();
    
    return baseEntropy + uppercaseEntropy + l33tEntropy;
  }
  
  
  /**
   * @return the additional entropy provided by uppercase
   */
  private double uppercaseEntropy () {
    String password = getToken();
    
    // Common uppercase pattern
    if (password.matches(ALL_LOWER))   return 0d;
    if (password.matches(START_UPPER)) return 1d;
    if (password.matches(ALL_UPPER))   return 1d;
    if (password.matches(END_UPPER))   return 1d;
    
    // Count the number of upper case characters
    int upperCount = 0;
    for (char c : password.toCharArray()) {
      if (Character.isUpperCase(c)) {
        upperCount++;
      }
    }
    
    // Count the number of lower case characters
    int lowerCount = 0;
    for (char c : password.toCharArray()) {
      if (Character.isLowerCase(c)) {
        lowerCount++;
      }
    }
    
    // Calculate all the possibilies
    int possiblities = 0;
    int totalCase = upperCount + lowerCount;
    int minCase = Math.min(upperCount, lowerCount);
    for (int i = 0; i <= minCase; i++) {
      possiblities += nCk(totalCase, i);
    }
    
    return Math.max(log2(possiblities), 1);
  }
  private static final String START_UPPER = "^[A-Z][^A-Z]+";
  private static final String END_UPPER = "^[^A-Z]+[A-Z]$";
  private static final String ALL_UPPER = "^[^a-z]+$";
  private static final String ALL_LOWER = "^[^A-Z]+$";
  
  
  /**
   * @return the additional entropy provided by l33t formating
   */
  private double l33tEntropy () {
    if (!isL33t) return 0d;
    
    int possibilities = 0;
    for (Map.Entry<Character, Character> e : l33tSubstitution.entrySet()) {
      char original = e.getValue();
      char sub = e.getKey();
      int substitutionCount = 0;
      int unSubstitutionCount = 0;
      for (char c : getToken().toCharArray()) {
        if (c == sub) substitutionCount++;
        if (c == original) unSubstitutionCount++;
      }
      int totalSub = substitutionCount + unSubstitutionCount;
      int minSub = Math.min(substitutionCount, unSubstitutionCount);
      for (int i = 0; i <= minSub; i++) {
        possibilities += nCk(totalSub, i);
      }
    }
    
    return Math.max(1, log2(possibilities)); // 1 bit of entropy (instead of 0)
                                             // for single-letter substitution 
                                             // like 4pple -> apple
  }
  
  
  /**
   * @return the rank of the password in the dictionary
   */
  public int getRank () {
    return rank;
  }
  
  
  /**
   * @return true if the password is written in l33t, false otherwise
   */
  public boolean isIsL33t () {
    return isL33t;
  }

  
  /**
   * @return the hash map of the l33t substitution
   */
  public HashMap<Character, Character> getL33tSubstitution() {
    return l33tSubstitution;
  }
  
  
}
