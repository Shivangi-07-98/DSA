import java.util.*;
public class Q4_ClimbStairsMinimumMoves {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] jumps = new int[n];
    for (int i = 0; i < n; i++) {
      jumps[i] = scn.nextInt();
    }

    Integer[] storage = new Integer[n + 1];
    
    System.out.println(climbStairsMinimum(n, 0, jumps));
    System.out.println(climbStairsMinimum_memo(n, 0, jumps, storage));
    System.out.println(climbStairsMinimum_tab(n, jumps));
  }

  // Recursive solution
  public static int climbStairsMinimum(int n, int src, int[] jumps) {
    if (src == n) {
      return 0;
    }

    int minMoves = Integer.MAX_VALUE;
    for (int jump = 1; jump <= jumps[src] && src + jump <= n; jump++) {
      int moves = climbStairsMinimum(n, src + jump, jumps);
      if (moves != Integer.MAX_VALUE) {
        minMoves = Math.min(minMoves, moves + 1);
      }
    }

    return minMoves;
  }

  // Memoized solution
  public static int climbStairsMinimum_memo(int n, int src, int[] jumps, Integer[] storage) {
    if (src == n) {
      return 0;
    }

    if (storage[src] != null) {
      return storage[src];
    }

    int minMoves = Integer.MAX_VALUE;
    for (int jump = 1; jump <= jumps[src] && src + jump <= n; jump++) {
      int moves = climbStairsMinimum_memo(n, src + jump, jumps, storage);
      if (moves != Integer.MAX_VALUE) {
        minMoves = Math.min(minMoves, moves + 1);
      }
    }

    storage[src] = minMoves;
    return minMoves;
  }

  // Tabulation solution
  public static int climbStairsMinimum_tab(int n, int[] jumps) {
    Integer[] strg = new Integer[n + 1];
    strg[n] = 0;

    for (int i = n - 1; i >= 0; i--) {
      if (jumps[i] > 0) {
        int min = Integer.MAX_VALUE;
        for (int jump = 1; jump <= jumps[i] && i + jump <= n; jump++) {
          if (strg[i + jump] != null) {
            min = Math.min(min, strg[i + jump]);
          }
        }
        if (min != Integer.MAX_VALUE) {
          strg[i] = min + 1;
        }
      }
    }

    return strg[0];
  }
  
}
