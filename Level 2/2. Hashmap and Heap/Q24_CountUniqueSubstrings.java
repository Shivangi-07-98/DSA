// Time O(n)
// Space O(n)

import java.io.*;
import java.util.*;

public class Q24_CountUniqueSubstrings {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    System.out.println(solution(str));
  }

  public static int solution(String str) {
    HashMap<Character, Integer> map = new HashMap<>();

    int i = -1;
    int j = -1;
    int count = 0;

    while (true) {
      boolean f1 = false;
      boolean f2 = false;

      // Acquire
      while (i < str.length() - 1) {
        f1 = true;
        i++;

        char ch = str.charAt(i);
        map.put(ch, map.getOrDefault(ch, 0) + 1);

        // Duplicate found
        if (map.get(ch) == 2) {
          break;
        } else {
          count += (i - j); // ⭐ Core Pepcoding Logic
        }
      }

      // Release
      while (j < i) {
        f2 = true;
        j++;

        char ch = str.charAt(j);
        map.put(ch, map.get(ch) - 1);

        if (map.get(ch) == 1) {
          count += (i - j); // ⭐ Resume counting
          break;
        }
      }

      if (!f1 && !f2)
        break;
    }

    return count;
  }
}

// Input:
// abcd
// 
// Output:
// 10
// 
// Explanation:
// All substrings are unique
// n(n+1)/2 = 4*5/2 = 10
