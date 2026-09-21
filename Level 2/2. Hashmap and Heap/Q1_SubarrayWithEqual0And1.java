// https://leetcode.com/problems/contiguous-array/

// Time O(n)
// Space O(n)

import java.io.*;
import java.util.*;

public class Q1_SubarrayWithEqual0And1 {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 7
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) { // 1 0 0 1 0 1 1
      arr[i] = scn.nextInt();
    }

    int ans = SubarrayWithEqualZeroAndOne(arr, n);
    System.out.println(ans);
  }

  // count subarrays having equal number of 0 and 1
  static int SubarrayWithEqualZeroAndOne(int[] arr, int n) {
    int ans = 0;
    int sum = 0;

    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    for (int val : arr) {
      sum += (val == 0 ? -1 : 1);

      if (map.containsKey(sum)) {
        ans += map.get(sum);
        map.put(sum, map.get(sum) + 1);
      } else {
        map.put(sum, 1);
      }
    }

    return ans;
  }

}

// Input:
// 7
// 1 0 0 1 0 1 1
//
// Output:
// 8
