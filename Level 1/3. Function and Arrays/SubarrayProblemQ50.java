import java.io.*;
import java.util.*;

public class SubarrayProblemQ50{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner (System.in);
    int n = scn.nextInt();
    int [] a = new int [n];
    for (int i = 0; i < a.length; i++){
        a[i] = scn.nextInt();
    }
    
    for(int si = 0; si < a.length; si++){
        for (int ei = si; ei < a.length; ei++){
            for (int elements = si; elements <= ei; elements++){
                System.out.print(a[elements] + "\t");
            }
            System.out.println();
        }
    }
  }
}