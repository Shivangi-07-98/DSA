import java.util.*;

public class Q22_PaintFence {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 8
    int k = scn.nextInt(); // 3

    System.out.println(paintFence_tab(n, k));
  }

  // Tabulation solution
  public static int paintFence_tab(int n, int k) {
    int cii = 0;
    int cij = k;
    int total = cii + cij;

    for (int i = 2; i <= n; i++) {
      int ncii = cij * 1;
      int ncij = total * (k - 1);
      int ntotal = ncii + ncij;

      cii = ncii;
      cij = ncij;
      total = ntotal;
    }

    return total;
  }

}
// paint n fences with k colors
// at most 2 adjacent fences can have same color

/*
 * Sample Input:
 * 8
 * 3
 * 
 * Sample Output:
 * 3672
 */
