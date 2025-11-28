import java.io.*;
import java.util.*;

public class delete {
  public static void main(String[] args) {

    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 9
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt(); // [2 5 9 3 1 12 6 8 7] => [5 9 12 12 12 -1 8 -1 -1]
    }

    int[] ans = new int[n];
    Stack<Integer> stack = new Stack<>();
    stack.push(0);

    

    for (int i = 0; i < n; i++) {
      System.out.print(ans[i] + " ");
    }

  }
}
