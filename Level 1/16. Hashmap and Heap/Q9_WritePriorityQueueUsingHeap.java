import java.io.*;
import java.util.*;
// O(n) > log(n) > O(1)

// add log(n)
// remove log(n)
// peek O(1)

// linked list(sorted) approach -> peek O(1), remove O(1), add O(n) 
// linked list(unsorted) approach -> peek O(n), remove O(n), add O(1) 

// priority queue heap data structure se implement hoti hai = using 2 properties hop, cbt
// HOP = heap order property (binary tree hi hota hai)
// CBT = complete binary tree

// hop = Parent would have higher priority then both the children
// cbt = mtlb parent then left child then right child, aisa nhi hoga pehle right child hoga and left child hai hi nhi
// 1 node then parent, 2 node parent and left child, 3 node parent and left and right child, 4 node parent and left and right child and left child's left child
// arraylist implementation enabled = add remove log(n)
public class Q9_WritePriorityQueueUsingHeap {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
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
    public int peek() {
      if (data.size() == 0) {
        System.out.println("Underflow");
        return -1;
      }
      return data.get(0);
    }

    // O(1)
    public int size() {
      return data.size();
    }

  }

  public static void main(String[] args) throws Exception {
    PriorityQueue qu = new PriorityQueue();
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
// priority queue implement krni hai heap data structure ke through in which add log(n)remove log(n) peek O(1)
// heap binary tree hota hai having HOP and CBT property
// add aur remove ki complexity log(n) mai krne ke liye arraylist se tree implement kre kuki euler O(n) ka hota hai 
// 
