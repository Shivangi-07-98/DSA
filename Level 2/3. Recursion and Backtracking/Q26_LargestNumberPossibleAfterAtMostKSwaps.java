// Time Complexity: O(n^k)
// Space Complexity: O(n)
import java.util.*;

public class Q26_LargestNumberPossibleAfterAtMostKSwaps {

  private static String max;

  private static void solve(char[] arr, int k, int idx) {
    if (k == 0 || idx == arr.length) {
      String curr = new String(arr);
      if (curr.compareTo(max) > 0) max = curr;
      return;
    }

    char maxDigit = arr[idx];
    for (int i = idx + 1; i < arr.length; i++) {
      if (arr[i] > maxDigit) maxDigit = arr[i];
    }

    if (maxDigit == arr[idx]) {
      solve(arr, k, idx + 1);
      return;
    }

    for (int i = idx + 1; i < arr.length; i++) {
      if (arr[i] == maxDigit) {
        swap(arr, idx, i);
        solve(arr, k - 1, idx + 1);
        swap(arr, idx, i);
      }
    }
  }

  private static void swap(char[] arr, int i, int j) {
    char tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    int k = scn.nextInt();
    max = str;
    solve(str.toCharArray(), k, 0);
    System.out.println(max);
  }

}

/*
 * Input:
 * 129814999
 * 4
 *
 * Output:
 * 999984211
 */
