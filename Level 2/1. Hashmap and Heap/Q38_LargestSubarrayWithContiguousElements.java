// Time Complexity: O(n^2), Space Complexity: O(1)

import java.io.*;
import java.util.*;

public class Q38_LargestSubarrayWithContiguousElements {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    System.out.println(solution(arr));
  }

  public static int solution(int[] arr) {
    int n = arr.length;
    int ans = 0;

    for (int i = 0; i < n; i++) {
      int min = arr[i];
      int max = arr[i];
      HashSet<Integer> set = new HashSet<>();
      set.add(arr[i]);

      for (int j = i + 1; j < n; j++) {
        if (set.contains(arr[j])) {
          break;
        }

        set.add(arr[j]);
        min = Math.min(min, arr[j]);
        max = Math.max(max, arr[j]);
      }

      if (max - min == set.size() - 1) {
        ans = Math.max(ans, set.size());
      }
    }

    return ans;
  }
}

/*
 * Input:
 * 7
 * 10 12 11 14 13 16 15
 * 
 * Output:
 * 7
 */
