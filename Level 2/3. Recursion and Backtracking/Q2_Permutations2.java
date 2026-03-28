// Time Complexity: O(nPr * n)
// Space Complexity: O(n)
import java.util.*;

public class Q2_Permutations2 {

  private static void permute(int idx, int[] boxes, boolean[] used, int r, int usedCount) {
    if (idx == boxes.length) {
      if (usedCount == r) {
        printBoxes(boxes);
      }
      return;
    }

    for (int i = 1; i <= r; i++) {
      if (!used[i]) {
        used[i] = true;
        boxes[idx] = i;
        permute(idx + 1, boxes, used, r, usedCount + 1);
        boxes[idx] = 0;
        used[i] = false;
      }
    }

    if (boxes.length - idx - 1 >= r - usedCount) {
      permute(idx + 1, boxes, used, r, usedCount);
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
    boolean[] used = new boolean[r + 1];
    permute(0, boxes, used, r, 0);
  }

}

/*
 * Input:
 * 3
 * 2
 *
 * Output:
 * 12-
 * 13-
 * 21-
 * 23-
 * 31-
 * 32-
 * 1-2
 * 1-3
 * 2-1
 * 2-3
 * 3-1
 * 3-2
 * -12
 * -13
 * -21
 * -23
 * -31
 * -32
 */
