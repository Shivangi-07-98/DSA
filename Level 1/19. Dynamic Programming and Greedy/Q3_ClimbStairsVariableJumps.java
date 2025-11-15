import java.util.*;
public class Q3_ClimbStairsVariableJumps {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 10
    int[] arr = new int[n]; // 0-9
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt(); // 3 3 0 2 1 2 4 2 0 0
    }

    int[] storage = new int[n + 1]; // 11 size 0-10
    
    System.out.println(climbStairsVariable_memo(n, 0, arr, storage));
    System.out.println(climbStairsVariable_tab(n, arr));
  }

  // Memoized solution
  public static int climbStairsVariable_memo(int n, int src, int[] arr, int[] storage) {
    if (src == n) {
      return 1;
    }

    if (storage[src] != 0) {
      return storage[src];
    }

    int total = 0;
    for (int jump = 1; jump <= arr[src]; jump++) {
      if (src + jump <= n) {
        total += climbStairsVariable_memo(n, src + jump, arr, storage);
      }
    }

    storage[src] = total;
    return total;
  }

  // Tabulation solution
  public static int climbStairsVariable_tab(int n, int[] arr) {
    int[] strg = new int[n + 1];
    strg[n] = 1;

    for (int i = n - 1; i >= 0; i--) {
      strg[i] = 0;
      for (int jump = i + 1; jump <= i + arr[i]; jump++) {
        if(jump < strg.length){
          strg[i] = strg[i] + strg[jump];
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
5
*/