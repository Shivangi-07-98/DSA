import java.util.*;

// Number of islands (same as Q7) but cells projected onto an adjacency matrix.
public class Q20_NumberOfIslandsUsingAdjacencyMatrix {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);

    int rows = scn.nextInt();
    int cols = scn.nextInt();

    int[][] grid = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        grid[i][j] = scn.nextInt();
      }
    }

    int vertices = rows * cols;
    boolean[][] graph = new boolean[vertices][vertices];
    boolean[] isLand = new boolean[vertices];

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == 1) {
          continue;
        }

        int idx = index(cols, r, c);
        isLand[idx] = true;

        connectIfLand(grid, graph, cols, r, c, r - 1, c);
        connectIfLand(grid, graph, cols, r, c, r + 1, c);
        connectIfLand(grid, graph, cols, r, c, r, c - 1);
        connectIfLand(grid, graph, cols, r, c, r, c + 1);
      }
    }

    boolean[] visited = new boolean[vertices];
    int count = 0;
    for (int v = 0; v < vertices; v++) {
      if (isLand[v] && !visited[v]) {
        count++;
        dfs(graph, visited, v);
      }
    }

    System.out.println(count);
    scn.close();
  }

  private static void connectIfLand(int[][] grid, boolean[][] graph, int cols, int r, int c, int nr, int nc) {
    if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length) {
      return;
    }
    if (grid[nr][nc] == 1) {
      return;
    }

    int idx = index(cols, r, c);
    int nbrIdx = index(cols, nr, nc);
    graph[idx][nbrIdx] = true;
    graph[nbrIdx][idx] = true;
  }

  private static void dfs(boolean[][] graph, boolean[] visited, int src) {
    visited[src] = true;
    for (int nbr = 0; nbr < graph.length; nbr++) {
      if (graph[src][nbr] && !visited[nbr]) {
        dfs(graph, visited, nbr);
      }
    }
  }

  private static int index(int cols, int r, int c) {
    return r * cols + c;
  }
}

// input
// 8
// 8
// 0 0 1 1 1 1 1 1
// 0 0 1 1 1 1 1 1
// 1 1 1 1 1 1 1 0
// 1 1 0 0 0 1 1 0
// 1 1 1 1 0 1 1 0
// 1 1 1 1 0 1 1 0
// 1 1 1 1 1 1 1 0
// 1 1 1 1 1 1 1 0

// output
// 3
