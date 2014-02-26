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

package zxcvbn.java.resources;

import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Matthis Perrin <matthis.perrin at gmail.com>
 */
public class AdjacencyGraphTest {

  /**
   * Test of neighborsNumber method, of class AdjacencyGraph.
   */
  @Test
  public void testNeighborsNumber() {
    System.out.println("Test of neighborsNumber method, of class AdjacencyGraph");
    
    HashMap<String[], Integer> fixture = new HashMap<>();
    fixture.put(new String[] {}, 0);
    fixture.put(new String[] {null}, 0);
    fixture.put(new String[] {"a"}, 1);
    fixture.put(new String[] {""}, 1);
    fixture.put(new String[] {"a", "rsa", ""}, 3);
    fixture.put(new String[] {"a", null, "b"}, 2);
    fixture.put(new String[] {null, null, null}, 0);
    fixture.put(new String[] {null, "a", null, "b", null, null}, 2);
    
    // Test the fixture
    for (Map.Entry<String[], Integer> entry : fixture.entrySet()) {
      String[] neighbors = entry.getKey();
      int expected = entry.getValue();
      int computed = AdjacencyGraph.neighborsNumber(neighbors);
      Assert.assertEquals(expected, computed);
    }
  }
  
  /**
   * Test of calcAverageDegree method, of class AdjacencyGraph.
   */
  @Test
  public void testCalcAverageDegree() {
    System.out.println("Test of calcAverageDegree method, of class AdjacencyGraph");
    
    HashMap<HashMap<Character, String[]>, Double> fixture = new HashMap<>();
    fixture.put(AdjacencyGraph.qwerty, 4.595744680851064);
    fixture.put(AdjacencyGraph.dvorak, 4.595744680851064);
    fixture.put(AdjacencyGraph.keypad, 5.066666666666666);
    fixture.put(AdjacencyGraph.macKeypad, 5.25);
    
    // Test the fixture
    for (Map.Entry<HashMap<Character, String[]>, Double> entry : fixture.entrySet()) {
      HashMap<Character, String[]> keys = entry.getKey();
      double expected = entry.getValue();
      double computed = AdjacencyGraph.calcAverageDegree(keys);
      Assert.assertEquals(expected, computed);
    }
  }
  
}
