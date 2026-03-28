// Time Complexity: O(k^n)
// Space Complexity: O(n)
import java.util.*;

public class Q19_KPartitions {

  private static int count = 0;

  private static void solve(int n, int k, int idx, int filled, List<List<Integer>> parts) {
    if (idx > n) {
      if (filled == k) {
        count++;
        print(parts);
      }
      return;
    }

    for (int i = 0; i < parts.size(); i++) {
      if (!parts.get(i).isEmpty()) {
        parts.get(i).add(idx);
        solve(n, k, idx + 1, filled, parts);
        parts.get(i).remove(parts.get(i).size() - 1);
      } else {
        parts.get(i).add(idx);
        solve(n, k, idx + 1, filled + 1, parts);
        parts.get(i).remove(parts.get(i).size() - 1);
        break;
      }
    }
  }

  private static void print(List<List<Integer>> parts) {
    String line = "";
    for (List<Integer> p : parts) {
      line += p.toString() + " ";
    }
    System.out.println(line.trim());
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = scn.nextInt();
    List<List<Integer>> parts = new ArrayList<>();
    for (int i = 0; i < k; i++) parts.add(new ArrayList<>());
    solve(n, k, 1, 0, parts);
    System.out.println(count);
  }

}

/*
 * Input:
 * 4
 * 2
 *
 * Output:
 * [1, 2, 3] [4]
 * [1, 2, 4] [3]
 * [1, 3, 4] [2]
 * [1, 4] [2, 3]
 * [1, 2] [3, 4]
 * [1, 3] [2, 4]
 * [1] [2, 3, 4]
 * 7
 */
