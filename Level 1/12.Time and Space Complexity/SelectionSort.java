// O(n^2)
import java.io.*;
import java.util.*;
public class SelectionSort {
    public static void main (String [] args) throws Exception{
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int [] arr = new int [n];
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }

        selectionSort(arr);
        print(arr);
    }

    public static void selectionSort(int [] arr){
        for(int i = 0; i <= arr.length-2; i++){
            for(int j = i+1; j <= arr.length -1; j++){
                int small = i;
                if (arr[j] < arr[small]){
                     small = j;
                }
                swap(arr, i, small);

            }
        }

    }

    public static void swap ( int [] arr, int i, int small ){
        int temp = arr[i];
        arr[i] = arr[small];
        arr[small] = temp;
    }

    public static void print (int [] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}