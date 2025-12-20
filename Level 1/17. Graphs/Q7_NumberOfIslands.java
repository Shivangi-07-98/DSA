// O(m * n) - DFS visits each grid cell at most once.
import java.io.*;
import java.util.*;

public class Q7_NumberOfIslands {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);

    int m = scn.nextInt();
    int n = scn.nextInt();

    int[][] arr = new int[m][n];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    boolean[][] visited = new boolean[m][n];
    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (visited[i][j] == false && arr[i][j] == 0) {
          count++;
          fillcomp(arr, visited, i, j);
        }
      }
    }

    System.out.println(count);
    scn.close();
  }

  static void fillcomp(int[][] arr, boolean[][] visited, int i, int j) {
    if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) {
      return;
    }
    if (visited[i][j] == true || arr[i][j] == 1) {
      return;
    }

    visited[i][j] = true;
    fillcomp(arr, visited, i + 1, j);
    fillcomp(arr, visited, i - 1, j);
    fillcomp(arr, visited, i, j + 1);
    fillcomp(arr, visited, i, j - 1);
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
//
// output
// 3

// 0 is land, 1 is water
// every cell is a vertex, edges are virtual
// find number of islands, connect all 0, and give answer i.e. 3
