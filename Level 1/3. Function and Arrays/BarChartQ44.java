import java.io.*;
import java.util.*;

public class BarChartQ44{
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int [] a = new int [n];
        for (int i = 0; i < a.length; i++){
            a[i] = scn.nextInt ();
        }
        
        int max = a[0];
        for (int i = 1; i < a.length; i++){
            if (a[i] > max){
                max = a[i];
            }
        }
        
            for (int k = max; k > 0; k--){
                
                for (int b = 0; b < a.length; b++){
                
                if (a[b] >= k){
                    System.out.print ("*\t");
                }else{
                    System.out.print ("\t");
                }
                }
                System.out.println ();
            }
        }
        
    }