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
public class SequenceMatchTest {
  
  public SequenceMatchTest() {
  }

  /**
   * Test of calculateEntropy method, of class SequenceMatch.
   */
  @Test
  public void testCalculateEntropy() {
    System.out.println("Test of calculateEntropy method, "
                     + "of class SequenceMatch");
    
    HashMap<String, Double> fixtureAsc = new HashMap<>();
    fixtureAsc.put("abcd", 3d);
    fixtureAsc.put("bcde", 6.700439718141093);
    fixtureAsc.put("klmnopqrstuv", 8.285402218862249);
    fixtureAsc.put("ABCD", 7.700439718141093);
    fixtureAsc.put("BCDE", 7.700439718141093);
    fixtureAsc.put("OPQRSTUVWXYZ", 9.285402218862249);
    fixtureAsc.put("1234", 3d);
    fixtureAsc.put("2345", 5.321928094887363);
    fixtureAsc.put("0123456789", 6.643856189774725);
    
    // Test the asc fixture
    for (Map.Entry<String, Double> entry : fixtureAsc.entrySet()) {
      String password = entry.getKey();
      double expected = entry.getValue();
      double computed = new SequenceMatch(password, true).calculateEntropy();
      Assert.assertEquals(password, expected, computed);
    }
    
    
    HashMap<String, Double> fixtureDesc = new HashMap<>();
    fixtureDesc.put("dcba", 7.700439718141093);
    fixtureDesc.put("edcb", 7.700439718141093);
    fixtureDesc.put("vutsrqponmlk", 9.285402218862249);
    fixtureDesc.put("DCBA", 8.700439718141093);
    fixtureDesc.put("EDCB", 8.700439718141093);
    fixtureDesc.put("ZYXWVUTSRQPO", 10.285402218862249);
    fixtureDesc.put("4321", 6.321928094887363);
    fixtureDesc.put("5432", 6.321928094887363);
    fixtureDesc.put("9876543210", 7.643856189774725);
    
    // Test the asc fixture
    for (Map.Entry<String, Double> entry : fixtureDesc.entrySet()) {
      String password = entry.getKey();
      double expected = entry.getValue();
      double computed = new SequenceMatch(password, false).calculateEntropy();
      Assert.assertEquals(password, expected, computed);
    }
  }
  
}
