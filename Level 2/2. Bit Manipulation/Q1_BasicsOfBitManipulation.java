// Time Complexity: O(1), Space Complexity: O(1)
import java.util.*;

public class Q1_BasicsOfBitManipulation {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    int i = scn.nextInt();
    int j = scn.nextInt();
    int k = scn.nextInt();
    int m = scn.nextInt();

    int setI = n | (1 << i);
    int unsetJ = n & (~(1 << j));
    int toggleK = n ^ (1 << k);
    boolean isMSet = (n & (1 << m)) != 0;

    System.out.println(setI);
    System.out.println(unsetJ);
    System.out.println(toggleK);
    System.out.println(isMSet);
  }

}

/*
 * Input:
 * 57
 * 2
 * 3
 * 4
 * 5
 *
 * Output:
 * 61
 * 49
 * 41
 * true
 */
