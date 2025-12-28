import java.io.*;
import java.util.*;

public class Q10_CountEncodings {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine(); // 123

    System.out.println(countEncodings_tab(str));
  }

  // Tabulation solution
  public static int countEncodings_tab(String str) {
    int[] dp = new int[str.length() + 1]; // 4 = empty 1 2 3

    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i < dp.length; i++) {
      char chi = str.charAt(i - 1); // dp ka i str mai i-1 hai
      char chim1 = str.charAt(i - 2); // dp ka i-1 str mai i-2 hai

      if (chi != '0') {
        dp[i] = dp[i - 1];
      }

      if (chim1 != '0' && Integer.parseInt("" + chim1 + chi) <= 26) {
        dp[i] += dp[i - 2];
      }
    }

    return dp[dp.length - 1];
  }

}
// 1-26 a-z
// starting from 0 is invalid input

/*
 * Sample Input:
 * 123
 * 
 * Sample Output:
 * 3
 */
