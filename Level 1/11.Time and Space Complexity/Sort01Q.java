import java.util.*;
public class Sort01Q{
  public static void main (String [] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 7
    int [] arr = new int [n];
    for(int i = 0; i < n; i++){
      arr[i] = scn.nextInt(); // 1 1 0 1 0 0 1
    }
    sort(arr);
    for(int i = 0; i < arr.length; i++){
      System.out.print(arr[i] + " ");
    }
  }

  public static void sort(int [] arr){
    int i=0;
    int j=0;

    while(j < arr.length){
        if(arr[j] == 0){
          swap(arr, i, j);
          i++;
        }
        j++;
      
    }
  }

  public static void swap(int [] arr, int i, int j){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    
  }
}
