// Time Complexity: O((n*m)Cq)
// Space Complexity: O(n*m)
import java.util.*;

public class Q9_QueensCombinations2DAs1DQueenChooses {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    int tq = scn.nextInt();
    int[][] board = new int[n][m];
    queens(1, tq, 0, board);
  }

  private static void queens(int qpsf, int tq, int idx, int[][] board) {
    if (qpsf > tq) {
      printBoard(board);
      return;
    }

    int n = board.length;
    int m = board[0].length;
    for (int i = idx; i < n * m; i++) {
      int r = i / m;
      int c = i % m;
      if (board[r][c] == 0) {
        board[r][c] = qpsf;
        queens(qpsf + 1, tq, i + 1, board);
        board[r][c] = 0;
      }
    }
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
 * q1\t-\t
 * q2\t-\t
 *
 * q1\t-\t
 * -\tq2\t
 *
 * -\tq1\t
 * q2\t-\t
 *
 * -\tq1\t
 * -\tq2\t
 *
 * -\t-\t
 * q1\tq2\t
 */
