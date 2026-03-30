// Time Complexity: O(log n), Space Complexity: O(log n)
import java.util.*;

public class Q23_CountSetBitsInFirstNNaturalNumbers {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    System.out.println(countSetBits(n));
  }

  static int countSetBits(int n) {
    if (n == 0) {
      return 0;
    }

    int x = largestPowerOf2(n);
    int bitsTill2x = x * (1 << (x - 1));
    int msbBits = n - (1 << x) + 1;
    int rest = n - (1 << x);

    return bitsTill2x + msbBits + countSetBits(rest);
  }

  static int largestPowerOf2(int n) {
    int x = 0;
    while ((1 << (x + 1)) <= n) {
      x++;
    }
    return x;
  }

}

/*
 * Input:
 * 6
 *
 * Output:
 * 9
 */
