import java.io.*;
import java.util.*;

public class Q7_TargetSumSubsets {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt(); // 5
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) { // 4 2 7 1 3
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt(); // 10

    Boolean[][] storage = new Boolean[n + 1][target + 1]; // 6 11

    System.out.println(targetSumSubsets_memo(arr, 0, target, storage));
    System.out.println(targetSumSubsets_tab(arr, target));
  }

  // Memoized solution
  public static boolean targetSumSubsets_memo(int[] arr, int idx, int target, Boolean[][] storage) {
    if (target == 0) {
      return true;
    } else if (idx == arr.length) {
      return false;
    }

    if (target >= 0 && storage[idx][target] != null) {
      return storage[idx][target];
    }

    boolean exclude = targetSumSubsets_memo(arr, idx + 1, target, storage);
    boolean include = targetSumSubsets_memo(arr, idx + 1, target - arr[idx], storage);

    boolean ans = exclude || include;

    if (target >= 0) {
      storage[idx][target] = ans;
    }

    return ans;
  }

  // Tabulation solution
  public static boolean targetSumSubsets_tab(int[] arr, int target) {
    boolean[][] strg = new boolean[arr.length + 1][target + 1]; // 6 11
    // arr in row 0 1 2 3 4 5, target in col 0 1 2 3 4 5 6 7 8 9 10

    for (int i = 0; i < strg.length; i++) { // row = 0-5
      for (int j = 0; j < strg[0].length; j++) { // col = 0-10

        if (i == 0 && j == 0) { // strg[0][0]
          strg[i][j] = true;
        } else if (i == 0) { // row = 0
          strg[i][j] = false;
        } else if (j == 0) { // col = 0
          strg[i][j] = true;
        } else {
          strg[i][j] = strg[i - 1][j];
          int val = arr[i - 1]; // strg ka i ek jyada hai arr se
          if (j >= val && strg[i - 1][j - val]) {
            strg[i][j] = true;
          }
        }

      }
    }

    return strg[arr.length][target]; // strg[5][10]
  }

}
// kya iss array ka koi subset aisa hai jiska sum 10 hai
// each element can be included or excluded

/*
 * Sample Input:
 * 5
 * 4 2 7 1 3
 * 10
 * 
 * Sample Output:
 * true
 */

// subset calculation formula = 2^n
// All 32 subsets of [4, 2, 7, 1, 3]
// 1. [_, _, _, _, _] = sum 0
// 2. [_, _, _, _, 3] = sum 3
// 3. [_, _, _, 1, _] = sum 1
// 4. [_, _, _, 1, 3] = sum 4
// 5. [_, _, 7, _, _] = sum 7
// 6. [_, _, 7, _, 3] = sum 10**
// 7. [_, _, 7, 1, _] = sum 8
// 8. [_, _, 7, 1, 3] = sum 11
// 9. [_, 2, _, _, _] = sum 2
// 10. [_, 2, _, _, 3] = sum 5
// 11. [_, 2, _, 1, _] = sum 3
// 12. [_, 2, _, 1, 3] = sum 6
// 13. [_, 2, 7, _, _] = sum 9
// 14. [_, 2, 7, _, 3] = sum 12
// 15. [_, 2, 7, 1, _] = sum 10**
// 16. [_, 2, 7, 1, 3] = sum 13
// 17. [4, _, _, _, _] = sum 4
// 18. [4, _, _, _, 3] = sum 7
// 19. [4, _, _, 1, _] = sum 5
// 20. [4, _, _, 1, 3] = sum 8
// 21. [4, _, 7, _, _] = sum 11
// 22. [4, _, 7, _, 3] = sum 14
// 23. [4, _, 7, 1, _] = sum 12
// 24. [4, _, 7, 1, 3] = sum 15
// 25. [4, 2, _, _, _] = sum 6
// 26. [4, 2, _, _, 3] = sum 9
// 27. [4, 2, _, 1, _] = sum 7
// 28. [4, 2, _, 1, 3] = sum 10**
// 29. [4, 2, 7, _, _] = sum 13
// 30. [4, 2, 7, _, 3] = sum 16
// 31. [4, 2, 7, 1, _] = sum 14
// 32. [4, 2, 7, 1, 3] = sum 17
