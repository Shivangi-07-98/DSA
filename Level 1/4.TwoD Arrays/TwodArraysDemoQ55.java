import java.io.*;
import java.util.*;

public class TwodArraysDemoQ55{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner (System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    
    int [][] twoD = new int [n][m];
    
    for (int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            twoD [i][j] = scn.nextInt();
        }
    }
    
    for (int i = 0; i < n; i++){
        for (int j = 0; j < m; j++){
            System.out.print(twoD[i][j] + " " );
        }
        System.out.println();
    }
    
 }

}