import java.io.*;
import java.util.*;

public class Q20_TilingWith2x1Tiles {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 8

    System.out.println(tiling2x1_tab(n));
  }

  // Tabulation solution
  public static int tiling2x1_tab(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }

}
// tile floor of size n*2 with tiles of size 2*1
// same as climb stairs with 1 or 2 steps

/*
 * Sample Input:
 * 8
 * 
 * Sample Output:
 * 34
 */
