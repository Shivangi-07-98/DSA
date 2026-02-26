// Time Complexity: O(n), Space Complexity: O(k)

import java.io.*;
import java.util.*;

public class Q47_CountExactlyKUniqueSubstrings {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    int k = scn.nextInt();

    System.out.println(solution(str, k));
  }

  public static long atMostK(String str, int k) {
    if (k <= 0)
      return 0;

    HashMap<Character, Integer> map = new HashMap<>();
    int i = 0;
    int j = 0;
    long ans = 0;

    while (i < str.length()) {
      char ch = str.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);

      while (map.size() > k) {
        char left = str.charAt(j);
        map.put(left, map.get(left) - 1);
        if (map.get(left) == 0)
          map.remove(left);
        j++;
      }

      ans += (i - j + 1);
      i++;
    }

    return ans;
  }

  public static long solution(String str, int k) {
    return atMostK(str, k) - atMostK(str, k - 1);
  }
}

/*
 * Input:
 * pqpqs
 * 2
 * 
 * Output:
 * 7
 */

