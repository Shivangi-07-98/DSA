// https://leetcode.com/problems/russian-doll-envelopes/


import java.io.*;
import java.util.*;

public class Q9_RussianDollEnvelopes {

  // Returns the maximum number of envelopes that can be nested
  static int maxEnvelopes(int[][] arr) {
    Arrays.sort(arr, (a, b) -> {
      if (a[0] != b[0]) {
        return a[0] - b[0];
      }
      // For same width, sort height desc to avoid counting equal widths in LIS
      return b[1] - a[1];
    });

    int[] lis = new int[arr.length];
    lis[0] = 1;

    for (int i = 1; i < arr.length; i++) {
      int max = 0;
      for (int j = 0; j < i; j++) {
        if (arr[j][1] < arr[i][1]) {
          max = Math.max(max, lis[j]);
        }
      }

      lis[i] = max + 1;
    }

    int len = 0;
    for (int val : lis) {
      len = Math.max(len, val);
    }

    return len;
  }

  public static void main(String[] args) {
    int[][] arr = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };

    System.out.println(maxEnvelopes(arr));
  }
  
}
