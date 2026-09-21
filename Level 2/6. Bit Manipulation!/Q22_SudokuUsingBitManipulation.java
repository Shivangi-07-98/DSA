// Time Complexity: Exponential in empty cells, Space Complexity: O(1)
import java.util.*;

public class Q22_SudokuUsingBitManipulation {

  static int[] rowMask = new int[9];
  static int[] colMask = new int[9];
  static int[][] boxMask = new int[3][3];

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int[][] board = new int[9][9];

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        board[i][j] = scn.nextInt();
        if (board[i][j] != 0) {
          int mask = 1 << board[i][j];
          rowMask[i] |= mask;
          colMask[j] |= mask;
          boxMask[i / 3][j / 3] |= mask;
        }
      }
    }

    solve(board, 0, 0);

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  static boolean solve(int[][] board, int r, int c) {
    if (r == 9) {
      return true;
    }

    int nr = c == 8 ? r + 1 : r;
    int nc = c == 8 ? 0 : c + 1;

    if (board[r][c] != 0) {
      return solve(board, nr, nc);
    }

    for (int num = 1; num <= 9; num++) {
      int mask = 1 << num;
      if ((rowMask[r] & mask) != 0) {
        continue;
      }
      if ((colMask[c] & mask) != 0) {
        continue;
      }
      if ((boxMask[r / 3][c / 3] & mask) != 0) {
        continue;
      }

      board[r][c] = num;
      rowMask[r] |= mask;
      colMask[c] |= mask;
      boxMask[r / 3][c / 3] |= mask;

      if (solve(board, nr, nc)) {
        return true;
      }

      board[r][c] = 0;
      rowMask[r] ^= mask;
      colMask[c] ^= mask;
      boxMask[r / 3][c / 3] ^= mask;
    }

    return false;
  }

}

/*
 * Input:
 * 3 0 6 5 0 8 4 0 0
 * 5 2 0 0 0 0 0 0 0
 * 0 8 7 0 0 0 0 3 1
 * 0 0 3 0 1 0 0 8 0
 * 9 0 0 8 6 3 0 0 5
 * 0 5 0 0 9 0 6 0 0
 * 1 3 0 0 0 0 2 5 0
 * 0 0 0 0 0 0 0 7 4
 * 0 0 5 2 0 6 3 0 0
 *
 * Output:
 * Solved sudoku grid (9x9)
 */
