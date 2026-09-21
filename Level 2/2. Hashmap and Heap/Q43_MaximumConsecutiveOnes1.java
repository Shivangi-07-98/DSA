// Time O(n)
// Space O(1)

import java.util.*;

public class Q43_MaximumConsecutiveOnes1 {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    System.out.println(solution(arr));
    scn.close();
  }

  public static int solution(int[] arr) {
    int len = 0;

    int i = 0;
    int j = -1;
    int zc = 0;

    while (i < arr.length && j < i) {
      while (i < arr.length) {
        if (arr[i] == 1) {
          // nothing to do
        } else if (arr[i] == 0) {
          zc++;
        }

        if (zc <= 1) {
          int tlen = i - j;
          len = Math.max(len, tlen);
          i++;
        } else {
          i++;
          break;
        }
      }

      while (j < i) {
        j++;
        if (arr[j] == 0) {
          zc--;
        }

        if (zc <= 1) {
          break;
        }
      }
    }

    return len;
  }
}

// Input:
// 7
// 1 0 1 1 0 1 1

// Output:
// 5
