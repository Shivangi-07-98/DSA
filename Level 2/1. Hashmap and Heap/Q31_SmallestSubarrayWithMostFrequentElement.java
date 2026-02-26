// Time Complexity: O(n), Space Complexity: O(n)

import java.io.*;
import java.util.*;

public class Q31_SmallestSubarrayWithMostFrequentElement {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int[] ans = solution(arr);
    System.out.println(ans[0]);
    System.out.println(ans[1]);
    System.out.println(ans[2]);
  }

  public static int[] solution(int[] arr) {
    HashMap<Integer, Integer> freq = new HashMap<>();
    HashMap<Integer, Integer> first = new HashMap<>();

    int maxFreq = 0;
    int bestLen = Integer.MAX_VALUE;
    int bestStart = 0;
    int bestEnd = 0;
    int bestEle = arr[0];

    for (int i = 0; i < arr.length; i++) {
      int val = arr[i];
      first.putIfAbsent(val, i);
      int f = freq.getOrDefault(val, 0) + 1;
      freq.put(val, f);

      int start = first.get(val);
      int len = i - start + 1;

      if (f > maxFreq) {
        maxFreq = f;
        bestLen = len;
        bestStart = start;
        bestEnd = i;
        bestEle = val;
      } else if (f == maxFreq) {
        if (len < bestLen || (len == bestLen && start < bestStart)) {
          bestLen = len;
          bestStart = start;
          bestEnd = i;
          bestEle = val;
        }
      }
    }

    return new int[] { bestEle, bestStart, bestEnd };
  }
}

/*
 * Input:
 * 9
 * 1 2 2 3 1 4 2 1 1
 * 
 * Output:
 * 1
 * 0
 * 8
 */
