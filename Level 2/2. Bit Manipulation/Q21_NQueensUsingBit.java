// Time Complexity: O(n!), Space Complexity: O(n)
import java.util.*;

public class Q21_NQueensUsingBit {

  static int count;

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    count = 0;
    solve(0, n, 0, 0, 0);

    System.out.println(count);
  }

  static void solve(int row, int n, int cols, int d1, int d2) {
    if (row == n) {
      count++;
      return;
    }

    int available = ((1 << n) - 1) & (~(cols | d1 | d2));

    while (available != 0) {
      int bit = available & -available;
      available -= bit;

      solve(row + 1, n, cols | bit, (d1 | bit) << 1, (d2 | bit) >> 1);
    }
  }

}

/*
 * Input:
 * 4
 *
 * Output:
 * 2
 */
