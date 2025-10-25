import java.io.*;
import java.util.*;

// O(n) - each element pushed and popped at most once
// Find stock span - number of consecutive days (including current) where price was <= current price
public class Q4_StockSpan {
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt(); // 7
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt(); // [100 80 60 70 60 75 85] => [1 1 1 2 1 4 6]
    }

    int[] span = new int[arr.length];
    Stack<Integer> st = new Stack<>();

    // First day always has span of 1
    span[0] = 1;
    st.push(0); // pushing the index in stack

    // Process from left to right
    for (int i = 1; i < arr.length; i++) {
      // Pop indices where price is <= current price
      while (st.size() > 0 && arr[st.peek()] <= arr[i]) {
        st.pop();
      }

      // If stack is empty, all previous days had price <= current
      if (st.size() == 0) {
        span[i] = i + 1;
      } else {
        span[i] = i - st.peek();
      }

      st.push(i);
    }

    for (int i = 0; i < n; i++) {
      System.out.println(span[i]);
    }
  }
}
