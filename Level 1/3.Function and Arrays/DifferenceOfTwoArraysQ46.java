import java.io.*;
import java.util.*;

public class DifferenceOfTwoArraysQ46{
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner (System.in);
        
        int n1 = scn.nextInt();
        int [] a1 = new int [n1];
        for (int i = 0; i < a1.length; i++){
            a1[i] = scn.nextInt();
        }
        int n2 = scn.nextInt();
        int [] a2 = new int [n2];
        for (int i = 0; i < a2.length; i++){
            a2[i] = scn.nextInt();
        }
        // size of sub array
        int [] sub  = new int [n2];
        
        int i = a1.length-1;
        int j = a2.length-1;
        int k = sub.length-1;
        
        int borrow = 0;
        while (k >= 0){
            int d = a2[j] - borrow;
            
            if (i >= 0){
            d = d - a1[i];
            }
            if (d < 0){
                d = d + 10;
                borrow = 1;
            }
            else {
                borrow = 0;
            }
            // c = d / 10;
            // d = d % 10;
            sub[k] = d;
            
            i--;
            j--;
            k--;
            
        }
        // don't print starting zeroes
        // for(int z = 0; z < sub.length; z++){
        // System.out.println (sub [z]);
        // }
        
        // this loop can't be used because it eliminates all the zeroes of the answer
        
        // for(int z = 0; z < sub.length; z++){
        //     if (sub[z] == 0){
                
        //     }
        //     else {
        //         System.out.println (sub[z]);
        //     }
        // }
        
        int z = 0;
        while (z < sub.length){
            if (sub[z] == 0){
                z++;
            }else{
                break;
            }
        }
            while (z < sub.length)
          { System.out.println (sub[z]);
            z++;
          }
    }
    
    }