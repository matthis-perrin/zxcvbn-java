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

import zxcvbn.matching.YearMatch;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Matthis Perrin <matthis.perrin at gmail.com>
 */
public class YearMatchTest {
  
  public YearMatchTest() {
  }

  /**
   * Test of calculateEntropy method, of class YearMatch.
   */
  @Test
  public void testCalculateEntropy() {
    System.out.println("Test of calculateEntropy method, of class YearMatch");
    
    HashMap<String, Double> fixture = new HashMap<>();
    fixture.put("1900", 6.894817763307944);
    fixture.put("1982", 6.894817763307944);
    fixture.put("1990", 6.894817763307944);
    fixture.put("1993", 6.894817763307944);
    fixture.put("2000", 6.894817763307944);
    fixture.put("2007", 6.894817763307944);
    fixture.put("2012", 6.894817763307944);
    fixture.put("2016", 6.894817763307944);
    fixture.put("2019", 6.894817763307944);
    
    // Test the fixture
    for (Map.Entry<String, Double> entry : fixture.entrySet()) {
      String password = entry.getKey();
      double expected = entry.getValue();
      double computed = new YearMatch(password).calculateEntropy();
      Assert.assertEquals(password, expected, computed);
    }
  }
  
}
