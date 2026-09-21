// https://leetcode.com/problems/max-consecutive-ones/

// Time O(n)
// Space O(1)

import java.io.*;
import java.util.*;

public class Q17_LongestConsecutive1s {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int ans = longestConsecutiveOnes(arr);
    System.out.println(ans);
  }

  static int longestConsecutiveOnes(int[] arr) {
    int tl = 0; // temporary length
    int ml = 0; // maximum length

    for (int val : arr) {
      if (val == 0) {
        if (tl > ml) {
          ml = tl;
        }
        tl = 0;
      } else {
        tl++;
      }
    }

    if (tl > ml) {
      ml = tl;
    }

    return ml;
  }

}

// Input:
// 8
// 1 1 0 1 1 1 0 1
// 
// Output:
// 3
