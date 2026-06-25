// https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/

// Time O(n)
// Space O(n)

import java.io.*;
import java.util.*;

public class Q9_CountPairSumDivisibleByK {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int k = scn.nextInt();

    // Brute Force Solution
    long ans1 = countPairSumDivisibleByK1(arr, n, k);
    System.out.println("Brute Force: " + ans1);

    // Optimized Solution
    long ans2 = countPairSumDivisibleByK2(arr, n, k);
    System.out.println("Optimized: " + ans2);
  }

  // Brute Force Solution
  // Time O(n²)
  // Space O(1)
  static long countPairSumDivisibleByK1(int[] arr, int n, int k) {
    long count = 0;
    for (int i = 0; i < n; i++) {
      int val1 = arr[i];
      for (int j = i + 1; j < n; j++) {
        int val2 = arr[j];
        int sum = val1 + val2;
        if (sum % k == 0) {
          // System.out.println(val1 + " " + val2 + " = " + sum);
          count = count + 1;
        }
      }
    }
    // System.out.println("count " + count);
    return count;
  }

  // Optimized Solution
  // Time O(n)
  // Space O(n)
  static long countPairSumDivisibleByK2(int[] arr, int n, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int val : arr) {
      int remainder = val % k;
      if (remainder < 0) {
        remainder = remainder + k;
      }

      if (map.containsKey(remainder)) {
        map.put(remainder, map.get(remainder) + 1);
      } else {
        map.put(remainder, 1);
      }
    }

    long ans = 0;

    for (int rem : map.keySet()) {
      int freq = map.get(rem);

      if (rem == 0) {
        // For remainder 0: pairs = nC2 = n * (n-1) / 2
        ans += (long) freq * (freq - 1) / 2;
      } else if (2 * rem == k) {
        // For remainder k/2 (middle point): pairs = nC2 = n * (n-1) / 2
        ans += (long) freq * (freq - 1) / 2;
      } else if (rem < k - rem && map.containsKey(k - rem)) {
        // For other pairs: multiply frequencies of rem and (k-rem)
        int otherFreq = map.get(k - rem);
        ans += (long) freq * otherFreq;
      }
    }

    return ans;
  }

}

// Input:
// 5
// 2 2 1 7 5
// 4
//
// Output:
// 3
