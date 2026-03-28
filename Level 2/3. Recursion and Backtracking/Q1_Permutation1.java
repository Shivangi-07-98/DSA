// Time Complexity: O(nPr * n)
// Space Complexity: O(n)
import java.util.*;

public class Q1_Permutation1 {

  private static void permute(int[] boxes, int ci, int ti) {
    if (ci > ti) {
      printBoxes(boxes);
      return;
    }

    for (int i = 0; i < boxes.length; i++) {
      if (boxes[i] == 0) {
        boxes[i] = ci;
        permute(boxes, ci + 1, ti);
        boxes[i] = 0;
      }
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
    permute(boxes, 1, r);
  }

}

/*
 * Input:
 * 3
 * 2
 *
 * Output:
 * 12-
 * 1-2
 * 21-
 * 2-1
 * -12
 * -21
 */
