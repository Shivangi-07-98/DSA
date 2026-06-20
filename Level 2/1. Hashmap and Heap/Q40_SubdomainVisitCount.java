// Time O(total chars)
// Space O(total chars)

import java.io.*;
import java.util.*;

public class Q40_SubdomainVisitCount {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    scn.nextLine();

    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextLine();
    }

    List<String> ans = solution(arr);
    for (String s : ans)
      System.out.println(s);
  }

  public static List<String> solution(String[] cpdomains) {
    HashMap<String, Integer> map = new HashMap<>();

    for (String s : cpdomains) {
      String[] parts = s.split(" ");
      int cnt = Integer.parseInt(parts[0]);
      String domain = parts[1];

      map.put(domain, map.getOrDefault(domain, 0) + cnt);

      for (int i = 0; i < domain.length(); i++) {
        if (domain.charAt(i) == '.') {
          String sub = domain.substring(i + 1);
          map.put(sub, map.getOrDefault(sub, 0) + cnt);
        }
      }
    }

    ArrayList<String> res = new ArrayList<>();
    for (String key : map.keySet()) {
      res.add(map.get(key) + " " + key);
    }
    return res;
  }
}

// Input:
// 2
// 9001 discuss.leetcode.com
// 50 yahoo.com
// 
// Output:
// 9001 discuss.leetcode.com
// 9001 leetcode.com
// 9051 com
// 50 yahoo.com
