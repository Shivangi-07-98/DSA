import java.util.*;

public class FloodFillQ97 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    int[][] arr = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    boolean[][] visited = new boolean[arr.length][arr[0].length];
    FloodFill(arr, visited, 0, 0, " ");
  }

  public static void FloodFill(int[][] maze, boolean[][] visited, int sr, int sc, String asf) {

    if (sr == maze.length || sc == maze[0].length || sr == -1 || sc == -1 || maze[sr][sc] == 1
        || visited[sr][sc] == true) {
      return;
    }

    else if (sr == maze.length - 1 && sc == maze[0].length - 1) {
      System.out.println(asf);
      return;
    }

    visited[sr][sc] = true;
    FloodFill(maze, visited, sr - 1, sc, asf + "t");
    FloodFill(maze, visited, sr, sc - 1, asf + "l");
    FloodFill(maze, visited, sr + 1, sc, asf + "d");
    FloodFill(maze, visited, sr, sc + 1, asf + "r");
    visited[sr][sc] = false;

  }

}
