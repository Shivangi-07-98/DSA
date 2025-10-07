import java.io.*;
import java.util.*;

// in queue added in last removed from front
// in priority queue
// remove will not be from front (as small numbers have high priority)
public class PriorityQueueIntro {



  public static void main(String[] args) throws Exception {

    PriorityQueue<Integer> pq = new PriorityQueue<>(); // gives priority to small numbers
    // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // gives priority to bigger numbers
    
    // add remove log(n) peek O(1)
    pq.add(20);
    pq.add(40);
    pq.add(33);
    pq.add(57);
    pq.add(10);
    pq.add(67);

    System.out.println(pq.peek()); // 10
    pq.remove();
    System.out.println(pq.peek()); // 20
    pq.remove();
    System.out.println(pq.peek()); // 33
    pq.remove();
    System.out.println(pq.peek()); // 40
    pq.remove();
    System.out.println(pq.peek()); // 57
    pq.remove();
    System.out.println(pq.peek()); // 67
    pq.remove();

  }
  
}
