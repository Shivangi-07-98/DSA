// Time Complexity: O(nPk)
// Space Complexity: O(n)
import java.util.*;

public class Q32_WordsKLengthWords4 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    int k = scn.nextInt();
    char[] spots = new char[k];
    solve(str, 0, k, spots, 0, new HashMap<>());
  }

  private static void solve(String str, int idx, int k, char[] spots, int filled, Map<Character, Integer> last) {
    if (idx == str.length()) {
      if (filled == k) {
        System.out.println(new String(spots));
      }
      return;
    }

    char ch = str.charAt(idx);
    int lo = last.getOrDefault(ch, -1);
    for (int i = lo + 1; i < spots.length; i++) {
      if (spots[i] == 0) {
        spots[i] = ch;
        last.put(ch, i);
        solve(str, idx + 1, k, spots, filled + 1, last);
        spots[i] = 0;
        if (lo == -1) last.remove(ch); else last.put(ch, lo);
      }
    }

    solve(str, idx + 1, k, spots, filled, last);
  }


}

/*
 * Input:
 * aabc
 * 2
 *
 * Output:
 * aa
 * ab
 * ac
 * ba
 * bc
 * ca
 */
