// Time O(n)
// Space O(n)

import java.io.*;
import java.util.*;

public class Q63_LineReflection {
  public static boolean isReflected(int[][] points) {
    HashSet<String> set = new HashSet<>();

    long xmin = points[0][0];
    long xmax = points[0][0];

    set.add(points[0][0] + "$" + points[0][1]);

    for (int i = 1; i < points.length; i++) {
      set.add(points[i][0] + "$" + points[i][1]);
      xmin = Math.min(xmin, points[i][0]);
      xmax = Math.max(xmax, points[i][0]);
    }

    long twiceXmirr = xmin + xmax;

    for (int i = 0; i < points.length; i++) {
      long x = points[i][0];
      long y = points[i][1];

      long ximg = twiceXmirr - x;
      long yimg = y;

      if (set.contains(ximg + "$" + yimg) == false) {
        return false;
      }
    }

    return true;
  }
  
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[][] points = new int[n][2];

    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < points[0].length; j++) {
        points[i][j] = scn.nextInt();
      }
    }

    System.out.println(isReflected(points));
  }
}

// Input:
// 4
// 1 1
// -1 1
// 1 -1
// -1 -1
// 
// Output:
// true
