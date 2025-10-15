import java.io.*;
import java.util.*;

public class Q4_LongestConsecutiveSequence {
  



  public static void main (String[] args) throws Exception{
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt(); // 10
    int[] arr = new int [n];
    for(int i = 0; i < arr.length; i++){
      arr[i] = scn.nextInt(); // 8 1 5 10 3 12 11 6 9 2
    }

    HashMap<Integer, Boolean> map = new HashMap<>();

    // first loop put true in front of everyone => O(n)
    for(int val: arr){
      map.put(val, true);
    }

    // second loop put false that are not beginning of sequence => O(n)
    for(int val: arr){
      if(map.containsKey(val - 1) == true){
        map.put(val, false);
      }
    }

    // third loop => O(n)
    int msp = 0;
    int mlen = 0;
    for(int val: arr){
      if(map.get(val) == true){
        int tsp = val;
        int tlen = 1;

        while(map.containsKey(tsp + tlen) == true){
          tlen++;
        }

        if(tlen > mlen){
          msp = tsp;
          mlen = tlen;
        }
      }
    }

    for(int i = 0; i < mlen; i++){
      System.out.print(msp + i + " ");
    }
  }



}
