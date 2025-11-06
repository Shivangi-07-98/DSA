import java.util.*;
public class Q14_UnboundedKnapsack {

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

    Integer[] storage = new Integer[capacity + 1];
    System.out.println(unboundedKnapsack(values, weights, capacity));
    System.out.println(unboundedKnapsack_memo(values, weights, capacity, storage));
    System.out.println(unboundedKnapsack_tab(values, weights, capacity));
    System.out.println(unboundedKnapsack_optimized(values, weights, capacity));
  }

  // Recursive solution
  // Each item can be used unlimited times
  public static int unboundedKnapsack(int[] values, int[] weights, int capacity) {
    if (capacity == 0) {
      return 0;
    }

    int maxValue = 0;
    for (int i = 0; i < values.length; i++) {
      if (capacity >= weights[i]) {
        maxValue = Math.max(maxValue, values[i] + unboundedKnapsack(values, weights, capacity - weights[i]));
      }
    }

    return maxValue;
  }

  // Memoized solution
  public static int unboundedKnapsack_memo(int[] values, int[] weights, int capacity, Integer[] storage) {
    if (capacity == 0) {
      return 0;
    }

    if (storage[capacity] != null) {
      return storage[capacity];
    }

    int maxValue = 0;
    for (int i = 0; i < values.length; i++) {
      if (capacity >= weights[i]) {
        maxValue = Math.max(maxValue, values[i] + unboundedKnapsack_memo(values, weights, capacity - weights[i], storage));
      }
    }

    storage[capacity] = maxValue;
    return maxValue;
  }

  // Tabulation solution
  public static int unboundedKnapsack_tab(int[] values, int[] weights, int capacity) {
    int[] strg = new int[capacity + 1];

    for (int j = 1; j <= capacity; j++) {
      for (int i = 0; i < values.length; i++) {
        if (j >= weights[i]) {
          strg[j] = Math.max(strg[j], values[i] + strg[j - weights[i]]);
        }
      }
    }

    return strg[capacity];
  }

  // Space optimized solution (already optimized in tabulation)
  public static int unboundedKnapsack_optimized(int[] values, int[] weights, int capacity) {
    return unboundedKnapsack_tab(values, weights, capacity);
  }
  
}

