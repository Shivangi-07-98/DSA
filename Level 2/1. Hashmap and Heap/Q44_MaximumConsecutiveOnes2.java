// Time Complexity: O(n), Space Complexity: O(1)

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
    scn.close();
  }

  public static int solution(int[] arr, int k) {
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

        if (zc <= k) {
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

        if (zc <= k) {
          break;
        }
      }
    }

    return len;
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
