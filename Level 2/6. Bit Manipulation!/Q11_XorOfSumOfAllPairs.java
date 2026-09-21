// Time Complexity: O(n^2), Space Complexity: O(1)
import java.util.*;

public class Q11_XorOfSumOfAllPairs {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        ans ^= (arr[i] + arr[j]);
      }
    }

    System.out.println(ans);
  }

}

/*
 * Input:
 * 4
 * 1 2 3 4
 *
 * Output:
 * 2
 */
