// LeetCode 1352: Count Substrings (Longest Version)
// https://leetcode.com/problems/count-substrings-with-equal-number-of-0s-1s-and-2s/
// Time O(n)
// Space O(n)
import java.io.*;
import java.util.*;

public class Q6_LongestSubstringWithEqual012 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();

    int ans = longestSubstringWithEqual012(str);
    System.out.println(ans);
  }

  // find longest substring having equal number of 0, 1 and 2
  static int longestSubstringWithEqual012(String str) {
    int ans = 0;
    int c0 = 0;
    int c1 = 0;
    int c2 = 0;
    String key = "0#0";
    HashMap<String, Integer> map = new HashMap<>();
    map.put(key, -1);

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == '0') {
        c0++;
      } else if (ch == '1') {
        c1++;
      } else {
        c2++;
      }

      key = (c1 - c0) + "#" + (c2 - c1);

      if (map.containsKey(key)) {
        int firstIndex = map.get(key);
        int length = i - firstIndex;
        if (length > ans) {
          ans = length;
        }
      } else {
        map.put(key, i);
      }
    }

    return ans;
  }

}

// Input:
// 0102010
// 
// Output:
// 7
