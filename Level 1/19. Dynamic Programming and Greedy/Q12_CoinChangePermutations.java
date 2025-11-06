import java.util.*;
public class Q12_CoinChangePermutations {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] coins = new int[n];
    for (int i = 0; i < n; i++) {
      coins[i] = scn.nextInt();
    }
    int target = scn.nextInt();

    Integer[] storage = new Integer[target + 1];
    System.out.println(coinChangePermutations(coins, target));
    System.out.println(coinChangePermutations_memo(coins, target, storage));
    System.out.println(coinChangePermutations_tab(coins, target));
  }

  // Recursive solution
  // Permutation: order matters, so we can use any coin at any position
  public static int coinChangePermutations(int[] coins, int target) {
    if (target == 0) {
      return 1;
    }
    if (target < 0) {
      return 0;
    }

    int count = 0;
    
    // Try all coins at current position
    for (int coin : coins) {
      if (target >= coin) {
        count += coinChangePermutations(coins, target - coin);
      }
    }

    return count;
  }

  // Memoized solution
  public static int coinChangePermutations_memo(int[] coins, int target, Integer[] storage) {
    if (target == 0) {
      return 1;
    }
    if (target < 0) {
      return 0;
    }

    if (storage[target] != null) {
      return storage[target];
    }

    int count = 0;
    
    for (int coin : coins) {
      if (target >= coin) {
        count += coinChangePermutations_memo(coins, target - coin, storage);
      }
    }

    storage[target] = count;
    return count;
  }

  // Tabulation solution
  public static int coinChangePermutations_tab(int[] coins, int target) {
    int[] strg = new int[target + 1];
    strg[0] = 1;

    // For each target, try all coins (permutation)
    for (int i = 1; i <= target; i++) {
      for (int coin : coins) {
        if (i >= coin) {
          strg[i] += strg[i - coin];
        }
      }
    }

    return strg[target];
  }
  
}

