// Time Complexity: O(n), Space Complexity: O(n)
// agar do strings ke saare characters match kar rahe hain, aur jo characters match nahi kar rahe unki count **k ya usse kam hai**, to wo **k-anagram** hain
 
import java.io.*;
import java.util.*;

public class Q20_KAnagrams {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str1 = scn.next();
    String str2 = scn.next();
    int k = scn.nextInt();

    System.out.println(areKAnagrams(str1, str2, k));
  }

  public static boolean areKAnagrams(String str1, String str2, int k) {
    if (str1.length() != str2.length()) {
      return false;
    }

    int[] farr = new int[26];

    // frequency of str1
    for (int i = 0; i < str1.length(); i++) {
      char ch = str1.charAt(i);
      farr[ch - 'a']++;
    }

    // reduce frequency using str2
    for (int i = 0; i < str2.length(); i++) {
      char ch = str2.charAt(i);
      if (farr[ch - 'a'] != 0) {
        farr[ch - 'a']--;
      }
    }

    int diff = 0;
    for (int i = 0; i < 26; i++) {
      diff += farr[i];
    }

    return diff <= k;
  }

}

// Algorithm - dono str ka freq map bnao

/*
 * input
 * fodr
 * gork
 * 2
 * 
 * output
 * true
 */
