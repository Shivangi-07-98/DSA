import java.util.*;
public class Q7_TargetSumSubsets {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();

    Boolean[][] storage = new Boolean[n + 1][target + 1];
    
    System.out.println(targetSumSubsets(0, 0, arr, target));
    System.out.println(targetSumSubsets_memo(0, 0, arr, target, storage));
    System.out.println(targetSumSubsets_tab(arr, target));
  }

  // Recursive solution
  public static boolean targetSumSubsets(int idx, int sum, int[] arr, int target) {
    if (idx == arr.length) {
      return sum == target;
    }

    boolean include = targetSumSubsets(idx + 1, sum + arr[idx], arr, target);
    boolean exclude = targetSumSubsets(idx + 1, sum, arr, target);

    return include || exclude;
  }

  // Memoized solution
  public static boolean targetSumSubsets_memo(int idx, int sum, int[] arr, int target, Boolean[][] storage) {
    if (idx == arr.length) {
      return sum == target;
    }

    if (storage[idx][sum] != null) {
      return storage[idx][sum];
    }

    boolean include = targetSumSubsets_memo(idx + 1, sum + arr[idx], arr, target, storage);
    boolean exclude = targetSumSubsets_memo(idx + 1, sum, arr, target, storage);

    storage[idx][sum] = include || exclude;
    return storage[idx][sum];
  }

  // Tabulation solution
  public static boolean targetSumSubsets_tab(int[] arr, int target) {
    boolean[][] strg = new boolean[arr.length + 1][target + 1];

    for (int i = 0; i <= arr.length; i++) {
      for (int j = 0; j <= target; j++) {
        if (i == 0 && j == 0) {
          strg[i][j] = true;
        } else if (i == 0) {
          strg[i][j] = false;
        } else if (j == 0) {
          strg[i][j] = true;
        } else {
          if (strg[i - 1][j]) {
            strg[i][j] = true;
          } else if (j >= arr[i - 1] && strg[i - 1][j - arr[i - 1]]) {
            strg[i][j] = true;
          } else {
            strg[i][j] = false;
          }
        }
      }
    }

    return strg[arr.length][target];
  }

  // Tabulation solution pep
  public static boolean targetSumSubsets_tab_pep(int[] arr, int target) {
    boolean[][] strg = new boolean[arr.length + 1][target + 1];

    for (int i = 0; i <= arr.length; i++) {
      for (int j = 0; j <= target; j++) {
        if (i == 0 && j == 0) {
          strg[i][j] = true;
        } else if (i == 0) {
          strg[i][j] = false;
        } else if (j == 0) {
          strg[i][j] = true;
        } else {
          strg[i][j] = strg[i - 1][j] || (j >= arr[i - 1] && strg[i - 1][j - arr[i - 1]]);
        }
      }
    }

    return strg[arr.length][target];
  }
  
}

/*
Sample Input:
5
4 2 7 1 3
10

Sample Output:
true
*/