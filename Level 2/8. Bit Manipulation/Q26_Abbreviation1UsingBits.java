// Time Complexity: O(2^n * n), Space Complexity: O(n)
import java.util.*;

public class Q26_Abbreviation1UsingBits {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();

    int n = str.length();
    int limit = 1 << n;

    for (int mask = 0; mask < limit; mask++) {
      StringBuilder sb = new StringBuilder();
      int count = 0;

      for (int i = 0; i < n; i++) {
        int bit = 1 << (n - 1 - i);

        if ((mask & bit) != 0) {
          count++;
        } else {
          if (count > 0) {
            sb.append(count);
            count = 0;
          }
          sb.append(str.charAt(i));
        }
      }

      if (count > 0) {
        sb.append(count);
      }

      System.out.println(sb.toString());
    }
  }

}

/*
 * Input:
 * pep
 *
 * Output:
 * pep
 * pe1
 * p1p
 * p2
 * 1ep
 * 1e1
 * 2p
 * 3
 */
