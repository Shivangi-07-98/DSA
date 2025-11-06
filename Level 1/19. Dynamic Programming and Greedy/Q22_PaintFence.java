import java.util.*;
public class Q22_PaintFence {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = scn.nextInt();

    Integer[] storage = new Integer[n + 1];
    System.out.println(paintFence(n, k));
    System.out.println(paintFence_memo(n, k, storage));
    System.out.println(paintFence_tab(n, k));
    System.out.println(paintFence_optimized(n, k));
  }

  // Recursive solution
  // Paint n fences with k colors such that at most 2 adjacent fences have same color
  public static int paintFence(int n, int k) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return k;
    }
    if (n == 2) {
      return k * k;
    }

    // Last two fences have same color: (k-1) * paintFence(n-2, k)
    // Last two fences have different color: (k-1) * paintFence(n-1, k)
    int same = (k - 1) * paintFence(n - 2, k);
    int diff = (k - 1) * paintFence(n - 1, k);

    return same + diff;
  }

  // Memoized solution
  public static int paintFence_memo(int n, int k, Integer[] storage) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return k;
    }
    if (n == 2) {
      return k * k;
    }

    if (storage[n] != null) {
      return storage[n];
    }

    int same = (k - 1) * paintFence_memo(n - 2, k, storage);
    int diff = (k - 1) * paintFence_memo(n - 1, k, storage);

    storage[n] = same + diff;
    return storage[n];
  }

  // Tabulation solution
  public static int paintFence_tab(int n, int k) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return k;
    }
    if (n == 2) {
      return k * k;
    }

    int[] strg = new int[n + 1];
    strg[1] = k;
    strg[2] = k * k;

    for (int i = 3; i <= n; i++) {
      strg[i] = (k - 1) * (strg[i - 1] + strg[i - 2]);
    }

    return strg[n];
  }

  // Space optimized solution
  public static int paintFence_optimized(int n, int k) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return k;
    }
    if (n == 2) {
      return k * k;
    }

    int prev2 = k;
    int prev1 = k * k;

    for (int i = 3; i <= n; i++) {
      int curr = (k - 1) * (prev1 + prev2);
      prev2 = prev1;
      prev1 = curr;
    }

    return prev1;
  }
  
}

