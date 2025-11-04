import java.io.*;
import java.util.*;

// correct approach
public class Q5_KLargestElements2 {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 9
    int []arr = new int[n];
    for(int i = 0; i < arr.length; i++){
      arr[i] = scn.nextInt(); // [10 19 3 74 86 57 24 5 11]
    }
    int k = scn.nextInt(); // 3

    // add remove log(n) peek O(1)
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    // klog(k) for adding, space O(k) 
    for(int i = 0; i < k; i++){
      pq.add(arr[i]);
    }

    // (k-n)log(k)
    for(int i = k; i < arr.length; i++){
      int val = arr[i];
      if(val > pq.peek()){
        pq.remove();
        pq.add(val);
      }
    }

    // klog(k)
    while (pq.size() > 0) {
      System.out.print(pq.peek() + " "); // in ascending order
      pq.remove();
    }

  }
  
}
