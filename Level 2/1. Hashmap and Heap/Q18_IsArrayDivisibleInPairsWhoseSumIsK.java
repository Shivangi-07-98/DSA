// LeetCode 1497: Check If Array Pairs Are Divisible by k
// https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
// Time O(n)
// Space O(n)

// WHAT IS THE QUESTION ASKING?
// Check if array can be divided into pairs such that sum of each pair is divisible by k
import java.io.*;
import java.util.*;

public class Q18_IsArrayDivisibleInPairsWhoseSumIsK {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int k = scn.nextInt();

    solution(arr, k);
  }

  public static void solution(int[] arr, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int val : arr) {
      int rem = val % k;
      if (rem < 0) {
        rem = rem + k;
      }
      if (map.containsKey(rem)) {
        map.put(rem, map.get(rem) + 1);
      } else {
        map.put(rem, 1);
      }
    }

    for (int val : arr) {
      int rem = val % k;
      if (rem < 0) {
        rem = rem + k;
      }

      if (2 * rem == k) {
        if (map.get(rem) % 2 != 0) {
          System.out.println("false");
          return;
        }
      } else if (rem == 0) {
        if (map.get(rem) % 2 != 0) {
          System.out.println("false");
          return;
        }
      } else { // don't know if k-rem exists??
        if (map.get(rem) != map.getOrDefault(k - rem, 0)) {
          System.out.println("false");
          return;
        }
      }
    }

    System.out.println("true");
  }

}

// Input:
// 4
// 9 7 5 3
// 6
// 
// Output:
// true
// 
// n = 4 elements, means 2 pair
// n = 10 elements, means 5 pair
