// Time Complexity: O((n*n)Cn * n*n)
// Space Complexity: O(n*n)
import java.util.*;

public class Q12_NKnightsCombinations2DAs1DKnightChooses {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] chess = new boolean[n][n];
    nknights(0, n, chess, -1);
  }

  private static void nknights(int kpsf, int tk, boolean[][] chess, int lbno) {
    if (kpsf == tk) {
      printBoard(chess);
      return;
    }

    int n = chess.length;
    for (int i = lbno + 1; i < n * n; i++) {
      int r = i / n;
      int c = i % n;
      if (!chess[r][c] && IsKnightSafe(chess, r, c)) {
        chess[r][c] = true;
        nknights(kpsf + 1, tk, chess, i);
        chess[r][c] = false;
      }
    }
  }

  public static boolean IsKnightSafe(boolean[][] chess, int i, int j) {
    if (i - 1 >= 0 && j - 2 >= 0 && chess[i - 1][j - 2]) return false;
    if (i - 2 >= 0 && j - 1 >= 0 && chess[i - 2][j - 1]) return false;
    if (i - 2 >= 0 && j + 1 < chess.length && chess[i - 2][j + 1]) return false;
    if (i - 1 >= 0 && j + 2 < chess.length && chess[i - 1][j + 2]) return false;
    return true;
  }

  private static void printBoard(boolean[][] chess) {
    for (boolean[] row : chess) {
      for (boolean hasKnight : row) {
        System.out.print(hasKnight ? "k\t" : "-\t");
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
 * k	k	
 * -	-	
 *
 * k	-	
 * k	-	
 *
 * k	-	
 * -	k	
 *
 * -	k	
 * k	-	
 *
 * -	k	
 * -	k	
 *
 * -	-	
 * k	k	
 */
