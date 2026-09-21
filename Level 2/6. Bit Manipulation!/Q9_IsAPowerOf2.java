// Time Complexity: O(1), Space Complexity: O(1)
import java.util.*;

public class Q9_IsAPowerOf2 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    boolean ans = n > 0 && (n & (n - 1)) == 0;
    System.out.println(ans);
  }

}

/*
 * Input:
 * 16
 *
 * Output:
 * true
 */
