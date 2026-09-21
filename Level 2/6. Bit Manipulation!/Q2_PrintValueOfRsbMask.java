// Time Complexity: O(1), Space Complexity: O(1)
import java.util.*;

public class Q2_PrintValueOfRsbMask {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int rsb = n & -n;
    System.out.println(Integer.toBinaryString(rsb));
  }

}

/*
 * Input:
 * 58
 *
 * Output:
 * 10
 */
