// Time Complexity: O(2^n)
// Space Complexity: O(n)
import java.util.*;

public class Q27_WordsKSelection1 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    int k = scn.nextInt();
    solve(str, 0, k, "");
  }

  private static void solve(String str, int idx, int k, String asf) {
    if (idx == str.length()) {
      if (asf.length() == k) System.out.println(asf);
      return;
    }

    solve(str, idx + 1, k, asf + str.charAt(idx));
    solve(str, idx + 1, k, asf);
  }


}

/*
 * Input:
 * abc
 * 2
 *
 * Output:
 * ab
 * ac
 * bc
 */
