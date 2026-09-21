// Time O(total bricks)
// Space O(width breaks)

import java.io.*;
import java.util.*;

public class Q54_BrickWall {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int rows = scn.nextInt();
    List<List<Integer>> wall = new ArrayList<>();

    for (int i = 0; i < rows; i++) {
      int len = scn.nextInt();
      ArrayList<Integer> row = new ArrayList<>();
      for (int j = 0; j < len; j++) {
        row.add(scn.nextInt());
      }
      wall.add(row);
    }

    System.out.println(solution(wall));
  }

  public static int solution(List<List<Integer>> wall) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int maxEdges = 0;

    for (List<Integer> row : wall) {
      int sum = 0;
      for (int i = 0; i < row.size() - 1; i++) {
        sum += row.get(i);
        int val = map.getOrDefault(sum, 0) + 1;
        map.put(sum, val);
        maxEdges = Math.max(maxEdges, val);
      }
    }

    return wall.size() - maxEdges;
  }
}

// Input:
// 3
// 3
// 1 2 2
// 3
// 3 1 1
// 2
// 2 3
//
// Output:
// 1
