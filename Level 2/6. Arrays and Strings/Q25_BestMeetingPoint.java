// https://leetcode.com/problems/best-meeting-point/description/

// time O(m*n)
// space O(m+n)

import java.util.*;

public class Q25_BestMeetingPoint {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();

    int[][] grid = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        grid[i][j] = scn.nextInt();
      }
    }

    int dist = minTotalDistance(grid);
    System.out.println(dist);
    scn.close();
  }

  public static int minTotalDistance(int[][] grid) {
    ArrayList<Integer> rows = new ArrayList<>();

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          rows.add(i);
        }
      }
    }

    ArrayList<Integer> columns = new ArrayList<>();

    for (int j = 0; j < grid[0].length; j++) {
      for (int i = 0; i < grid.length; i++) {
        if (grid[i][j] == 1) {
          columns.add(j);
        }
      }
    }

    int r = rows.get(rows.size() / 2);
    int c = columns.get(columns.size() / 2);

    int d1 = 0;
    for (int row : rows) {
      d1 += Math.abs(row - r);
    }

    int d2 = 0;
    for (int column : columns) {
      d2 += Math.abs(column - c);
    }

    return d1 + d2;
  }

  public static int minTotalDistance2(int[][] grid) {
    ArrayList<Integer> xcord = new ArrayList<>();
    ArrayList<Integer> ycord = new ArrayList<>();

    // for row coordinates
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        if (grid[r][c] == 1) {
          xcord.add(r);
        }
      }
    }

    // for col coordinates
    for (int c = 0; c < grid[0].length; c++) {
      for (int r = 0; r < grid.length; r++) {
        if (grid[r][c] == 1) {
          ycord.add(c);
        }
      }
    }

    int x = xcord.get(xcord.size() / 2);
    int y = ycord.get(ycord.size() / 2);

    // calculate distance
    int dist = 0;
    for (int i = 0; i < xcord.size(); i++) {
      dist += Math.abs(xcord.get(i) - x) + Math.abs(ycord.get(i) - y);
    }
    return dist;
  }

}
