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

package zxcvbn.java;

import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Matthis Perrin <matthis.perrin at gmail.com>
 */
public class EntropyTest {
  
  
  /**
   * Test of log2 method, of class Entropy.
   */
  @Test
  public void testLog2() {
    Assert.assertEquals(Double.NaN, Entropy.log2(Double.NEGATIVE_INFINITY));
    Assert.assertEquals(Double.NaN, Entropy.log2(-1));
    Assert.assertEquals(Double.NEGATIVE_INFINITY, Entropy.log2(0));
    Assert.assertEquals(-1d, Entropy.log2(0.5));
    Assert.assertEquals(-2d, Entropy.log2(0.25));
    Assert.assertEquals(0d, Entropy.log2(1));
    Assert.assertEquals(1d, Entropy.log2(2));
    Assert.assertEquals(10d, Entropy.log2(1024));
    Assert.assertEquals(Double.POSITIVE_INFINITY, 
            Entropy.log2(Double.POSITIVE_INFINITY));
  }

  
  /**
   * Test of calculateRepeatEntropy method, of class Entropy.
   */
  @Test
  public void testCalculateRepeatEntropy() {
    HashMap<String, Double> fixture = new HashMap<>();
    fixture.put("", 0d);
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
      double computedEntropy = Entropy.calculateRepeatEntropy(password);
      Assert.assertEquals(password, expectedEntropy, computedEntropy);
    }
  }

  
  /**
   * Test of calculateSequenceEntropy method, of class Entropy.
   */
  @Test
  public void testCalculateSequenceEntropy() {
    HashMap<String, Double> fixtureAsc = new HashMap<>();
    fixtureAsc.put("", 0d);
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
      double expectedEntropy = entry.getValue();
      double computedEntropy = Entropy.calculateSequenceEntropy(password, true);
      Assert.assertEquals(password, expectedEntropy, computedEntropy);
    }
    
    
    HashMap<String, Double> fixtureDesc = new HashMap<>();
    fixtureDesc.put("", 0d);
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
      double expectedEntropy = entry.getValue();
      double computedEntropy = Entropy.calculateSequenceEntropy(password, false);
      Assert.assertEquals(password, expectedEntropy, computedEntropy);
    }
  }

  
  /**
   * Test of calculateDigitsEntropy method, of class Entropy.
   */
  @Test
  public void testCalculateDigitsEntropy() {
    HashMap<String, Double> fixture = new HashMap<>();
    fixture.put("", 0d);
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
      double computedEntropy = Entropy.calculateDigitsEntropy(password);
      Assert.assertEquals(password, expectedEntropy, computedEntropy);
    }
  }
  
}
