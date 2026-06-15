// https://www.geeksforgeeks.org/smallest-window-contains-characters-string/

// https://www.geeksforgeeks.org/problems/smallest-distant-window3132/1

// Time O(n)
// Space O(n)

import java.io.*;
import java.util.*;

public class Q28_SmallestSubstringAllCharsOfString {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    System.out.println(solution(str));
  }

  public static int solution(String str) {
    // Count distinct characters
    HashSet<Character> set = new HashSet<>();
    for (char ch : str.toCharArray()) {
      set.add(ch);
    }

    int required = set.size();

    HashMap<Character, Integer> map = new HashMap<>();
    int j = 0;
    int minLen = Integer.MAX_VALUE;

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);

      while (map.size() == required) {
        minLen = Math.min(minLen, i - j + 1);
        char lch = str.charAt(j);
        map.put(lch, map.get(lch) - 1);
        if (map.get(lch) == 0) {
          map.remove(lch);
        }
        j++;
      }
    }

    return minLen;
  }
}

// Input:
// aabcbcdbca

// Output:
// 4
