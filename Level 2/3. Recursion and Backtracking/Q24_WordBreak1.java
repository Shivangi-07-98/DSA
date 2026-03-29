// Time Complexity: O(2^n)
// Space Complexity: O(n)
import java.util.*;

public class Q24_WordBreak1 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    int n = scn.nextInt();
    Set<String> dict = new HashSet<>();
    for (int i = 0; i < n; i++) {
      dict.add(scn.next());
    }
    solve(str, dict, "");
  }

  private static void solve(String str, Set<String> dict, String asf) {
    if (str.length() == 0) {
      System.out.println(asf.trim());
      return;
    }

    for (int i = 1; i <= str.length(); i++) {
      String prefix = str.substring(0, i);
      if (dict.contains(prefix)) {
        solve(str.substring(i), dict, asf + prefix + " ");
      }
    }
  }


}

/*
 * Input:
 * ilikeicecreamandmango
 * 5
 * i like ice cream mango
 *
 * Output:
 * i like ice cream and mango
 */
