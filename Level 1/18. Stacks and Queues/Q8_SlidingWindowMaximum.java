import java.io.*;
import java.util.*;

public class Q8_SlidingWindowMaximum {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 11
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt(); // 5 3 4 5 5 4 3 6 5 6 4 = 7 2 3 7 7 7 7 11 9 11 11 (idx)
    }
    int k = scn.nextInt(); // 4
    // if k is 7, 0-14 have elements meaning n = 15 elements in n = 21
    // or 0 to arr.length - 7 have elements so array size is arr.length - 7 + 1
    // so array of size n - k + 1

    int[] ans = new int[n - k + 1]; // 11-4+1 = 8 windows (indices 0-7)

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
    // System.out.print(right[i] + " "); // 7 2 3 7 7 7 7 11 9 11 11
    // }

    int j = 0; // travels in right arr
    for (int i = 0; i < ans.length; i++) { // 0 to n-k (8 windows for n=11, k=4)
      if (j < i) {
        j = i;
      }
      while (right[j] < i + k) { // 4, 5, 6, 7, 8, 9, 10
        j = right[j];
      }
      ans[i] = arr[j];
    }

    for (int val : ans) {
      System.out.print(val + " "); // 7 2 3 7 7 7 7 11 9 11 11
    }

  }
}

// O(n) - each element added and removed at most once
// Naive O(n*k) approach: For each window, loop through k elements to find max
// Complexity: (n-k+1) windows × k checks = O(n*k)

// - O(n*k) becomes slow for large k (if k=n/2, it's O(n²))
