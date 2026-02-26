// Time Complexity: O(n log n), Space Complexity: O(n)

import java.io.*;
import java.util.*;

public class Q56_TheSkylineProblem {

  private static class Event {
    int x;
    int h;

    Event(int x, int h) {
      this.x = x;
      this.h = h;
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[][] buildings = new int[n][3];
    for (int i = 0; i < n; i++) {
      buildings[i][0] = scn.nextInt();
      buildings[i][1] = scn.nextInt();
      buildings[i][2] = scn.nextInt();
    }

    List<List<Integer>> ans = solution(buildings);
    for (List<Integer> p : ans) {
      System.out.println(p.get(0) + " " + p.get(1));
    }
  }

  public static List<List<Integer>> solution(int[][] buildings) {
    ArrayList<Event> events = new ArrayList<>();

    for (int[] b : buildings) {
      events.add(new Event(b[0], -b[2]));
      events.add(new Event(b[1], b[2]));
    }

    Collections.sort(events, (a, b) -> {
      if (a.x != b.x)
        return a.x - b.x;
      return a.h - b.h;
    });

    TreeMap<Integer, Integer> heights = new TreeMap<>();
    heights.put(0, 1);

    int prevMax = 0;
    ArrayList<List<Integer>> res = new ArrayList<>();

    for (Event e : events) {
      if (e.h < 0) {
        int h = -e.h;
        heights.put(h, heights.getOrDefault(h, 0) + 1);
      } else {
        int h = e.h;
        heights.put(h, heights.get(h) - 1);
        if (heights.get(h) == 0)
          heights.remove(h);
      }

      int currMax = heights.lastKey();
      if (currMax != prevMax) {
        res.add(Arrays.asList(e.x, currMax));
        prevMax = currMax;
      }
    }

    return res;
  }
}

/*
 * Input:
 * 3
 * 2 9 10
 * 3 7 15
 * 5 12 12
 * 
 * Output:
 * 2 10
 * 3 15
 * 7 12
 * 12 0
 */
