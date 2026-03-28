// Time Complexity: O(nCr * n)
// Space Complexity: O(n)
import java.util.*;

public class Q4_Combinations2 {

  private static void combine(int idx, int[] boxes, int r, int placed) {
    if (idx == boxes.length) {
      if (placed == r) {
        printBoxes(boxes);
      }
      return;
    }

    if (placed < r) {
      boxes[idx] = placed + 1;
      combine(idx + 1, boxes, r, placed + 1);
      boxes[idx] = 0;
    }

    combine(idx + 1, boxes, r, placed);
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
    combine(0, boxes, r, 0);
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
