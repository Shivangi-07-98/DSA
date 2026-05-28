// https://www.geeksforgeeks.org/problems/pairs-of-non-coinciding-points4141/1

// Time Complexity: O(n), Space Complexity: O(n)

import java.io.*;
import java.util.*;

public class Q69_PairsOfNonCoincidingPoints {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[][] points = new int[n][2];
    for (int i = 0; i < n; i++) {
      points[i][0] = scn.nextInt();
      points[i][1] = scn.nextInt();
    }

    System.out.println(solution(points));
  }

  private static long comb2(long x) {
    return x * (x - 1) / 2;
  }

  public static long solution(int[][] points) {
    HashMap<Integer, Long> xMap = new HashMap<>();
    HashMap<Integer, Long> yMap = new HashMap<>();
    HashMap<String, Long> same = new HashMap<>();

    for (int[] p : points) {
      int x = p[0], y = p[1];
      xMap.put(x, xMap.getOrDefault(x, 0L) + 1);
      yMap.put(y, yMap.getOrDefault(y, 0L) + 1);
      String key = x + "#" + y;
      same.put(key, same.getOrDefault(key, 0L) + 1);
    }

    long ans = 0;
    for (long v : xMap.values())
      ans += comb2(v);
    for (long v : yMap.values())
      ans += comb2(v);
    for (long v : same.values())
      ans -= 2 * comb2(v);

    return ans;
  }
}

/*
 * Input:
 * 4
 * 1 2
 * 1 3
 * 2 3
 * 2 2
 * 
 * Output:
 * 4
 */
