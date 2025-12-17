// LeetCode 974: Subarray Sums Divisible by K (Longest Version)
// https://leetcode.com/problems/subarray-sums-divisible-by-k/
// Time Complexity: O(n)
// Space Complexity: O(n)
import java.io.*;
import java.util.*;

public class Q8_LongestSubarraySumDivisibleByK {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int k = scn.nextInt();

    int ans = longestSubarraySumDivisibleByK(arr, n, k);
    System.out.println(ans);
  }

  // find longest subarray with sum divisible by k
  static int longestSubarraySumDivisibleByK(int[] arr, int n, int k) {
    int ans = 0;
    int sum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, -1); // Initialize remainder 0 at index -1 (before start)

    for (int i = 0; i < n; i++) {
      sum += arr[i];

      // Calculate remainder, handling negative numbers
      int remainder = sum % k;
      if (remainder < 0) {
        remainder = remainder + k; // Make positive
      }

      // ===== MAIN LOGIC FOR LONGEST: Store first index, calculate length =====
      if (map.containsKey(remainder)) {
        int firstIndex = map.get(remainder);
        int length = i - firstIndex;
        if (length > ans) {
          ans = length;
        }
      } else {
        map.put(remainder, i); // Store first occurrence index
      }
      // ===== END OF MAIN LOGIC =====
    }

    return ans;
  }

}

/*
 * Sample Input:
 * 6
 * 4 5 0 -2 -3 1
 * 5
 * 
 * Sample Output:
 * 6
 */
