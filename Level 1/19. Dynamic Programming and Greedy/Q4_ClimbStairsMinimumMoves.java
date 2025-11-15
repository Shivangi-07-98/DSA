import java.util.*;
public class Q4_ClimbStairsMinimumMoves {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 10
    int[] arr = new int[n]; // 0-9
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt(); // 3 3 0 2 1 2 4 2 0 0
    }
    
    System.out.println(climbStairsMinimum_tab(n, arr));
  }

  // Tabulation solution
  public static int climbStairsMinimum_tab(int n, int[] arr) {
    int[] strg = new int[n + 1]; // 11 size 0-10
    strg[n] = 0;

    for (int i = n - 1; i >= 0; i--) {
      strg[i] = Integer.MAX_VALUE;
      for (int jump = i + 1; jump <= i + arr[i]; jump++) {
        if (jump < strg.length && strg[jump] != Integer.MAX_VALUE) {
          strg[i] = Math.min(strg[i], strg[jump] + 1);
        }
      }
    }

    return strg[0];
  }
  
}

/*
Sample Input:
10
3 3 0 2 1 2 4 2 0 0

Sample Output:
4
*/
