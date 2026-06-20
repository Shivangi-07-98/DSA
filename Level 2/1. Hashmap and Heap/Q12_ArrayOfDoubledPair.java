// LeetCode 954: Array of Doubled Pairs
// https://leetcode.com/problems/array-of-doubled-pairs/
// Time O(n log n)
// Space O(n)

// WHAT IS THE QUESTION ASKING?
// Can we reorder the array so that after reordering:
// - arr[0] and arr[1] form a pair where arr[1] = 2 * arr[0]
// - arr[2] and arr[3] form a pair where arr[3] = 2 * arr[2]
// - arr[4] and arr[5] form a pair where arr[5] = 2 * arr[4]
// - and so on...
// In general: arr[2*i+1] = 2 * arr[2*i] for every pair
//
// Example: [4,-2,2,-4] can be reordered to [-2,-4,2,4]
// where -4 = 2*(-2) and 4 = 2*2 ✓
import java.io.*;
import java.util.*;

public class Q12_ArrayOfDoubledPair {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    boolean ans = canReorderDoubled(arr);
    System.out.println(ans);
  }

  static boolean canReorderDoubled(int[] arr) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int val : arr) {
      map.put(val, map.getOrDefault(val, 0) + 1);
    }

    Arrays.sort(arr); // imp why? see this case 2 8 1 4
    // 2 takes wrong pair 4 instead 1 2 and 4 8 are pairs

    // Why skip zero? For zero: val=0 and 2*val=0 (same key!)
    // If we include zero, we'd decrement the SAME key twice in one iteration
    for (int val : arr) {
      if (val != 0 && map.containsKey(val) && map.containsKey(2 * val)) {
        if (map.get(val) > 1) {
          map.put(val, map.get(val) - 1);
        } else {
          map.remove(val);
        }

        if (map.get(2 * val) > 1) {
          map.put(2 * val, map.get(2 * val) - 1);
        } else {
          map.remove(2 * val);
        }
      }
    }

    // hashmap ka size 1 hai toh 0 ke saamne hmesha even hoga
    // aur agar 0 ke saamne odd pda bhi h toh hashmap ka size kbhi 1 nhi hoga eg
    // 0001
    if (map.size() == 0) {
      return true;
    } else if (map.size() == 1 && map.containsKey(0)) {
      return true;
    } else {
      return false;
    }
  }

}

// Example 1:
// Input: arr = [3,1,3,6]
// Output: false
// Explanation: Cannot form pairs where second = 2 * first
// 
// Example 2:
// Input: arr = [2,1,2,6]
// Output: false
// Explanation: Cannot form pairs where second = 2 * first
// 
// Example 3:
// Input: arr = [4,-2,2,-4]
// Output: true
// Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4]
// where -4 = 2*(-2) and 4 = 2*2
