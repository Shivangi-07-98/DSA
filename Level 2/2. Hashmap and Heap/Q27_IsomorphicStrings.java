// Time Complexity: O(n), Space Complexity: O(n)

// WHAT IS THE QUESTION ASKING?
// Isomorphic Strings: Two strings are isomorphic if characters can be mapped one-to-one
// Example: "egg" and "add" are isomorphic (e→a, g→d)
// Example: "foo" and "bar" are not isomorphic (o→a and o→r, conflict)

import java.io.*;
import java.util.*;

public class Q27_IsomorphicStrings {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    String s1 = scn.next();
    String s2 = scn.next();

    System.out.println(solution(s1, s2));
  }

  public static boolean solution(String s1, String s2) {

    if (s1.length() != s2.length())
      return false;

    HashMap<Character, Character> map = new HashMap<>();
    HashMap<Character, Boolean> used = new HashMap<>();

    for (int i = 0; i < s1.length(); i++) {

      char ch1 = s1.charAt(i);
      char ch2 = s2.charAt(i);

      // Mapping exists
      if (map.containsKey(ch1)) {

        if (map.get(ch1) != ch2) {
          return false; // conflict
        }

      } else {

        // Reverse conflict
        if (used.containsKey(ch2)) {
          return false;
        }

        map.put(ch1, ch2);
        used.put(ch2, true);
      }
    }

    return true;
  }
}

/*
 * Input:
 * egg add
 * 
 * Output:
 * true
 */
