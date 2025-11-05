import java.util.*;
public class Q14_PaintHouseManyColors {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = scn.nextInt();
    int[][] costs = new int[n][k];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < k; j++) {
        costs[i][j] = scn.nextInt();
      }
    }

    System.out.println(paintHouse_tab(costs, n, k));
    System.out.println(paintHouse_optimized(costs, n, k));
  }

  // Tabulation solution - O(n*k*k)
  public static int paintHouse_tab(int[][] costs, int n, int k) {
    int[][] strg = new int[n][k];

    for (int j = 0; j < k; j++) {
      strg[0][j] = costs[0][j];
    }

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < k; j++) {
        int minCost = Integer.MAX_VALUE;
        for (int prev = 0; prev < k; prev++) {
          if (prev != j) {
            minCost = Math.min(minCost, strg[i - 1][prev]);
          }
        }
        strg[i][j] = costs[i][j] + minCost;
      }
    }

    int result = Integer.MAX_VALUE;
    for (int j = 0; j < k; j++) {
      result = Math.min(result, strg[n - 1][j]);
    }

    return result;
  }

  // Optimized solution - O(n*k)
  // Track minimum and second minimum from previous row to avoid nested loop
  public static int paintHouse_optimized(int[][] costs, int n, int k) {
    int[] prev = new int[k];
    for (int j = 0; j < k; j++) {
      prev[j] = costs[0][j];
    }

    for (int i = 1; i < n; i++) {
      int[] curr = new int[k];
      
      // Find minimum and second minimum from previous row
      int min1 = Integer.MAX_VALUE;
      int min2 = Integer.MAX_VALUE;
      int min1Idx = -1;

      for (int j = 0; j < k; j++) {
        if (prev[j] < min1) {
          min2 = min1;
          min1 = prev[j];
          min1Idx = j;
        } else if (prev[j] < min2) {
          min2 = prev[j];
        }
      }

      // Fill current row
      for (int j = 0; j < k; j++) {
        if (j == min1Idx) {
          curr[j] = costs[i][j] + min2; // Use second minimum
        } else {
          curr[j] = costs[i][j] + min1; // Use minimum
        }
      }

      prev = curr;
    }

    int result = Integer.MAX_VALUE;
    for (int j = 0; j < k; j++) {
      result = Math.min(result, prev[j]);
    }

    return result;
  }
  
}

