import java.util.*;
public class Q9_ArrangeBuildings {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    long[] storage = new long[n + 1];
    System.out.println(arrangeBuildings(n));
    System.out.println(arrangeBuildings_memo(n, storage));
    System.out.println(arrangeBuildings_tab(n));
    System.out.println(arrangeBuildings_optimized(n));
  }

  // Recursive solution
  // Same logic as binary strings - one side can be arranged in countBinaryStrings ways
  // Total ways = countBinaryStrings(n) * countBinaryStrings(n)
  public static long arrangeBuildings(int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return 4; // 2 * 2
    }

    long ways = countBinaryStrings(n);
    return ways * ways;
  }

  private static long countBinaryStrings(int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return 2;
    }
    return countBinaryStrings(n - 1) + countBinaryStrings(n - 2);
  }

  // Memoized solution
  public static long arrangeBuildings_memo(int n, long[] storage) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return 4;
    }

    if (storage[n] != 0) {
      return storage[n];
    }

    long[] binaryStorage = new long[n + 1];
    long ways = countBinaryStrings_memo(n, binaryStorage);
    storage[n] = ways * ways;
    return storage[n];
  }

  private static long countBinaryStrings_memo(int n, long[] storage) {
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
  public static long arrangeBuildings_tab(int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return 4;
    }

    long[] strg = new long[n + 1];
    strg[0] = 1;
    strg[1] = 2;

    for (int i = 2; i <= n; i++) {
      strg[i] = strg[i - 1] + strg[i - 2];
    }

    return strg[n] * strg[n];
  }

  // Space optimized solution
  public static long arrangeBuildings_optimized(int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return 4;
    }

    long prev2 = 1;
    long prev1 = 2;

    for (int i = 2; i <= n; i++) {
      long curr = prev1 + prev2;
      prev2 = prev1;
      prev1 = curr;
    }

    return prev1 * prev1;
  }
  
}

