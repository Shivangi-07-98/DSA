// LeetCode 781: Rabbits in Forest
// https://leetcode.com/problems/rabbits-in-forest/
// Time Complexity: O(n), Space Complexity: O(n)

// We need to find the minimum number of rabbits in the forest
// Example: If 7 rabbits say "3 others like me" → they form groups of size 4 (3+1)
// Number of groups = ceil(7/4) = 2, so minimum rabbits = 2 * 4 = 8
import java.io.*;
import java.util.*;

public class Q13_RabbitsInForest {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int ans = solution(arr);
    System.out.println(ans);
  }

  static int solution(int[] arr) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int val : arr) {
      map.put(val, map.getOrDefault(val, 0) + 1);
    }

    int ans = 0;

    for (int key : map.keySet()) {
      int gs = key + 1;
      int reportees = map.get(key); // Frequency: how many rabbits said this number
      // Math.ceil() returns DOUBLE type (e.g., 3.0), not int (3)
      // Even though the value is a whole number, the return type is double
      // Example: Math.ceil(2.1) = 3.0 (double), Math.ceil(2.9) = 3.0 (double)
      int ng = (int) Math.ceil(reportees * 1.0 / gs * 1.0); // Number of groups needed
      ans += ng * gs; // Total rabbits = number of groups * group size
    }

    return ans;
  }

}
/*
 * array for below input is n = 27
 * [3 3 3 3 3 3 3 2 2 2 2 2 2 4 4 4 4 4 4 4 4 4 0 0 1 1 1]
 * 7 rabbits bol rhe mere jaise 3 aur hai
 * 6 rabbits bol rhe mere jaise 2 aur hai
 * 9 rabbits bol rhe mere jaise 4 aur hai
 * 2 rabbits bol rhe mere jaise 0 aur hai
 * 3 rabbits bol rhe mere jaise 1 aur hai
 * 
 * 1st case mere jaise 3 aur hai mtlb 4 ka group, 7 rabbits 4 + 4 ke group mai
 * fit honge 1 bachega
 * formula is number of groups * group ka size = (7/4) * 4
 * number of groups = 7/4 ka ceil
 * 
 * 2 ka ceil 2
 * 2.1 to 2.9 ka ceil 3
 * 3 ka ceil 3
 * 
 * min rabbits is = 30
 */
