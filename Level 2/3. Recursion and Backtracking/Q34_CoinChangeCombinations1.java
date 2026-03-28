// Time Complexity: O(n * amount)
// Space Complexity: O(amount)
import java.util.*;

public class Q34_CoinChangeCombinations1 {

  private static void solve(int[] coins, int idx, int target, String asf) {
    if (target == 0) {
      System.out.println(asf.trim());
      return;
    }
    if (idx == coins.length) return;

    for (int t = target; t >= coins[idx]; t -= coins[idx]) {
      String next = asf;
      int count = (target - t) / coins[idx];
      for (int i = 0; i < count; i++) next = next + coins[idx] + " ";
      solve(coins, idx + 1, t, next);
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] coins = new int[n];
    for (int i = 0; i < n; i++) coins[i] = scn.nextInt();
    int target = scn.nextInt();
    solve(coins, 0, target, "");
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
 * 2 5
 */
