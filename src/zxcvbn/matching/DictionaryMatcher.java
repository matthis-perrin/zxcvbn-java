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

import java.util.ArrayList;
import java.util.HashMap;
import zxcvbn.resources.Dictionaries;

/**
 *
 * @author Matthis Perrin <matthis.perrin at gmail.com>
 */
public class DictionaryMatcher {
  
  
  /**
   * Look for every part of the password that match an entry in our dictionaries
   * @param password the password that be analyzed
   * @return the list of all the match found
   */
  public static ArrayList<DictionnaryMatch> match (String password) {
    
    ArrayList<DictionnaryMatch> matches = new ArrayList<>();
    
    for (int start = 0; start < password.length(); start++) {
      for (int end = start + 1; end <= password.length(); end++) {
        String split = password.substring(start, end);
        for (HashMap<String, Integer> dictionary : Dictionaries.dictionaries) {
          Integer rank = dictionary.get(split);
          if (rank != null) {
            matches.add(new DictionnaryMatch(split, rank, false, 
                    new HashMap<Character, Character>()));
          }
        }
      }
    }
    
    return matches;
    
  }
  
  
}
