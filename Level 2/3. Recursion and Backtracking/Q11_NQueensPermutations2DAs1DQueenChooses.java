// Time Complexity: O((n*n)Pq * n*n)
// Space Complexity: O(n*n)
import java.util.*;

public class Q11_NQueensPermutations2DAs1DQueenChooses {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[][] chess = new int[n][n];
    nqueens(0, n, chess);
  }

  private static void nqueens(int qpsf, int tq, int[][] chess) {
    if (qpsf == tq) {
      printBoard(chess);
      return;
    }

    int n = chess.length;
    int m = chess[0].length;
    for (int i = 0; i < n * m; i++) {
      int r = i / m;
      int c = i % m;
      if (chess[r][c] == 0 && isSafe(chess, r, c)) {
        chess[r][c] = qpsf + 1;
        nqueens(qpsf + 1, tq, chess);
        chess[r][c] = 0;
      }
    }
  }

  public static boolean isSafe(int[][] chess, int row, int col) {
    for (int i = row - 1, j = col; i >= 0; i--) {
      if (chess[i][j] != 0) return false;
    }
    for (int i = row + 1, j = col; i < chess.length; i++) {
      if (chess[i][j] != 0) return false;
    }
    for (int i = row, j = col - 1; j >= 0; j--) {
      if (chess[i][j] != 0) return false;
    }
    for (int i = row, j = col + 1; j < chess.length; j++) {
      if (chess[i][j] != 0) return false;
    }
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (chess[i][j] != 0) return false;
    }
    for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
      if (chess[i][j] != 0) return false;
    }
    for (int i = row + 1, j = col + 1; i < chess.length && j < chess.length; i++, j++) {
      if (chess[i][j] != 0) return false;
    }
    for (int i = row + 1, j = col - 1; i < chess.length && j >= 0; i++, j--) {
      if (chess[i][j] != 0) return false;
    }
    return true;
  }

  private static void printBoard(int[][] chess) {
    for (int[] row : chess) {
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
 * 4
 *
 * Output:
 * -	q1	-	-	
 * -	-	-	q2	
 * q3	-	-	-	
 * -	-	q4	-	
 *
 * -	q1	-	-	
 * -	-	-	q2	
 * q4	-	-	-	
 * -	-	q3	-	
 *
 * -	q1	-	-	
 * -	-	-	q3	
 * q2	-	-	-	
 * -	-	q4	-	
 *
 * -	q1	-	-	
 * -	-	-	q4	
 * q2	-	-	-	
 * -	-	q3	-	
 * 
 * ... 44 more boards
 */
