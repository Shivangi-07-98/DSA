// Time Complexity: O(n^p)
// Space Complexity: O(p)
import java.util.*;

public class Q23_PatternMatching {

  private static void solve(String str, String pattern, int idx, int si,
      LinkedHashMap<Character, String> map, HashSet<String> used) {
    if (idx == pattern.length()) {
      if (si == str.length()) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, String> e : map.entrySet()) {
          sb.append(e.getKey()).append(" -> ").append(e.getValue()).append(", ");
        }
        if (sb.length() >= 2) sb.setLength(sb.length() - 2);
        System.out.println(sb.toString());
      }
      return;
    }

    char ch = pattern.charAt(idx);
    if (map.containsKey(ch)) {
      String mapped = map.get(ch);
      if (si + mapped.length() <= str.length() && str.startsWith(mapped, si)) {
        solve(str, pattern, idx + 1, si + mapped.length(), map, used);
      }
      return;
    }

    for (int cut = si + 1; cut <= str.length(); cut++) {
      String part = str.substring(si, cut);
      if (used.contains(part)) continue;
      map.put(ch, part);
      used.add(part);
      solve(str, pattern, idx + 1, cut, map, used);
      map.remove(ch);
      used.remove(part);
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    String pattern = scn.next();
    LinkedHashMap<Character, String> map = new LinkedHashMap<>();
    HashSet<String> used = new HashSet<>();
    solve(str, pattern, 0, 0, map, used);
  }

}

/*
 * Input:
 * graphtreesgraph
 * pep
 *
 * Output:
 * p -> graph, e -> trees
 */
