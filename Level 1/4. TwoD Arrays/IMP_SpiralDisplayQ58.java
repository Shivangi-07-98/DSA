import java.io.*;
import java.util.*;
public class IMP_SpiralDisplayQ58 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt(); // rows
        int m = scn.nextInt(); // columns

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int minr = 0;
        int maxr = arr.length-1;
        int minc = 0;
        int maxc = arr[0].length-1;
        int TotalElements = n*m;
        int count = 1; 

        while(count <= TotalElements){
            // count check in every for loop
            // downward
            for( int i = minr, j = minc; i <= maxr && count <= TotalElements ; i++){               
                System.out.print (arr[i][j] + " ");
                // System.out.print (count + " ");
                count ++;
            }
            minc++;

            // rightward
            for( int i = maxr, j = minc; j <= maxc && count <= TotalElements ; j++){               
                System.out.print (arr[i][j] + " ");
                // System.out.print (count + " ");
                count ++;
            }
            maxr--;

            // upward
            for(int i = maxr, j = maxc; i >= minr && count <= TotalElements ; i--){              
                System.out.print (arr[i][j] + " ");
                // System.out.print (count + " ");
                count ++;
            }
            maxc--;

            // leftward
            for(int i = minr, j = maxc; j >= minc && count <= TotalElements ; j-- ){               
                System.out.print (arr[i][j] + " "); 
                // System.out.print (count + " ");
                count ++;
            }
            minr++;

        }

        System.out.println ();
        System.out.print (count);
        
        

    }
}