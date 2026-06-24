// https://leetcode.com/problems/subarray-sums-divisible-by-k/

// Time O(n)
// Space O(n)

import java.io.*;
import java.util.*;

public class Q4_SubarraySumDivisibleByK {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int k = scn.nextInt();

    int ans = subarraySumDivisibleByK(arr, n, k);
    System.out.println(ans);
  }

  // count subarrays with sum divisible by k
  static int subarraySumDivisibleByK(int[] arr, int n, int k) {
    int ans = 0;
    int sum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1); // Initialize remainder 0 with frequency 1

    for (int val : arr) {
      sum += val;

      // Calculate remainder, handling negative numbers
      int remainder = sum % k;
      if (remainder < 0) {
        remainder = remainder + k; // Make positive
      }

      if (map.containsKey(remainder)) {
        ans += map.get(remainder);
        map.put(remainder, map.get(remainder) + 1);
      } else {
        map.put(remainder, 1);
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
// 7

/* note - don't format

Array:
     3   -42    17    11    23    31     2    17

Sum:
0    3   -39   -22   -11    12    43    45    62

Remainder (k = 7):
0₁   3₁    3₂    6₁    3₃    5₁    1₁    3₄    6₂


-22 = (-21) - 1
    = (-28) + 6

Therefore:
-22 % 7 = -1

Adjusted remainder:
-1 + 7 = 6

*/
