// Time Complexity: O((n*m)Pq)
// Space Complexity: O(n*m)
import java.util.*;

public class Q8_QueensPermutations2DAs2DBoxChooses {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    int tq = scn.nextInt();
    int[][] board = new int[n][m];
    boolean[] used = new boolean[tq + 1];
    queens(0, 0, tq, board, used);
  }

  private static void queens(int idx, int qpsf, int tq, int[][] board, boolean[] used) {
    int n = board.length;
    int m = board[0].length;
    if (idx == n * m) {
      if (qpsf == tq) {
        printBoard(board);
      }
      return;
    }

    int r = idx / m;
    int c = idx % m;

    for (int q = 1; q <= tq; q++) {
      if (!used[q]) {
        used[q] = true;
        board[r][c] = q;
        queens(idx + 1, qpsf + 1, tq, board, used);
        board[r][c] = 0;
        used[q] = false;
      }
    }

    queens(idx + 1, qpsf, tq, board, used);
  }

  private static void printBoard(int[][] board) {
    for (int[] row : board) {
      for (int val : row) {
        System.out.print(val == 0 ? "-\t" : "q" + val + "\t");
      }
      System.out.println();
    }
    System.out.println();
  }


}

/*
 * Input:
 * 2
 * 2
 * 2
 *
 * Output:
 * q1\tq2\t
 * -\t-\t
 *
 * q2\tq1\t
 * -\t-\t
 *
 * q1\t-\t
 * q2\t-\t
 *
 * q2\t-\t
 * q1\t-\t
 *
 * q1\t-\t
 * -\tq2\t
 *
 * q2\t-\t
 * -\tq1\t
 *
 * -\tq1\t
 * q2\t-\t
 *
 * -\tq2\t
 * q1\t-\t
 *
 * -\tq1\t
 * -\tq2\t
 *
 * -\tq2\t
 * -\tq1\t
 */
