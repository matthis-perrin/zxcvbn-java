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
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Matthis Perrin <matthis.perrin at gmail.com>
 */
public class DictionaryMatcherTest {
  
  
  /**
   * Test of match method, of class DictionaryMatcher, without l33t value.
   */
  @Test
  public void testDictionaryMatchWithoutL33t () {
    System.out.println("Test of dictionaryMatch method (without l33t value), of class DictionaryMatcher");
    
    ArrayList<DictionaryMatch> computed = DictionaryMatcher.match("password");
    
    ArrayList<DictionaryMatch> expected = new ArrayList<>();
    ArrayList<Character[]> empty = new ArrayList<>();
    expected.add(new DictionaryMatch("pas", 9120, false, empty));
    expected.add(new DictionaryMatch("pass", 35, false, empty));
    expected.add(new DictionaryMatch("passwor", 2748, false, empty));
    expected.add(new DictionaryMatch("password", 1, false, empty));
    expected.add(new DictionaryMatch("a", 5, false, empty));
    expected.add(new DictionaryMatch("as", 71, false, empty));
    expected.add(new DictionaryMatch("ass", 611, false, empty));
    expected.add(new DictionaryMatch("assword", 1666, false, empty));
    expected.add(new DictionaryMatch("sword", 1854, false, empty));
    expected.add(new DictionaryMatch("word", 419, false, empty));
    expected.add(new DictionaryMatch("or", 92, false, empty));

    int computedHash = 0;
    for (DictionaryMatch match : computed) {
      computedHash += match.hashCode();
    }
    
    int expectedHash = 0;
    for (DictionaryMatch match : expected) {
      expectedHash += match.hashCode();
    }
    
    Assert.assertEquals(expectedHash, computedHash);
  }
  
  
  /**
   * Test of match method, of class DictionaryMatcher, using a l33t value.
   */
  @Test
  public void testDictionaryMatchWithL33t () {
    System.out.println("Test of dictionaryMatch method (with l33t value), of class DictionaryMatcher");
    
    ArrayList<DictionaryMatch> computed = DictionaryMatcher.match("vanders7oo7");
    
    ArrayList<DictionaryMatch> expected = new ArrayList<>();
    
    ArrayList<Character[]> subs1 = new ArrayList<>();
    expected.add(new DictionaryMatch("van", 422, false, subs1));
    
    ArrayList<Character[]> subs2 = new ArrayList<>();
    subs2.add(new Character[] {'7', 'l'});
    subs2.add(new Character[] {'7', 't'});
    expected.add(new DictionaryMatch("vanders7oo7", 25341, true, subs2));
    
    ArrayList<Character[]> subs3 = new ArrayList<>();
    expected.add(new DictionaryMatch("a", 5, false, subs3));
    
    ArrayList<Character[]> subs4 = new ArrayList<>();
    expected.add(new DictionaryMatch("an", 102, false, subs4));
    
    ArrayList<Character[]> subs5 = new ArrayList<>();
    expected.add(new DictionaryMatch("and", 6, false, subs5));
    
    ArrayList<Character[]> subs6 = new ArrayList<>();
    expected.add(new DictionaryMatch("anders", 2059, false, subs6));
    
    ArrayList<Character[]> subs7 = new ArrayList<>();
    expected.add(new DictionaryMatch("der", 7489, false, subs7));
    
    ArrayList<Character[]> subs8 = new ArrayList<>();
    expected.add(new DictionaryMatch("ers", 12623, false, subs8));
    
    ArrayList<Character[]> subs9 = new ArrayList<>();
    subs9.add(new Character[] {'7', 't'});
    subs9.add(new Character[] {'7', 'l'});
    expected.add(new DictionaryMatch("s7oo7", 7688, true, subs9));
    
    ArrayList<Character[]> subs10 = new ArrayList<>();
    subs10.add(new Character[] {'7', 't'});
    expected.add(new DictionaryMatch("7o", 3, true, subs10));
    
    ArrayList<Character[]> subs11 = new ArrayList<>();
    subs11.add(new Character[] {'7', 'l'});
    expected.add(new DictionaryMatch("7oo", 7840, true, subs11));
    
    ArrayList<Character[]> subs12 = new ArrayList<>();
    subs12.add(new Character[] {'7', 't'});
    expected.add(new DictionaryMatch("7oo", 111, true, subs12));
    
    ArrayList<Character[]> subs13 = new ArrayList<>();
    subs13.add(new Character[] {'7', 'l'});
    subs13.add(new Character[] {'7', 't'});
    expected.add(new DictionaryMatch("7oo7", 11009, true, subs13));
    
    ArrayList<Character[]> subs14 = new ArrayList<>();
    subs14.add(new Character[] {'7', 't'});
    subs14.add(new Character[] {'7', 'l'});
    expected.add(new DictionaryMatch("7oo7", 1781, true, subs14));
    
    ArrayList<Character[]> subs15 = new ArrayList<>();
    subs15.add(new Character[] {'7', 't'});
    subs15.add(new Character[] {'7', 't'});
    expected.add(new DictionaryMatch("7oo7", 9491, true, subs15));

    int computedHash = 0;
    for (DictionaryMatch match : computed) {
      computedHash += match.hashCode();
    }
    
    int expectedHash = 0;
    for (DictionaryMatch match : expected) {
      expectedHash += match.hashCode();
    }
    
    Assert.assertEquals(expectedHash, computedHash);
  }
  
  
}
