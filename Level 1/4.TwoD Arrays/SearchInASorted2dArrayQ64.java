import java.io.*;
import java.util.*;
public class SearchInASorted2dArrayQ {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int [][] a = new int [n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = scn.nextInt();
            }
        }
        int x = scn.nextInt();
        
        int minr = 0;
        int maxr = a.length-1;
        int minc = 0;
        int maxc = a[0].length-1;
        
        while(minr <= maxr && maxc >= minc){
        int pointer = a[minr][maxc]; // write inside loop
        if(x < pointer){
            maxc--;
        }
        else if(x > pointer){
            minr++;
        }
        else{
            System.out.println(minr);
            System.out.println(maxc);
            return;
        }
    }
    System.out.println("Not Found");
    }
}