// Time Complexity: O(n), Space Complexity: O(1)
import java.util.*;

public class Q8_OneRepeatingAndOneMissing {

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
    for (int i = 1; i <= n; i++) {
      xor ^= i;
    }

    int rsb = xor & -xor;
    int x = 0;
    int y = 0;

    for (int val : arr) {
      if ((val & rsb) == 0) {
        x ^= val;
      } else {
        y ^= val;
      }
    }

    for (int i = 1; i <= n; i++) {
      if ((i & rsb) == 0) {
        x ^= i;
      } else {
        y ^= i;
      }
    }

    int repeating;
    int missing;
    boolean xExists = false;

    for (int val : arr) {
      if (val == x) {
        xExists = true;
        break;
      }
    }

    if (xExists) {
      repeating = x;
      missing = y;
    } else {
      repeating = y;
      missing = x;
    }

    System.out.println("Repeating: " + repeating);
    System.out.println("Missing: " + missing);
  }

}

/*
 * Input:
 * 5
 * 1 3 3 4 5
 *
 * Output:
 * Repeating: 3
 * Missing: 2
 */
