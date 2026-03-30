// Time Complexity: O((n*n)Cn * n*n)
// Space Complexity: O(n*n)
import java.util.*;

public class Q12_NKnightsCombinations2DAs1DKnightChooses {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = n;
    int[][] board = new int[n][n];
    nknights(1, k, 0, board);
  }

  private static void nknights(int kpsf, int tk, int idx, int[][] board) {
    if (kpsf > tk) {
      printBoard(board);
      return;
    }

    int n = board.length;
    int m = board[0].length;
    for (int i = idx; i < n * m; i++) {
      int r = i / m;
      int c = i % m;
      if (board[r][c] == 0 && isSafe(board, r, c)) {
        board[r][c] = kpsf;
        nknights(kpsf + 1, tk, i + 1, board);
        board[r][c] = 0;
      }
    }
  }

  private static boolean isSafe(int[][] board, int r, int c) {
    int[][] moves = { {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2} };
    for (int[] mv : moves) {
      int nr = r + mv[0];
      int nc = c + mv[1];
      if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length) {
        if (board[nr][nc] != 0) return false;
      }
    }
    return true;
  }

  private static void printBoard(int[][] board) {
    for (int[] row : board) {
      for (int val : row) {
        System.out.print(val == 0 ? "-\t" : "k" + val + "\t");
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
 * k1	
 */
