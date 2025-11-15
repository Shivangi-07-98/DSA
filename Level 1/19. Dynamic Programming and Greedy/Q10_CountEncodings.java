import java.util.*;
public class Q10_CountEncodings {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();

    Integer[] storage = new Integer[str.length() + 1];
    System.out.println(countEncodings(str, 0));
    System.out.println(countEncodings_memo(str, 0, storage));
    System.out.println(countEncodings_tab(str));
  }

  // Recursive solution
  public static int countEncodings(String str, int idx) {
    if (idx == str.length()) {
      return 1;
    }

    if (str.charAt(idx) == '0') {
      return 0;
    }

    int count = 0;
    
    // Single digit
    count += countEncodings(str, idx + 1);

    // Two digits (if valid)
    if (idx + 1 < str.length()) {
      int num = Integer.parseInt(str.substring(idx, idx + 2));
      if (num >= 10 && num <= 26) {
        count += countEncodings(str, idx + 2);
      }
    }

    return count;
  }

  // Memoized solution
  public static int countEncodings_memo(String str, int idx, Integer[] storage) {
    if (idx == str.length()) {
      return 1;
    }

    if (storage[idx] != null) {
      return storage[idx];
    }

    if (str.charAt(idx) == '0') {
      storage[idx] = 0;
      return 0;
    }

    int count = 0;
    
    // Single digit
    count += countEncodings_memo(str, idx + 1, storage);

    // Two digits (if valid)
    if (idx + 1 < str.length()) {
      int num = Integer.parseInt(str.substring(idx, idx + 2));
      if (num >= 10 && num <= 26) {
        count += countEncodings_memo(str, idx + 2, storage);
      }
    }

    storage[idx] = count;
    return count;
  }

  // Tabulation solution
  public static int countEncodings_tab(String str) {
    int n = str.length();
    int[] strg = new int[n + 1];
    
    strg[n] = 1;

    for (int i = n - 1; i >= 0; i--) {
      if (str.charAt(i) == '0') {
        strg[i] = 0;
        continue;
      }

      strg[i] = strg[i + 1];

      if (i + 1 < n) {
        int num = Integer.parseInt(str.substring(i, i + 2));
        if (num >= 10 && num <= 26) {
          strg[i] += strg[i + 2];
        }
      }
    }

    return strg[0];
  }
  
}

/*
Sample Input:
123

Sample Output:
3
*/

