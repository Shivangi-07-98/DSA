import java.io.*;
import java.util.*;

public class Q18_PaintHouseManyColors {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt(); // 4
    int k = scn.nextInt(); // 3
    int[][] arr = new int[n][k]; // 4 3
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    System.out.println(paintHouse_tab(arr));
  }

  // Tabulation solution - O(n*k)
  public static int paintHouse_tab(int[][] arr) {
    int k = arr[0].length;
    int[] prev = new int[k];
    for (int j = 0; j < k; j++) {
      prev[j] = arr[0][j];
    }

    for (int i = 1; i < arr.length; i++) {
      int[] curr = new int[k];

      int min1 = Integer.MAX_VALUE;
      int min2 = Integer.MAX_VALUE;
      int min1Idx = -1;

      for (int j = 0; j < k; j++) {
        if (prev[j] < min1) {
          min2 = min1;
          min1 = prev[j];
          min1Idx = j;
        } else if (prev[j] < min2) {
          min2 = prev[j];
        }
      }

      for (int j = 0; j < k; j++) {
        if (j == min1Idx) {
          curr[j] = arr[i][j] + min2;
        } else {
          curr[j] = arr[i][j] + min1;
        }
      }

      prev = curr;
    }

    int result = Integer.MAX_VALUE;
    for (int j = 0; j < k; j++) {
      result = Math.min(result, prev[j]);
    }

    return result;
  }

}
// adjacent houses cannot have same color
// k colors available
// minimize cost

/*
 * Sample Input:
 * 4
 * 3
 * 1 5 7 (house 1)
 * 5 8 4 (house 2)
 * 3 2 9 (house 3)
 * 1 2 4 (house 4)
 * 
 * Sample Output:
 * 8
 */
