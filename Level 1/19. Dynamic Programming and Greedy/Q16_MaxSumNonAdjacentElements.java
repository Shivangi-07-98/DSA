import java.util.*;
public class Q16_MaxSumNonAdjacentElements {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    Integer[] storage = new Integer[n + 1];
    System.out.println(maxSumNonAdjacent(arr, 0));
    System.out.println(maxSumNonAdjacent_memo(arr, 0, storage));
    System.out.println(maxSumNonAdjacent_tab(arr));
    System.out.println(maxSumNonAdjacent_optimized(arr));
  }

  // Recursive solution
  public static int maxSumNonAdjacent(int[] arr, int idx) {
    if (idx >= arr.length) {
      return 0;
    }

    int include = arr[idx] + maxSumNonAdjacent(arr, idx + 2);
    int exclude = maxSumNonAdjacent(arr, idx + 1);

    return Math.max(include, exclude);
  }

  // Memoized solution
  public static int maxSumNonAdjacent_memo(int[] arr, int idx, Integer[] storage) {
    if (idx >= arr.length) {
      return 0;
    }

    if (storage[idx] != null) {
      return storage[idx];
    }

    int include = arr[idx] + maxSumNonAdjacent_memo(arr, idx + 2, storage);
    int exclude = maxSumNonAdjacent_memo(arr, idx + 1, storage);

    storage[idx] = Math.max(include, exclude);
    return storage[idx];
  }

  // Tabulation solution
  public static int maxSumNonAdjacent_tab(int[] arr) {
    int n = arr.length;
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return arr[0];
    }

    int[] strg = new int[n];
    strg[0] = arr[0];
    strg[1] = Math.max(arr[0], arr[1]);

    for (int i = 2; i < n; i++) {
      strg[i] = Math.max(strg[i - 1], arr[i] + strg[i - 2]);
    }

    return strg[n - 1];
  }

  // Space optimized solution
  public static int maxSumNonAdjacent_optimized(int[] arr) {
    int n = arr.length;
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return arr[0];
    }

    int prev2 = arr[0];
    int prev1 = Math.max(arr[0], arr[1]);

    for (int i = 2; i < n; i++) {
      int curr = Math.max(prev1, arr[i] + prev2);
      prev2 = prev1;
      prev1 = curr;
    }

    return prev1;
  }
  
}

/*
Sample Input:
6
5 10 10 100 5 6

Sample Output:
116
*/

