import java.io.*;
import java.util.*;
import java.util.Arrays;
public class SortingArrays {
    public static void main (String[] args){
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt(); // 6
        int [] arr = new int [n];
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt(); // 10 20 4 67 34 4
        }

        Arrays.sort(arr); // nlogn
        
        for(int i = 0; i < n; i++){
            System.out.print( arr[i] + " ");
        }

    }
}
