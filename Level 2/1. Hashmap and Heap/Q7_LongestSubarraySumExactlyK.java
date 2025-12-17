// LeetCode 560: Subarray Sum Equals K (Longest Version)
// https://leetcode.com/problems/subarray-sum-equals-k/
// Time Complexity: O(n)
// Space Complexity: O(n)
import java.io.*;
import java.util.*;

public class Q7_LongestSubarraySumExactlyK {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = scn.nextInt();
    }
    int k = scn.nextInt();

    int ans = longestSubarraySum(nums, k);
    System.out.println(ans);
  }

  // find longest subarray with sum exactly equal to k
  static int longestSubarraySum(int[] nums, int k) {
    int ans = 0;
    int sum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, -1); // Initialize sum 0 at index -1 (before start)

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];

      // ===== MAIN LOGIC FOR LONGEST: Check for (sum - k), calculate length =====
      if (map.containsKey(sum - k)) {
        int firstIndex = map.get(sum - k);
        int length = i - firstIndex;
        if (length > ans) {
          ans = length;
        }
      }

      if (!map.containsKey(sum)) {
        map.put(sum, i); // Store first occurrence index
      }
      // ===== END OF MAIN LOGIC =====
    }

    return ans;
  }

}

/*
 * Sample Input:
 * 5
 * 1 1 1 2 3
 * 3
 * 
 * Sample Output:
 * 3
 */
