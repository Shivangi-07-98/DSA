// LeetCode 525: Contiguous Array (Longest Version)
// https://leetcode.com/problems/contiguous-array/
// Time Complexity: O(n)
// Space Complexity: O(n)
import java.io.*;
import java.util.*;

public class Q5_LongestSubarrayWithEqual0And1 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int ans = longestSubarrayWithEqualZeroAndOne(arr, n);
    System.out.println(ans);
  }

  // find longest subarray having equal number of 0 and 1
  static int longestSubarrayWithEqualZeroAndOne(int[] arr, int n) {
    int ans = 0;
    int sum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, -1); // Initialize sum 0 at index -1 (before start)

    for (int i = 0; i < n; i++) {
      sum += (arr[i] == 0 ? -1 : 1);

      // ===== MAIN LOGIC FOR LONGEST: Store first index, calculate length =====
      if (map.containsKey(sum)) {
        int firstIndex = map.get(sum);
        int length = i - firstIndex;
        if (length > ans) {
          ans = length;
        }
      } else {
        map.put(sum, i); // Store first occurrence index
      }
      // ===== END OF MAIN LOGIC =====
    }

    return ans;
  }

}

/*
 * Sample Input:
 * 7
 * 1 0 0 1 0 1 1
 * 
 * Sample Output:
 * 6
 */
