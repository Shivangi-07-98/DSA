// Time Complexity: O(n), Space Complexity: O(n)

import java.io.*;
import java.util.*;

public class Q48_EquivalentSubarrays {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    System.out.println(solution(arr));
  }

  private static long atMostK(int[] arr, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int i = 0;
    int j = 0;
    long ans = 0;

    while (i < arr.length) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

      while (map.size() > k) {
        int val = arr[j];
        map.put(val, map.get(val) - 1);
        if (map.get(val) == 0)
          map.remove(val);
        j++;
      }

      ans += (i - j + 1);
      i++;
    }

    return ans;
  }

  public static long solution(int[] arr) {
    HashSet<Integer> set = new HashSet<>();
    for (int val : arr)
      set.add(val);

    int k = set.size();
    return atMostK(arr, k) - atMostK(arr, k - 1);
  }
}

/*
 * Input:
 * 5
 * 2 1 3 2 3
 * 
 * Output:
 * 5
 */
