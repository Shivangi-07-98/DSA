// Time Complexity: O(nCk)
// Space Complexity: O(n)
import java.util.*;

public class Q30_WordsKSelection2 {

  private static void solve(String str, int idx, int k, char[] spots, int filled) {
    if (idx == str.length()) {
      if (filled == k) {
        System.out.println(new String(spots));
      }
      return;
    }

    char ch = str.charAt(idx);
    for (int i = 0; i < spots.length; i++) {
      if (spots[i] == 0) {
        spots[i] = ch;
        solve(str, idx + 1, k, spots, filled + 1);
        spots[i] = 0;
        break;
      }
    }
    solve(str, idx + 1, k, spots, filled);
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    int k = scn.nextInt();
    char[] spots = new char[k];
    solve(str, 0, k, spots, 0);
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
