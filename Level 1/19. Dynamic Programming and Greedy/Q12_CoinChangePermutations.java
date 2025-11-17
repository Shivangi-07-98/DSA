import java.util.*;

public class Q12_CoinChangePermutations {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 4
    int[] coins = new int[n];
    for (int i = 0; i < n; i++) { // 2 3 5 6
      coins[i] = scn.nextInt();
    }
    int amt = scn.nextInt(); // 7

    System.out.println(coinChangePermutations_tab(coins, amt));
  }

  // Tabulation solution
  public static int coinChangePermutations_tab(int[] coins, int amt) {
    int[] dp = new int[amt + 1];
    dp[0] = 1;

    for (int tar = 1; tar <= amt; tar++) {
      for (int coin : coins) {
        if (tar >= coin) {
          dp[tar] += dp[tar - coin];
        }
      }
    }

    return dp[amt];
  }

}
// 4 types infinite coins hai 2 3 5 6 aur hme 7 rs pay krne hai, kitne tarike se pay kar skte hai
// combination ways = 2 2 3, 2 5 = 2
// permutation ways = 2 2 3, 2 3 2, 3 2 2, 2 5, 5 2 = 5

// target outer loop, coins inner loop

/*
Sample Input:
4
2 3 5 6
7

Sample Output:
5
*/
