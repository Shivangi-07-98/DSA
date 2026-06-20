// Time O(26 * n)
// Space O(26)

import java.io.*;
import java.util.*;

public class Q66_LongestSubstringEachCharAtLeastK {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s = scn.next();
    int k = scn.nextInt();

    System.out.println(solution(s, k));
  }

  public static int solution(String s, int k) {
    int ans = 0;

    for (int targetUnique = 1; targetUnique <= 26; targetUnique++) {
      int[] freq = new int[26];
      int i = 0;
      int j = 0;
      int unique = 0;
      int countAtLeastK = 0;

      while (i < s.length()) {
        int idx = s.charAt(i) - 'a';
        if (freq[idx] == 0)
          unique++;
        freq[idx]++;
        if (freq[idx] == k)
          countAtLeastK++;

        while (unique > targetUnique) {
          int left = s.charAt(j) - 'a';
          if (freq[left] == k)
            countAtLeastK--;
          freq[left]--;
          if (freq[left] == 0)
            unique--;
          j++;
        }

        if (unique == targetUnique && unique == countAtLeastK) {
          ans = Math.max(ans, i - j + 1);
        }

        i++;
      }
    }

    return ans;
  }
}

// Input:
// aaabb 3
// 
// Output:
// 3
