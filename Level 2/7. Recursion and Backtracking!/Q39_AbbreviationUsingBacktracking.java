// Time Complexity: O(2^n)
// Space Complexity: O(n)
import java.util.*;

public class Q39_AbbreviationUsingBacktracking {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    solve(str, 0, 0, "");
  }

  private static void solve(String str, int idx, int count, String asf) {
    if (idx == str.length()) {
      if (count > 0) asf += count;
      System.out.println(asf);
      return;
    }

    solve(str, idx + 1, count + 1, asf);
    String next = asf + (count > 0 ? count : "") + str.charAt(idx);
    solve(str, idx + 1, 0, next);
  }


}

/*
 * Input:
 * word
 *
 * Output:
 * 4
 * 3d
 * 2r1
 * 2rd
 * 1o2
 * 1o1d
 * 1or1
 * 1ord
 * w3
 * w2d
 * w1r1
 * w1rd
 * wo2
 * wo1d
 * wor1
 * word
 */
