// Time Complexity: O(n!)
// Space Complexity: O(n)
import java.util.*;

public class Q21_PermutationsWords1 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    char[] arr = str.toCharArray();
    boolean[] used = new boolean[arr.length];
    permute(arr, used, "");
  }

  private static void permute(char[] arr, boolean[] used, String asf) {
    if (asf.length() == arr.length) {
      System.out.println(asf);
      return;
    }

    for (int i = 0; i < arr.length; i++) {
      if (!used[i]) {
        used[i] = true;
        permute(arr, used, asf + arr[i]);
        used[i] = false;
      }
    }
  }


}

/*
 * Input:
 * abc
 *
 * Output:
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 */
