// Time Complexity: pick O(1), Space Complexity: O(blacklist size)

import java.io.*;
import java.util.*;

public class Q55_RandomPickWithBlacklist {

  private static class Solution {
    int size;
    HashMap<Integer, Integer> map = new HashMap<>();
    Random rand = new Random();

    Solution(int n, int[] blacklist) {
      size = n - blacklist.length;
      HashSet<Integer> black = new HashSet<>();
      for (int b : blacklist)
        black.add(b);

      int last = n - 1;
      for (int b : blacklist) {
        if (b < size) {
          while (black.contains(last))
            last--;
          map.put(b, last);
          last--;
        }
      }
    }

    int pick() {
      int r = rand.nextInt(size);
      return map.getOrDefault(r, r);
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    int[] blacklist = new int[m];
    for (int i = 0; i < m; i++) {
      blacklist[i] = scn.nextInt();
    }

    int q = scn.nextInt();
    Solution sol = new Solution(n, blacklist);

    for (int i = 0; i < q; i++) {
      System.out.println(sol.pick());
    }
  }
}

/*
 * Input:
 * 7 2
 * 2 3
 * 5
 * 
 * Output:
 * random values from [0,1,4,5,6]
 */
