// Time Complexity: O(number of set bits), Space Complexity: O(1)
import java.util.*;

public class Q16_FlipBitsToConvertAToB {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();

    int x = a ^ b;
    int count = 0;

    while (x != 0) {
      x &= (x - 1);
      count++;
    }

    System.out.println(count);
  }

}

/*
 * Input:
 * 29
 * 15
 *
 * Output:
 * 2
 */
