import java.util.*; 
public class CountSortQ {
  public static void main (String [] args){
    Scanner scn = new Scanner (System.in);
    int n = scn.nextInt(); // 13
    int [] arr = new int [n];
    for(int i = 0; i < arr.length; i++){
      arr[i] = scn.nextInt(); // 5 3 7 3 5 7 2 5 2 7 6 5 6
    }

    int min = scn.nextInt(); // 2
    int max = scn.nextInt(); // 7
    countSort(arr, min, max);

  }

  public static void countSort(int [] arr, int min, int max){
    int range = max - min + 1;
    int [] farr = new int [range];
    int [] ans = new int [arr.length];

    // collecting the frequencies
    for(int i = 0; i < arr.length; i++){
      int val = arr[i];
      farr[val - min]++;
    }

    // convert freq to prefix sum array psa
    for(int i = 1; i < farr.length; i++){
      farr[i] = farr[i] + farr[i-1];
    }

    // fill the ans
    for(int i = arr.length-1; i >= 0; i--){
      int val = arr[i];
      int pos = farr[val-min];
      ans[pos - 1] = val;
      farr[val-min]--;
    }

    print(ans);

  }

  public static void print(int [] ans){
    for(int i = 0; i < ans.length; i++){
      System.out.print(ans[i] + " "); // 2 2 3 3 5 5 5 5 6 6 7 7 7 
    }

  }

}
