import java.io.*;
import java.util.*;

// O(n) - each character processed once
// Generate smallest number following pattern where 'd' = decrease, 'i' = increase
public class Q13_SmallestNumberFollowingPattern {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();

    int val = 1;
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (ch == 'd') {
        // d means: push and increase
        st.push(val);
        val++;
      } else {
        // i means: push, increase, pop all
        st.push(val);
        val++;
        while (st.size() > 0) {
          int res = st.pop();
          System.out.print(res);
        }
      }
    }

    // At the end: push and pop all
    st.push(val);
    while (st.size() > 0) {
      int res = st.pop();
      System.out.print(res);
    }
    System.out.println();
    scn.close();
  }
}

// Pattern rules:
// 'd' = decrease: push current value, increment value
// 'i' = increase: push current value, increment value, then pop and print all
// At end: push final value, then pop and print all

// Sample Input:
// ddddiiii
//
// Sample Output:
// 543216789
//
// Explanation:
// d: push 1, val=2
// d: push 2, val=3
// d: push 3, val=4
// d: push 4, val=5
// i: push 5, val=6, pop all -> prints 54321
// i: push 6, val=7, pop all -> prints 6
// i: push 7, val=8, pop all -> prints 7
// i: push 8, val=9, pop all -> prints 8
// End: push 9, pop all -> prints 9
// Final: 543216789
