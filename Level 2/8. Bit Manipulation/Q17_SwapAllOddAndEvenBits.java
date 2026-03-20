// Time Complexity: O(1), Space Complexity: O(1)
import java.util.*;

public class Q17_SwapAllOddAndEvenBits {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int evenBits = n & 0xAAAAAAAA;
    int oddBits = n & 0x55555555;

    evenBits >>>= 1;
    oddBits <<= 1;

    int ans = evenBits | oddBits;
    System.out.println(ans);
  }

}

/*
 * Input:
 * 23
 *
 * Output:
 * 43
 */
