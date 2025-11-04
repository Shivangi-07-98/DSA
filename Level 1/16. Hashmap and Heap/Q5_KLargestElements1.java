import java.io.*;
import java.util.*;

// worst approach
// have to print 3 largest elements
public class Q5_KLargestElements1 {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 9
    int []arr = new int[n];
    for(int i = 0; i < arr.length; i++){
      arr[i] = scn.nextInt(); // [10 19 3 74 86 57 24 5 11] = 86 74 57
    }
    int k = scn.nextInt(); // 3

    // add remove log(n), peek O(1)
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    // nlog(n) for adding n elements, space O(n) 
    for(int val: arr){
      pq.add(val);
    }

    // klog(n) for removing k elements
    for(int i = 0; i < k; i++){
      int ans = pq.remove();
      System.out.print(ans + " ");
    }

  }
  
}
