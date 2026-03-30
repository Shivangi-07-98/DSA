// Time Complexity: O((n*n)Cn * n*n)
// Space Complexity: O(n*n)
import java.util.*;

public class Q9_QueensCombinations2DAs1DQueenChooses {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    boolean[][] chess = new boolean[n][n];
    queensCombinations(0, n, chess, -1);
  }

  public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lbno) {
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

    for (int i = lbno + 1; i < chess.length * chess.length; i++) {
      int r = i / chess.length;
      int c = i % chess.length;
      if (!chess[r][c]) {
        chess[r][c] = true;
        queensCombinations(qpsf + 1, tq, chess, i);
        chess[r][c] = false;
      }
    }
  }
  
}

/*
 * Input:
 * 2
 *
 * Output:
 * q	q	
 * -	-	
 *
 * q	-	
 * q	-	
 *
 * q	-	
 * -	q	
 *
 * -	q	
 * q	-	
 *
 * -	q	
 * -	q	
 *
 * -	-	
 * q	q	
 */
