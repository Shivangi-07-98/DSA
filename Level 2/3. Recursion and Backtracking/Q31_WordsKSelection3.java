// Time Complexity: O(nCk)
// Space Complexity: O(n)
import java.util.*;

public class Q31_WordsKSelection3 {

  private static void solve(List<Character> chars, int[] freq, int idx, int k, String asf) {
    if (idx == chars.size()) {
      if (asf.length() == k) System.out.println(asf);
      return;
    }

    char ch = chars.get(idx);
    for (int i = 0; i <= freq[idx] && asf.length() + i <= k; i++) {
      String next = asf;
      for (int j = 0; j < i; j++) next = next + ch;
      solve(chars, freq, idx + 1, k, next);
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    int k = scn.nextInt();

    LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
    for (char ch : str.toCharArray()) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    List<Character> chars = new ArrayList<>(map.keySet());
    int[] freq = new int[chars.size()];
    for (int i = 0; i < chars.size(); i++) freq[i] = map.get(chars.get(i));

    solve(chars, freq, 0, k, "");
  }

}

/*
 * Input:
 * aab
 * 2
 *
 * Output:
 * aa
 * ab
 */
