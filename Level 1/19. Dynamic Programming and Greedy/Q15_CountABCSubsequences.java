import java.util.*;

public class Q15_CountABCSubsequences {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next(); // abcabc

    System.out.println(countABCSubsequences_tab(str));
  }

  // Tabulation solution
  public static int countABCSubsequences_tab(String str) {
    int a = 0;
    int ab = 0;
    int abc = 0;

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (ch == 'a') {
        a = 2 * a + 1;
      } else if (ch == 'b') {
        ab = 2 * ab + a;
      } else if (ch == 'c') {
        abc = 2 * abc + ab;
      }
    }

    return abc;
  }

}

// count subsequences of pattern a+b+c+ (one or more a, then one or more b, then
// one or more c)

/*
 * Sample Input:
 * abcabc
 * 
 * Sample Output:
 * 7
 */
