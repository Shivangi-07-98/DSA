import java.io.*;
import java.util.*;

public class delete {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 7
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt(); // 100 80 60 70 60 75 85 = 1 1 1 2 1 4 6
    }

    int[] ans = new int[n];
    ans[0] = 1;
    Stack<Integer> stack = new Stack<>();
    stack.push(0);

    for (int i = 1; i < n; i++) {
      while(stack.size() > 0 && arr[stack.peek()] <= arr[i]){
        stack.pop();
      }
      if (stack.size() == 0) {
        ans[i] = i + 1;
      } else {
        ans[i] = i - stack.peek();
      }

      stack.push(i);
    }

    for (int i = 0; i < n; i++) {
      System.out.print(ans[i] + " ");
    }

  }
}
