// Time Complexity: O(n), Space Complexity: O(1)

import java.io.*;
import java.util.*;

public class Q44_MaximumConsecutiveOnes2 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int k = scn.nextInt();

    System.out.println(solution(arr, k));
  }

  public static int solution(int[] arr, int k) {
    int i = 0;
    int j = 0;
    int zeros = 0;
    int ans = 0;

    while (i < arr.length) {
      if (arr[i] == 0)
        zeros++;

      while (zeros > k) {
        if (arr[j] == 0)
          zeros--;
        j++;
      }

      ans = Math.max(ans, i - j + 1);
      i++;
    }

    return ans;
  }
}

/*
 * Input:
 * 10
 * 1 1 1 0 0 0 1 1 1 1
 * 2
 * 
 * Output:
 * 6
 */
