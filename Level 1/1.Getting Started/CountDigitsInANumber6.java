import java.util.*;

public class CountDigitsInANumber6 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int dig = 0;
    while (n != 0) {
      // n = n/10;
      int quo = n / 10;
      n = quo;
      dig++;
    }
    System.out.println(dig);
  }
}