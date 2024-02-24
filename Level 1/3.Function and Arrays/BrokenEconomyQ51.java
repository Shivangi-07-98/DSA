import java.io.*;
import java.util.*;

public class BrokenEconomyQ51{

public static void main(String[] args) throws Exception {
    
    Scanner scn = new Scanner (System.in);
    int n = scn.nextInt();
    int [] a = new int [n];
    for (int i = 0; i < n; i++){
       a[i] = scn.nextInt();
    }
    int d = scn.nextInt();
    
    int left = 0;
    int right = a.length-1;
    int ceil = 0;
    int floor = 0;
    while(left <= right){
        int mid = (left + right) / 2;
        if (d < a[mid]){
             ceil = a[mid];
            right = mid-1;
        }
        else if (d > a[mid]){
             floor = a[mid];
            left = mid + 1;
        }
        else{
             floor = a[mid];
             ceil = a[mid];
        }
    }
        System.out.println(ceil);
        System.out.println(floor);
 }

}