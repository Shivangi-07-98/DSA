// Time Complexity: O(n), Space Complexity: O(n)
import java.io.*;
import java.util.*;

public class Q20_KAnagrams {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String str1 = s.next();
    String str2 = s.next();
    int k = s.nextInt();

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

/*
 * input
 * fodr
 * gork
 * 2
 * 
 * output
 * true
 */
