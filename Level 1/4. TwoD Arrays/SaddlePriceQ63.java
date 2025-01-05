import java.io.*;
import java.util.*;
public class SaddlePriceQ63 { //1
  public static void main(String[] args) throws Exception { //2

    // input starts
    Scanner scn = new Scanner (System.in);
    int n = scn.nextInt();
    int [][] a = new int [n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = scn.nextInt();
      }
    }
    // input end

    for (int i = 0; i < n; i++) { // row start
      int col = 0;
      int min = a[i][0];
      for (int j = 1; j < n; j++) { // col start
        if (a[i][j] < min) {
          min = a[i][j];
          col = j;
        }
      } // col end
      boolean saddle = true;
      for (int q = 0; q < n; q++) {
        if (a[q][col] > min ) {
          saddle = false;
          break;
        }
      }
      if ( saddle == true) {
        System.out.println(min);
        return;
      }
    } // row end

    System.out.println("Invalid input");
  } //2
} //1