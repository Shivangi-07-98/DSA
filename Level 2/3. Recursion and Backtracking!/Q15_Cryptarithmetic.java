// Time Complexity: O(10^u)
// Space Complexity: O(u)
import java.util.*;

public class Q15_Cryptarithmetic {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.next();
    String s2 = scn.next();
    String s3 = scn.next();

    LinkedHashSet<Character> set = new LinkedHashSet<>();
    for (char ch : s1.toCharArray()) set.add(ch);
    for (char ch : s2.toCharArray()) set.add(ch);
    for (char ch : s3.toCharArray()) set.add(ch);

    List<Character> uniq = new ArrayList<>(set);
    Map<Character, Integer> map = new HashMap<>();
    boolean[] used = new boolean[10];
    Set<Character> leading = new HashSet<>();
    if (s1.length() > 1) leading.add(s1.charAt(0));
    if (s2.length() > 1) leading.add(s2.charAt(0));
    if (s3.length() > 1) leading.add(s3.charAt(0));

    solve(uniq, 0, map, used, s1, s2, s3, leading);
  }

  private static void solve(List<Character> uniq, int idx, Map<Character, Integer> map, boolean[] used,
      String s1, String s2, String s3, Set<Character> leading) {
    if (idx == uniq.size()) {
      long n1 = toNumber(s1, map);
      long n2 = toNumber(s2, map);
      long n3 = toNumber(s3, map);
      if (n1 + n2 == n3) {
        String line = "";
        for (Character ch : uniq) {
          line += ch + "-" + map.get(ch) + " ";
        }
        System.out.println(line.trim());
      }
      return;
    }

    char ch = uniq.get(idx);
    for (int d = 0; d <= 9; d++) {
      if (!used[d]) {
        if (d == 0 && leading.contains(ch)) continue;
        used[d] = true;
        map.put(ch, d);
        solve(uniq, idx + 1, map, used, s1, s2, s3, leading);
        map.remove(ch);
        used[d] = false;
      }
    }
  }

  private static long toNumber(String s, Map<Character, Integer> map) {
    long num = 0;
    for (int i = 0; i < s.length(); i++) {
      num = num * 10 + map.get(s.charAt(i));
    }
    return num;
  }


}

/*
 * Input:
 * send
 * more
 * money
 *
 * Output:
 * s-9 e-5 n-6 d-7 m-1 o-0 r-8 y-2
 */
