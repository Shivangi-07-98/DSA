// Time Complexity: O(amount * n)
// Space Complexity: O(amount)
import java.util.*;

public class Q35_CoinChangePermutations1 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] coins = new int[n];
    for (int i = 0; i < n; i++) coins[i] = scn.nextInt();
    int target = scn.nextInt();
    solve(coins, target, "");
  }

  private static void solve(int[] coins, int target, String asf) {
    if (target == 0) {
      System.out.println(asf.trim());
      return;
    }

    for (int coin : coins) {
      if (coin <= target) {
        solve(coins, target - coin, asf + coin + " ");
      }
    }
  }


}

/*
 * Input:
 * 3
 * 2 3 5
 * 7
 *
 * Output:
 * 2 2 3
 * 2 3 2
 * 3 2 2
 * 2 5
 * 5 2
 */
