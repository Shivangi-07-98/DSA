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

    int[][] storage = new int[n][m];
    for (int i = 0; i < n; i++) {
      Arrays.fill(storage[i], -1);
    }
    
    System.out.println(minCostMaze(n - 1, m - 1, maze));
    System.out.println(minCostMaze_memo(n - 1, m - 1, maze, storage));
    System.out.println(minCostMaze_tab(n, m, maze));
  }

  // Recursive solution
  public static int minCostMaze(int r, int c, int[][] maze) {
    if (r == 0 && c == 0) {
      return maze[0][0];
    }

    int minCost = Integer.MAX_VALUE;
    if (r - 1 >= 0) {
      int cost = minCostMaze(r - 1, c, maze);
      if (cost != Integer.MAX_VALUE) {
        minCost = Math.min(minCost, cost + maze[r][c]);
      }
    }
    if (c - 1 >= 0) {
      int cost = minCostMaze(r, c - 1, maze);
      if (cost != Integer.MAX_VALUE) {
        minCost = Math.min(minCost, cost + maze[r][c]);
      }
    }

    return minCost;
  }

  // Memoized solution
  public static int minCostMaze_memo(int r, int c, int[][] maze, int[][] storage) {
    if (r == 0 && c == 0) {
      return maze[0][0];
    }

    if (storage[r][c] != -1) {
      return storage[r][c];
    }

    int minCost = Integer.MAX_VALUE;
    if (r - 1 >= 0) {
      int cost = minCostMaze_memo(r - 1, c, maze, storage);
      if (cost != Integer.MAX_VALUE) {
        minCost = Math.min(minCost, cost + maze[r][c]);
      }
    }
    if (c - 1 >= 0) {
      int cost = minCostMaze_memo(r, c - 1, maze, storage);
      if (cost != Integer.MAX_VALUE) {
        minCost = Math.min(minCost, cost + maze[r][c]);
      }
    }

    storage[r][c] = minCost;
    return minCost;
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

