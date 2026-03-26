// Time Complexity: O(2^n)
// Space Complexity: O(n)
import java.util.*;

public class Q36_CoinChangeCombinations2 {

  private static void solve(int[] coins, int idx, int target, String asf) {
    if (target == 0) {
      System.out.println(asf.trim());
      return;
    }
    if (idx == coins.length || target < 0) return;

    solve(coins, idx + 1, target - coins[idx], asf + coins[idx] + " ");
    solve(coins, idx + 1, target, asf);
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
 * 4
 * 2 3 5 6
 * 8
 *
 * Output:
 * 2 6
 * 3 5
 */
