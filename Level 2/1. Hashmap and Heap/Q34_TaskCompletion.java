// Time O(n log n)
// Space O(n)
import java.io.*;
import java.util.*;

public class Q34_TaskCompletion {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();

    boolean[] done = new boolean[n + 1];
    for (int i = 0; i < m; i++) {
      done[scn.nextInt()] = true;
    }

    ArrayList<Integer> s1 = new ArrayList<>();
    ArrayList<Integer> s2 = new ArrayList<>();

    boolean turn = true;
    for (int task = 1; task <= n; task++) {
      if (!done[task]) {
        if (turn)
          s1.add(task);
        else
          s2.add(task);
        turn = !turn;
      }
    }

    for (int x : s1)
      System.out.print(x + " ");
    System.out.println();
    for (int x : s2)
      System.out.print(x + " ");
  }

}

// Input:
// 6 2
// 2 4
//
// Output:
// 1 5
// 3 6
