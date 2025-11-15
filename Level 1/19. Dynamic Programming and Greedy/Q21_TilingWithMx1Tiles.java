import java.util.*;
public class Q21_TilingWithMx1Tiles {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();

    long[] storage = new long[n + 1];
    System.out.println(tilingMx1(n, m));
    System.out.println(tilingMx1_memo(n, m, storage));
    System.out.println(tilingMx1_tab(n, m));
    System.out.println(tilingMx1_optimized(n, m));
  }

  // Recursive solution
  // Tiling a floor of size n*m with tiles of size m*1
  public static long tilingMx1(int n, int m) {
    if (n < m) {
      return 1; // Only vertical placement possible
    }
    if (n == m) {
      return 2; // Can place all vertically or all horizontally
    }

    // Place tile vertically: remaining area is (n-1)*m
    long vertical = tilingMx1(n - 1, m);
    
    // Place tile horizontally: remaining area is (n-m)*m
    long horizontal = tilingMx1(n - m, m);

    return vertical + horizontal;
  }

  // Memoized solution
  public static long tilingMx1_memo(int n, int m, long[] storage) {
    if (n < m) {
      return 1;
    }
    if (n == m) {
      return 2;
    }

    if (storage[n] != 0) {
      return storage[n];
    }

    storage[n] = tilingMx1_memo(n - 1, m, storage) + tilingMx1_memo(n - m, m, storage);
    return storage[n];
  }

  // Tabulation solution
  public static long tilingMx1_tab(int n, int m) {
    if (n < m) {
      return 1;
    }

    long[] strg = new long[n + 1];

    for (int i = 0; i < m; i++) {
      strg[i] = 1;
    }
    strg[m] = 2;

    for (int i = m + 1; i <= n; i++) {
      strg[i] = strg[i - 1] + strg[i - m];
    }

    return strg[n];
  }

  // Space optimized solution
  public static long tilingMx1_optimized(int n, int m) {
    if (n < m) {
      return 1;
    }
    if (n == m) {
      return 2;
    }

    long[] prev = new long[m];
    for (int i = 0; i < m - 1; i++) {
      prev[i] = 1;
    }
    prev[m - 1] = 2;

    for (int i = m + 1; i <= n; i++) {
      long curr = prev[(i - 1) % m] + prev[(i - m) % m];
      prev[(i - 1) % m] = curr;
    }

    return prev[n % m];
  }
  
}

/*
Sample Input:
8
3

Sample Output:
13
*/

