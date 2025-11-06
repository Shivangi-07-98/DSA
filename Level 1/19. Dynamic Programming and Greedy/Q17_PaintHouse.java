import java.util.*;
public class Q17_PaintHouse {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[][] costs = new int[n][3];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 3; j++) {
        costs[i][j] = scn.nextInt();
      }
    }

    Integer[][] storage = new Integer[n][3];
    System.out.println(paintHouse(costs, 0, -1));
    System.out.println(paintHouse_memo(costs, 0, -1, storage));
    System.out.println(paintHouse_tab(costs));
    System.out.println(paintHouse_optimized(costs));
  }

  // Recursive solution
  public static int paintHouse(int[][] costs, int house, int prevColor) {
    if (house == costs.length) {
      return 0;
    }

    int minCost = Integer.MAX_VALUE;
    for (int color = 0; color < 3; color++) {
      if (color != prevColor) {
        int cost = costs[house][color] + paintHouse(costs, house + 1, color);
        minCost = Math.min(minCost, cost);
      }
    }

    return minCost;
  }

  // Memoized solution
  public static int paintHouse_memo(int[][] costs, int house, int prevColor, Integer[][] storage) {
    if (house == costs.length) {
      return 0;
    }

    int storageIdx = prevColor == -1 ? 0 : prevColor + 1;
    if (prevColor != -1 && storage[house][prevColor] != null) {
      return storage[house][prevColor];
    }

    int minCost = Integer.MAX_VALUE;
    for (int color = 0; color < 3; color++) {
      if (color != prevColor) {
        int cost = costs[house][color] + paintHouse_memo(costs, house + 1, color, storage);
        minCost = Math.min(minCost, cost);
      }
    }

    if (prevColor != -1) {
      storage[house][prevColor] = minCost;
    }
    return minCost;
  }

  // Tabulation solution
  public static int paintHouse_tab(int[][] costs) {
    int n = costs.length;
    int[][] strg = new int[n][3];

    for (int j = 0; j < 3; j++) {
      strg[0][j] = costs[0][j];
    }

    for (int i = 1; i < n; i++) {
      strg[i][0] = costs[i][0] + Math.min(strg[i - 1][1], strg[i - 1][2]);
      strg[i][1] = costs[i][1] + Math.min(strg[i - 1][0], strg[i - 1][2]);
      strg[i][2] = costs[i][2] + Math.min(strg[i - 1][0], strg[i - 1][1]);
    }

    return Math.min(Math.min(strg[n - 1][0], strg[n - 1][1]), strg[n - 1][2]);
  }

  // Space optimized solution
  public static int paintHouse_optimized(int[][] costs) {
    int n = costs.length;
    int prev0 = costs[0][0];
    int prev1 = costs[0][1];
    int prev2 = costs[0][2];

    for (int i = 1; i < n; i++) {
      int curr0 = costs[i][0] + Math.min(prev1, prev2);
      int curr1 = costs[i][1] + Math.min(prev0, prev2);
      int curr2 = costs[i][2] + Math.min(prev0, prev1);

      prev0 = curr0;
      prev1 = curr1;
      prev2 = curr2;
    }

    return Math.min(Math.min(prev0, prev1), prev2);
  }
  
}

