// Time O(n^2)
// Space O(1)

import java.io.*;
import java.util.*;

public class Q65_BinaryStringSubstrings1ToN {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s = scn.next();
    int n = scn.nextInt();

    System.out.println(solution(s, n));
  }

  public static boolean solution(String s, int n) {
    for (int i = 1; i <= n; i++) {
      String bin = Integer.toBinaryString(i);
      if (!s.contains(bin))
        return false;
    }
    return true;
  }
}

// Input:
// 0110 3
// 
// Output:
// true
