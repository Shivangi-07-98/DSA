import java.util.*;
public class Q13_ZeroOneKnapsack {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] values = new int[n];
    int[] weights = new int[n];
    for (int i = 0; i < n; i++) {
      values[i] = scn.nextInt();
    }
    for (int i = 0; i < n; i++) {
      weights[i] = scn.nextInt();
    }
    int capacity = scn.nextInt();

    Integer[][] storage = new Integer[n + 1][capacity + 1];
    System.out.println(zeroOneKnapsack(values, weights, 0, capacity));
    System.out.println(zeroOneKnapsack_memo(values, weights, 0, capacity, storage));
    System.out.println(zeroOneKnapsack_tab(values, weights, capacity));
    System.out.println(zeroOneKnapsack_optimized(values, weights, capacity));
  }

  // Recursive solution
  // Each item can be used at most once
  public static int zeroOneKnapsack(int[] values, int[] weights, int idx, int capacity) {
    if (idx == values.length || capacity == 0) {
      return 0;
    }

    int include = 0;
    if (capacity >= weights[idx]) {
      include = values[idx] + zeroOneKnapsack(values, weights, idx + 1, capacity - weights[idx]);
    }
    
    int exclude = zeroOneKnapsack(values, weights, idx + 1, capacity);

    return Math.max(include, exclude);
  }

  // Memoized solution
  public static int zeroOneKnapsack_memo(int[] values, int[] weights, int idx, int capacity, Integer[][] storage) {
    if (idx == values.length || capacity == 0) {
      return 0;
    }

    if (storage[idx][capacity] != null) {
      return storage[idx][capacity];
    }

    int include = 0;
    if (capacity >= weights[idx]) {
      include = values[idx] + zeroOneKnapsack_memo(values, weights, idx + 1, capacity - weights[idx], storage);
    }
    
    int exclude = zeroOneKnapsack_memo(values, weights, idx + 1, capacity, storage);

    storage[idx][capacity] = Math.max(include, exclude);
    return storage[idx][capacity];
  }

  // Tabulation solution
  public static int zeroOneKnapsack_tab(int[] values, int[] weights, int capacity) {
    int n = values.length;
    int[][] strg = new int[n + 1][capacity + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= capacity; j++) {
        if (j >= weights[i - 1]) {
          strg[i][j] = Math.max(strg[i - 1][j], values[i - 1] + strg[i - 1][j - weights[i - 1]]);
        } else {
          strg[i][j] = strg[i - 1][j];
        }
      }
    }

    return strg[n][capacity];
  }

  // Space optimized solution
  public static int zeroOneKnapsack_optimized(int[] values, int[] weights, int capacity) {
    int n = values.length;
    int[] prev = new int[capacity + 1];

    for (int i = 0; i < n; i++) {
      int[] curr = new int[capacity + 1];
      for (int j = 1; j <= capacity; j++) {
        if (j >= weights[i]) {
          curr[j] = Math.max(prev[j], values[i] + prev[j - weights[i]]);
        } else {
          curr[j] = prev[j];
        }
      }
      prev = curr;
    }

    return prev[capacity];
  }
  
}

/*
Sample Input:
5
15 14 10 45 30
2 5 1 3 4
7

Sample Output:
75
*/

