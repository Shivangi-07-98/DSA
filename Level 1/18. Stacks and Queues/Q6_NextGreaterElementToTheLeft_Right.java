import java.io.*;
import java.util.*;

public class Q6_NextGreaterElementToTheLeft_Right {
  public static void main(String[] args) {

    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 7
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt(); // [100 80 60 70 60 75 85] => [1 1 1 2 1 4 6]
    }

    int[] ans = new int[n];
    Stack<Integer> stack = new Stack<>();
    stack.push(n-1);

    for (int i = n-2; i >= 0; i--) {
      while (stack.size() > 0 && arr[i] >= arr[stack.peek()]) {
        int idx = stack.pop();
        ans[idx] = idx - i;
      }
      stack.push(i);
    }

    while (stack.size() > 0) {
      ans[stack.pop()] = stack.pop() + 1;
    }

    for (int i = 0; i < n; i++) {
      System.out.print(ans[i] + " ");
    }

  }
}
