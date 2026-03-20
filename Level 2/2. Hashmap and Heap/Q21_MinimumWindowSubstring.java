// Time Complexity: O(n), Space Complexity: O(n)
import java.io.*;
import java.util.*;

public class Q21_MinimumWindowSubstring {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    String s = scn.next();
    String t = scn.next();

    String ans = minWindow(s, t);
    System.out.println(ans);
  }

  public static String minWindow(String s, String t) {
    if (t.length() > s.length()) {
      return "";
    }

    HashMap<Character, Integer> tmap = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      char ch = t.charAt(i);
      tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
    }

    int mmc = t.length(); // mismatch character
    int i = 0;
    int j = -1;

    HashMap<Character, Integer> smap = new HashMap<>();
    String ans = "";

    while (true) {
      // acquire
      while (mmc > 0 && i < s.length()) {
        char ch = s.charAt(i);
        smap.put(ch, smap.getOrDefault(ch, 0) + 1);

        if (smap.getOrDefault(ch, 0) <= tmap.getOrDefault(ch, 0)) {
          mmc--;
        }
        i++;
      }

      // release
      while (mmc == 0 && j < i) {
        String pans = s.substring(j + 1, i);

        if (ans.length() == 0) {
          ans = pans;
        } else if (pans.length() < ans.length()) {
          ans = pans;
        }

        j++;
        char ch = s.charAt(j);
        smap.put(ch, smap.getOrDefault(ch, 0) - 1);

        if (smap.getOrDefault(ch, 0) < tmap.getOrDefault(ch, 0)) {
          mmc++;
        }
      }

      if (i == s.length()) {
        break;
      }
    }

    return ans;
  }

}

/*
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C'
 * from string t.
 * 
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * 
 * Example 3:
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 */
