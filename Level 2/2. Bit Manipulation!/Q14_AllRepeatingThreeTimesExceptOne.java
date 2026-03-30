// Time Complexity: O(32*n), Space Complexity: O(1)
import java.util.*;

public class Q14_AllRepeatingThreeTimesExceptOne {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int ans = 0;

    for (int bit = 0; bit < 32; bit++) {
      int sum = 0;
      for (int val : arr) {
        if (((val >> bit) & 1) == 1) {
          sum++;
        }
      }

      if (sum % 3 != 0) {
        ans |= (1 << bit);
      }
    }

    System.out.println(ans);
  }

}

/*
 * Input:
 * 7
 * 6 1 3 3 3 6 6
 *
 * Output:
 * 1
 */
