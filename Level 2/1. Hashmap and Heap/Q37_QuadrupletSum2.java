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

    System.out.println(fourSumCount(a, b, c, d));
    scn.close();
  }

  public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    int n = A.length;
    if (n == 0)
      return 0;

    int res = 0;

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        res += map.getOrDefault(-1 * (C[i] + D[j]), 0);
      }
    }

    return res;
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
