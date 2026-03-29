// Time Complexity: O((n*m)Cq)
// Space Complexity: O(n*m)
import java.util.*;

public class Q7_QueensCombinations2DAs2DBoxChooses {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    queens(0, n, 0, 0, "");
  }

  public static void queens(int qpsf, int tq, int row, int col, String asf) {
    if (row == tq) {
      if (qpsf == tq) {
        System.out.println(asf);
      }
      return;
    }

    if (col != tq - 1) {
      queens(qpsf + 1, tq, row + 1, 0, asf + "q\n");
      queens(qpsf + 0, tq, row + 1, 0, asf + "-\n");
    } else {
      queens(qpsf + 1, tq, row, col + 1, asf + "q");
      queens(qpsf + 0, tq, row, col + 1, asf + "-");
    }
  }

}

/*
 * Input:
 * 2
 *
 * Output:
 * q1 q2
 * - -
 *
 * q1 -
 * q2 -
 *
 * q1 -
 * - q2
 *
 * - q1
 * q2 -
 *
 * - q1
 * - q2
 *
 * - -
 * q1 q2
 */
