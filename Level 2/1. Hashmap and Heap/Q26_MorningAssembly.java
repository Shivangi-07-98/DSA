// https://www.geeksforgeeks.org/problems/morning-assembly3038/1
// Time Complexity: O(n log n), Space Complexity: O(n)
import java.io.*;
import java.util.*;

public class Q26_MorningAssembly {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    System.out.println(solution(arr));
  }

  public static int solution(int[] arr) {
    ArrayList<Integer> lis = new ArrayList<>();

    for (int val : arr) {
      int idx = Collections.binarySearch(lis, val);
      if (idx < 0) {
        idx = -idx - 1; // insertion point
      }

      if (idx == lis.size()) {
        lis.add(val);
      } else {
        lis.set(idx, val);
      }
    }

    return arr.length - lis.size();
  }
}

/*
 * Input:
 * 7
 * 5 1 6 2 3 4 7
 * 
 * Output:
 * 2
 * 
 * Explanation:
 * LIS = 1 2 3 4 7 → length 5
 * Remove = 7 - 5 = 2
 */
