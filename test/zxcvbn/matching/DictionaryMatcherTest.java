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
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Matthis Perrin <matthis.perrin at gmail.com>
 */
public class DictionaryMatcherTest {
  
  public DictionaryMatcherTest() {
  }

  /**
   * Test of match method, of class DictionaryMatcher.
   */
  @Test
  public void testDictionaryMatch() {
    System.out.println("Test of dictionaryMatch method, of class DictionaryMatcher");
    
    ArrayList<DictionnaryMatch> computed = DictionaryMatcher.match("password");
    
    ArrayList<DictionnaryMatch> expected = new ArrayList<>();
    HashMap<Character, Character> emptyHashMap = new HashMap<>();
    expected.add(new DictionnaryMatch("pas", 9120, false, emptyHashMap));
    expected.add(new DictionnaryMatch("pass", 35, false, emptyHashMap));
    expected.add(new DictionnaryMatch("passwor", 2748, false, emptyHashMap));
    expected.add(new DictionnaryMatch("password", 1, false, emptyHashMap));
    expected.add(new DictionnaryMatch("a", 5, false, emptyHashMap));
    expected.add(new DictionnaryMatch("as", 71, false, emptyHashMap));
    expected.add(new DictionnaryMatch("ass", 611, false, emptyHashMap));
    expected.add(new DictionnaryMatch("assword", 1666, false, emptyHashMap));
    expected.add(new DictionnaryMatch("sword", 1854, false, emptyHashMap));
    expected.add(new DictionnaryMatch("word", 419, false, emptyHashMap));
    expected.add(new DictionnaryMatch("or", 92, false, emptyHashMap));

    int computedHash = 0;
    for (DictionnaryMatch match : computed) {
      computedHash += match.hashCode();
    }
    
    int expectedHash = 0;
    for (DictionnaryMatch match : expected) {
      expectedHash += match.hashCode();
    }
    
    Assert.assertEquals(expectedHash, computedHash);
  }
  
  
  
}
