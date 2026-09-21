// time O(2^n)
// space O(n)

import java.io.*;
import java.util.*;

public class Q1_FibonacciDP {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 10

    int[] strg = new int[n + 1];

    System.out.println(fib(n));
    System.out.println(fib_memo(n, strg));
    System.out.println(fib_tab(n));
  }

  // Recursive solution
  public static int fib(int n) {
    if (n == 0 || n == 1) {
      return n;
    }

    int fnm1 = fib(n - 1);
    int fnm2 = fib(n - 2);
    int fn = fnm1 + fnm2;

    return fn;
  }

  // Memoized solution
  public static int fib_memo(int n, int[] strg) {
    if (n == 0 || n == 1) {
      return n;
    }

    if (strg[n] != 0) {
      return strg[n];
    }

    int fnm1 = fib_memo(n - 1, strg);
    int fnm2 = fib_memo(n - 2, strg);
    int fn = fnm1 + fnm2;

    strg[n] = fn;
    return fn;
  }

  // Tabulation solution
  public static int fib_tab(int n) {
    int[] strg = new int[n + 1];

    strg[0] = 0;
    strg[1] = 1;
    
    for (int i = 2; i <= n; i++) {
      strg[i] = strg[i - 1] + strg[i - 2];
    }

    return strg[n];
  }

}

/*
 * Sample Input:
 * 10
 * 
 * Sample Output:
 * 55
 */

// Fibonacci indexing starts from 0.
// So Fibonacci of 5 is 5, not 3.
// 0 is the 0th Fibonacci number.
