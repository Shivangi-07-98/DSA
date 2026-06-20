// LeetCode 1502: Can Make Arithmetic Progression From Sequence
// https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
// 
// WHAT IS AP SEQUENCE?
// AP = Arithmetic Progression
// An AP sequence has CONSTANT DIFFERENCE between consecutive numbers
// Example: [1, 3, 5, 7] -> difference is 2 (3-1=2, 5-3=2, 7-5=2)
// Example: [2, 4, 6, 8, 10] -> difference is 2
// Example: [5, 10, 15, 20] -> difference is 5
// 
// WHAT DOES THIS QUESTION ASK?
// Given an array, can we REARRANGE it to form an AP sequence?
// Example: [3, 5, 1] can be rearranged to [1, 3, 5] -> YES (difference = 2)
// Example: [1, 2, 4] cannot form AP -> NO (no constant difference possible)
// 
// Time O(n)
// Space O(n)
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
    HashSet<Integer> set = new HashSet<>();
    int min = Integer.MAX_VALUE;
    int smin = Integer.MAX_VALUE;

    for (int val : arr) {
      set.add(val);

      if (val < min) {
        smin = min;
        min = val;
      } else if (val < smin) {
        smin = val;
      }
    }

    int d = smin - min;

    for (int i = 0; i < n; i++) {
      if (set.contains(min)) {
        min = min + d;
      } else {
        return false;
      }
    }

    return true;
  }

}

// Input 1:
// 4
// 3 5 1 7
// Output 1:
// true
// 
// Explanation: Can be rearranged to [1, 3, 5, 7] which is AP with difference =
// 2
// 
// Input 2:
// 4
// 1 3 5 7
// Output 2:
// true
// 
// Explanation: Already an AP sequence with difference = 2
// 
// Input 3:
// 3
// 1 2 4
// Output 3:
// false
// 
// Explanation: Cannot form AP.
// If arranged as [1, 2, 4]: difference = 1, then 2 (not constant)
// If arranged as [1, 4, 2]: difference = 3, then -2 (not constant)
// No arrangement gives constant difference -> NO
// 
// Input 4:
// 3
// 1 1 1
// Output 4:
// true
// 
// Explanation: All numbers same, difference = 0 (constant) -> YES
