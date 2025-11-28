import java.io.*;
import java.util.*;

public class Q7_LargestAreaHistogram {
  public static void main(String[] args) {

    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 11
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt(); // 5 3 4 5 5 4 3 6 5 6 4
    }

    int[] left = new int[n];
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    left[0] = -1;

    for (int i = 1; i < n; i++) {
      while (stack.size() > 0 && arr[i] <= arr[stack.peek()]) {
        stack.pop();
      }

      if (stack.size() == 0) {
        left[i] = -1;
      } else {
        left[i] = stack.peek();
      }
      // If we push(i) first, then peek() returns i itself (wrong!).
      stack.push(i);
    }

    int[] right = new int[n];
    Stack<Integer> stack2 = new Stack<>();
    stack2.push(n - 1);
    right[n - 1] = n;

    for (int i = n - 2; i >= 0; i--) {
      while (stack2.size() > 0 && arr[i] <= arr[stack2.peek()]) {
        stack2.pop();
      }

      if (stack2.size() == 0) {
        right[i] = n;
      } else {
        right[i] = stack2.peek();
      }
      // If we push(i) first, then peek() returns i itself (wrong!).
      stack2.push(i);
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int ht = arr[i]; // 5 3 4 5 5 4 3 6 5 6 4
      int width = right[i] - left[i] - 1; // 1 11 4 2 2 4 11 1 3 1 4
      int area = ht * width; // 5 33 16 10 10 16 33 6 15 6 16
      if (area > max) {
        max = area;
      }
    }

    System.out.println(max);

  }
}
