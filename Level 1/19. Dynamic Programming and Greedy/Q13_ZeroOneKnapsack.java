import java.io.*;
import java.util.*;

public class Q13_ZeroOneKnapsack {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt(); // 5
    int[] values = new int[n];
    int[] wts = new int[n];
    for (int i = 0; i < n; i++) { // 15 14 10 45 30
      values[i] = scn.nextInt();
    }
    for (int i = 0; i < n; i++) { // 2 5 1 3 4
      wts[i] = scn.nextInt();
    }
    int cap = scn.nextInt(); // 7

    System.out.println(zeroOneKnapsack_tab(values, wts, cap));
  }

  // Tabulation solution
  public static int zeroOneKnapsack_tab(int[] values, int[] wts, int cap) {
    int[][] dp = new int[values.length + 1][cap + 1]; // 6 8

    for (int i = 1; i < dp.length; i++) { // row = 1-5
      for (int j = 1; j < dp[0].length; j++) { // col = 1-7
        int idx = i - 1;
        int wt = wts[idx];
        int val = values[idx];

        if (j >= wt) {
          dp[i][j] = Math.max(dp[i - 1][j] + 0, dp[i - 1][j - wt] + val);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[values.length][cap]; // 5 7
  }

}
// each item can be used at most once
// maximize value within capacity, bag mai value maximum krni hai
// har item ke paas 2 option hai bag mai ja skta hai aur nhi jaa skta hai
// 2^n = 32 combinations

/*
 * Sample Input:
 * 5
 * 15 14 10 45 30 (value)
 * 2 5 1 3 4 (weight)
 * 7 (bag of 7 kg capacity)
 * 
 * Sample Output:
 * 75
 */
