import java.util.*;

public class Q8_CountBinaryStrings {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 6

    System.out.println(countBinaryStrings_tab1(n));
  }

  // Tabulation solution
  public static int countBinaryStrings_tab1(int n) {
    int[] zero = new int[n + 1];
    int[] one = new int[n + 1];

    zero[1] = 1;
    one[1] = 1;

    for (int i = 2; i <= n; i++) {
      one[i] = one[i - 1] + zero[i - 1];
      zero[i] = one[i - 1];
    }

    return zero[n] + one[n];
  }

  // Tabulation solution - Space optimized (using variables instead of arrays)
  public static int countBinaryStrings_tab2(int n) {
    int old_zero = 1; // binary strings ending in 0 of length 1
    int old_one = 1; // binary strings ending in 1 of length 1

    for (int i = 2; i <= n; i++) {
      int new_one = old_zero + old_one;
      int new_zero = old_one;

      old_zero = new_zero;
      old_one = new_one;
    }

    return old_zero + old_one;
  }

}
// formula 2^n
// binary string 0,1 of length n jisme 2 zero saath nhi hone chaiye

/*
 * Sample Input:
 * 6
 * 
 * Sample Output:
 * 21
 */
