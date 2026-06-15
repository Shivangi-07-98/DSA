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
    int i = -1;
    int j = -1;
    int ans = Integer.MAX_VALUE;

    while (true) {
      boolean f1 = false;
      boolean f2 = false;

      while (i < str.length() - 1 && map.size() < required) {
        f1 = true;
        i++;
        char ch = str.charAt(i);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
      }

      while (j < i && map.size() == required) {
        f2 = true;
        ans = Math.min(ans, i - j);
        j++;
        char ch = str.charAt(j);
        map.put(ch, map.get(ch) - 1);
        if (map.get(ch) == 0) {
          map.remove(ch);
        }
      }

      if (!f1 && !f2)
        break;
    }

    return ans;
  }
}

// Input:
// aabcbcdbca

// Output:
// 4
