// LeetCode 1497: Check If Array Pairs Are Divisible by k
// https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
// Time Complexity: O(n)
// Space Complexity: O(n)
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

    long ans = countPairSumDivisibleByK(arr, n, k);
    System.out.println(ans);
  }

  // count pairs whose sum is divisible by k
  static long countPairSumDivisibleByK(int[] arr, int n, int k) {
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

/*
 * Sample Input:
 * 5
 * 2 2 1 7 5
 * 4
 * 
 * Sample Output:
 * 3
 */
