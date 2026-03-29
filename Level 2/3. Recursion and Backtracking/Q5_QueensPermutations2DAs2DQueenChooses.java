// Time Complexity: O((n*m)Pq)
// Space Complexity: O(n*m)
import java.util.*;

public class Q5_QueensPermutations2DAs2DQueenChooses {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[][] chess = new int[n][n];
    queens(0, n, chess);
  }

  private static void queens(int qpsf, int tq, int[][] chess) {
    if (qpsf == tq) {
      printBoard(chess);
      return;
    }

    for (int i = 0; i < chess.length; i++) {
      for (int j = 0; j < chess[0].length; j++) {
        if (chess[i][j] == 0) {
          chess[i][j] = qpsf + 1;
          queens(qpsf + 1, tq, chess);
          chess[i][j] = 0;
        }
      }
    }
  }

  // chess = [ row0, row1, row2, ... ]
  private static void printBoard(int[][] chess) {
    for (int[] row : chess) { // take one row at a time
      for (int val : row) { // take each value inside that row
        System.out.print(val == 0 ? "-  " : "q" + val + " ");
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
 * q1 q2
 * - -
 *
 * q1 -
 * q2 -
 *
 * q1 -
 * - q2
 *
 * - q1
 * q2 -
 *
 * - q1
 * - q2
 *
 * - -
 * q1 q2
 */
