// Time O(n log n)
// Space O(n)

import java.io.*;
import java.util.*;

public class Q58_MinimumCostToConnectSticks {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] sticks = new int[n];
    for (int i = 0; i < n; i++) {
      sticks[i] = scn.nextInt();
    }

    System.out.println(solution(sticks));
  }

  public static int solution(int[] sticks) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int s : sticks)
      pq.add(s);

    int cost = 0;

    while (pq.size() > 1) {
      int a = pq.remove();
      int b = pq.remove();
      int c = a + b;
      cost += c;
      pq.add(c);
    }

    return cost;
  }
}

// Input:
// 3
// 2 4 3
// 
// Output:
// 14
