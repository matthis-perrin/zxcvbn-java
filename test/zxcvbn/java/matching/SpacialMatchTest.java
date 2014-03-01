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

import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Matthis Perrin <matthis.perrin at gmail.com>
 */
public class SpacialMatchTest {
  
  /**
   * Test of calculateEntropy method, of class SpacialMatch.
   */
  @Test
  public void testCalculateEntropy() {
    System.out.println("Test of calculateEntropy method, of class SpacialMatch");
    
    HashMap<SpacialMatch, Double> fixture = new HashMap<>();
    fixture.put(new SpacialMatch("zxcvbn", true, 1, 0), 11.07681559705083d);
    fixture.put(new SpacialMatch("qwER43@!", true, 3, 4), 26.439812245844823d);
    fixture.put(new SpacialMatch("43@!", true, 1, 2), 13.799281621521923d);
    fixture.put(new SpacialMatch("Tr0", true, 1, 0), 9.754887502163468d);
    fixture.put(new SpacialMatch("cth", true, 2, 0), 12.239001757765582d);
    fixture.put(new SpacialMatch("23.", true, 2, 0), 12.239001757765582d);
    fixture.put(new SpacialMatch(".23.20", false, 5, 0), 18.719505805204097d);
    fixture.put(new SpacialMatch("cde", true, 1, 0), 9.754887502163468d);
    fixture.put(new SpacialMatch("fgh", true, 1, 0), 9.754887502163468d);
    fixture.put(new SpacialMatch("ijk", true, 2, 0), 12.239001757765582d);
    fixture.put(new SpacialMatch("987", false, 1, 0), 7.247927513443586d);
    fixture.put(new SpacialMatch("654", false, 1, 0), 7.247927513443586d);
    fixture.put(new SpacialMatch("987654321", true, 1, 0), 11.75488750216347d);
    fixture.put(new SpacialMatch("321", false, 1, 0), 7.247927513443586d);
    fixture.put(new SpacialMatch("erf", true, 2, 0), 12.239001757765582);
    fixture.put(new SpacialMatch("1qaz", true, 1, 0), 10.339850002884624d);
    fixture.put(new SpacialMatch("2wsx", true, 1, 0), 10.339850002884624d);
    fixture.put(new SpacialMatch("3edc", true, 1, 0), 10.339850002884624d);
    fixture.put(new SpacialMatch("iki", true, 2, 0), 12.239001757765582d);
    fixture.put(new SpacialMatch("nhu", true, 2, 0), 12.239001757765582d);
    fixture.put(new SpacialMatch("dfgh", true, 3, 0), 15.236088956496838d);
    fixture.put(new SpacialMatch("7654", true, 1, 0), 10.339850002884624d);
    fixture.put(new SpacialMatch("asdfghju7654rewq", true, 5, 0), 29.782050791593228d);
    fixture.put(new SpacialMatch("&*()", true, 1, 3), 12.661778097771986d);
    fixture.put(new SpacialMatch("AOEUIDHG&*()LS_", true, 5, 14), 33.253655399271594d);
    fixture.put(new SpacialMatch("123", false, 1, 0), 7.247927513443586d);
    fixture.put(new SpacialMatch("456", false, 1, 0), 7.247927513443586d);
    fixture.put(new SpacialMatch("12345678", true, 1, 0), 11.562242424221074d);
    fixture.put(new SpacialMatch("6789", true, 1, 0), 10.339850002884624d);
    fixture.put(new SpacialMatch("789", false, 1, 0), 7.247927513443586d);
    fixture.put(new SpacialMatch("DER", true, 2, 2), 14.239001757765582d);
    fixture.put(new SpacialMatch("BgbH", true, 3, 1), 17.5580170513842d);
    
    // Test the fixture
    for (Map.Entry<SpacialMatch, Double> entry : fixture.entrySet()) {
      SpacialMatch match = entry.getKey();
      double expected = entry.getValue();
      double computed = match.calculateEntropy();
      Assert.assertEquals(match.getToken(), expected, computed);
    }
  }
  
}
