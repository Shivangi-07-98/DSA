// Time Complexity: O(nCr * n)
// Space Complexity: O(n)
import java.util.*;
public class Q3_Combinations1 {

  public static void combinations(int cb, int tb, int ssf, int ts, String asf) {
    if (cb > tb) {
      if (ssf == ts) {
        System.out.println(asf);
      }
      return;
    }

    if (ssf < ts) {
      combinations(cb + 1, tb, ssf + 1, ts, asf + "i");
    }
    combinations(cb + 1, tb, ssf, ts, asf + "_");
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int nboxes = scn.nextInt();
    int ritems = scn.nextInt();
    combinations(1, nboxes, 0, ritems, "");
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
 * _12
 */
