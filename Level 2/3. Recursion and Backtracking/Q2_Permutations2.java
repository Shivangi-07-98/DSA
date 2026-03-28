
// Time Complexity: O(nPr * n)
// Space Complexity: O(n)
import java.util.*;

public class Q2_Permutations2 {

  public static void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf) {
    if (cb > tb) {
      if (ssf == ts) {
        System.out.println(asf);
      }
      return;
    }

    for (int i = 0; i < items.length; i++) {
      if (items[i] == 0) {
        items[i] = cb;
        permutations(cb + 1, tb, items, ssf + 1, ts, asf + (i + 1));
        items[i] = 0;
      }
    }

    permutations(cb + 1, tb, items, ssf, ts, asf + "_");
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int nboxes = scn.nextInt();
    int ritems = scn.nextInt();
    permutations(1, nboxes, new int[ritems], 0, ritems, "");
  }
}

/*
 * Input:
 * 3
 * 2
 *
 * Output:
 * 12_
 * 1_2
 * 21_
 * 2_1
 * _12
 * _21
 */
