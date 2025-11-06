import java.util.*;
public class Q23_FriendsPairing {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    long[] storage = new long[n + 1];
    System.out.println(friendsPairing(n));
    System.out.println(friendsPairing_memo(n, storage));
    System.out.println(friendsPairing_tab(n));
    System.out.println(friendsPairing_optimized(n));
  }

  // Recursive solution
  // Count ways to pair n friends
  // Each friend can either remain single or pair with any other friend
  public static long friendsPairing(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }

    // Friend remains single: remaining n-1 friends
    long single = friendsPairing(n - 1);
    
    // Friend pairs with any of the remaining (n-1) friends: (n-1) * friendsPairing(n-2)
    long pair = (n - 1) * friendsPairing(n - 2);

    return single + pair;
  }

  // Memoized solution
  public static long friendsPairing_memo(int n, long[] storage) {
    if (n == 0 || n == 1) {
      return 1;
    }

    if (storage[n] != 0) {
      return storage[n];
    }

    storage[n] = friendsPairing_memo(n - 1, storage) + (n - 1) * friendsPairing_memo(n - 2, storage);
    return storage[n];
  }

  // Tabulation solution
  public static long friendsPairing_tab(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }

    long[] strg = new long[n + 1];
    strg[0] = 1;
    strg[1] = 1;

    for (int i = 2; i <= n; i++) {
      strg[i] = strg[i - 1] + (i - 1) * strg[i - 2];
    }

    return strg[n];
  }

  // Space optimized solution
  public static long friendsPairing_optimized(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }

    long prev2 = 1;
    long prev1 = 1;

    for (int i = 2; i <= n; i++) {
      long curr = prev1 + (i - 1) * prev2;
      prev2 = prev1;
      prev1 = curr;
    }

    return prev1;
  }
  
}

