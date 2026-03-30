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

  private static void nqueens(int qpsf, int tq, boolean[][] chess, int lbno) {
    if (qpsf == tq) {
      printBoard(chess);
      return;
    }

    int n = chess.length;
    for (int i = lbno + 1; i < n * n; i++) {
      int r = i / n;
      int c = i % n;
      if (!chess[r][c] && isSafe(chess, r, c)) {
        chess[r][c] = true;
        nqueens(qpsf + 1, tq, chess, i);
        chess[r][c] = false;
      }
    }
  }

  private static boolean isSafe(boolean[][] chess, int r, int c) {
    int n = chess.length;

    for (int i = r - 1; i >= 0; i--) {
      if (chess[i][c])
        return false;
    }
    for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
      if (chess[i][j])
        return false;
    }
    for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++) {
      if (chess[i][j])
        return false;
    }

    return true;
  }

  private static void printBoard(boolean[][] chess) {
    for (boolean[] row : chess) {
      for (boolean hasQueen : row) {
        System.out.print(hasQueen ? "q\t" : "-\t");
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
