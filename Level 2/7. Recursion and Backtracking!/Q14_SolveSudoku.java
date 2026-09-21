// Time Complexity: O(9^(empty))
// Space Complexity: O(1)
import java.util.*;

public class Q14_SolveSudoku {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int[][] board = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        board[i][j] = scn.nextInt();
      }
    }

    if (solve(board, 0, 0)) {
      printBoard(board);
    }
  }

  private static boolean solve(int[][] board, int r, int c) {
    if (r == 9) return true;

    int nr = r;
    int nc = c + 1;
    if (nc == 9) {
      nr = r + 1;
      nc = 0;
    }

    if (board[r][c] != 0) {
      return solve(board, nr, nc);
    }

    for (int num = 1; num <= 9; num++) {
      if (isSafe(board, r, c, num)) {
        board[r][c] = num;
        if (solve(board, nr, nc)) return true;
        board[r][c] = 0;
      }
    }

    return false;
  }

  private static boolean isSafe(int[][] board, int r, int c, int val) {
    for (int i = 0; i < 9; i++) {
      if (board[r][i] == val) return false;
      if (board[i][c] == val) return false;
    }

    int sr = (r / 3) * 3;
    int sc = (c / 3) * 3;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[sr + i][sc + j] == val) return false;
      }
    }

    return true;
  }

  private static void printBoard(int[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        System.out.print(board[i][j] + (j == 8 ? "" : " "));
      }
      System.out.println();
    }
  }


}

/*
 * Input:
 * 0 0 0 2 6 0 7 0 1
 * 6 8 0 0 7 0 0 9 0
 * 1 9 0 0 0 4 5 0 0
 * 8 2 0 1 0 0 0 4 0
 * 0 0 4 6 0 2 9 0 0
 * 0 5 0 0 0 3 0 2 8
 * 0 0 9 3 0 0 0 7 4
 * 0 4 0 0 5 0 0 3 6
 * 7 0 3 0 1 8 0 0 0
 *
 * Output:
 * 4 3 5 2 6 9 7 8 1
 * 6 8 2 5 7 1 4 9 3
 * 1 9 7 8 3 4 5 6 2
 * 8 2 6 1 9 5 3 4 7
 * 3 7 4 6 8 2 9 1 5
 * 9 5 1 7 4 3 6 2 8
 * 5 1 9 3 2 6 8 7 4
 * 2 4 8 9 5 7 1 3 6
 * 7 6 3 4 1 8 2 5 9
 */
