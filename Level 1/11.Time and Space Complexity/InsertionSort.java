// O(n^2)
import java.util.*;
public class InsertionSort {
    public static void main(String [] args) throws Exception{
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int [] arr = new int [n];
        for (int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        insertionSort(arr);
        print(arr);
    }

    public static void insertionSort (int [] arr){
        for (int i = 1; i < arr.length; i++){
            for(int j = i-1; j >= 0; j--){
                if (arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
                else{
                    break;
                }
            }
        }
    }

    public static void swap(int [] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    public static void print (int [] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    
}