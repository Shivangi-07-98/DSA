// O(2^n)
// 0 1 1 2 3 5 8 13 21 34 55
// 0 1 2 3 4 5 6 7  8  9  10
import java.util.*;
public class fib {
    public static void main (String [] args)throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.print( fib(n) );
    }

    public static int fib(int n){
        if (n == 0 || n == 1){
            return n;
        }

        int fibnm1 = fib(n-1);
        int fibnm2 = fib(n-2);
        int ans = fibnm1 + fibnm2;
        return ans;
    }
}
