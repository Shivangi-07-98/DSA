import java.util.*;
public class Q3_ClimbStairsVariableJumps {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] jumps = new int[n];
    for (int i = 0; i < n; i++) {
      jumps[i] = scn.nextInt();
    }

    int[] storage = new int[n + 1];
    
    System.out.println(climbStairsVariable(n, 0, jumps));
    System.out.println(climbStairsVariable_memo(n, 0, jumps, storage));
    System.out.println(climbStairsVariable_tab(n, jumps));
  }

  // Recursive solution
  public static int climbStairsVariable(int n, int src, int[] jumps) {
    if (src == n) {
      return 1;
    }

    int total = 0;
    for (int jump = 1; jump <= jumps[src]; jump++) {
      if (src + jump <= n) {
        total += climbStairsVariable(n, src + jump, jumps);
      }
    }

    return total;
  }

  // Memoized solution
  public static int climbStairsVariable_memo(int n, int src, int[] jumps, int[] storage) {
    if (src == n) {
      return 1;
    }

    if (storage[src] != 0) {
      return storage[src];
    }

    int total = 0;
    for (int jump = 1; jump <= jumps[src]; jump++) {
      if (src + jump <= n) {
        total += climbStairsVariable_memo(n, src + jump, jumps, storage);
      }
    }

    storage[src] = total;
    return total;
  }

  // Tabulation solution
  public static int climbStairsVariable_tab(int n, int[] jumps) {
    int[] strg = new int[n + 1];
    strg[n] = 1;

    for (int i = n - 1; i >= 0; i--) {
      for (int jump = 1; jump <= jumps[i] && i + jump <= n; jump++) {
        strg[i] += strg[i + jump];
      }
    }

    return strg[0];
  }

  // Tabulation solution pep
  public static int climbStairsVariable_tab_pep(int n, int[] jumps) {
    int[] strg = new int[n + 1];
    strg[n] = 1;

    for (int i = n - 1; i >= 0; i--) {
      strg[i] = 0;
      for (int jump = i + 1; jump <= i + jumps[i]; jump++) {
        if(jump < strg.length){
          strg[i] = strg[i] + strg[jump];
        }
      }
    }

    return strg[0];
  }
  
}
