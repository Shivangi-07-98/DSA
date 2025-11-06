import java.util.*;
public class Q24_PartitionIntoSubsets {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = scn.nextInt();

    Long[][] storage = new Long[n + 1][k + 1];
    System.out.println(partitionIntoSubsets(n, k));
    System.out.println(partitionIntoSubsets_memo(n, k, storage));
    System.out.println(partitionIntoSubsets_tab(n, k));
  }

  // Recursive solution
  // Partition n elements into k non-empty subsets
  public static long partitionIntoSubsets(int n, int k) {
    if (n == 0 || k == 0 || n < k) {
      return 0;
    }
    if (n == k || k == 1) {
      return 1;
    }

    // Element can be added to existing subset: k * partitionIntoSubsets(n-1, k)
    // Element can form new subset: partitionIntoSubsets(n-1, k-1)
    long existing = k * partitionIntoSubsets(n - 1, k);
    long newSubset = partitionIntoSubsets(n - 1, k - 1);

    return existing + newSubset;
  }

  // Memoized solution
  public static long partitionIntoSubsets_memo(int n, int k, Long[][] storage) {
    if (n == 0 || k == 0 || n < k) {
      return 0;
    }
    if (n == k || k == 1) {
      return 1;
    }

    if (storage[n][k] != null) {
      return storage[n][k];
    }

    long existing = k * partitionIntoSubsets_memo(n - 1, k, storage);
    long newSubset = partitionIntoSubsets_memo(n - 1, k - 1, storage);

    storage[n][k] = existing + newSubset;
    return storage[n][k];
  }

  // Tabulation solution
  public static long partitionIntoSubsets_tab(int n, int k) {
    if (n == 0 || k == 0 || n < k) {
      return 0;
    }

    long[][] strg = new long[n + 1][k + 1];

    // Base cases
    for (int i = 1; i <= n; i++) {
      strg[i][1] = 1; // k == 1: all elements in one subset
    }
    for (int i = 1; i <= n && i <= k; i++) {
      strg[i][i] = 1; // n == k: each element in its own subset
    }

    for (int i = 2; i <= n; i++) {
      for (int j = 2; j <= k && j < i; j++) {
        strg[i][j] = j * strg[i - 1][j] + strg[i - 1][j - 1];
      }
    }

    return strg[n][k];
  }
  
}

