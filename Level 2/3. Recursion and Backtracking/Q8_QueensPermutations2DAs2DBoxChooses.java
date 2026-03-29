// Time Complexity: O((n*m)Pq)
// Space Complexity: O(n*m)
import java.util.*;

public class Q8_QueensPermutations2DAs2DBoxChooses {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    boolean[] queens = new boolean[n];
    queensPermutations(0, n, 0, 0, "", queens);
  }

  public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
    if (row == tq) {
      if (qpsf == tq) {
        System.out.println(asf);
      }
      return;
    }

    if (col == tq - 1) {
      for (int i = 0; i < queens.length; i++) {
        if (!queens[i]) {
          queens[i] = true;
          queensPermutations(qpsf + 1, tq, row + 1, 0, asf + "q" + (i + 1) + "\n", queens);
          queens[i] = false;
        }
      }
      queensPermutations(qpsf, tq, row + 1, 0, asf + "-\n", queens);

    } else {
      for (int i = 0; i < queens.length; i++) {
        if (!queens[i]) {
          queens[i] = true;
          queensPermutations(qpsf + 1, tq, row, col + 1, asf + "q" + (i + 1), queens);
          queens[i] = false;
        }
      }
      queensPermutations(qpsf, tq, row, col + 1, asf + "-", queens);
    }
  }

}

/*
 * Input:
 * 2
 *
 * Output:
 * q1q2
 * --
 *
 * q1-
 * q2-
 *
 * q1-
 * -q2
 *
 * q2q1
 * --
 *
 * q2-
 * q1-
 *
 * q2-
 * -q1
 *
 * -q1
 * q2-
 *
 * -q1
 * -q2
 *
 * -q2
 * q1-
 *
 * -q2
 * -q1
 *
 * --
 * q1q2
 *
 * --
 * q2q1
 */
