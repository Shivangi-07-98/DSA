// https://leetcode.com/problems/subarray-sums-divisible-by-k/

// Time O(n)
// Space O(n)

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
    map.put(0, -1);

    for (int i = 0; i < n; i++) {
      sum += arr[i];

      // Calculate remainder, handling negative numbers
      int remainder = sum % k;
      if (remainder < 0) {
        remainder = remainder + k; // Make positive
      }

      if (map.containsKey(remainder)) {
        int firstIndex = map.get(remainder);
        int length = i - firstIndex;
        if (length > ans) {
          ans = length;
        }
      } else {
        map.put(remainder, i);
      }
    }

    return ans;
  }

}

// Input:
// 6
// 4 5 0 -2 -3 1
// 5
// 
// Output:
// 6
