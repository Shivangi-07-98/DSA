// Time Complexity: O((n*n)Cn * n*n)
// Space Complexity: O(n*n)
import java.util.*;

public class Q10_NQueensCombinations2DAs1DQueenChooses {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] chess = new boolean[n][n];
    nqueens(0, n, chess, -1);
  }

  public static void nqueens(int qpsf, int tq, boolean[][] chess, int lcno) {
    if (qpsf == tq) {
      for (int i = 0; i < chess.length; i++) {
        for (int j = 0; j < chess.length; j++) {
          System.out.print(chess[i][j] ? "q\t" : "-\t");
        }
        System.out.println();
      }
      System.out.println();
      return;
    }

    for (int i = lcno + 1; i < chess.length * chess.length; i++) {
      int row = i / chess.length;
      int col = i % chess.length;
      if (!chess[row][col] && IsQueenSafe(chess, row, col)) {
        chess[row][col] = true;
        nqueens(qpsf + 1, tq, chess, i);
        chess[row][col] = false;
      }
    }
  }

  public static boolean IsQueenSafe(boolean[][] chess, int row, int col) {
    for (int i = row, j = col - 1; j >= 0; j--) {
      if (chess[i][j]) {
        return false;
      }
    }
    for (int i = row - 1, j = col; i >= 0; i--) {
      if (chess[i][j]) {
        return false;
      }
    }
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (chess[i][j]) {
        return false;
      }
    }
    for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
      if (chess[i][j]) {
        return false;
      }
    }
    return true;
  }

}

/*
 * Input:
 * 4
 *
 * Output:
 * - q - -
 * - - - q
 * q - - -
 * - - q -
 *
 * - - q -
 * q - - -
 * - - - q
 * - q - -
 */
