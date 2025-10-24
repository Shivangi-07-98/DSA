import java.io.*;
import java.util.*;

// O(n) - each element pushed and popped at most once
// Find next greater element to the right for each element, if not found print -1
public class Q3_NextGreaterElementToTheRight {
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt(); // 9
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt(); // [2 5 9 3 1 12 6 8 7] => [5 9 12 12 12 -1 8 -1 -1]
    }

    int[] nge = new int[arr.length];
    Stack<Integer> st = new Stack<>();

    // Last element has no greater element to right
    nge[arr.length - 1] = -1;
    st.push(arr[arr.length - 1]);

    // Process from right to left
    for (int i = arr.length - 2; i >= 0; i--) {
      // Pop smaller elements from stack
      while (st.size() > 0 && st.peek() <= arr[i]) {
        st.pop();
      }
      
      // If stack is empty, no greater element to right
      if (st.size() == 0) {
        nge[i] = -1;
      } else {
        nge[i] = st.peek();
      }
      
      st.push(arr[i]);
    }

    for (int i = 0; i < n; i++) {
      System.out.println(nge[i]);
    }
  }
}
