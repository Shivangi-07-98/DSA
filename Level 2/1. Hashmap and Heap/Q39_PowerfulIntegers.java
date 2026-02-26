// Time Complexity: O(log(bound)^2), Space Complexity: O(log(bound)^2)

import java.io.*;
import java.util.*;

public class Q39_PowerfulIntegers {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int x = scn.nextInt();
    int y = scn.nextInt();
    int bound = scn.nextInt();

    List<Integer> ans = solution(x, y, bound);
    Collections.sort(ans);
    for (int val : ans)
      System.out.print(val + " ");
  }

  public static List<Integer> solution(int x, int y, int bound) {
    HashSet<Integer> set = new HashSet<>();

    int a = 1;
    while (a <= bound) {
      int b = 1;
      while (a + b <= bound) {
        set.add(a + b);
        if (y == 1)
          break;
        b *= y;
      }
      if (x == 1)
        break;
      a *= x;
    }

    return new ArrayList<>(set);
  }
}

/*
 * Input:
 * 2 3 10
 * 
 * Output:
 * 2 3 4 5 7 9 10
 */
