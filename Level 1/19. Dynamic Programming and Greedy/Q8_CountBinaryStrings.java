import java.util.*;
public class Q8_CountBinaryStrings {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    long[] storage = new long[n + 1];
    System.out.println(countBinaryStrings(n));
    System.out.println(countBinaryStrings_memo(n, storage));
    System.out.println(countBinaryStrings_tab(n));
    System.out.println(countBinaryStrings_optimized(n));
  }

  // Recursive solution
  public static long countBinaryStrings(int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return 2;
    }

    return countBinaryStrings(n - 1) + countBinaryStrings(n - 2);
  }

  // Memoized solution
  public static long countBinaryStrings_memo(int n, long[] storage) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return 2;
    }

    if (storage[n] != 0) {
      return storage[n];
    }

    storage[n] = countBinaryStrings_memo(n - 1, storage) + countBinaryStrings_memo(n - 2, storage);
    return storage[n];
  }

  // Tabulation solution
  public static long countBinaryStrings_tab(int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return 2;
    }

    long[] strg = new long[n + 1];
    strg[0] = 1;
    strg[1] = 2;

    for (int i = 2; i <= n; i++) {
      strg[i] = strg[i - 1] + strg[i - 2];
    }

    return strg[n];
  }

  // Space optimized solution
  public static long countBinaryStrings_optimized(int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return 2;
    }

    long prev2 = 1; // strings ending with 0
    long prev1 = 2; // total strings

    for (int i = 2; i <= n; i++) {
      long curr = prev1 + prev2;
      prev2 = prev1;
      prev1 = curr;
    }

    return prev1;
  }
  
}

/*
Sample Input:
5

Sample Output:
13
*/

