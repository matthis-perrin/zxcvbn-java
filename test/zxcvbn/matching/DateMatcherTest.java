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

import java.util.ArrayList;
import org.junit.Test;

/**
 *
 * @author Matthis Perrin <matthis.perrin at gmail.com>
 */
public class DateMatcherTest {
  
  /**
   * Test of match method, of class DateMatcher.
   */
  @Test
  public void testMatch() {
    String password = "121935-18-2374_6_281.97.4682346 8 1973 2 44";
    ArrayList<DateMatch> matches = DateMatcher.match(password);
    for (DateMatch m : matches) {
      String sep = (m.getSeparator() == "") ? "[empty]" : m.getSeparator();
      System.out.println(m.getDay() + sep + m.getMonth() + sep + m.getYear());
    }
  }
  
}
