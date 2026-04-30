// https://leetcode.com/problems/longest-consecutive-sequence/description/

import java.io.*;
import java.util.*;

public class Q4_LongestConsecutiveSequence {
  
  public static void main (String[] args) throws Exception{
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt(); // 10
    int[] arr = new int [n];
    for(int i = 0; i < arr.length; i++){
      arr[i] = scn.nextInt(); // 8 1 5 10 3 12 11 6 9 2 = 1 2 3, 5 6, 8 9 10 11 12
    } // print 8 9 10 11 12

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
    int msp = 0; // max starting point
    int mlen = 0; // max length
    for(int val: arr){
      if(map.get(val) == true){
        int tsp = val; // temporary starting point
        int tlen = 1; // temporary length

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

// ---------------------------------------------------------------------

/*
class Solution {
  public int longestConsecutive(int[] nums) {
    HashMap<Integer, Boolean> map = new HashMap<>();
    for (int val : nums) {
      map.put(val, true);
    }

    for (int val : nums) {
      if (map.containsKey(val - 1)) {
        map.put(val, false);
      }
    }

    int res = 0;

    for (int val : nums) {
      if (map.get(val) == true) {
        int len = 1;
        while (map.containsKey(val + len)) {
          len++;
        }

        if (len > res) {
          res = len;
        }
      }
    }

    return res;
  }
}

*/
