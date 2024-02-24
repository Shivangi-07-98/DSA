import java.io.*;
import java.util.*;

public class PowerlinearQ {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int ans = power(x, n);
        System.out.println(ans);
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int a = power(x, n - 1);
        int b = x * a;
        return b;
    }
}