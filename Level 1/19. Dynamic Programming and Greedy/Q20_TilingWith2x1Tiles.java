import java.util.*;
public class Q20_TilingWith2x1Tiles {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    long[] storage = new long[n + 1];
    System.out.println(tiling2x1(n));
    System.out.println(tiling2x1_memo(n, storage));
    System.out.println(tiling2x1_tab(n));
    System.out.println(tiling2x1_optimized(n));
  }

  // Recursive solution
  // Tiling a floor of size n*2 with tiles of size 2*1
  public static long tiling2x1(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }

    // Place tile vertically: remaining area is (n-1)*2
    long vertical = tiling2x1(n - 1);
    
    // Place tile horizontally: remaining area is (n-2)*2
    long horizontal = tiling2x1(n - 2);

    return vertical + horizontal;
  }

  // Memoized solution
  public static long tiling2x1_memo(int n, long[] storage) {
    if (n == 0 || n == 1) {
      return 1;
    }

    if (storage[n] != 0) {
      return storage[n];
    }

    storage[n] = tiling2x1_memo(n - 1, storage) + tiling2x1_memo(n - 2, storage);
    return storage[n];
  }

  // Tabulation solution
  public static long tiling2x1_tab(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }

    long[] strg = new long[n + 1];
    strg[0] = 1;
    strg[1] = 1;

    for (int i = 2; i <= n; i++) {
      strg[i] = strg[i - 1] + strg[i - 2];
    }

    return strg[n];
  }

  // Space optimized solution
  public static long tiling2x1_optimized(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }

    long prev2 = 1;
    long prev1 = 1;

    for (int i = 2; i <= n; i++) {
      long curr = prev1 + prev2;
      prev2 = prev1;
      prev1 = curr;
    }

    return prev1;
  }
  
}

