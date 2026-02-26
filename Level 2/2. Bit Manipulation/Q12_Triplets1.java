// Time Complexity: O(n^2), Space Complexity: O(1)
import java.util.*;

public class Q12_Triplets1 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    long count = 0;

    for (int i = 0; i < n; i++) {
      int xor = 0;
      for (int k = i; k < n; k++) {
        xor ^= arr[k];
        if (xor == 0) {
          count += (k - i);
        }
      }
    }

    System.out.println(count);
  }

}

/*
 * Input:
 * 5
 * 2 3 1 6 7
 *
 * Output:
 * 4
 */
