// Time Complexity: O((n*n)Pq * n*n)
// Space Complexity: O(n*n)
import java.util.*;

public class Q11_NQueensPermutations2DAs1DQueenChooses {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int tq = n;
    int[][] board = new int[n][n];
    nqueens(1, tq, board);
  }

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

    for (int i = r - 1; i >= 0; i--) {
      if (board[i][c] != 0) return false;
    }
    for (int i = r + 1; i < n; i++) {
      if (board[i][c] != 0) return false;
    }
    for (int j = c - 1; j >= 0; j--) {
      if (board[r][j] != 0) return false;
    }
    for (int j = c + 1; j < n; j++) {
      if (board[r][j] != 0) return false;
    }
    for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] != 0) return false;
    }
    for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++) {
      if (board[i][j] != 0) return false;
    }
    for (int i = r + 1, j = c - 1; i < n && j >= 0; i++, j--) {
      if (board[i][j] != 0) return false;
    }
    for (int i = r + 1, j = c + 1; i < n && j < n; i++, j++) {
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


}

/*
 * Input:
 * 1
 *
 * Output:
 * q1	
 */
