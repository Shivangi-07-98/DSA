// Time Complexity: O(nCr * n)
// Space Complexity: O(n)
import java.util.*;

public class Q4_Combinations2 {

  public static void combinations(int[] boxes, int ci, int ti, int lb) {
    if (ci > ti) {
      for (int val : boxes) {
        if (val != 0) {
          System.out.print("i");
        } else {
          System.out.print("_");
        }
      }
      System.out.println();
      return;
    }

    for (int i = lb + 1; i < boxes.length; i++) {
      if (boxes[i] == 0) {
        boxes[i] = ci;
        combinations(boxes, ci + 1, ti, i);
        boxes[i] = 0;
      }
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int nboxes = scn.nextInt();
    int ritems = scn.nextInt();
    combinations(new int[nboxes], 1, ritems, -1);
  }

}

/*
 * Input:
 * 3
 * 2
 *
 * Output:
 * ii_
 * i_i
 * _ii
 */
