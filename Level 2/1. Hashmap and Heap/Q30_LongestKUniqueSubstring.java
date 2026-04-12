// Time Complexity: O(n), Space Complexity: O(n)
import java.io.*;
import java.util.*;

public class Q30_LongestKUniqueSubstring {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    int k = scn.nextInt();
    System.out.println(solution(str, k));
  }

  public static int solution(String str, int k) {
    HashMap<Character, Integer> map = new HashMap<>();
    int i = -1;
    int j = -1;
    int ans = -1;

    while (true) {
      boolean f1 = false;
      boolean f2 = false;

      // Acquire
      while (i < str.length() - 1) {
        f1 = true;
        i++;
        char ch = str.charAt(i);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
        if (map.size() < k) {
          continue;
        } else if (map.size() == k) {
          ans = Math.max(ans, i - j);
        } else {
          break;
        }
      }

      // Release
      while (j < i) {
        f2 = true;
        j++;
        char ch = str.charAt(j);
        map.put(ch, map.get(ch) - 1);
        if (map.get(ch) == 0) {
          map.remove(ch);
        }
        if (map.size() == k) {
          ans = Math.max(ans, i - j);
          break;
        }
      }

      if (!f1 && !f2)
        break;
    }

    return ans;
  }
}

/*
 * Input:
 * aabcbcdbca
 * 2
 * 
 * Output:
 * 4
 */
