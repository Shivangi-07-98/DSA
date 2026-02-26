// Time Complexity: O((n*m)Pq * n)
// Space Complexity: O(n*m)
import java.util.*;

public class Q11_NQueensPermutations2DAs1DQueenChooses {

  private static void nqueens(int qpsf, int tq, int[][] board) {
    if (qpsf > tq) {
      printBoard(board);
      return;
    }

    int n = board.length;
    int m = board[0].length;
    for (int i = 0; i < n * m; i++) {
      int r = i / m;
      int c = i % m;
      if (board[r][c] == 0 && isSafe(board, r, c)) {
        board[r][c] = qpsf;
        nqueens(qpsf + 1, tq, board);
        board[r][c] = 0;
      }
    }
  }

  private static boolean isSafe(int[][] board, int r, int c) {
    int n = board.length;
    int m = board[0].length;

    for (int i = r - 1; i >= 0; i--) {
      if (board[i][c] != 0) return false;
    }
    for (int i = r + 1; i < n; i++) {
      if (board[i][c] != 0) return false;
    }
    for (int j = c - 1; j >= 0; j--) {
      if (board[r][j] != 0) return false;
    }
    for (int j = c + 1; j < m; j++) {
      if (board[r][j] != 0) return false;
    }
    for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] != 0) return false;
    }
    for (int i = r - 1, j = c + 1; i >= 0 && j < m; i--, j++) {
      if (board[i][j] != 0) return false;
    }
    for (int i = r + 1, j = c - 1; i < n && j >= 0; i++, j--) {
      if (board[i][j] != 0) return false;
    }
    for (int i = r + 1, j = c + 1; i < n && j < m; i++, j++) {
      if (board[i][j] != 0) return false;
    }

    return true;
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

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int tq = scn.nextInt();
    int[][] board = new int[n][n];
    nqueens(1, tq, board);
  }

}

/*
 * Input:
 * 4
 * 4
 *
 * Output:
 * -\tq1\t-\t-\t
 * -\t-\t-\tq2\t
 * q3\t-\t-\t-\t
 * -\t-\tq4\t-\t
 *
 * -\t-\tq1\t-\t
 * q2\t-\t-\t-\t
 * -\t-\t-\tq3\t
 * -\tq4\t-\t-\t
 */
