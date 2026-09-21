// Time Complexity: O(2^n)
// Space Complexity: O(n)
import java.util.*;

public class Q25_TugOfWar {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = scn.nextInt();
    solve(arr, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);
    System.out.println(bestA);
    System.out.println(bestB);
  }

  private static int minDiff = Integer.MAX_VALUE;
  private static List<Integer> bestA = new ArrayList<>();
  private static List<Integer> bestB = new ArrayList<>();

  private static void solve(int[] arr, int idx, List<Integer> a, List<Integer> b, int sumA, int sumB) {
    if (idx == arr.length) {
      int diff = Math.abs(sumA - sumB);
      if (diff < minDiff) {
        minDiff = diff;
        bestA = new ArrayList<>(a);
        bestB = new ArrayList<>(b);
      }
      return;
    }

    if (a.size() < (arr.length + 1) / 2) {
      a.add(arr[idx]);
      solve(arr, idx + 1, a, b, sumA + arr[idx], sumB);
      a.remove(a.size() - 1);
    }

    if (b.size() < (arr.length + 1) / 2) {
      b.add(arr[idx]);
      solve(arr, idx + 1, a, b, sumA, sumB + arr[idx]);
      b.remove(b.size() - 1);
    }
  }


}

/*
 * Input:
 * 6
 * 1 2 3 4 5 6
 *
 * Output:
 * [1, 4, 6]
 * [2, 3, 5]
 */
