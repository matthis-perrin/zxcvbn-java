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
public class DigitMatchTest {
  
  public DigitMatchTest() {
  }

  /**
   * Test of calculateEntropy method, of class DigitMatch.
   */
  @Test
  public void testCalculateEntropy() {
    System.out.println("Test of calculateEntropy method, of class DigitMatch");
    
    HashMap<String, Double> fixture = new HashMap<>();
    fixture.put("2", 3.3219280948873626);
    fixture.put("45", 6.643856189774725);
    fixture.put("296", 9.965784284662087);
    fixture.put("2954", 13.28771237954945);
    fixture.put("01678", 16.609640474436812);
    fixture.put("394870", 19.931568569324174);
    fixture.put("9486034", 23.25349666421154);
    fixture.put("10037235", 26.5754247590989);
    fixture.put("923874291", 29.897352853986263);
    fixture.put("9041957412", 33.219280948873624);
    
    // Test the fixture
    for (Map.Entry<String, Double> entry : fixture.entrySet()) {
      String password = entry.getKey();
      double expectedEntropy = entry.getValue();
      double computedEntropy = new DigitMatch(password).calculateEntropy();
      Assert.assertEquals(password, expectedEntropy, computedEntropy);
    }
  }
  
}
