import java.util.*;
public class Q11_CoinChangeCombination {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] coins = new int[n];
    for (int i = 0; i < n; i++) {
      coins[i] = scn.nextInt();
    }
    int target = scn.nextInt();

    Integer[][] storage = new Integer[n + 1][target + 1];
    System.out.println(coinChangeCombination(coins, 0, target));
    System.out.println(coinChangeCombination_memo(coins, 0, target, storage));
    System.out.println(coinChangeCombination_tab(coins, target));
    System.out.println(coinChangeCombination_optimized(coins, target));
  }

  // Recursive solution
  // Combination: order doesn't matter, so we use coins in order
  public static int coinChangeCombination(int[] coins, int idx, int target) {
    if (target == 0) {
      return 1;
    }
    if (idx == coins.length) {
      return 0;
    }

    int count = 0;
    
    // Include current coin (can use multiple times)
    if (target >= coins[idx]) {
      count += coinChangeCombination(coins, idx, target - coins[idx]);
    }
    
    // Exclude current coin
    count += coinChangeCombination(coins, idx + 1, target);

    return count;
  }

  // Memoized solution
  public static int coinChangeCombination_memo(int[] coins, int idx, int target, Integer[][] storage) {
    if (target == 0) {
      return 1;
    }
    if (idx == coins.length) {
      return 0;
    }

    if (storage[idx][target] != null) {
      return storage[idx][target];
    }

    int count = 0;
    
    if (target >= coins[idx]) {
      count += coinChangeCombination_memo(coins, idx, target - coins[idx], storage);
    }
    
    count += coinChangeCombination_memo(coins, idx + 1, target, storage);

    storage[idx][target] = count;
    return count;
  }

  // Tabulation solution
  public static int coinChangeCombination_tab(int[] coins, int target) {
    int[] strg = new int[target + 1];
    strg[0] = 1;

    // Process coins one by one to maintain order (combination)
    for (int coin : coins) {
      for (int j = coin; j <= target; j++) {
        strg[j] += strg[j - coin];
      }
    }

    return strg[target];
  }

  // Space optimized solution (already optimized in tabulation)
  public static int coinChangeCombination_optimized(int[] coins, int target) {
    return coinChangeCombination_tab(coins, target);
  }
  
}

/*
Sample Input:
4
2 3 5 6
7

Sample Output:
2
*/

