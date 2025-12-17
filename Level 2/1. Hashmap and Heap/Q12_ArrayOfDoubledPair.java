// Time Complexity: O(n log n)
// Space Complexity: O(n)
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

  // check if array can be reordered such that arr[2*i+1] = 2 * arr[2*i]
  static boolean canReorderDoubled(int[] arr) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int val : arr) {
      if (map.containsKey(val)) {
        map.put(val, map.get(val) + 1);
      } else {
        map.put(val, 1);
      }
    }

    Arrays.sort(arr);

    for (int val : arr) {
      if (val != 0 && map.containsKey(val) && map.containsKey(2 * val)) {
        int freq1 = map.get(val);
        freq1--;
        if (freq1 == 0) {
          map.remove(val);
        } else {
          map.put(val, freq1);
        }

        int freq2 = map.get(2 * val);
        freq2--;
        if (freq2 == 0) {
          map.remove(2 * val);
        } else {
          map.put(2 * val, freq2);
        }
      }
    }

    if (map.size() == 0) {
      return true;
    } else if (map.size() == 1 && map.containsKey(0)) {
      return true;
    } else {
      return false;
    }
  }

}

/*
 * Sample Input:
 * 4
 * 4 -2 2 -4
 * 
 * Sample Output:
 * true
 */
