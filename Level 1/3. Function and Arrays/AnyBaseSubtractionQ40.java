import java.util.*;

public class AnyBaseSubtractionQ40 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getDifference(b, n1, n2);
        System.out.println(d);
    }

    public static int getDifference(int b, int n1, int n2) {

        int borrow = 0;
        int p = 1;
        int ans = 0;

        while (n2 > 0) {
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            n1 = n1 / 10;
            n2 = n2 / 10;

            // borrow settles first with d2
            d2 = d2 - borrow;

            int d = d2 - d1;
            if (d < 0) {

                d = d + b;
                borrow = 1;

            } else {
                borrow = 0; // don't leave else block empty
            }

            ans += d * p;
            p = p * 10;

        }
        return ans;
    }

}