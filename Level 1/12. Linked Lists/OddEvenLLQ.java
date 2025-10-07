// hint to solve ques => make two list odd and even then connect both and make (this) point to this list
// if both odd even present then this check odd.size > 0 && even.size > 0
// if only odd present
// if only even present

import java.io.*;
import java.util.*;

public class OddEvenLLQ {

  public static class Node {
    int data; // value
    Node next; // address of next node
  }

  public static class LinkedList {
    Node head; // address of first node
    Node tail; // address of last node
    int size; // value

    int size() {
      return size;
    }

    // O(1)
    void addLast(int val) {
      Node temp = new Node();
      temp.data = val;
      temp.next = null;

      if (size == 0) {
        head = tail = temp;
      } else {
        tail.next = temp;
        tail = temp;
      }

      size++;
    }

    // O(n)
    void display() {
      for (Node temp = head; temp != null; temp = temp.next) {
        System.out.print(temp.data + " ");
      }
      System.out.println();

    }

    // o1
    public int getFirst() {
      if (size == 0) {
        System.out.println("List is empty");
        return -1;
      }
      return head.data;
    }

    // O(1)
    void addFirst(int val) {
      Node temp = new Node();
      temp.data = val;

      if (size == 0) {
        // temp.next = null;
        head = tail = temp;
      } else {
        temp.next = head;
        head = temp;
      }

      size++;
    }

    public void removeFirst() {
      if (size == 0) {
        System.out.println("List is empty");
      } else if (size == 1) {
        head = tail = null;
        size = 0;
      } else {
        head = head.next;
        size--;
      }
    }

    void OddEven() {
      LinkedList odd = new LinkedList();
      LinkedList even = new LinkedList();

      while (size > 0) {
        int val = this.getFirst();
        this.removeFirst();

        if (val % 2 != 0) {
          odd.addLast(val);
        } else {
          even.addLast(val);
        }
      }

      if (odd.size > 0 && even.size > 0) {
        odd.tail.next = even.head;
        this.head = odd.head;
        this.tail = even.tail;
        this.size = odd.size + even.size;
      } else if (odd.size > 0) {
        this.head = odd.head;
        this.tail = odd.tail;
        this.size = odd.size;
      } else if (even.size > 0) {
        this.head = even.head;
        this.tail = even.tail;
        this.size = even.size;
      }

    }

  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    list.addLast(2);
    list.addLast(8);
    list.addLast(9);
    list.addLast(1);
    list.addLast(5);
    list.addLast(4);
    list.addLast(3);

    list.display(); // 2, 8, 9, 1, 5, 4, 3
    list.OddEven();
    list.display(); // 9, 1, 5, 3, 2, 8, 4

  }

}
