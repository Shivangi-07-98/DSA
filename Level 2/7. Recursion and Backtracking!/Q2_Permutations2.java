// Time Complexity: O(nPr * n)
// Space Complexity: O(n)
import java.util.*;
public class Q2_Permutations2 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int nboxes = scn.nextInt(); // 3
    int ritems = scn.nextInt(); // 2
    permutations(1, nboxes, new int[ritems], 0, ritems, "");
  }

  // Box chooses item/empty
  public static void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf) {
    if (cb > tb) {
      if (ssf == ts) { // ssf == ts ensures we placed all 2 items before printing
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

    // box blank bhi reh skta hai, ku? kuki boxes jyada hai 3 boxes hai 2 hi items aa skte
    permutations(cb + 1, tb, items, ssf, ts, asf + "_");
  }

}

/*
 * Q2 (box chooses item or empty):
 * What should I put in box 1? box 2? ...
 * Recursion fixes the box and tries unused items or empty.
 *
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
