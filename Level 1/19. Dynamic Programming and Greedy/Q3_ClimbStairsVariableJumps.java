import java.io.*;
import java.util.*;

public class Q3_ClimbStairsVariableJumps {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt(); // 10
    int[] arr = new int[n]; // 0-9
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt(); // 3 3 0 2 1 2 4 2 0 0
    }

    System.out.println(climbStairsVariable_tab(n, arr));
  }

  // Tabulation solution
  public static int climbStairsVariable_tab(int n, int[] arr) {
    int[] strg = new int[n + 1];
    strg[n] = 1;

    for (int i = n - 1; i >= 0; i--) {
      strg[i] = 0;
      for (int jump = i + 1; jump <= i + arr[i]; jump++) {
        if (jump < strg.length) {
          strg[i] = strg[i] + strg[jump];
        }
      }
    }

    return strg[0];
  }

}

/*
 * Sample Input:
 * 10
 * 3 3 0 2 1 2 4 2 0 0
 * 
 * Sample Output:
 * 5
 */

// we have to reach 0 to 10, array tells number of jumps we can take when we
// reach that block
