// Time Complexity: O(n^3), Space Complexity: O(1) (excluding output)

import java.io.*;
import java.util.*;

public class Q36_QuadrupletSum1 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = scn.nextInt();
    }
    int target = scn.nextInt();

    List<List<Integer>> ans = solution(nums, target);
    for (List<Integer> quad : ans) {
      System.out.println(quad);
    }
  }

  public static List<List<Integer>> solution(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();

    int n = nums.length;

    for (int i = 0; i < n; i++) {
      if (i > 0 && nums[i] == nums[i - 1])
        continue;

      for (int j = i + 1; j < n; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1])
          continue;

        int l = j + 1;
        int r = n - 1;

        while (l < r) {
          long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];

          if (sum == target) {
            res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
            l++;
            r--;

            while (l < r && nums[l] == nums[l - 1])
              l++;
            while (l < r && nums[r] == nums[r + 1])
              r--;
          } else if (sum < target) {
            l++;
          } else {
            r--;
          }
        }
      }
    }

    return res;
  }
}

/*
 * Input:
 * 6
 * 1 0 -1 0 -2 2
 * 0
 * 
 * Output:
 * [-2, -1, 1, 2]
 * [-2, 0, 0, 2]
 * [-1, 0, 0, 1]
 */
