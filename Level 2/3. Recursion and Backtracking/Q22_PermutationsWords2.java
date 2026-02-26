// Time Complexity: O(n!)
// Space Complexity: O(n)
import java.util.*;

public class Q22_PermutationsWords2 {

  private static void permute(List<Character> chars, int[] freq, int len, String asf) {
    if (asf.length() == len) {
      System.out.println(asf);
      return;
    }

    for (int i = 0; i < chars.size(); i++) {
      if (freq[i] > 0) {
        freq[i]--;
        permute(chars, freq, len, asf + chars.get(i));
        freq[i]++;
      }
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();

    LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
    for (char ch : str.toCharArray()) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    List<Character> chars = new ArrayList<>(map.keySet());
    int[] freq = new int[chars.size()];
    for (int i = 0; i < chars.size(); i++) {
      freq[i] = map.get(chars.get(i));
    }

    permute(chars, freq, str.length(), "");
  }

}

/*
 * Input:
 * aab
 *
 * Output:
 * aab
 * aba
 * baa
 */
