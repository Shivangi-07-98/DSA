// Time O(n^3)
// Space O(1) (excluding output)

import java.io.*;
import java.util.*;

public class Q36_QuadrupletSum1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int target = sc.nextInt();

    ArrayList<ArrayList<Integer>> ans = fourSum(arr, target, n);
    Collections.sort(ans, (a, b) -> {
      int i = 0;
      int j = 0;
      while (i < a.size()) {
        if (a.get(i).equals(b.get(j))) {
          i++;
          j++;
        } else {
          return a.get(i) - b.get(j);
        }
      }
      return 0;
    });

    for (ArrayList<Integer> quad : ans) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < quad.size(); i++) {
        if (i > 0) sb.append(' ');
        sb.append(quad.get(i));
      }
      System.out.println(sb.toString());
    }

    sc.close();
  }

  public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target, int n) {
    HashSet<ArrayList<Integer>> set = new HashSet<>();
    Arrays.sort(nums);

    for (int i = 0; i < n - 3; i++) {
      for (int j = i + 1; j < n - 2; j++) {
        int left = j + 1;
        int right = n - 1;
        while (left < right) {
          long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
          if (sum == target) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(nums[i]);
            tmp.add(nums[j]);
            tmp.add(nums[left]);
            tmp.add(nums[right]);
            set.add(tmp);
            left++;
            right--;
          } else if (sum < target) {
            left++;
          } else {
            right--;
          }
        }
      }
    }

    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    for (ArrayList<Integer> quad : set) {
      ret.add(quad);
    }
    return ret;
  }
}

// Input:
// 6
// 1 0 -1 0 -2 2
// 0
// 
// Output:
// -2 -1 1 2
// -2 0 0 2
// -1 0 0 1
