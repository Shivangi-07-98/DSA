import java.io.*;
import java.util.*;

public class Q9_ArrangeBuildings {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 5

    System.out.println(arrangeBuildings(n));
  }

  // Tabulation solution - Space optimized
  // using long as value is greater than 10^9
  public static long arrangeBuildings(int n) {
    long old_zero = 1; // binary strings ending in 0 of length 1
    long old_one = 1; // binary strings ending in 1 of length 1

    for (int i = 2; i <= n; i++) {
      long new_one = old_zero + old_one;
      long new_zero = old_one;

      old_zero = new_zero;
      old_one = new_one;
    }

    long oneside = old_zero + old_one;
    long ways = oneside * oneside;
    return ways;
  }

}
// 5 plots on each side of road, 2 building saath nhi honi chaiye
// 0 = Building, 1 = Space
// assume 2 building as 2 zero
// focus on one side first then total different ways is multiply both sides

/*
 * Sample Input:
 * 5
 * 
 * Sample Output:
 * 169
 */
