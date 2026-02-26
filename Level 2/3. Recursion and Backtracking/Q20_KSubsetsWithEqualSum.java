// Time Complexity: O(k^n)
// Space Complexity: O(n)
import java.util.*;

public class Q20_KSubsetsWithEqualSum {

  private static boolean solve(int[] arr, int idx, int k, int target, int[] sum, List<List<Integer>> sets) {
    if (idx == arr.length) {
      for (int s : sum) if (s != target) return false;
      print(sets);
      return true;
    }

    int val = arr[idx];
    for (int i = 0; i < k; i++) {
      if (sum[i] + val <= target) {
        sets.get(i).add(val);
        sum[i] += val;
        if (solve(arr, idx + 1, k, target, sum, sets)) return true;
        sum[i] -= val;
        sets.get(i).remove(sets.get(i).size() - 1);
      }
      if (sets.get(i).isEmpty()) break;
    }

    return false;
  }

  private static void print(List<List<Integer>> sets) {
    StringBuilder sb = new StringBuilder();
    for (List<Integer> set : sets) {
      sb.append(set.toString()).append(" ");
    }
    System.out.println(sb.toString().trim());
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      sum += arr[i];
    }
    int k = scn.nextInt();

    if (k == 0 || sum % k != 0) {
      System.out.println("-1");
      return;
    }

    int target = sum / k;
    int[] partSum = new int[k];
    List<List<Integer>> sets = new ArrayList<>();
    for (int i = 0; i < k; i++) sets.add(new ArrayList<>());
    solve(arr, 0, k, target, partSum, sets);
  }

}

/*
 * Input:
 * 5
 * 2 1 4 5 6
 * 3
 *
 * Output:
 * [2, 4] [1, 5] [6]
 */
