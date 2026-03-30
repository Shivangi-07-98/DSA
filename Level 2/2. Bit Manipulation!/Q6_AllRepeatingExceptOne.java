// Time Complexity: O(n), Space Complexity: O(1)
import java.util.*;

public class Q6_AllRepeatingExceptOne {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int xor = 0;
    for (int val : arr) {
      xor ^= val;
    }

    System.out.println(xor);
  }

}

/*
 * Input:
 * 7
 * 2 3 5 4 5 3 4
 *
 * Output:
 * 2
 */
