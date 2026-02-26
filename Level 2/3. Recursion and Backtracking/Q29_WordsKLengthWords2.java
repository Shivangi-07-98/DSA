// Time Complexity: O(nPk)
// Space Complexity: O(n)
import java.util.*;

public class Q29_WordsKLengthWords2 {

  private static void solve(List<Character> chars, int[] freq, int k, String asf) {
    if (asf.length() == k) {
      System.out.println(asf);
      return;
    }

    for (int i = 0; i < chars.size(); i++) {
      if (freq[i] > 0) {
        freq[i]--;
        solve(chars, freq, k, asf + chars.get(i));
        freq[i]++;
      }
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
    for (int i = 0; i < chars.size(); i++) {
      freq[i] = map.get(chars.get(i));
    }

    solve(chars, freq, k, "");
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
 * ba
 */
