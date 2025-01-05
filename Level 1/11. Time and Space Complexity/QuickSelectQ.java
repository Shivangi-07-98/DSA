import java.util.*;
public class QuickSelectQ {
  public static void main (String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 8
    int [] arr = new int[n];
    for(int i = 0; i < arr.length; i++){
      arr[i] = scn.nextInt(); // 40 60 30 20 90 70 80 50 => 20 30 40 50 60 70 80 90
    }
    int k = scn.nextInt(); // k smallest number
    System.out.println(QuickSelect(arr, 0, arr.length-1, k - 1));
    // print(arr);
  }

  public static int QuickSelect(int [] arr, int lo, int hi, int k){
    int pivot = arr[hi];
    int pidx = partition(arr, pivot, lo, hi);

    if(k > pidx){
      return QuickSelect(arr, pidx + 1, hi, k);
    }
    else if(k < pidx){
      return QuickSelect(arr, lo, pidx - 1, k);
    }
    else {
      return pivot;
    }
    
  }

  // j-1 is where the pivot is and is on correct spot
  public static int partition(int [] arr, int pivot, int lo, int hi){
    // System.out.println("pivot -> " + pivot);
    int i = lo, j = lo;
    while(i <= hi){
      if(arr[i] <= pivot){
        swap(arr, i, j);
        i++;
        j++;
      }
      else{
        i++;
      }
    }
    // System.out.println("pivot index -> " + (j - 1));
    return (j - 1);
  }

  public static void swap(int [] arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int [] arr){
    for(int i = 0; i < arr.length; i++){
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

}
