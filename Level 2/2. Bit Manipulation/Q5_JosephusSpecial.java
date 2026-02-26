// Time Complexity: O(log n), Space Complexity: O(1)
import java.util.*;

public class Q5_JosephusSpecial {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int hp2 = highestPowerOf2(n);
    int l = n - hp2;
    int ans = 2 * l + 1;

    System.out.println(ans);
  }

  static int highestPowerOf2(int n) {
    int p = 1;
    while ((p << 1) <= n) {
      p <<= 1;
    }
    return p;
  }

}

/*
 * Input:
 * 11
 *
 * Output:
 * 7
 */
