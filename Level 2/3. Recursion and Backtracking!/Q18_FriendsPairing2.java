// Time Complexity: O(n!)
// Space Complexity: O(n)
import java.util.*;

public class Q18_FriendsPairing2 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[] used = new boolean[n + 1];
    solve(n, used, "");
    System.out.println(count);
  }

  private static int count = 0;

  private static void solve(int n, boolean[] used, String asf) {
    int i = 1;
    while (i <= n && used[i]) i++;

    if (i > n) {
      count++;
      System.out.println(asf.trim());
      return;
    }

    used[i] = true;
    solve(n, used, asf + "(" + i + ") ");

    for (int j = i + 1; j <= n; j++) {
      if (!used[j]) {
        used[j] = true;
        solve(n, used, asf + "(" + i + "," + j + ") ");
        used[j] = false;
      }
    }

    used[i] = false;
  }


}

/*
 * Input:
 * 3
 *
 * Output:
 * (1) (2) (3)
 * (1) (2,3)
 * (1,2) (3)
 * (1,3) (2)
 * 4
 */
