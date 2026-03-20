// Time Complexity: O(32*n), Space Complexity: O(1)
import java.util.*;

public class Q25_SumOfBitDifferencesOfAllPairs {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    long ans = 0;

    for (int bit = 0; bit < 32; bit++) {
      long ones = 0;
      for (int val : arr) {
        if (((val >> bit) & 1) == 1) {
          ones++;
        }
      }

      long zeros = n - ones;
      ans += (ones * zeros * 2);
    }

    System.out.println(ans);
  }

}

/*
 * Input:
 * 3
 * 1 3 5
 *
 * Output:
 * 8
 */
