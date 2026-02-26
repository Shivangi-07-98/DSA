// Time Complexity: O(n)
// Space Complexity: O(1)
import java.util.*;

public class Q38_JosephusProblem {

  private static int josephus(int n, int k) {
    if (n == 1) return 0;
    return (josephus(n - 1, k) + k) % n;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = scn.nextInt();
    System.out.println(josephus(n, k));
  }

}

/*
 * Input:
 * 7
 * 3
 *
 * Output:
 * 3
 */
