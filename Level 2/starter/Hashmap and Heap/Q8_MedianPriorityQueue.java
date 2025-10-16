import java.io.*;
import java.util.*;

public class Q8_MedianPriorityQueue {

  public static class MedianPriorityQueue {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianPriorityQueue() {
      left = new PriorityQueue<>(Collections.reverseOrder()); // max heap
      right = new PriorityQueue<>(); // min heap
    }

    // log(n)
    public void add(int val) {
      if (right.size() > 0 && val > right.peek()) {
        right.add(val);
      } else {
        left.add(val);
      }

      // handle gap
      if (left.size() - right.size() == 2) {
        right.add(left.remove());
      } else if (right.size() - left.size() == 2) {
        left.add(right.remove());
      }
    }

    // log(n)
    public int remove() {
      if (this.size() == 0) {
        System.out.println("Underflow");
        return -1;
      }
      if (left.size() >= right.size()) {
        return left.remove();
      } else {
        return right.remove();
      }
    }

    // O(1)
    public int peek() {
      if (this.size() == 0) {
        System.out.println("Underflow");
        return -1;
      }
      if (left.size() >= right.size()) {
        return left.peek();
      } else {
        return right.peek();
      }
    }

    // 
    public int size() {
      return left.size() + right.size();
    }

  }

  public static void main(String[] args) throws Exception {
    
    MedianPriorityQueue qu = new MedianPriorityQueue();
    qu.add(10);
    qu.add(20);
    qu.add(30);
    qu.add(40);
    qu.add(25);
    qu.add(5);
    
    // System.out.println(qu.size());
    System.out.println(qu.peek());
    // System.out.println(qu.remove());
    
  }
}