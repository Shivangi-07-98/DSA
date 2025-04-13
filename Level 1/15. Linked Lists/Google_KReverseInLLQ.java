import java.io.*;
import java.util.*;

// abc def ghi jk => cba fed ihg jk only reverse 3 pairs because k = 3 
public class Google_KReverseInLLQ {

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

    void kReverse(int k) {
      LinkedList prev = null;
      LinkedList curr = new LinkedList();

      while (size() > 0) {

        if (size() < k) {
          int sz = size();
          for (int i = 0; i < sz; i++) {
            int val = getFirst();
            removeFirst();
            curr.addLast(val);
          }
        } else {
          for (int i = 0; i < k; i++) {
            int val = getFirst();
            removeFirst();
            curr.addFirst(val);
          }
        }

        if (prev == null) {
          prev = curr;
          curr = new LinkedList();
        } else {
          // prev = curr;
          prev.tail.next = curr.head;
          prev.tail = curr.tail;
          prev.size += curr.size;
          curr = new LinkedList();
        }

      }

      head = prev.head;
      tail = prev.tail;
      size = prev.size;
    }

  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    list.addLast(10);
    list.addLast(20);
    list.addLast(30);
    list.addLast(40);
    list.addLast(50);
    list.addLast(60);
    list.addLast(70);
    list.addLast(80);

    list.display(); // 10, 20, 30, 40, 50, 60, 70, 80
    list.kReverse(3);
    list.display(); // 30, 20, 10, 60, 50, 40, 70, 80

  }

}
