// Time Complexity: O(n)
// Space Complexity: O(n)
import java.io.*;
import java.util.*;

public class Q2_SubstringWithEqual012 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();

    long ans = getSubstringWithEqual012(str);
    System.out.println(ans);
  }

  // count substrings having equal number of 0, 1 and 2
  static long getSubstringWithEqual012(String str) {
    long ans = 0;
    int c0 = 0;
    int c1 = 0;
    int c2 = 0;
    String key = "0#0";
    HashMap<String, Integer> map = new HashMap<>();
    map.put(key, 1);

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == '0') {
        c0++;
      } else if (ch == '1') {
        c1++;
      } else {
        c2++;
      }

      key = (c1 - c0) + "#" + (c2 - c1);

      if (map.containsKey(key)) {
        int val = map.get(key);
        ans += val;
        map.put(key, val + 1);
      } else {
        map.put(key, 1);
      }
    }

    return ans;
  }

}

/*
 * Sample Input:
 * 0102010
 * 
 * Sample Output:
 * 2
 */
