// Time Complexity: O(n)
// Space Complexity: O(log n)
import java.util.*;

public class Q17_LexicographicalNumbers {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    for (int i = 1; i <= 9; i++) {
      if (i > n) break;
      dfs(i, n);
    }
  }

  private static void dfs(int curr, int n) {
    if (curr > n) return;
    System.out.println(curr);
    for (int i = 0; i <= 9; i++) {
      long next = (long) curr * 10 + i;
      if (next > n) break;
      dfs((int) next, n);
    }
  }


}

/*
 * Input:
 * 13
 *
 * Output:
 * 1
 * 10
 * 11
 * 12
 * 13
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 9
 */
