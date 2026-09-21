// Time Complexity: O(log n), Space Complexity: O(1)
import java.util.*;

public class Q13_ReduceNTo1 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int steps = 0;

    while (n != 1) {
      if ((n & 1) == 0) {
        n >>= 1;
      } else if (n == 3 || (n & 3) == 1) {
        n--;
      } else {
        n++;
      }
      steps++;
    }

    System.out.println(steps);
  }

}

/*
 * Input:
 * 8
 *
 * Output:
 * 3
 */
