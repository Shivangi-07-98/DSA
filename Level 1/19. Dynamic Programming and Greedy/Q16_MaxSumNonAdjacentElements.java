import java.io.*;
import java.util.*;

public class Q16_MaxSumNonAdjacentElements {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 6
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) { // 5 10 10 100 5 6
      arr[i] = scn.nextInt();
    }

    System.out.println(maxSumNonAdjacent_tab(arr));
  }

  // Tabulation solution - Space optimized
  public static int maxSumNonAdjacent_tab(int[] arr) {
    int inc = arr[0];
    int exc = 0;

    for (int i = 1; i < arr.length; i++) {
      int ninc = exc + arr[i];
      int nexc = Math.max(inc, exc);

      inc = ninc;
      exc = nexc;
    }

    return Math.max(inc, exc);
  }

}
// 2^n = 64 subsets
// out of 64 subsets kis subset ka sum max hai, cannot pick adjacent element

/*
 * Sample Input:
 * 6
 * 5 10 10 100 5 6
 * 
 * Sample Output:
 * 116
 */
