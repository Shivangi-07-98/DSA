// Time Complexity: O((n*m)Pq)
// Space Complexity: O(n*m)
import java.util.*;

public class Q5_QueensPermutations2DAs2DQueenChooses {

  private static void queens(int qpsf, int tq, int[][] board) {
    if (qpsf > tq) {
      printBoard(board);
      return;
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 0) {
          board[i][j] = qpsf;
          queens(qpsf + 1, tq, board);
          board[i][j] = 0;
        }
      }
    }
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
    int m = scn.nextInt();
    int tq = scn.nextInt();
    int[][] board = new int[n][m];
    queens(1, tq, board);
  }

}

/*
 * Input:
 * 2
 * 2
 * 2
 *
 * Output:
 * q1	q2	
 * -	-	
 *
 * q1	-	
 * q2	-	
 *
 * q1	-	
 * -	q2	
 *
 * -	q1	
 * q2	-	
 *
 * -	q1	
 * -	q2	
 *
 * -	-	
 * q1	q2	
 */

