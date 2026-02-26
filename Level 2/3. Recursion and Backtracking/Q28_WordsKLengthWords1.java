// Time Complexity: O(nPk)
// Space Complexity: O(n)
import java.util.*;

public class Q28_WordsKLengthWords1 {

  private static void solve(char[] arr, boolean[] used, int k, String asf) {
    if (asf.length() == k) {
      System.out.println(asf);
      return;
    }

    for (int i = 0; i < arr.length; i++) {
      if (!used[i]) {
        used[i] = true;
        solve(arr, used, k, asf + arr[i]);
        used[i] = false;
      }
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    int k = scn.nextInt();
    char[] arr = str.toCharArray();
    boolean[] used = new boolean[arr.length];
    solve(arr, used, k, "");
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
 * ba
 * bc
 * ca
 * cb
 */
