// Time Complexity: O(1), Space Complexity: O(1)
import java.util.*;

public class Q15_CopySetBitsInARange {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();
    int left = scn.nextInt();
    int right = scn.nextInt();

    int bits = right - left + 1;
    int mask = ((1 << bits) - 1) << (left - 1);

    int copied = b | (a & mask);
    System.out.println(copied);
  }

}

/*
 * Input:
 * 10
 * 13
 * 2
 * 3
 *
 * Output:
 * 15
 */
