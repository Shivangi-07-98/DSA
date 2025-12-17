// LeetCode 1502: Can Make Arithmetic Progression From Sequence
// https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
// Time Complexity: O(n)
// Space Complexity: O(n)
import java.io.*;
import java.util.*;

public class Q11_CheckAPSequence {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    boolean ans = canMakeAP(arr, n);
    System.out.println(ans);
  }

  // check if array can be rearranged to form AP sequence
  static boolean canMakeAP(int[] arr, int n) {
    if (n <= 2) {
      return true;
    }

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    HashSet<Integer> set = new HashSet<>();

    for (int val : arr) {
      min = Math.min(min, val);
      max = Math.max(max, val);
      set.add(val);
    }

    int diff = max - min;
    if (diff == 0) {
      return true;
    }

    if (diff % (n - 1) != 0) {
      return false;
    }

    int d = diff / (n - 1);

    for (int i = 0; i < n; i++) {
      int expected = min + i * d;
      if (!set.contains(expected)) {
        return false;
      }
    }

    return true;
  }

}

/*
 * Sample Input:
 * 4
 * 3 5 1 7
 * 
 * Sample Output:
 * false
 * 
 * Sample Input 2:
 * 4
 * 1 3 5 7
 * 
 * Sample Output 2:
 * true
 */
