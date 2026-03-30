// Time Complexity: O(n), Space Complexity: O(n)

import java.io.*;
import java.util.*;

public class Q63_LineReflection {

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

  public static boolean solution(int[][] points) {
    HashSet<String> set = new HashSet<>();

    int minX = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE;

    for (int[] p : points) {
      minX = Math.min(minX, p[0]);
      maxX = Math.max(maxX, p[0]);
      set.add(p[0] + "#" + p[1]);
    }

    int sum = minX + maxX;

    for (int[] p : points) {
      int rx = sum - p[0];
      String key = rx + "#" + p[1];
      if (!set.contains(key))
        return false;
    }

    return true;
  }
}

/*
 * Input:
 * 4
 * 1 1
 * -1 1
 * 1 -1
 * -1 -1
 * 
 * Output:
 * true
 */
