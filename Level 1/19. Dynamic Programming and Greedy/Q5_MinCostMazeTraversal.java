import java.io.*;
import java.util.*;

public class Q5_MinCostMazeTraversal {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt(); // 6
    int m = scn.nextInt(); // 6
    int[][] maze = new int[n][m]; // 6 6
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        maze[i][j] = scn.nextInt();
      }
    }

    System.out.println(minCostMaze_tab(n, m, maze));
  }

  // Tabulation solution
  public static int minCostMaze_tab(int n, int m, int[][] maze) {
    int[][] strg = new int[n][m];

    for (int i = n - 1; i >= 0; i--) { // 5-0
      for (int j = m - 1; j >= 0; j--) { // 5-0
        // 2d array mai ulta travel krenge
        if (i == n - 1 && j == m - 1) { // strg[5][5]
          strg[i][j] = maze[i][j];
        } else if (i == n - 1) { // row = 5
          strg[i][j] = strg[i][j + 1] + maze[i][j];
        } else if (j == m - 1) { // col = 5
          strg[i][j] = strg[i + 1][j] + maze[i][j];
        } else {
          strg[i][j] = Math.min(strg[i + 1][j], strg[i][j + 1]) + maze[i][j];
        }

      }
    }

    return strg[0][0];
  }

}

// ques is arr[0][0] => arr[5][5] path travel krne ki min cost kya hai
// movement is right and bottom only

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
 * 23
 */
