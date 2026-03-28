// Time Complexity: O(n!)
// Space Complexity: O(n)
import java.util.*;

public class Q41_AllPalindromicPermutations {

  private static String reverseString(String s) {
    char[] arr = s.toCharArray();
    int left = 0;
    int right = arr.length - 1;
    while (left < right) {
      char temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }
    return new String(arr);
  }

  private static void generate(List<Character> chars, int[] freq, int len, String asf, String mid) {
    if (asf.length() == len) {
      String rev = reverseString(asf);
      System.out.println(asf + mid + rev);
      return;
    }

    for (int i = 0; i < chars.size(); i++) {
      if (freq[i] > 0) {
        freq[i]--;
        generate(chars, freq, len, asf + chars.get(i), mid);
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

    int odd = 0;
    String mid = "";
    for (Map.Entry<Character, Integer> e : map.entrySet()) {
      if (e.getValue() % 2 == 1) {
        odd++;
        mid = String.valueOf(e.getKey());
      }
    }

    if (odd > 1) {
      System.out.println(-1);
      return;
    }

    List<Character> chars = new ArrayList<>();
    int[] freq = new int[map.size()];
    int idx = 0;
    int halfLen = 0;
    for (Map.Entry<Character, Integer> e : map.entrySet()) {
      chars.add(e.getKey());
      freq[idx] = e.getValue() / 2;
      halfLen += freq[idx];
      idx++;
    }

    generate(chars, freq, halfLen, "", mid);
  }

}

/*
 * Input:
 * aabb
 *
 * Output:
 * abba
 * baab
 */
