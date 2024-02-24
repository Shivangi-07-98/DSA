import java.util.*;

public class DigitsOfANumber7 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // part 1
        int div = 1;
        int temp = n;
        while (temp >= 10) {
            temp = temp / 10;
            div *= 10;
        }

        // part 2
        while (div >= 1) {
            int rem = n % div;
            int quo = n / div;
            System.out.println(quo);
            div = div / 10;
            n = rem;
        }
    }
}
