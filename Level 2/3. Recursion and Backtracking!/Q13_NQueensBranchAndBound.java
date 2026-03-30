// Time Complexity: O(n!)
// Space Complexity: O(n^2)
import java.util.*;

public class Q13_NQueensBranchAndBound {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[] cols = new boolean[n];
    boolean[] diag = new boolean[2 * n - 1];
    boolean[] adiag = new boolean[2 * n - 1];
    int[][] board = new int[n][n];
    nqueens(0, n, cols, diag, adiag, board);
  }

  private static void nqueens(int r, int n, boolean[] cols, boolean[] diag, boolean[] adiag, int[][] board) {
    if (r == n) {
      printBoard(board);
      return;
    }

    for (int c = 0; c < n; c++) {
      int d = r + c;
      int ad = r - c + n - 1;
      if (!cols[c] && !diag[d] && !adiag[ad]) {
        cols[c] = diag[d] = adiag[ad] = true;
        board[r][c] = 1;
        nqueens(r + 1, n, cols, diag, adiag, board);
        board[r][c] = 0;
        cols[c] = diag[d] = adiag[ad] = false;
      }
    }
  }

  private static void printBoard(int[][] board) {
    for (int[] row : board) {
      for (int val : row) {
        System.out.print(val == 1 ? "q\t" : "-\t");
      }
      System.out.println();
    }
    System.out.println();
  }


}

/*
 * Input:
 * 4
 *
 * Output:
 * -\tq\t-\t-\t
 * -\t-\t-\tq\t
 * q\t-\t-\t-\t
 * -\t-\tq\t-\t
 *
 * -\t-\tq\t-\t
 * q\t-\t-\t-\t
 * -\t-\t-\tq\t
 * -\tq\t-\t-\t
 */
