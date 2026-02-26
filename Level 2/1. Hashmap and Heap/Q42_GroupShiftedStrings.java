// Time Complexity: O(total chars), Space Complexity: O(total chars)

import java.io.*;
import java.util.*;

public class Q42_GroupShiftedStrings {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.next();
    }

    List<List<String>> ans = solution(arr);
    for (List<String> group : ans) {
      System.out.println(group);
    }
  }

  private static String key(String s) {
    if (s.length() == 1)
      return "single";

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < s.length(); i++) {
      int diff = s.charAt(i) - s.charAt(i - 1);
      if (diff < 0)
        diff += 26;
      sb.append(diff).append('#');
    }
    return sb.toString();
  }

  public static List<List<String>> solution(String[] arr) {
    HashMap<String, ArrayList<String>> map = new HashMap<>();

    for (String s : arr) {
      String k = key(s);
      map.putIfAbsent(k, new ArrayList<>());
      map.get(k).add(s);
    }

    return new ArrayList<>(map.values());
  }
}

/*
 * Input:
 * 6
 * abc bcd acef xyz az ba
 * 
 * Output:
 * [abc, bcd, xyz]
 * [az, ba]
 * [acef]
 */
