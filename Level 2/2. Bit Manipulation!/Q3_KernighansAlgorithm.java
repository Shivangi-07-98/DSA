// Time Complexity: O(number of set bits), Space Complexity: O(1)
import java.util.*;

public class Q3_KernighansAlgorithm {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int count = 0;
    while (n != 0) {
      int rsb = n & -n;
      n -= rsb;
      count++;
    }

    System.out.println(count);
  }

}

/*
 * Input:
 * 51
 *
 * Output:
 * 4
 */
