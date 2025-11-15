import java.util.*;
public class Q1_FibonacciDP {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 10

    int[] storage = new int[n + 1];
    
    System.out.println(fib(n));
    System.out.println(fib_memo(n, storage));
  }

  // Recursive solution
  public static int fib(int n) {
    if (n == 0 || n == 1) {
      return n;
    }

    int fnm1 = fib(n - 1);
    int fnm2 = fib(n - 2);
    int fn = fnm1 + fnm2;

    return fn;
  }

  // Memoized solution
  public static int fib_memo(int n, int[] storage) {
    if (n == 0 || n == 1) {
      return n;
    }

    if (storage[n] != 0) {
      return storage[n];
    }

    int fnm1 = fib_memo(n - 1, storage);
    int fnm2 = fib_memo(n - 2, storage);
    int fn = fnm1 + fnm2;

    storage[n] = fn;
    return fn;
  }
  
}

/*
Sample Input:
10

Sample Output:
55
*/