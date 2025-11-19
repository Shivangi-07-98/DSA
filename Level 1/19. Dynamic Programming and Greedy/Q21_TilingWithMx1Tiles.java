import java.util.*;

public class Q21_TilingWithMx1Tiles {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 39
    int m = scn.nextInt(); // 16

    System.out.println(tilingMx1_tab(n, m));
  }

  // Tabulation solution
  public static int tilingMx1_tab(int n, int m) {
    int[] dp = new int[n + 1];
    dp[0] = 0;

    for (int i = 1; i <= n; i++) {
      if (i < m) {
        dp[i] = 1;
      } else if (i == m) {
        dp[i] = 2;
      } else {
        dp[i] = dp[i - 1] + dp[i - m];
      }
    }

    return dp[n];
  }

}
// tile floor of size n*m with tiles of size m*1
// same as climb stairs with 1 or m steps

/*
 * Sample Input:
 * 39
 * 16
 * 
 * Sample Output:
 * 61
 */
