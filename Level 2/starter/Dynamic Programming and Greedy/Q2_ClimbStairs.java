import java.util.*;
public class Q2_ClimbStairs {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 5

    int[] storage = new int[n + 1];
    
    System.out.println(climbStairs(n));
    System.out.println(climbStairs_memo(n, storage));
  }

  // Recursive solution
  public static int climbStairs(int n) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      return 0;
    }

    int nm1 = climbStairs(n - 1);
    int nm2 = climbStairs(n - 2);
    int nm3 = climbStairs(n - 3);
    int total = nm1 + nm2 + nm3;

    return total;
  }

  // Memoized solution
  public static int climbStairs_memo(int n, int[] storage) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      return 0;
    }

    if (storage[n] != 0) {
      return storage[n];
    }

    int nm1 = climbStairs_memo(n - 1, storage);
    int nm2 = climbStairs_memo(n - 2, storage);
    int nm3 = climbStairs_memo(n - 3, storage);
    int total = nm1 + nm2 + nm3;

    storage[n] = total;
    return total;
  }
  
}
