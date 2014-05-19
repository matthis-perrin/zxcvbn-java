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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import zxcvbn.resources.Dictionaries;

/**
 *
 * @author Matthis Perrin <matthis.perrin at gmail.com>
 */
public class DictionaryMatcher {
  
  
  /**
   * Look for every part of the password that match an entry in our dictionaries
   * @param password the password that is analyzed
   * @return the list of all the match found
   */
  public static ArrayList<DictionaryMatch> match (String password) {
    
    ArrayList<DictionaryMatch> matches = new ArrayList<>();
    
    // Create all possible subsequences of the password
    for (int start = 0; start < password.length(); start++) {
      for (int end = start + 1; end <= password.length(); end++) {
        
        // For each subsequence get all the possbile l33t substitutions
        String split = password.substring(start, end);
        HashMap<String, ArrayList<Character[]>> l33tSubstitutions = 
                getAllL33tSub(split);
        
        // Add the original to the list
        l33tSubstitutions.put(split, new ArrayList<Character[]>());
        
        // Iterate through all the substitutions
        for (Map.Entry<String, ArrayList<Character[]>> entry : l33tSubstitutions.entrySet()) {
          String unl33tSplit = entry.getKey();
          ArrayList<Character[]> subs = entry.getValue();
          boolean isL33t = !subs.isEmpty();
          
          // Iterate through all our dictionaries
          for (HashMap<String, Integer> dictionary : Dictionaries.dictionaries) {
            
            // If there is a match, we add it to the result
            Integer rank = dictionary.get(unl33tSplit);
            if (rank != null) {
              matches.add(new DictionaryMatch(split, rank, isL33t, subs));
            }
            
          }
        }
        
      }
    }
    
    // Return all the matches
    return matches;
    
  }
  
  
  /**
   * Get all the possible l33t substitutions for a given password
   * @param password the password where we are looking for the l33t 
   * substitutions
   * @return an <code>HashMap</code> of all the possible password after l33t 
   * substitutions along with a <code>HashMap</code> of the substitutions
   */
  private static HashMap<String, ArrayList<Character[]>> getAllL33tSub (
          String password) {
    Character[] array = new Character[password.length()];
    for (int i = 0; i < password.length(); i++) {
      array[i] = new Character(password.charAt(i));
    }
    return getAllL33tSub(array, 0, new ArrayList<Character[]>());
  }
  
  
  
  /**
   * <code>HashMap</code> describing the common l33t substitutions
   */
  private static final HashMap<Character, Character[]> l33tTable = 
          new HashMap<>();
  static {
    l33tTable.put('!', new Character[] { 'i' });
    l33tTable.put('$', new Character[] { 's' });
    l33tTable.put('%', new Character[] { 'x' });
    l33tTable.put('(', new Character[] { 'c' });
    l33tTable.put('+', new Character[] { 't' });
    l33tTable.put('0', new Character[] { 'o' });
    l33tTable.put('1', new Character[] { 'i', 'l' });
    l33tTable.put('2', new Character[] { 'z' });
    l33tTable.put('3', new Character[] { 'e' });
    l33tTable.put('4', new Character[] { 'a' });
    l33tTable.put('5', new Character[] { 's' });
    l33tTable.put('6', new Character[] { 'g' });
    l33tTable.put('7', new Character[] { 'l', 't' });
    l33tTable.put('8', new Character[] { 'b' });
    l33tTable.put('9', new Character[] { 'g' });
    l33tTable.put('<', new Character[] { 'c' });
    l33tTable.put('@', new Character[] { 'a' });
    l33tTable.put('[', new Character[] { 'c' });
    l33tTable.put('{', new Character[] { 'c' });
    l33tTable.put('|', new Character[] { 'i', 'l' });
  }
  
  
  /**
   * Recursive method that get all the possible l33t substitutions for a given 
   * password, starting at a specific index
   * @param password the password where we are looking for the l33t 
   * substitutions
   * @param index the index we start looking for substitutions
   * @param substitutions the <code>ArrayList</code> of the substitutions that
   * already occurred
   * @return an <code>HashMap</code> of all the possible password after l33t 
   * substitutions along with a <code>ArrayList</code> of the substitutions
   */
  private static HashMap<String, ArrayList<Character[]>> getAllL33tSub (
          Character[] password, int index, 
          ArrayList<Character[]> substitutions) {
    
    // Init our result variable
    HashMap<String, ArrayList<Character[]>> sub = new HashMap<>();
    
    // Go through all the character of tha password starting at the specified
    // index
    for (int i = index; i < password.length; i++) {
      Character currentChar = password[i];
      // Get the possible substitutions for the current character
      Character[] charSub = l33tTable.get(currentChar);
      
      // If no substitution are possible, we continue
      if (charSub != null) {
        
        // Iterate through all the possible substitutions
        for (Character charToSub : charSub) {
          
          // Clone the map of substitutions and add the current substitutions
          ArrayList<Character[]> subCopy = 
                  (ArrayList<Character[]>) substitutions.clone();
          subCopy.add(new Character[] {password[i], charToSub});
          
          // Clone the password and perform the substitution
          Character[] passwordCopy = Arrays.copyOf(password, password.length);
          passwordCopy[i] = charToSub;
          
          // Get all the possible substitutions from the current state
          sub.putAll(getAllL33tSub(passwordCopy, i + 1, subCopy));
        }
        
        // Once we found a substitution we stop, the rest is taken care of by
        // the recursive call
        break;
      }
    }
    
    // If no substitution has been made, we are at the end of the recursion
    // so we add the final password and its substitutions
    if (sub.isEmpty()) {
      StringBuilder sb = new StringBuilder(password.length);
      for (Character c : password) sb.append(c);// Convert Character[] to String
      sub.put(sb.toString(), substitutions);
    }
    
    // Returns all the passwords found (and the substitutions)
    return sub;
    
  }
  
  
}
