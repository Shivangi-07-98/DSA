// Time Complexity: O(n * m), Space Complexity: O(n * m)

import java.io.*;
import java.util.*;

public class Q35_PairsWithGivenSumInTwoSortedMatrices {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();

    int[][] mat1 = new int[n][m];
    int[][] mat2 = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        mat1[i][j] = scn.nextInt();
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        mat2[i][j] = scn.nextInt();
      }
    }

    int k = scn.nextInt();
    System.out.println(solution(mat1, mat2, k));
  }

  public static int solution(int[][] mat1, int[][] mat2, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int[] row : mat1) {
      for (int val : row) {
        map.put(val, map.getOrDefault(val, 0) + 1);
      }
    }

    int count = 0;
    for (int[] row : mat2) {
      for (int val : row) {
        count += map.getOrDefault(k - val, 0);
      }
    }

    return count;
  }
}

/*
 * Input:
 * 2 2
 * 1 3
 * 5 7
 * 2 3
 * 4 8
 * 10
 * 
 * Output:
 * 2
 */
