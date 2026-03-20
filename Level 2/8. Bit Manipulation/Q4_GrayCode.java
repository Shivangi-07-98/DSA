// Time Complexity: O(2^n), Space Complexity: O(2^n)
import java.util.*;

public class Q4_GrayCode {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    List<Integer> ans = grayCode(n);
    for (int val : ans) {
      System.out.print(val + " ");
    }
    System.out.println();
  }

  static List<Integer> grayCode(int n) {
    List<Integer> result = new ArrayList<>();
    int size = 1 << n;

    for (int i = 0; i < size; i++) {
      result.add(i ^ (i >> 1));
    }

    return result;
  }

}

/*
 * Input:
 * 2
 *
 * Output:
 * 0 1 3 2
 */
