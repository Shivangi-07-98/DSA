import java.util.*;

public class Q17_PaintHouse {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 4
    int[][] arr = new int[n][3]; // 4 3
    for (int i = 0; i < arr.length; i++) {
      arr[i][0] = scn.nextInt();
      arr[i][1] = scn.nextInt();
      arr[i][2] = scn.nextInt();
    }

    System.out.println(paintHouse_tab(arr));
  }
  
  // Sample Input:
  // 4
  // 1 5 7 (house 1)
  // 5 8 4 (house 2)
  // 3 2 9 (house 3)
  // 1 2 4 (house 4)
  // Tabulation solution - Space optimized
  public static int paintHouse_tab(int[][] arr) {
    int red = arr[0][0];
    int green = arr[0][1];
    int blue = arr[0][2];

    for (int i = 1; i < arr.length; i++) { // row = 1-3
      int nred = Math.min(green, blue) + arr[i][0];
      int ngreen = Math.min(red, blue) + arr[i][1];
      int nblue = Math.min(green, red) + arr[i][2];

      red = nred;
      green = ngreen;
      blue = nblue;
    }

    return Math.min(red, Math.min(green, blue));
  }

}
// adjacent houses cannot have same color
// minimize cost

/*
 * Sample Input:
 * 4
 * 1 5 7 (house 1)
 * 5 8 4 (house 2)
 * 3 2 9 (house 3)
 * 1 2 4 (house 4)
 * 
 * Sample Output:
 * 8
 */
