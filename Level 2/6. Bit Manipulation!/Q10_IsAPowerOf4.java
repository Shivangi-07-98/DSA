// Time Complexity: O(1), Space Complexity: O(1)
import java.util.*;

public class Q10_IsAPowerOf4 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    boolean isPowerOf2 = n > 0 && (n & (n - 1)) == 0;
    boolean bitAtOddPosition = (n & 0x55555555) != 0;

    System.out.println(isPowerOf2 && bitAtOddPosition);
  }

}

/*
 * Input:
 * 64
 *
 * Output:
 * true
 */
