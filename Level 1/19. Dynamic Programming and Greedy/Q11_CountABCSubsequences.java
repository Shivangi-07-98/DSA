import java.util.*;
public class Q11_CountABCSubsequences {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();

    System.out.println(countABCSubsequences(str));
    System.out.println(countABCSubsequences_optimized(str));
  }

  // Using DP approach
  // a+ means one or more a's, b+ means one or more b's, c+ means one or more c's
  // We track counts for a+, a+b+, a+b+c+
  public static int countABCSubsequences(String str) {
    int a = 0; // count of subsequences ending with a+
    int ab = 0; // count of subsequences ending with a+b+
    int abc = 0; // count of subsequences ending with a+b+c+

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (ch == 'a') {
        a = 2 * a + 1; // new a can be added to all existing a+ subsequences or start new
      } else if (ch == 'b') {
        ab = 2 * ab + a; // new b can be added to all existing a+b+ subsequences or appended to a+
      } else if (ch == 'c') {
        abc = 2 * abc + ab; // new c can be added to all existing a+b+c+ subsequences or appended to a+b+
      }
    }

    return abc;
  }

  // Alternative approach using DP array
  public static int countABCSubsequences_optimized(String str) {
    int n = str.length();
    int[] a = new int[n + 1];
    int[] ab = new int[n + 1];
    int[] abc = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      char ch = str.charAt(i - 1);

      a[i] = a[i - 1];
      ab[i] = ab[i - 1];
      abc[i] = abc[i - 1];

      if (ch == 'a') {
        a[i] = 2 * a[i - 1] + 1;
      } else if (ch == 'b') {
        ab[i] = 2 * ab[i - 1] + a[i - 1];
      } else if (ch == 'c') {
        abc[i] = 2 * abc[i - 1] + ab[i - 1];
      }
    }

    return abc[n];
  }
  
}

