import java.io.*;
import java.util.*;

public class SubsetsOfArrayQ53{ //1

public static void main(String[] args) throws Exception { //2
    // write your code here
    Scanner scn = new Scanner (System.in);
    int n = scn.nextInt();
    int [] a = new int [n];
    for (int i = 0; i < n; i++){
        a[i] = scn.nextInt();
    }
    
    int pow = (1 << n); //2^n
    
    for (int c = 0; c < pow; c++){ //3
        int q = c; 
        String str = " ";
        
        for(int j = 0; j < n; j++){ //4
        int rem = q % 2;
              q = q / 2;
              if (rem == 0){
                  str = ("-\t") + str ;
              }
              else{
                  str = a[n-1-j] + "\t" + str;
              }
              
        } //4
           System.out.println(str); 
    } //3
    
 } //2

} //1