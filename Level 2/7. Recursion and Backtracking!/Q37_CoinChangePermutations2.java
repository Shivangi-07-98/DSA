// Time Complexity: O(n!)
// Space Complexity: O(n)
import java.util.*;

public class Q37_CoinChangePermutations2 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] coins = new int[n];
    for (int i = 0; i < n; i++) coins[i] = scn.nextInt();
    int target = scn.nextInt();
    solve(coins, new boolean[n], target, "");
  }

  private static void solve(int[] coins, boolean[] used, int target, String asf) {
    if (target == 0) {
      System.out.println(asf.trim());
      return;
    }

    for (int i = 0; i < coins.length; i++) {
      if (!used[i] && coins[i] <= target) {
        used[i] = true;
        solve(coins, used, target - coins[i], asf + coins[i] + " ");
        used[i] = false;
      }
    }
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
 * 6 2
 * 3 5
 * 5 3
 */
