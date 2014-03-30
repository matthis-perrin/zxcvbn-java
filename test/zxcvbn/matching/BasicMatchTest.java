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

import zxcvbn.matching.BasicMatch;
import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Matthis Perrin <matthis.perrin at gmail.com>
 */
public class BasicMatchTest {
  
  
  @Rule
  public ExpectedException illegalArgumentException = ExpectedException.none();
  
  
  /**
   * Test of the constructor of class BasicMatch.
   */
  @Test
  public void testContructor () {
    System.out.println("Test of the constructor of class BasicMatch");
    
    illegalArgumentException.expect(IllegalArgumentException.class);
    illegalArgumentException.expectMessage("Null String");
    BasicMatch instanceWithNull = new BasicMatchImpl(null);
    
    illegalArgumentException.expect(IllegalArgumentException.class);
    illegalArgumentException.expectMessage("Empty String");
    BasicMatch instanceWithEmpty = new BasicMatchImpl(null);
  }

  
  /**
   * Test of getToken method, of class BasicMatch.
   */
  @Test
  public void testGetToken () {
    System.out.println("Test of getToken method, of class BasicMatch");
    BasicMatch instance = new BasicMatchImpl("dummyToken");
    String result = instance.getToken();
    Assert.assertEquals("dummyToken", result);
  }

  
  /**
   * Test of log2 method, of class BasicMatch.
   */
  @Test
  public void testLog2 () {
    System.out.println("Test of log2 method, of class BasicMatch");
    Assert.assertEquals(Double.NaN, BasicMatch.log2(Double.NEGATIVE_INFINITY));
    Assert.assertEquals(Double.NaN, BasicMatch.log2(-1));
    Assert.assertEquals(Double.NEGATIVE_INFINITY, BasicMatch.log2(0));
    Assert.assertEquals(-1d, BasicMatch.log2(0.5));
    Assert.assertEquals(-2d, BasicMatch.log2(0.25));
    Assert.assertEquals(0d, BasicMatch.log2(1));
    Assert.assertEquals(1d, BasicMatch.log2(2));
    Assert.assertEquals(10d, BasicMatch.log2(1024));
    Assert.assertEquals(Double.POSITIVE_INFINITY, 
            BasicMatch.log2(Double.POSITIVE_INFINITY));
  }
  
  
  public class BasicMatchImpl extends BasicMatch {

    public BasicMatchImpl (String s) {
      super(s);
    }

    @Override
    public double calculateEntropy() { return 0; }
  }

  
  /**
   * Test of nCk method, of class BasicMatch.
   */
  @Test
  public void testNCk() {
    System.out.println("Test of nCk method, of class BasicMatch.");
    Assert.assertEquals(0l, BasicMatch.nCk(2, 3));
    Assert.assertEquals(1l, BasicMatch.nCk(10, 0));
    Assert.assertEquals(120l, BasicMatch.nCk(10, 3));
    Assert.assertEquals(120l, BasicMatch.nCk(10, 7));
    Assert.assertEquals(1646492110120l, BasicMatch.nCk(80, 10));
    Assert.assertEquals(26252279997448736l, BasicMatch.nCk(58, 27));
  }
  
  
}
