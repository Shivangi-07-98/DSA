import java.io.*;
import java.util.*;

public class Q8_SlidingWindowMaximum {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 11
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt(); // Example: [1 3 2 4 5 2 1 6 3 4 2]
    }
    int k = scn.nextInt(); // 4

    // array of size n - k + 1
    int[] ans = new int[n - k + 1]; // 11-4+1 = 8 (stores max for each window)

    // next greater element to the right_right
    int[] right = new int[n];
    Stack<Integer> st = new Stack<>();
    right[n - 1] = n;
    st.push(n - 1);

    for (int i = n - 2; i >= 0; i--) {
      while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
        st.pop();
      }

      if (st.size() == 0) {
        right[i] = n;
      } else {
        right[i] = st.peek();
      }

      st.push(i);
    }

    // for (int i = 0; i < n; i++) {
    // System.out.print(right[i] + " "); // 1 3 3 4 7 7 7 11 9 11 11 (idx)
    // }
    // System.out.println();

    int j = 0; // travels in right arr
    for (int i = 0; i < ans.length; i++) {
      if (j < i) {
        j = i;
      }
      // Keep jumping to next greater element while it's still within window [i, i+k-1]
      while (right[j] < i + k) { // 4 5 6 7 8 9 10 11
        j = right[j];
      }
      // Now j points to max element in window i
      ans[i] = arr[j];
    }

    for (int val : ans) {
      System.out.print(val + " "); // 4 5 5 5 6 6 6 6
    }

  }
}

// O(n) - each element added and removed at most once
// Naive O(n*k) approach: For each window, loop through k elements to find max
// Complexity: (n-k+1) windows × k checks = O(n*k)

// - O(n*k) becomes slow for large k (if k=n/2, it's O(n²))
