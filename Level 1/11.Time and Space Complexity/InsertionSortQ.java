// O(n^2)
import java.io.*;
import java.util.*;

public class InsertionSortQ {

    public static void insertionSort(int[] arr) {
        // write your code here
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(isGreater(arr, j, j+1) == true){
                    swap(arr, j, j + 1);
                } else {
                    break;
                }
                // if (arr[j] > arr[j + 1]) {
                //     swap(arr, j, j + 1);
                // } else {
                //     break;
                // }
            }
        }
    }

    // return true if jth element is greater than ith element
    public static boolean isGreater(int[] arr, int a, int b) {
        System.out.println("Comparing " + arr[b] + " and " + arr[a]);
        if (arr[a] > arr[b]) {
            return true;
        } else {
            return false;
        }
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int a, int b) {
        System.out.println("Swapping " + arr[a] + " and " + arr[b]);
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        insertionSort(arr);
        print(arr);
    }

}