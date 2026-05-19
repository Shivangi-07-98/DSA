import java.io.*;
import java.util.*;

public class Q6_GoldMine {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt(); // 6
    int m = scn.nextInt(); // 6
    int[][] mine = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        mine[i][j] = scn.nextInt();
      }
    }

    System.out.println(goldMine_tab(n, m, mine));
  }

  // Tabulation solution
  public static int goldMine_tab(int n, int m, int[][] mine) {
    int[][] strg = new int[mine.length][mine[0].length];

    for (int j = strg[0].length - 1; j >= 0; j--) { // col 5 4 3 2 1 0
      for (int i = 0; i < strg.length; i++) { // row 0 1 2 3 4 5
        // 2d array mai ulta travel krenge from right to left
        // 0-5(5) 0-5(4) 0-5(3) 0-5(2) 0-5(1) 0-5(0) = 6 loops
        if (j == strg[0].length - 1) { // col = 5
          strg[i][j] = mine[i][j];
        } else if (i == 0) { // row = 0
          strg[i][j] = mine[i][j] + Math.max(strg[i][j + 1], strg[i + 1][j + 1]);
        } else if (i == strg.length - 1) { // row = 5
          strg[i][j] = mine[i][j] + Math.max(strg[i][j + 1], strg[i - 1][j + 1]);
        } else {
          strg[i][j] = mine[i][j] + Math.max(strg[i][j + 1], Math.max(strg[i - 1][j + 1], strg[i + 1][j + 1]));
        }

      }
    }

    int maxGold = strg[0][0];
    for (int i = 1; i < strg.length; i++) { // loop in row
      if (strg[i][0] > maxGold) {
        maxGold = strg[i][0];
      }
    }

    return maxGold;
  }

}
// ques is you can start from any row of col 0 and move forward with three moves
// (right, diagonal up and down) and reach end col collecting max gold
// movement is right, diagonal up, diagonal down

/*
 * Sample Input:
 * 6
 * 6
 * 0 1 4 2 8 2
 * 4 3 6 5 0 4
 * 1 2 4 1 4 6
 * 2 0 7 3 2 2
 * 3 1 5 9 2 4
 * 2 7 0 8 5 1
 * 
 * Sample Output:
 * 33
 */
