// Time Complexity: O(n * k log k), Space Complexity: O(n * k)

import java.io.*;
import java.util.*;

public class Q41_GroupAnagrams {

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

  public static List<List<String>> solution(String[] strs) {
    HashMap<String, ArrayList<String>> map = new HashMap<>();

    for (String s : strs) {
      char[] ch = s.toCharArray();
      Arrays.sort(ch);
      String key = new String(ch);

      map.putIfAbsent(key, new ArrayList<>());
      map.get(key).add(s);
    }

    return new ArrayList<>(map.values());
  }
}

/*
 * Input:
 * 6
 * eat tea tan ate nat bat
 * 
 * Output:
 * [eat, tea, ate]
 * [tan, nat]
 * [bat]
 */
