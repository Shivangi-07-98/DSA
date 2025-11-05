import java.util.*;
public class Q6_GoldMine {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    int[][] mine = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        mine[i][j] = scn.nextInt();
      }
    }

    int[][] storage = new int[n][m];
    for (int i = 0; i < n; i++) {
      Arrays.fill(storage[i], -1);
    }
    
    int maxGold = 0;
    for (int i = 0; i < n; i++) {
      maxGold = Math.max(maxGold, goldMine(i, 0, mine));
    }
    System.out.println(maxGold);

    maxGold = 0;
    for (int i = 0; i < n; i++) {
      maxGold = Math.max(maxGold, goldMine_memo(i, 0, mine, storage));
    }
    System.out.println(maxGold);
    
    System.out.println(goldMine_tab(n, m, mine));
  }

  // Recursive solution
  public static int goldMine(int r, int c, int[][] mine) {
    if (c == mine[0].length - 1) {
      return mine[r][c];
    }

    int maxGold = mine[r][c];
    int nextGold = 0;

    if (r - 1 >= 0) {
      nextGold = Math.max(nextGold, goldMine(r - 1, c + 1, mine));
    }
    nextGold = Math.max(nextGold, goldMine(r, c + 1, mine));
    if (r + 1 < mine.length) {
      nextGold = Math.max(nextGold, goldMine(r + 1, c + 1, mine));
    }

    return maxGold + nextGold;
  }

  // Memoized solution
  public static int goldMine_memo(int r, int c, int[][] mine, int[][] storage) {
    if (c == mine[0].length - 1) {
      return mine[r][c];
    }

    if (storage[r][c] != -1) {
      return storage[r][c];
    }

    int maxGold = mine[r][c];
    int nextGold = 0;

    if (r - 1 >= 0) {
      nextGold = Math.max(nextGold, goldMine_memo(r - 1, c + 1, mine, storage));
    }
    nextGold = Math.max(nextGold, goldMine_memo(r, c + 1, mine, storage));
    if (r + 1 < mine.length) {
      nextGold = Math.max(nextGold, goldMine_memo(r + 1, c + 1, mine, storage));
    }

    storage[r][c] = maxGold + nextGold;
    return storage[r][c];
  }

  // Tabulation solution
  public static int goldMine_tab(int n, int m, int[][] mine) {
    int[][] strg = new int[mine.length][mine[0].length];

    for (int j = mine[0].length - 1; j >= 0; j--) {
      for (int i = 0; i < mine.length; i++) {
        if (j == mine[0].length - 1) {
          strg[i][j] = mine[i][j];
        } else if (i == 0) {
          int maxNext = Math.max(strg[i][j + 1], strg[i + 1][j + 1]);
          strg[i][j] = mine[i][j] + maxNext;
        } else if (i == mine.length - 1) {
          int maxNext = Math.max(strg[i][j + 1], strg[i - 1][j + 1]);
          strg[i][j] = mine[i][j] + maxNext;
        } else {
          int maxNext = Math.max(strg[i][j + 1], Math.max(strg[i - 1][j + 1], strg[i + 1][j + 1]));
          strg[i][j] = mine[i][j] + maxNext;
        }
      }
    }

    int maxGold = 0;
    for (int i = 0; i < mine.length; i++) {
      maxGold = Math.max(maxGold, strg[i][0]);
    }

    return maxGold;
  }

}
