import java.io.*;
import java.util.*;

public class Q14_UnboundedKnapsack {

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

    System.out.println(unboundedKnapsack_tab(values, wts, cap));
  }

  // Tabulation solution
  public static int unboundedKnapsack_tab(int[] values, int[] wts, int cap) {
    int[] dp = new int[cap + 1]; // 8

    for (int i = 1; i < dp.length; i++) { // row = 1-7
      for (int j = 0; j < wts.length; j++) { // col = 0-4
        int wt = wts[j];
        int val = values[j];

        if (i >= wt) {
          dp[i] = Math.max(dp[i], dp[i - wt] + val);
        }
      }
    }

    return dp[cap]; // 7
  }

}
// each item can be used unlimited times
// maximize value within capacity, bag mai value maximum krni hai

/*
 * Sample Input:
 * 5
 * 15 14 10 45 30 (value)
 * 2 5 1 3 4 (weight)
 * 7 (bag of 7 kg capacity)
 * 
 * Sample Output:
 * 100
 */
