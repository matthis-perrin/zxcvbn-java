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
public class DateMatchTest {
  
  public DateMatchTest() {
  }

  /**
   * Test of calculateEntropy method, of class DateMatch.
   */
  @Test
  public void testCalculateEntropy() {
    System.out.println("Test of calculateEntropy method, of class DateMatch");
    
    HashMap<DateMatch, Double> fixture = new HashMap<>();
    fixture.put(new DateMatch(0, 0, 1990, ""), 15.433976574415976);
    fixture.put(new DateMatch(1, 0, 2012, ""), 15.433976574415976);
    fixture.put(new DateMatch(12, 12, 1900, ""), 15.433976574415976);
    fixture.put(new DateMatch(23, 10, 2014, ""), 15.433976574415976);
    fixture.put(new DateMatch(10, 23, 2014, ""), 15.433976574415976);
    fixture.put(new DateMatch(0, 0, 1990, "."), 17.433976574415976);
    fixture.put(new DateMatch(1, 0, 2012, "/"), 17.433976574415976);
    fixture.put(new DateMatch(12, 12, 1900, "-"), 17.433976574415976);
    fixture.put(new DateMatch(23, 10, 2014, ","), 17.433976574415976);
    fixture.put(new DateMatch(10, 23, 2014, " "), 17.433976574415976);
    
    // Test the fixture
    for (Map.Entry<DateMatch, Double> entry : fixture.entrySet()) {
      DateMatch match = entry.getKey();
      double expectedEntropy = entry.getValue();
      double computedEntropy = match.calculateEntropy();
      Assert.assertEquals(match.getToken(), expectedEntropy, computedEntropy);
    }
  }
  
}
