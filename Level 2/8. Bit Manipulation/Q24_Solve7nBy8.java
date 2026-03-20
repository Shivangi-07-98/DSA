// Time Complexity: O(1), Space Complexity: O(1)
import java.util.*;

public class Q24_Solve7nBy8 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int ans = n - (n >> 3);
    System.out.println(ans);
  }

}

/*
 * Input:
 * 40
 *
 * Output:
 * 35
 */
