// Time O(n)
// Space O(n)

// WHAT IS THE QUESTION ASKING?
// Count pairs (i, j) where i < j and arr[i] - i == arr[j] - j
// Key insight: If arr[i] - i == arr[j] - j, then arr[i] - arr[j] = i - j
// We calculate diff = arr[i] - i for each element
// For each diff with frequency f, number of pairs = fC2 = f * (f-1) / 2
import java.io.*;
import java.util.*;

public class Q14_SameDifferences {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    long ans = countSameDifferencePairs(arr);
    System.out.println(ans);
  }

  static long countSameDifferencePairs(int[] arr) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      int diff = arr[i] - i;
      map.put(diff, map.getOrDefault(diff, 0) + 1);
    }

    long ans = 0;

    // If frequency is f, number of pairs = fC2 = f * (f-1) / 2
    for (int key : map.keySet()) {
      long freq = (long) map.get(key); // Cast to long to prevent overflow
      long val = (freq * (freq - 1) / 2);
      ans += val;
    }

    return ans;
  }

}

// Input:
// 5
// 1 2 3 4 5
// 
// Output:
// 10
// 
// Explanation:
// Calculation:
// - Index 0: diff = 1 - 0 = 1
// - Index 1: diff = 2 - 1 = 1
// - Index 2: diff = 3 - 2 = 1
// - Index 3: diff = 4 - 3 = 1
// - Index 4: diff = 5 - 4 = 1
// 
// Map: {1: 5}
// Pairs = 5C2 = 5 * 4 / 2 = 10
// 
// Key insight: If arr[i] - i == arr[j] - j, then arr[i] - arr[j] = i - j
