import java.io.*;
import java.util.*;

public class FactorialQ {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = factorial(n);
        System.out.println(ans);
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int a = factorial(n - 1);
        int b = n * a;
        return b;
    }
}