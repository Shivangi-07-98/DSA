// Time Complexity: O(n^2), Space Complexity: O(n)

import java.io.*;
import java.util.*;

public class Q37_QuadrupletSum2 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[] a = new int[n];
    int[] b = new int[n];
    int[] c = new int[n];
    int[] d = new int[n];

    for (int i = 0; i < n; i++)
      a[i] = scn.nextInt();
    for (int i = 0; i < n; i++)
      b[i] = scn.nextInt();
    for (int i = 0; i < n; i++)
      c[i] = scn.nextInt();
    for (int i = 0; i < n; i++)
      d[i] = scn.nextInt();

    System.out.println(solution(a, b, c, d));
  }

  public static int solution(int[] a, int[] b, int[] c, int[] d) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int x : a) {
      for (int y : b) {
        int sum = x + y;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
    }

    int ans = 0;
    for (int x : c) {
      for (int y : d) {
        ans += map.getOrDefault(-(x + y), 0);
      }
    }

    return ans;
  }
}

/*
 * Input:
 * 2
 * 1 2
 * -2 -1
 * -1 2
 * 0 2
 * 
 * Output:
 * 2
 */
