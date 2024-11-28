// O(n^2)
import java.io.*;
import java.util.*;

public class SelectionSortQ {

  public static void selectionSort(int[] arr) {
    //write your code here
    for (int i = 0; i <= arr.length-2; i++){
        int minidx = i;
        for(int j = i + 1; j <= arr.length-1; j++){
            if(isSmaller(arr,j , minidx)== true){
                minidx = j;
            }
        }
        swap (arr,i , minidx);
    }
  }

  // return true if ith element is smaller than jth element
  public static boolean isSmaller(int[] arr, int j, int minidx) {
    System.out.println("Comparing " + arr[j] + " and " + arr[minidx]);
    if (arr[j] < arr[minidx]) {
      return true;
    } else {
      return false;
    }
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int minidx) {
    System.out.println("Swapping " + arr[i] + " and " + arr[minidx]);
    int temp = arr[i];
    arr[i] = arr[minidx];
    arr[minidx] = temp;
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    selectionSort(arr);
    print(arr);
  }

}