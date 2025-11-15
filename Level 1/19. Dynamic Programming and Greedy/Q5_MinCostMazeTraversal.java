import java.util.*;
public class Q5_MinCostMazeTraversal {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    int[][] maze = new int[n][m];
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

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i == 0 && j == 0) {
          strg[i][j] = maze[i][j];
        } else if (i == 0) {
          strg[i][j] = strg[i][j - 1] + maze[i][j];
        } else if (j == 0) {
          strg[i][j] = strg[i - 1][j] + maze[i][j];
        } else {
          strg[i][j] = Math.min(strg[i - 1][j], strg[i][j - 1]) + maze[i][j];
        }
      }
    }

    return strg[n - 1][m - 1];
  }

  // Tabulation solution pep
  public static int minCostMaze_tab_pep(int n, int m, int[][] maze) {
    int[][] strg = new int[n][m];

    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        if (i == n - 1 && j == m - 1) {
          strg[i][j] = maze[i][j];
        } else if (i == n - 1) {
          strg[i][j] = strg[i][j + 1] + maze[i][j];
        } else if (j == m - 1) {
          strg[i][j] = strg[i + 1][j] + maze[i][j];
        } else {
          strg[i][j] = Math.min(strg[i + 1][j], strg[i][j + 1]) + maze[i][j];
        }
      }
    }

    return strg[0][0];
  }
  
}

/*
Sample Input:
6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1

Sample Output:
23
*/