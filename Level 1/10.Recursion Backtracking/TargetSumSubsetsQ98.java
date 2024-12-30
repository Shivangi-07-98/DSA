import java.util.*;
public class TargetSumSubsetsQ98 {
  public static void main (String [] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 5
    int [] arr = new int [n];
    for(int i = 0; i < arr.length; i++){
      arr[i] = scn.nextInt(); // 10 20 30 40 50
    }
    int tar = scn.nextInt(); // 60
    TargetSumSubsets(arr, 0, "", 0, tar);
  }

  public static void TargetSumSubsets(int [] arr, int idx, String set, int sos, int tar) {
    if(idx == arr.length){
      if(sos == tar){
        System.out.println(set + "_");
      }
      return;
    }
    TargetSumSubsets(arr, idx + 1, set, sos, tar);
    TargetSumSubsets(arr, idx + 1, set + arr[idx] + ", ", sos + arr[idx], tar);

  }
}
