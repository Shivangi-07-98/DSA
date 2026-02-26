// Time Complexity: O(n log n), Space Complexity: O(n)

import java.io.*;
import java.util.*;

public class Q62_MinimumNumberOfRefuelingStops {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int target = scn.nextInt();
    int startFuel = scn.nextInt();
    int n = scn.nextInt();

    int[][] stations = new int[n][2];
    for (int i = 0; i < n; i++) {
      stations[i][0] = scn.nextInt();
      stations[i][1] = scn.nextInt();
    }

    System.out.println(solution(target, startFuel, stations));
  }

  public static int solution(int target, int startFuel, int[][] stations) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    int fuel = startFuel;
    int idx = 0;
    int stops = 0;

    while (fuel < target) {
      while (idx < stations.length && stations[idx][0] <= fuel) {
        pq.add(stations[idx][1]);
        idx++;
      }

      if (pq.isEmpty())
        return -1;

      fuel += pq.remove();
      stops++;
    }

    return stops;
  }
}

/*
 * Input:
 * 100 10 4
 * 10 60
 * 20 30
 * 30 30
 * 60 40
 * 
 * Output:
 * 2
 */
