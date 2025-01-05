import java.util.*;
public class SortLoHiQ{
  public static void main (String [] args){
    Scanner scn = new Scanner(System.in);
    int lo = scn.nextInt();
    int hi = scn.nextInt();
    
    int n = scn.nextInt(); // 8
    int [] arr = new int [n];
    for(int i = 0; i < n; i++){
      arr[i] = scn.nextInt(); // 1 2 0 1 2 0 1 2
    }
    
    // sort1(arr, lo, hi);
    sort2(arr, lo, hi);
    for(int i = 0; i < arr.length; i++){
      System.out.print(arr[i] + " ");
    }
  }

  public static void sort1(int [] arr, int lo, int hi){
    int i=0;
    int j=0;
    int k=0;

    while(j < arr.length){
        if(arr[j] == 0){
          swap(arr, i, j);
          swap(arr, k, j);
          i++;
          k++;
          j++;
        }
        else if(arr[j] == 1){
          swap(arr, k, j);
          k++;
          j++; 
        }
        else{
          j++;
        }
    }
  }

  
  public static void sort2(int [] arr, int lo, int hi){
    int i=0;
    int j=0;
    int k=arr.length-1;

    while(j <= k){
        if(arr[j] < lo){
          swap(arr, i, j);
          i++;
          j++;
        }
        else if(arr[j] >= lo && arr[j] <= hi){
          j++; 
        }
        else{
          swap(arr, k, j);
          k--;
        }
    }
  }

  public static void swap(int [] arr, int i, int j){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    
  }
}

