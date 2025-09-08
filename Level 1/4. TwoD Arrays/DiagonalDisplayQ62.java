// NOT AT ALL IMPORTANT - SKIP IT
// Diagonal traversal is niche and not commonly asked
import java.io.*;
import java.util.*;

public class DiagonalDisplayQ62 {

  public static void main(String[] args) throws Exception {
    
    // input starts
    Scanner scn = new Scanner (System.in);
    int n = scn.nextInt();
    int [][] arr = new int [n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = scn.nextInt();
      }
    }
    // input end
    for(int g = 0; g < n; g++){
    for(int i = 0, j = g; j < n; i++, j++){
        System.out.println(arr[i][j]);
      }
    }
  }
}