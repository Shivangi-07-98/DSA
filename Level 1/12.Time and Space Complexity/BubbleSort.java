// O(n^2)
import java.io.*;
import java.util.*;
public class BubbleSort{
    public static void main (String[]args) throws Exception{

        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int [] arr = new int [n];
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        bubbleSort(arr);
        print(arr);
    }
    
    public static void bubbleSort (int [] arr){
        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j <= arr.length-1-i; j++){
                if (isSmaller(arr, j+1, j) == true){
                    swap(arr, j+1, j);
                }
            }
        }
    }

    public static boolean isSmaller (int [] arr, int b, int a){
        if (arr[b] < arr[a]){
            return true;
        }
        else {
            return false;
        }
    }

    public static void swap (int [] arr, int b, int a){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void print(int [] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}