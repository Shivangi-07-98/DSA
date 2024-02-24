// O( n*sqrt(n) )
import java.util.*;

public class PrintAllPrimes {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // 30

        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j*j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime == true) {
                System.out.print(i + " ");
            }

        }


    }
}