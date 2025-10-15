import java.io.*;
import java.util.*;

public class Q6_SortKSortedArray {
  



  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 9
    int []arr = new int[n];
    for(int i = 0; i < arr.length; i++){
      arr[i] = scn.nextInt(); // [30 10 20 40 70 80 50 60 90]
    }
    int k = scn.nextInt(); // 2

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    // klog(k)
    for(int i = 0; i <= k; i++){
      pq.add(arr[i]);
    }

    // nlog(k)
    for(int i = k + 1; i < arr.length; i++){
      int val = pq.remove();
      System.out.print(val + " ");
      pq.add(arr[i]);
    }

    // klog(k)
    while (pq.size() > 0) {
      int val = pq.remove();
      System.out.print(val + " ");
      
    }
  }
}
