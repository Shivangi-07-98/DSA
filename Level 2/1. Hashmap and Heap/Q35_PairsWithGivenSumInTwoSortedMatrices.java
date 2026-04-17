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

  // duplicate values
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

  // unique values
  public static int solve(int[][] num1, int[][] num2, int k) {
    int size = num2.length * num2[0].length;
    int left = 0;
    int right = size - 1;
    int ans = 0;

    while (left < size && right >= 0) {
      int r1 = left / num1[0].length;
      int c1 = left % num1[0].length;

      int r2 = right / num2[0].length;
      int c2 = right % num2[0].length;

      int sum = num1[r1][c1] + num2[r2][c2];

      if (sum == k) {
        ans++;
        left++;
        right--;
      } else if (sum < k) {
        left++;
      } else {
        right--;
      }
    }

    return ans;
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
