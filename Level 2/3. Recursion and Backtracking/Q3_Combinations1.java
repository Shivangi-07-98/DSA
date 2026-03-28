// Time Complexity: O(nCr * n)
// Space Complexity: O(n)
import java.util.*;

public class Q3_Combinations1 {

  private static void combine(int[] boxes, int ci, int ti, int lastBox) {
    if (ci > ti) {
      printBoxes(boxes);
      return;
    }

    for (int i = lastBox + 1; i < boxes.length; i++) {
      boxes[i] = ci;
      combine(boxes, ci + 1, ti, i);
      boxes[i] = 0;
    }
  }

  private static void printBoxes(int[] boxes) {
    for (int val : boxes) {
      System.out.print(val == 0 ? "-" : val);
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int r = scn.nextInt();
    int[] boxes = new int[n];
    combine(boxes, 1, r, -1);
  }

}

/*
 * Input:
 * 4
 * 2
 *
 * Output:
 * 12--
 * 1-2-
 * 1--2
 * -12-
 * -1-2
 * --12
 */
