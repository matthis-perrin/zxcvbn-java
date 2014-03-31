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
public class DictionaryMatchTest {
  
  
  /**
   * Test of calculateEntropy method, of class DictionaryMatch.
   */
  @Test
  public void testCalculateEntropy() {
    System.out.println("Test of calculateEntropy method, of class DictionaryMatch");
  
    ArrayList<Character[]> sub = new ArrayList<Character[]>();
    double entropy;
    
    DictionaryMatch match = new DictionaryMatch("zxcv", 1028, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 10.005624549193877d, entropy);
    sub.clear();

    match = new DictionaryMatch("zxcvb", 998, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 9.962896005337262d, entropy);
    sub.clear();

    match = new DictionaryMatch("zxcvbn", 115, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 6.845490050944376d, entropy);
    sub.clear();

    match = new DictionaryMatch("wE", 29, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 5.857980995127573d, entropy);
    sub.clear();

    match = new DictionaryMatch("qwER", 655, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.81478271506211d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("ER4", 1461, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.5127404628035d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("4", 5, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.321928094887362d, entropy);
    sub.clear();

    sub.add(new Character[] {'3', 'e'});
    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("R43", 716, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.483815777264256d, entropy);
    sub.clear();

    sub.add(new Character[] {'@', 'a'});
    match = new DictionaryMatch("@", 5, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.321928094887362d, entropy);
    sub.clear();

    sub.add(new Character[] {'!', 'i'});
    match = new DictionaryMatch("!", 2, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2d, entropy);
    sub.clear();

    sub.add(new Character[] {'!', 'i'});
    match = new DictionaryMatch("!", 2, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("Tr0u", 28225, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 16.784685960547726d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("4", 5, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.321928094887362d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("b4d", 214, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 8.741466986401146d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("4do", 9947, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.280045761300384d, entropy);
    sub.clear();

    match = new DictionaryMatch("do", 24, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 4.584962500721157d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("Tr0ub4dour", 20111, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 17.29569719959013d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("b4dour", 31006, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 15.920259799328303d, entropy);
    sub.clear();

    match = new DictionaryMatch("dour", 29563, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.851505058556926d, entropy);
    sub.clear();

    match = new DictionaryMatch("our", 118, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 6.882643049361842d, entropy);
    sub.clear();

    match = new DictionaryMatch("cor", 13202, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.6884688827327d, entropy);
    sub.clear();

    match = new DictionaryMatch("or", 92, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 6.523561956057013d, entropy);
    sub.clear();

    match = new DictionaryMatch("corr", 8178, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.997532347526366d, entropy);
    sub.clear();

    match = new DictionaryMatch("orr", 560, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 9.129283016944967d, entropy);
    sub.clear();

    match = new DictionaryMatch("rec", 9992, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.286557761607957d, entropy);
    sub.clear();

    match = new DictionaryMatch("correct", 1525, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 10.574593527337612d, entropy);
    sub.clear();

    match = new DictionaryMatch("thor", 1650, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 10.688250309133178d, entropy);
    sub.clear();

    match = new DictionaryMatch("or", 92, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 6.523561956057013d, entropy);
    sub.clear();

    match = new DictionaryMatch("hors", 7646, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.900489484834651d, entropy);
    sub.clear();

    match = new DictionaryMatch("horse", 494, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 8.948367231584678d, entropy);
    sub.clear();

    match = new DictionaryMatch("a", 5, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2.321928094887362d, entropy);
    sub.clear();

    match = new DictionaryMatch("bat", 2195, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.100005224422722d, entropy);
    sub.clear();

    match = new DictionaryMatch("at", 59, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 5.882643049361842d, entropy);
    sub.clear();

    match = new DictionaryMatch("batt", 8998, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.135388651579046d, entropy);
    sub.clear();

    match = new DictionaryMatch("batte", 27737, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.759524135517584d, entropy);
    sub.clear();

    match = new DictionaryMatch("batter", 9383, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.195833549955587d, entropy);
    sub.clear();

    match = new DictionaryMatch("ter", 8915, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.122019082512358d, entropy);
    sub.clear();

    match = new DictionaryMatch("battery", 3845, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.90876788284919d, entropy);
    sub.clear();

    match = new DictionaryMatch("a", 5, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2.321928094887362d, entropy);
    sub.clear();

    match = new DictionaryMatch("tap", 3152, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.622051819456376d, entropy);
    sub.clear();

    match = new DictionaryMatch("staple", 14066, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.779924501967908d, entropy);
    sub.clear();

    match = new DictionaryMatch("coR", 13202, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.6884688827327d, entropy);
    sub.clear();

    match = new DictionaryMatch("oR", 92, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.523561956057013d, entropy);
    sub.clear();

    match = new DictionaryMatch("coRr", 8178, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 15.319460442413728d, entropy);
    sub.clear();

    match = new DictionaryMatch("oRr", 560, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.129283016944967d, entropy);
    sub.clear();

    match = new DictionaryMatch("rec", 9992, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.286557761607957d, entropy);
    sub.clear();

    match = new DictionaryMatch("coRrect", 1525, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.574593527337612d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("th0r", 1650, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.688250309133178d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("th0r", 1650, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.688250309133178d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("th0r", 1650, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.688250309133178d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("0r", 92, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.523561956057013d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("0r", 92, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.523561956057013d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("0r", 92, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.523561956057013d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("h0rs", 7646, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.900489484834651d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("h0rs", 7646, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.900489484834651d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("h0rs", 7646, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.900489484834651d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("h0rse", 494, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 9.948367231584678d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("h0rse", 494, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 9.948367231584678d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("h0rse", 494, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 9.948367231584678d, entropy);
    sub.clear();

    match = new DictionaryMatch("a", 5, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2.321928094887362d, entropy);
    sub.clear();

    sub.add(new Character[] {'+', 't'});
    match = new DictionaryMatch("ba+", 2195, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.100005224422722d, entropy);
    sub.clear();

    sub.add(new Character[] {'+', 't'});
    match = new DictionaryMatch("a+", 59, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 6.882643049361842d, entropy);
    sub.clear();

    sub.add(new Character[] {'+', 't'});
    match = new DictionaryMatch("ba++", 8998, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.135388651579046d, entropy);
    sub.clear();

    sub.add(new Character[] {'+', 't'});
    match = new DictionaryMatch("ba++e", 27737, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 15.759524135517584d, entropy);
    sub.clear();

    sub.add(new Character[] {'+', 't'});
    match = new DictionaryMatch("ba++er", 9383, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.195833549955587d, entropy);
    sub.clear();

    sub.add(new Character[] {'+', 't'});
    match = new DictionaryMatch("+er", 8915, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.122019082512358d, entropy);
    sub.clear();

    sub.add(new Character[] {'+', 't'});
    match = new DictionaryMatch("ba++ery", 3845, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.90876788284919d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    sub.add(new Character[] {'2', 'z'});
    match = new DictionaryMatch("200", 2892, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.497851836951119d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    sub.add(new Character[] {'2', 'z'});
    match = new DictionaryMatch("200", 2892, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.497851836951119d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    sub.add(new Character[] {'2', 'z'});
    match = new DictionaryMatch("200", 2892, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.497851836951119d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    sub.add(new Character[] {'2', 'z'});
    sub.add(new Character[] {'7', 't'});
    match = new DictionaryMatch("2007", 23656, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 16.11488102884148d, entropy);
    sub.clear();

    match = new DictionaryMatch("a", 5, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2.321928094887362d, entropy);
    sub.clear();

    match = new DictionaryMatch("tap", 3152, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.622051819456376d, entropy);
    sub.clear();

    match = new DictionaryMatch("staple", 14066, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.779924501967908d, entropy);
    sub.clear();

    sub.add(new Character[] {'$', 's'});
    match = new DictionaryMatch("staple$", 1517, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.151967870968189d, entropy);
    sub.clear();

    sub.add(new Character[] {'$', 's'});
    match = new DictionaryMatch("staple$", 1517, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.151967870968189d, entropy);
    sub.clear();

    sub.add(new Character[] {'$', 's'});
    match = new DictionaryMatch("staple$", 1517, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.151967870968189d, entropy);
    sub.clear();

    sub.add(new Character[] {'$', 's'});
    match = new DictionaryMatch("le$", 739, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 10.52943055414615d, entropy);
    sub.clear();

    sub.add(new Character[] {'$', 's'});
    match = new DictionaryMatch("le$", 739, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 10.52943055414615d, entropy);
    sub.clear();

    sub.add(new Character[] {'$', 's'});
    match = new DictionaryMatch("le$", 739, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 10.52943055414615d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("D0", 24, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 6.584962500721157d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("D0g", 706, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.46352437327118d, entropy);
    sub.clear();

    match = new DictionaryMatch("a", 5, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2.321928094887362d, entropy);
    sub.clear();

    match = new DictionaryMatch("abc", 12262, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.581906689308768d, entropy);
    sub.clear();

    match = new DictionaryMatch("abcd", 612, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 9.257387842692651d, entropy);
    sub.clear();

    match = new DictionaryMatch("abcde", 1911, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 10.900112062977458d, entropy);
    sub.clear();

    match = new DictionaryMatch("abcdef", 437, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 8.7714894695006d, entropy);
    sub.clear();

    match = new DictionaryMatch("abcdefg", 565, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 9.142107057302551d, entropy);
    sub.clear();

    match = new DictionaryMatch("abcdefgh", 983, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 9.94104760634058d, entropy);
    sub.clear();

    match = new DictionaryMatch("hi", 212, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.7279204545632d, entropy);
    sub.clear();

    match = new DictionaryMatch("i", 2, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 1d, entropy);
    sub.clear();

    sub.add(new Character[] {'8', 'b'});
    sub.add(new Character[] {'9', 'g'});
    match = new DictionaryMatch("k98", 7035, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.780334708123895d, entropy);
    sub.clear();

    sub.add(new Character[] {'8', 'b'});
    sub.add(new Character[] {'9', 'g'});
    match = new DictionaryMatch("k98", 7035, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.780334708123895d, entropy);
    sub.clear();

    sub.add(new Character[] {'8', 'b'});
    sub.add(new Character[] {'9', 'g'});
    match = new DictionaryMatch("k98", 7035, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.780334708123895d, entropy);
    sub.clear();

    match = new DictionaryMatch("9876", 2134, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.059344460824425d, entropy);
    sub.clear();

    match = new DictionaryMatch("98765", 3635, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.827739648806958d, entropy);
    sub.clear();

    match = new DictionaryMatch("987654", 262, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 8.03342300153745d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("4", 5, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.321928094887362d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("4", 5, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.321928094887362d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("4", 5, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.321928094887362d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("4", 5, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.321928094887362d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("4", 5, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.321928094887362d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("4", 5, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.321928094887362d, entropy);
    sub.clear();

    match = new DictionaryMatch("98765432", 953, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 9.896332403909941d, entropy);
    sub.clear();

    sub.add(new Character[] {'2', 'z'});
    sub.add(new Character[] {'3', 'e'});
    sub.add(new Character[] {'4', 'a'});
    sub.add(new Character[] {'5', 's'});
    match = new DictionaryMatch("5432", 6209, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.600145216358667d, entropy);
    sub.clear();

    sub.add(new Character[] {'2', 'z'});
    sub.add(new Character[] {'3', 'e'});
    sub.add(new Character[] {'4', 'a'});
    sub.add(new Character[] {'5', 's'});
    match = new DictionaryMatch("5432", 6209, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.600145216358667d, entropy);
    sub.clear();

    sub.add(new Character[] {'2', 'z'});
    sub.add(new Character[] {'3', 'e'});
    sub.add(new Character[] {'4', 'a'});
    sub.add(new Character[] {'5', 's'});
    match = new DictionaryMatch("5432", 6209, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.600145216358667d, entropy);
    sub.clear();

    sub.add(new Character[] {'2', 'z'});
    sub.add(new Character[] {'3', 'e'});
    sub.add(new Character[] {'4', 'a'});
    sub.add(new Character[] {'5', 's'});
    match = new DictionaryMatch("5432", 6209, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.600145216358667d, entropy);
    sub.clear();

    match = new DictionaryMatch("5432", 6282, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.617008227651965d, entropy);
    sub.clear();

    sub.add(new Character[] {'2', 'z'});
    sub.add(new Character[] {'3', 'e'});
    sub.add(new Character[] {'4', 'a'});
    sub.add(new Character[] {'5', 's'});
    match = new DictionaryMatch("5432", 6209, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.600145216358667d, entropy);
    sub.clear();

    sub.add(new Character[] {'2', 'z'});
    sub.add(new Character[] {'3', 'e'});
    sub.add(new Character[] {'4', 'a'});
    sub.add(new Character[] {'5', 's'});
    match = new DictionaryMatch("5432", 6209, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.600145216358667d, entropy);
    sub.clear();

    match = new DictionaryMatch("987654321", 1104, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 10.108524456778168d, entropy);
    sub.clear();

    match = new DictionaryMatch("87654321", 380, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 8.569855608330949d, entropy);
    sub.clear();

    match = new DictionaryMatch("7654321", 1620, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 10.661778097771988d, entropy);
    sub.clear();

    match = new DictionaryMatch("654321", 46, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 5.523561956057013d, entropy);
    sub.clear();

    match = new DictionaryMatch("54321", 659, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 9.364134655008051d, entropy);
    sub.clear();

    match = new DictionaryMatch("4321", 458, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 8.839203788096945d, entropy);
    sub.clear();

    sub.add(new Character[] {'1', 'i'});
    match = new DictionaryMatch("1", 2, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2d, entropy);
    sub.clear();

    sub.add(new Character[] {'1', 'i'});
    match = new DictionaryMatch("1", 2, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2d, entropy);
    sub.clear();

    sub.add(new Character[] {'1', 'i'});
    match = new DictionaryMatch("1", 2, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2d, entropy);
    sub.clear();

    sub.add(new Character[] {'1', 'i'});
    match = new DictionaryMatch("1", 2, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2d, entropy);
    sub.clear();

    match = new DictionaryMatch("neve", 20379, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.314795639569521d, entropy);
    sub.clear();

    match = new DictionaryMatch("eve", 745, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 9.541096615349524d, entropy);
    sub.clear();

    match = new DictionaryMatch("never", 109, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 6.768184324776926d, entropy);
    sub.clear();

    match = new DictionaryMatch("ever", 165, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.366322214245815d, entropy);
    sub.clear();

    match = new DictionaryMatch("ver", 15569, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.926388662349689d, entropy);
    sub.clear();

    match = new DictionaryMatch("for", 17, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 4.08746284125034d, entropy);
    sub.clear();

    match = new DictionaryMatch("or", 92, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 6.523561956057013d, entropy);
    sub.clear();

    match = new DictionaryMatch("forge", 7969, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.960182981831876d, entropy);
    sub.clear();

    match = new DictionaryMatch("forget", 344, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 8.426264754702098d, entropy);
    sub.clear();

    match = new DictionaryMatch("get", 42, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 5.392317422778761d, entropy);
    sub.clear();

    sub.add(new Character[] {'1', 'i'});
    match = new DictionaryMatch("1", 2, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2d, entropy);
    sub.clear();

    sub.add(new Character[] {'1', 'i'});
    match = new DictionaryMatch("1", 2, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2d, entropy);
    sub.clear();

    sub.add(new Character[] {'1', 'i'});
    sub.add(new Character[] {'3', 'e'});
    match = new DictionaryMatch("t13", 1407, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.458406613236534d, entropy);
    sub.clear();

    sub.add(new Character[] {'1', 'i'});
    sub.add(new Character[] {'3', 'e'});
    match = new DictionaryMatch("t13", 1407, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.458406613236534d, entropy);
    sub.clear();

    sub.add(new Character[] {'1', 'i'});
    match = new DictionaryMatch("1", 2, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2d, entropy);
    sub.clear();

    sub.add(new Character[] {'1', 'i'});
    match = new DictionaryMatch("1", 2, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2d, entropy);
    sub.clear();

    match = new DictionaryMatch("1997", 3722, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.861862340059153d, entropy);
    sub.clear();

    sub.add(new Character[] {'1', 'i'});
    match = new DictionaryMatch("1", 2, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2d, entropy);
    sub.clear();

    match = new DictionaryMatch("a", 5, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2.321928094887362d, entropy);
    sub.clear();

    match = new DictionaryMatch("1qaz", 7005, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.77416933531818d, entropy);
    sub.clear();

    match = new DictionaryMatch("1qaz2wsx", 503, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 8.974414589805528d, entropy);
    sub.clear();

    match = new DictionaryMatch("ed", 333, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 8.379378367071263d, entropy);
    sub.clear();

    match = new DictionaryMatch("em", 496, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 8.954196310386877d, entropy);
    sub.clear();

    match = new DictionaryMatch("temp", 1749, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 10.772314573921653d, entropy);
    sub.clear();

    match = new DictionaryMatch("a", 5, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2.321928094887362d, entropy);
    sub.clear();

    match = new DictionaryMatch("pas", 9120, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.154818109052105d, entropy);
    sub.clear();

    match = new DictionaryMatch("as", 71, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 6.149747119504682d, entropy);
    sub.clear();

    match = new DictionaryMatch("temppass", 3663, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.83880998570856d, entropy);
    sub.clear();

    match = new DictionaryMatch("pass", 35, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 5.129283016944966d, entropy);
    sub.clear();

    match = new DictionaryMatch("ass", 611, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 9.25502856981873d, entropy);
    sub.clear();

    match = new DictionaryMatch("i", 2, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 1d, entropy);
    sub.clear();

    match = new DictionaryMatch("bria", 18004, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.136029849385553d, entropy);
    sub.clear();

    match = new DictionaryMatch("ria", 3598, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.812979471251483d, entropy);
    sub.clear();

    match = new DictionaryMatch("a", 5, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2.321928094887362d, entropy);
    sub.clear();

    match = new DictionaryMatch("brian", 20, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 4.321928094887363d, entropy);
    sub.clear();

    match = new DictionaryMatch("ian", 242, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.9188632372745955d, entropy);
    sub.clear();

    match = new DictionaryMatch("an", 102, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 6.672425341971495d, entropy);
    sub.clear();

    match = new DictionaryMatch("i", 2, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 1d, entropy);
    sub.clear();

    match = new DictionaryMatch("smit", 11209, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.45236995480311d, entropy);
    sub.clear();

    match = new DictionaryMatch("it", 8, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3d, entropy);
    sub.clear();

    match = new DictionaryMatch("smith", 1, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 0d, entropy);
    sub.clear();

    match = new DictionaryMatch("i", 2, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 1d, entropy);
    sub.clear();

    match = new DictionaryMatch("bria", 18004, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.136029849385553d, entropy);
    sub.clear();

    match = new DictionaryMatch("ria", 3598, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.812979471251483d, entropy);
    sub.clear();

    match = new DictionaryMatch("a", 5, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2.321928094887362d, entropy);
    sub.clear();

    match = new DictionaryMatch("brian", 20, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 4.321928094887363d, entropy);
    sub.clear();

    match = new DictionaryMatch("ian", 242, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.9188632372745955d, entropy);
    sub.clear();

    match = new DictionaryMatch("an", 102, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 6.672425341971495d, entropy);
    sub.clear();

    match = new DictionaryMatch("i", 2, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 1d, entropy);
    sub.clear();

    match = new DictionaryMatch("smit", 11209, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.45236995480311d, entropy);
    sub.clear();

    match = new DictionaryMatch("it", 8, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3d, entropy);
    sub.clear();

    match = new DictionaryMatch("smith", 1, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 0d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("th4", 8742, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.093747662785669d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("h4", 395, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 9.625708843064466d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("4", 5, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.321928094887362d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("th4m", 25399, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 15.632484076411412d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("h4m", 1376, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.426264754702098d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("4m", 124, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.954196310386876d, entropy);
    sub.clear();

    match = new DictionaryMatch("a", 5, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2.321928094887362d, entropy);
    sub.clear();

    match = new DictionaryMatch("may", 239, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.90086680798075d, entropy);
    sub.clear();

    match = new DictionaryMatch("mayo", 739, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 9.52943055414615d, entropy);
    sub.clear();

    match = new DictionaryMatch("mayor", 2043, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 10.996473488733228d, entropy);
    sub.clear();

    match = new DictionaryMatch("or", 92, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 6.523561956057013d, entropy);
    sub.clear();

    match = new DictionaryMatch("a", 5, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2.321928094887362d, entropy);
    sub.clear();

    match = new DictionaryMatch("pas", 9120, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.154818109052105d, entropy);
    sub.clear();

    match = new DictionaryMatch("as", 71, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 6.149747119504682d, entropy);
    sub.clear();

    match = new DictionaryMatch("pass", 35, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 5.129283016944966d, entropy);
    sub.clear();

    match = new DictionaryMatch("ass", 611, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 9.25502856981873d, entropy);
    sub.clear();

    match = new DictionaryMatch("passwor", 2748, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.4241662888181d, entropy);
    sub.clear();

    match = new DictionaryMatch("or", 92, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 6.523561956057013d, entropy);
    sub.clear();

    match = new DictionaryMatch("password", 1, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 0d, entropy);
    sub.clear();

    match = new DictionaryMatch("assword", 1666, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 10.702172685365547d, entropy);
    sub.clear();

    match = new DictionaryMatch("sword", 1854, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 10.85642552862553d, entropy);
    sub.clear();

    match = new DictionaryMatch("word", 419, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 8.710806433699352d, entropy);
    sub.clear();

    match = new DictionaryMatch("password1", 476, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 8.894817763307945d, entropy);
    sub.clear();

    sub.add(new Character[] {'1', 'i'});
    match = new DictionaryMatch("1", 2, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2d, entropy);
    sub.clear();

    match = new DictionaryMatch("i", 2, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 1d, entropy);
    sub.clear();

    match = new DictionaryMatch("viki", 1240, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 10.276124405274238d, entropy);
    sub.clear();

    match = new DictionaryMatch("i", 2, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 1d, entropy);
    sub.clear();

    match = new DictionaryMatch("kin", 6047, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.562003863651551d, entropy);
    sub.clear();

    match = new DictionaryMatch("in", 13, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.700439718141092d, entropy);
    sub.clear();

    match = new DictionaryMatch("viking", 185, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.531381460516312d, entropy);
    sub.clear();

    match = new DictionaryMatch("king", 29, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 4.857980995127573d, entropy);
    sub.clear();

    match = new DictionaryMatch("ing", 5422, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.404609397837712d, entropy);
    sub.clear();

    sub.add(new Character[] {'1', 'i'});
    match = new DictionaryMatch("1", 2, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2d, entropy);
    sub.clear();

    sub.add(new Character[] {'1', 'i'});
    match = new DictionaryMatch("1", 2, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2d, entropy);
    sub.clear();

    match = new DictionaryMatch("thx1138", 172, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.426264754702098d, entropy);
    sub.clear();

    match = new DictionaryMatch("1138", 5937, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.53551839776867d, entropy);
    sub.clear();

    match = new DictionaryMatch("coR", 13202, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.6884688827327d, entropy);
    sub.clear();

    match = new DictionaryMatch("oR", 92, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.523561956057013d, entropy);
    sub.clear();

    match = new DictionaryMatch("coRp", 12703, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 15.954809725293464d, entropy);
    sub.clear();

    match = new DictionaryMatch("i", 2, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 1d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("ScoRpi0", 287, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.209301046034144d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("ScoRpi0n", 299, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.666945170046835d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("pi0n", 23485, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 15.51945197314515d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("0n", 26, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 5.700439718141093d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("ScoRpi0ns", 26760, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 21.502206361878933d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("i0ns", 25689, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 15.648863110850051d, entropy);
    sub.clear();

    match = new DictionaryMatch("do", 24, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 4.584962500721157d, entropy);
    sub.clear();

    match = new DictionaryMatch("you", 1, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 0d, entropy);
    sub.clear();

    match = new DictionaryMatch("no", 18, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 4.169925001442312d, entropy);
    sub.clear();

    match = new DictionaryMatch("know", 15, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.9068905956085187d, entropy);
    sub.clear();

    match = new DictionaryMatch("now", 56, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 5.807354922057605d, entropy);
    sub.clear();

    match = new DictionaryMatch("ya", 467, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 8.867278739709663d, entropy);
    sub.clear();

    match = new DictionaryMatch("a", 5, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2.321928094887362d, entropy);
    sub.clear();

    match = new DictionaryMatch("ryan", 49, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 5.614709844115208d, entropy);
    sub.clear();

    match = new DictionaryMatch("yan", 2313, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.175549550636191d, entropy);
    sub.clear();

    match = new DictionaryMatch("an", 102, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 6.672425341971495d, entropy);
    sub.clear();

    match = new DictionaryMatch("anh", 1540, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 10.588714635582264d, entropy);
    sub.clear();

    match = new DictionaryMatch("hun", 9540, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.219773550892874d, entropy);
    sub.clear();

    match = new DictionaryMatch("hunt", 140, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.129283016944966d, entropy);
    sub.clear();

    match = new DictionaryMatch("hunte", 18598, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.182859864042896d, entropy);
    sub.clear();

    match = new DictionaryMatch("hunter", 25, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 4.643856189774724d, entropy);
    sub.clear();

    match = new DictionaryMatch("ter", 8915, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.122019082512358d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    sub.add(new Character[] {'2', 'z'});
    match = new DictionaryMatch("ter20", 29539, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 15.850333366130798d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    sub.add(new Character[] {'2', 'z'});
    match = new DictionaryMatch("200", 2892, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.497851836951119d, entropy);
    sub.clear();

    match = new DictionaryMatch("2000", 19, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 4.247927513443585d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("000", 3952, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.948367231584678d, entropy);
    sub.clear();

    match = new DictionaryMatch("i", 2, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 1d, entropy);
    sub.clear();

    match = new DictionaryMatch("ria", 3598, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.812979471251483d, entropy);
    sub.clear();

    match = new DictionaryMatch("a", 5, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2.321928094887362d, entropy);
    sub.clear();

    match = new DictionaryMatch("ian", 242, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.9188632372745955d, entropy);
    sub.clear();

    match = new DictionaryMatch("an", 102, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 6.672425341971495d, entropy);
    sub.clear();

    match = new DictionaryMatch("anh", 1540, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 10.588714635582264d, entropy);
    sub.clear();

    match = new DictionaryMatch("hun", 9540, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.219773550892874d, entropy);
    sub.clear();

    match = new DictionaryMatch("hunt", 140, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.129283016944966d, entropy);
    sub.clear();

    match = new DictionaryMatch("hunte", 18598, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.182859864042896d, entropy);
    sub.clear();

    match = new DictionaryMatch("hunter", 25, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 4.643856189774724d, entropy);
    sub.clear();

    match = new DictionaryMatch("ter", 8915, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.122019082512358d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    sub.add(new Character[] {'2', 'z'});
    match = new DictionaryMatch("ter20", 29539, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 15.850333366130798d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    sub.add(new Character[] {'2', 'z'});
    match = new DictionaryMatch("200", 2892, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.497851836951119d, entropy);
    sub.clear();

    match = new DictionaryMatch("2000", 19, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 4.247927513443585d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("000", 3952, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.948367231584678d, entropy);
    sub.clear();

    match = new DictionaryMatch("a", 5, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2.321928094887362d, entropy);
    sub.clear();

    match = new DictionaryMatch("as", 71, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 6.149747119504682d, entropy);
    sub.clear();

    match = new DictionaryMatch("asdf", 173, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.4346282276367255d, entropy);
    sub.clear();

    match = new DictionaryMatch("asdfg", 651, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 9.346513733165635d, entropy);
    sub.clear();

    match = new DictionaryMatch("asdfgh", 78, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 6.285402218862249d, entropy);
    sub.clear();

    match = new DictionaryMatch("asdfghj", 1987, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 10.956376157249672d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("4", 5, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.321928094887362d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("4", 5, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.321928094887362d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("4re", 36, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 6.169925001442312d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("4re", 36, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 6.169925001442312d, entropy);
    sub.clear();

    match = new DictionaryMatch("rewq", 6646, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.69827057769203d, entropy);
    sub.clear();

    match = new DictionaryMatch("A", 5, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.321928094887362d, entropy);
    sub.clear();

    match = new DictionaryMatch("I", 2, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2d, entropy);
    sub.clear();

    sub.add(new Character[] {'1', 'i'});
    match = new DictionaryMatch("1", 2, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2d, entropy);
    sub.clear();

    sub.add(new Character[] {'1', 'i'});
    match = new DictionaryMatch("1", 2, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2d, entropy);
    sub.clear();

    match = new DictionaryMatch("1234", 4, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("4", 5, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.321928094887362d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("4", 5, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.321928094887362d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    match = new DictionaryMatch("4", 5, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.321928094887362d, entropy);
    sub.clear();

    match = new DictionaryMatch("12345", 6, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2.584962500721156d, entropy);
    sub.clear();

    match = new DictionaryMatch("2345", 2786, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.443979542601253d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    sub.add(new Character[] {'5', 's'});
    match = new DictionaryMatch("45", 71, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.149747119504682d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    sub.add(new Character[] {'5', 's'});
    match = new DictionaryMatch("45", 71, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.149747119504682d, entropy);
    sub.clear();

    sub.add(new Character[] {'4', 'a'});
    sub.add(new Character[] {'5', 's'});
    match = new DictionaryMatch("45", 71, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.149747119504682d, entropy);
    sub.clear();

    match = new DictionaryMatch("123456", 2, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 1d, entropy);
    sub.clear();

    match = new DictionaryMatch("1234567", 23, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 4.523561956057013d, entropy);
    sub.clear();

    match = new DictionaryMatch("234567", 3209, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.647908074281808d, entropy);
    sub.clear();

    match = new DictionaryMatch("4567", 5356, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.386940245324311d, entropy);
    sub.clear();

    match = new DictionaryMatch("12345678", 3, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 1.5849625007211563d, entropy);
    sub.clear();

    match = new DictionaryMatch("5678", 3673, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.842743180731658d, entropy);
    sub.clear();

    match = new DictionaryMatch("hi", 212, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.7279204545632d, entropy);
    sub.clear();

    match = new DictionaryMatch("i", 2, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 1d, entropy);
    sub.clear();

    match = new DictionaryMatch("6789", 5842, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.51224664282918d, entropy);
    sub.clear();

    match = new DictionaryMatch("ros", 13085, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.675626303935397d, entropy);
    sub.clear();

    match = new DictionaryMatch("rose", 65, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 6.022367813028454d, entropy);
    sub.clear();

    match = new DictionaryMatch("rosebud", 245, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.936637939002572d, entropy);
    sub.clear();

    match = new DictionaryMatch("bud", 786, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 9.618385502258606d, entropy);
    sub.clear();

    match = new DictionaryMatch("Ros", 13085, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.675626303935397d, entropy);
    sub.clear();

    match = new DictionaryMatch("Rose", 65, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.022367813028454d, entropy);
    sub.clear();

    match = new DictionaryMatch("Rosebud", 245, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 8.936637939002573d, entropy);
    sub.clear();

    match = new DictionaryMatch("bud", 786, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 9.618385502258606d, entropy);
    sub.clear();

    match = new DictionaryMatch("ROS", 13085, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.675626303935397d, entropy);
    sub.clear();

    match = new DictionaryMatch("ROSE", 65, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.022367813028454d, entropy);
    sub.clear();

    match = new DictionaryMatch("ROSEBUD", 245, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 8.936637939002573d, entropy);
    sub.clear();

    match = new DictionaryMatch("BUD", 786, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 10.618385502258606d, entropy);
    sub.clear();

    match = new DictionaryMatch("ros", 13085, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.675626303935397d, entropy);
    sub.clear();

    match = new DictionaryMatch("rose", 65, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 6.022367813028454d, entropy);
    sub.clear();

    match = new DictionaryMatch("rosebuD", 245, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 8.936637939002573d, entropy);
    sub.clear();

    match = new DictionaryMatch("buD", 786, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 10.618385502258606d, entropy);
    sub.clear();

    match = new DictionaryMatch("ros", 13085, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.675626303935397d, entropy);
    sub.clear();

    sub.add(new Character[] {'3', 'e'});
    match = new DictionaryMatch("ros3", 65, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.022367813028454d, entropy);
    sub.clear();

    sub.add(new Character[] {'3', 'e'});
    match = new DictionaryMatch("ros3bud", 245, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 8.936637939002573d, entropy);
    sub.clear();

    match = new DictionaryMatch("bud", 786, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 9.618385502258606d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    match = new DictionaryMatch("r0s", 13085, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.675626303935397d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    sub.add(new Character[] {'3', 'e'});
    match = new DictionaryMatch("r0s3", 65, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.022367813028454d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    sub.add(new Character[] {'3', 'e'});
    match = new DictionaryMatch("r0s3bud", 245, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 8.936637939002573d, entropy);
    sub.clear();

    match = new DictionaryMatch("bud", 786, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 9.618385502258606d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    sub.add(new Character[] {'$', 's'});
    match = new DictionaryMatch("R0$", 13085, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 15.675626303935397d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    sub.add(new Character[] {'3', 'e'});
    sub.add(new Character[] {'$', 's'});
    match = new DictionaryMatch("R0$3", 65, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 8.60733031374961d, entropy);
    sub.clear();

    sub.add(new Character[] {'0', 'o'});
    sub.add(new Character[] {'3', 'e'});
    sub.add(new Character[] {'8', 'b'});
    sub.add(new Character[] {'$', 's'});
    match = new DictionaryMatch("R0$38uD", 245, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.936637939002573d, entropy);
    sub.clear();

    sub.add(new Character[] {'8', 'b'});
    match = new DictionaryMatch("8uD", 786, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.618385502258606d, entropy);
    sub.clear();

    match = new DictionaryMatch("ver", 15569, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.926388662349689d, entropy);
    sub.clear();

    match = new DictionaryMatch("i", 2, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 1d, entropy);
    sub.clear();

    match = new DictionaryMatch("lin", 1233, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 10.26795708440284d, entropy);
    sub.clear();

    match = new DictionaryMatch("in", 13, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.700439718141092d, entropy);
    sub.clear();

    match = new DictionaryMatch("verline", 3735, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.8668925276766d, entropy);
    sub.clear();

    match = new DictionaryMatch("erline", 2551, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.316847183602473d, entropy);
    sub.clear();

    match = new DictionaryMatch("line", 500, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 8.965784284662087d, entropy);
    sub.clear();

    match = new DictionaryMatch("neVA", 723, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 12.957283455588417d, entropy);
    sub.clear();

    match = new DictionaryMatch("eVA", 140, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 9.129283016944967d, entropy);
    sub.clear();

    match = new DictionaryMatch("A", 5, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.321928094887362d, entropy);
    sub.clear();

    match = new DictionaryMatch("eVAN", 281, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 10.456354415108288d, entropy);
    sub.clear();

    match = new DictionaryMatch("VAN", 422, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 9.721099188707186d, entropy);
    sub.clear();

    match = new DictionaryMatch("AN", 102, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 7.672425341971495d, entropy);
    sub.clear();

    match = new DictionaryMatch("AND", 6, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.584962500721156d, entropy);
    sub.clear();

    match = new DictionaryMatch("eVANDER", 29489, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 17.847889279619423d, entropy);
    sub.clear();

    match = new DictionaryMatch("DER", 7489, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.870557374326417d, entropy);
    sub.clear();

    match = new DictionaryMatch("DERM", 23406, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 15.514590783745719d, entropy);
    sub.clear();

    match = new DictionaryMatch("ERM", 5991, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.54858111816513d, entropy);
    sub.clear();

    match = new DictionaryMatch("ERMA", 376, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 9.554588851677638d, entropy);
    sub.clear();

    match = new DictionaryMatch("A", 5, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.321928094887362d, entropy);
    sub.clear();

    match = new DictionaryMatch("MAR", 7086, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.790755750118313d, entropy);
    sub.clear();

    match = new DictionaryMatch("VANDERMARK", 11007, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.4261336899697d, entropy);
    sub.clear();

    match = new DictionaryMatch("MARK", 14, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 4.807354922057604d, entropy);
    sub.clear();

    match = new DictionaryMatch("ARK", 7669, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13.90482275429421d, entropy);
    sub.clear();

    match = new DictionaryMatch("he", 37, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 5.20945336562895d, entropy);
    sub.clear();

    match = new DictionaryMatch("i", 2, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 1d, entropy);
    sub.clear();

    match = new DictionaryMatch("A", 5, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.321928094887362d, entropy);
    sub.clear();

    match = new DictionaryMatch("A", 5, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.321928094887362d, entropy);
    sub.clear();

    match = new DictionaryMatch("a", 5, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2.321928094887362d, entropy);
    sub.clear();

    sub.add(new Character[] {'9', 'g'});
    match = new DictionaryMatch("Ba9", 903, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 11.818582177480858d, entropy);
    sub.clear();

    match = new DictionaryMatch("A", 5, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.321928094887362d, entropy);
    sub.clear();

    match = new DictionaryMatch("ABu", 9388, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 15.196602126523171d, entropy);
    sub.clear();

    sub.add(new Character[] {'9', 'g'});
    match = new DictionaryMatch("Bu9", 2048, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 13d, entropy);
    sub.clear();

    sub.add(new Character[] {'9', 'g'});
    match = new DictionaryMatch("Bu99", 5067, true, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 14.306916113522544d, entropy);
    sub.clear();

    match = new DictionaryMatch("To", 3, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 2.584962500721156d, entropy);
    sub.clear();

    match = new DictionaryMatch("of", 9, false, sub);
    entropy = match.calculateEntropy();
    Assert.assertEquals(match.getToken(), 3.1699250014423126d, entropy);
    sub.clear();

  }
  
  
}
