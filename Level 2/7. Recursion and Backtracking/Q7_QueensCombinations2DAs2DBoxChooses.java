// Time Complexity: O((n*m)Cq)
// Space Complexity: O(n*m)
import java.util.*;

public class Q7_QueensCombinations2DAs2DBoxChooses {

  private static void queens(int idx, int qpsf, int tq, int[][] board) {
    int n = board.length;
    int m = board[0].length;
    if (idx == n * m) {
      if (qpsf == tq) {
        printBoard(board);
      }
      return;
    }

    int r = idx / m;
    int c = idx % m;

    if (qpsf < tq) {
      board[r][c] = qpsf + 1;
      queens(idx + 1, qpsf + 1, tq, board);
      board[r][c] = 0;
    }

    queens(idx + 1, qpsf, tq, board);
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
    queens(0, 0, tq, board);
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

