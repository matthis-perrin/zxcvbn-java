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

package zxcvbn.resources;

import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Matthis Perrin <matthis.perrin at gmail.com>
 */
public class DictionariesTest {
  
  /**
   * Test of loadFile method, of class Dictionaries.
   */
  @Test
  public void testLoadFile() {
    System.out.println("Test of loadFile method, of class Dictionaries");
    
    HashMap<String, Integer> fixture = new HashMap<>();
    fixture.put("password", 1);
    fixture.put("27sfd83", null);
    fixture.put("hunter", 25);
    
    // Test the fixture
    for (Map.Entry<String, Integer> entry : fixture.entrySet()) {
      String value = entry.getKey();
      Integer expected = entry.getValue();
      Integer computed = Dictionaries.passwords.get(value);
      Assert.assertEquals(expected, computed);
    }
  }
  
}
