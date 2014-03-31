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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Matthis Perrin <matthis.perrin at gmail.com>
 */
public class Dictionaries {


  /**
   * Read a resource file with a list of entries (sorted by frequency) and use
   * it to create a ranked dictionary.
   * @param fileName the name of the file
   * @return the ranked dictionary (a <code>HashMap</code> which associated a
   * rank to each entry
   */
  private static HashMap<String, Integer> loadFile (String fileName) {
    HashMap<String, Integer> ranked = new HashMap<>();

    try {
      String path = "dictionaries/" + fileName;
      InputStream is = Dictionaries.class.getResourceAsStream(path);
      BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

      String line;
      int i = 1;
      while ((line = br.readLine()) != null) {
        ranked.put(line, i++);
      }
    }
    catch (IOException e) {
      System.out.println("Error while reading " + fileName);
    }

    return ranked;
  }



  /**
   * Ranked dictionary of common passwords
   */
  public static final HashMap<String, Integer> passwords = loadFile("passwords.txt");

  /**
   * Ranked dictionary of common male names
   */
  public static final HashMap<String, Integer> maleNames = loadFile("male-names.txt");

  /**
   * Ranked dictionary of common female names
   */
  public static final HashMap<String, Integer> femaleNames = loadFile("female-names.txt");

  /**
   * Ranked dictionary of common surnames
   */
  public static final HashMap<String, Integer> surnames = loadFile("surnames.txt");

  /**
   * Ranked dictionary of common English word
   */
  public static final HashMap<String, Integer> english = loadFile("english.txt");


  /**
   * List all the ranked dictionaries
   */
  public static final ArrayList<HashMap<String, Integer>> dictionaries = 
          new ArrayList<>();
  static {
    dictionaries.add(passwords);
    dictionaries.add(maleNames);
    dictionaries.add(femaleNames);
    dictionaries.add(surnames);
    dictionaries.add(english);
  }


}
