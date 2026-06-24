// https://leetcode.com/problems/subarray-sum-equals-k/

// Time O(n)
// Space O(n)

import java.io.*;
import java.util.*;

public class Q3_SubarraysSumExactlyK {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int k = scn.nextInt();

    int ans = subarraySum(arr, k);
    System.out.println(ans);
  }

  // count subarrays with sum exactly equal to k
  static int subarraySum(int[] arr, int k) {
    int ans = 0;
    int sum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    for (int val : arr) {
      sum += val;

      if (map.containsKey(sum - k)) {
        ans += map.get(sum - k);
      }

      if (map.containsKey(sum)) {
        map.put(sum, map.get(sum) + 1);
      } else {
        map.put(sum, 1);
      }
    }

    return ans;
  }

}

// Input:
// 5
// 1 1 1 2 3
// 3
// 
// Output:
// 2
