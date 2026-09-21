// Time Complexity: O((n*m)Cq)
// Space Complexity: O(n*m)
import java.util.*;

public class Q6_QueensCombinations2DAs2DQueenChooses {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] chess = new boolean[n][n];
    queens(0, n, chess, 0, -1);
  }

  private static void queens(int qpsf, int tq, boolean[][] chess, int i, int j) {
    if (qpsf == tq) {
      printBoard(chess);
      return;
    }

    int rows = chess.length;
    int cols = chess[0].length;
    for (int r = i; r < rows; r++) {
      int cStart = (r == i) ? j + 1 : 0;
      for (int c = cStart; c < cols; c++) {
        if (chess[r][c] == false) {
          chess[r][c] = true;
          queens(qpsf + 1, tq, chess, r, c);
          chess[r][c] = false;
        }
      }
    }
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
 * 2
 *
 * Output:
 * q q
 * - -
 *
 * q -
 * q -
 *
 * q -
 * - q
 *
 * - q
 * q -
 *
 * - q
 * - q
 *
 * - -
 * q q
 */
