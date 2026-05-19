import java.io.*;
import java.util.*;

public class Q2_ClimbStairs {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 5

    int[] storage = new int[n + 1];

    System.out.println(climbStairs_memo(n, storage));
    System.out.println(climbStairs_tab(n));
  }

  // Memoized solution O(3^n)
  public static int climbStairs_memo(int n, int[] storage) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      return 0;
    }

    if (storage[n] != 0) {
      return storage[n];
    }

    int nm1 = climbStairs_memo(n - 1, storage);
    int nm2 = climbStairs_memo(n - 2, storage);
    int nm3 = climbStairs_memo(n - 3, storage);
    int total = nm1 + nm2 + nm3;

    storage[n] = total;
    return total;
  }

  // Tabulation solution
  public static int climbStairs_tab(int n) {
    int[] strg = new int[n + 1];
    strg[0] = 1;

    for (int i = 1; i <= n; i++) {
      // arr is from 0 to n, so if n is 0 or 1, there is no value stored for -ve no.
      if (i - 1 >= 0) {
        strg[i] += strg[i - 1];
      }
      if (i - 2 >= 0) {
        strg[i] += strg[i - 2];
      }
      if (i - 3 >= 0) {
        strg[i] += strg[i - 3];
      }
    }

    return strg[n];
  }

  // Tabulation solution
  public static int climbStairs_tab2(int n) {
    int[] strg = new int[n + 1];
    strg[0] = 1;

    for (int i = 1; i <= n; i++) {
      // arr is from 0 to n, so if n is 0 or 1, there is no value stored for -ve no.
      if (i >= 3) {
        strg[i] = strg[i - 1] + strg[i - 2] + strg[i - 3];
      }
      else if (i == 2) {
        strg[i] = strg[i - 1] + strg[i - 2];
      }
      else if (i == 1) {
        strg[i] = strg[i - 1];
      }
    }

    return strg[n];
  }

}
// 3 moves allowed at a time 1, 2, 3

/*
 * Sample Input:
 * 5
 * 
 * Sample Output:
 * 13
 */
