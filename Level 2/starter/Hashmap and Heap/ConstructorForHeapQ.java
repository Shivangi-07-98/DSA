import java.io.*;
import java.util.*;

public class ConstructorForHeapQ { 

  public static class MyPriorityQueue {
    ArrayList<Integer> data;

    public MyPriorityQueue() {
      data = new ArrayList<>();
    }

    // Write a constructor for heap to accept array and do complexity of O(n) instead of  O(nlog(n))
    public MyPriorityQueue(int[] arr) {
      data = new ArrayList<>();
      // for(int val: arr){
      //   add(val);
      // }

      for(int val: arr){
        data.add(val);
      }
      for (int i = data.size() / 2 - 1; i >= 0; i--) {
        downheapify(i);
      }
    }

    // O(log n)
    public void add(int val) {
      data.add(val);
      upheapify(data.size() - 1);
    }

    // O(log n)
    public int remove() {
      if (data.size() == 0) {
        System.out.println("Underflow");
        return -1;
      }
      
      swap(0, data.size() - 1);
      int val = data.remove(data.size() - 1);
      downheapify(0);
      return val;
    }

    // O(1)
    public int peek() {
      if (data.size() == 0) {
        System.out.println("Underflow");
        return -1;
      }
      return data.get(0);
    }
    
    // O(log n)
    public void upheapify(int i) {
      if (i == 0) {
        return;
      }
      
      int pi = (i - 1) / 2;
      if (data.get(pi) > data.get(i)) {
        swap(pi, i);
        upheapify(pi);
      }
    }
    
    // O(log n)
    public void downheapify(int i) {
      int mini = i;
      
      int li = 2 * i + 1;
      if (li < data.size() && data.get(li) < data.get(mini)) {
        mini = li;
      }
      
      int ri = 2 * i + 2;
      if (ri < data.size() && data.get(ri) < data.get(mini)) {
        mini = ri;
      }
      
      if (mini != i) {
        swap(i, mini);
        downheapify(mini);
      }
    }
    
    public void swap(int i, int j) {
      int ith = data.get(i);
      int jth = data.get(j);
      data.set(i, jth);
      data.set(j, ith);
    }

    // O(1)
    public int size() {
      return data.size();
    }

  }

  public static void main(String[] args) throws Exception {
    int[] arr = {5, 15, 2, 22, 37, 92, 81, 47};
    MyPriorityQueue pq = new MyPriorityQueue(arr);

    while (pq.size() > 0) {
      int val = pq.peek();
      System.out.print(val + " ");
      pq.remove();
    }

  }
}