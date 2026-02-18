import java.io.*;
import java.util.*;

// O(n log n) - sorting + O(n) processing
// Merge overlapping intervals and print in increasing order of start time
public class Q16_MergeOverlappingInterval {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 6
    int[][] arr = new int[n][2]; // 6 2
    for (int i = 0; i < n; i++) { // 0-5
      arr[i][0] = scn.nextInt();
      arr[i][1] = scn.nextInt();
    }
    mergeOverlappingIntervals(arr);
    scn.close();
  }

  static class Pair implements Comparable<Pair> {
    int start;
    int end;

    Pair(int start, int end) {
      this.start = start;
      this.end = end;
    }

    // +ve hai this bada hai, 0 hai this barabar hai, -ve hai this chhota hai
    public int compareTo(Pair o) {
      if (this.start != o.start) {
        return this.start - o.start;
      } else {
        return this.end - o.end;
      }
    }
    
  }

  public static void mergeOverlappingIntervals(int[][] arr) {
    // merge overlapping intervals and print in increasing order of start time
    Pair[] pairs = new Pair[arr.length]; // 6
    for (int i = 0; i < pairs.length; i++) { // 0-5
      pairs[i] = new Pair(arr[i][0], arr[i][1]);
    }

    Arrays.sort(pairs);

    Stack<Pair> st = new Stack<>();
    for (int i = 0; i < pairs.length; i++) { // 0-5
      if (i == 0) {
        st.push(pairs[0]);
      } else {
        Pair top = st.peek();
        Pair curr = pairs[i];
        if (curr.start > top.end) {
          st.push(curr);
        } else {
          top.end = Math.max(curr.end, top.end);
        }
      }
    }

    // Reverse stack to print in correct order
    Stack<Pair> rs = new Stack<>();
    while (st.size() > 0) {
      rs.push(st.pop());
    }

    System.out.println();
    while (rs.size() > 0) {
      Pair p = rs.pop();
      System.out.println(p.start + " " + p.end);
    }
  }
  
}

// Algorithm:
// 1. Convert intervals to Pair objects
// 2. Sort pairs by start time (then end time if start is same)
// 3. Use stack to merge: if current.start > top.end, push new interval
// else merge by updating top.end = max(curr.end, top.end)
// 4. Reverse stack and print

// Sample Input:
// 6
// 22 28
// 1 8
// 25 27
// 14 19
// 27 30
// 5 12
//
// Sample Output:
// 1 12
// 14 19
// 22 30
