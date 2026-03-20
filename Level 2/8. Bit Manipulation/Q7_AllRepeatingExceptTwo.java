// Time Complexity: O(n), Space Complexity: O(1)
import java.util.*;

public class Q7_AllRepeatingExceptTwo {

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

    int rsb = xor & -xor;
    int a = 0;
    int b = 0;

    for (int val : arr) {
      if ((val & rsb) == 0) {
        a ^= val;
      } else {
        b ^= val;
      }
    }

    if (a < b) {
      System.out.println(a);
      System.out.println(b);
    } else {
      System.out.println(b);
      System.out.println(a);
    }
  }

}

/*
 * Input:
 * 8
 * 1 2 3 2 1 4 5 5
 *
 * Output:
 * 3
 * 4
 */
