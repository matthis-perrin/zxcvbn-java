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
public class RepeatMatchTest {
  
  public RepeatMatchTest() {
  }

  /**
   * Test of calculateEntropy method, of class RepeatMatch.
   */
  @Test
  public void testCalculateEntropy() {
    System.out.println("Test of calculateEntropy method, of class RepeatMatch");
    
    HashMap<String, Double> fixture = new HashMap<>();
    fixture.put("a", 4.700439718141093);
    fixture.put("aaaaaaaaaa", 8.022367813028454);
    fixture.put("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 10.022367813028454);
    fixture.put("A", 4.700439718141093);
    fixture.put("AAAAAAAAAA", 8.022367813028454);
    fixture.put("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", 10.022367813028454);
    fixture.put("0", 3.3219280948873626);
    fixture.put("0000000000", 6.643856189774725);
    fixture.put("0000000000000000000000000000000000000000", 8.643856189774725);
    fixture.put("@", 5.044394119358453);
    fixture.put("@@@@@@@@@@", 8.366322214245816);
    fixture.put("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@", 10.366322214245816);
    fixture.put("é", 6.643856189774725);
    fixture.put("éééééééééé", 9.965784284662087);
    fixture.put("éééééééééééééééééééééééééééééééééééééééé", 11.965784284662087);
    
    // Test the fixture
    for (Map.Entry<String, Double> entry : fixture.entrySet()) {
      String password = entry.getKey();
      double expectedEntropy = entry.getValue();
      double computedEntropy = new RepeatMatch(password).calculateEntropy();
      Assert.assertEquals(password, expectedEntropy, computedEntropy);
    }
  }
  
}
