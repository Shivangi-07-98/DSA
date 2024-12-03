import java.util.*;
public class PartitionAnArrayQ{
  public static void main (String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int [] arr = new int [n];
    for(int i = 0; i < arr.length; i++){
      arr[i] = scn.nextInt();
    }

    int pivot = scn.nextInt();

    PartitioningAnArray(arr, pivot);
    for(int i = 0; i < arr.length; i++){
      System.out.print(arr[i] + " ");
    }
  }

  public static void PartitioningAnArray(int [] arr, int pivot){
    int i = 0;
    int j = 0;
    while(j < arr.length){
      if(arr[j] <= pivot){
        swap(arr, i, j);
        i++;
        j++;
      }
      else{
        j++;
      }
    }
  }

  public static void swap(int [] arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}

