// Time Complexity: O(n log n), Space Complexity: O(n)

import java.io.*;
import java.util.*;

public class Q61_AvoidFloodInTheCity {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] rains = new int[n];
    for (int i = 0; i < n; i++) {
      rains[i] = scn.nextInt();
    }

    int[] ans = solution(rains);
    for (int x : ans)
      System.out.print(x + " ");
  }

  public static int[] solution(int[] rains) {
    int n = rains.length;
    int[] ans = new int[n];

    HashMap<Integer, Integer> lastRainDay = new HashMap<>();
    TreeSet<Integer> dryDays = new TreeSet<>();

    for (int i = 0; i < n; i++) {
      if (rains[i] == 0) {
        dryDays.add(i);
        ans[i] = 1;
      } else {
        int lake = rains[i];
        ans[i] = -1;

        if (lastRainDay.containsKey(lake)) {
          Integer dry = dryDays.higher(lastRainDay.get(lake));
          if (dry == null)
            return new int[0];

          ans[dry] = lake;
          dryDays.remove(dry);
        }

        lastRainDay.put(lake, i);
      }
    }

    return ans;
  }
}

/*
 * Input:
 * 6
 * 1 2 0 0 2 1
 * 
 * Output:
 * -1 -1 2 1 -1 -1
 */
