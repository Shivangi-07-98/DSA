import java.io.*;
import java.util.*;

public class AddAtIndexQ {

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

    // 4, 1000
    void addAt(int idx, int val) { // 10 20 30 40 50 => 10 20 30 40 1000 50

      if (idx == 0) {
        addFirst(val);
      } else if (idx == size) {
        addLast(val);
      } else if (idx < 0 || idx > size) {
        System.out.println("Invalid arguments");
      } else {
        Node prevIdx = head;

        for (int i = 0; i < idx - 1; i++) {
          prevIdx = prevIdx.next;
        }

        Node nextIdx = prevIdx.next;

        Node temp = new Node();
        temp.data = val;
        temp.next = nextIdx;

        prevIdx.next = temp;
        size++;
      }

    }

    // O(n)
    void display() {
      for (Node temp = head; temp != null; temp = temp.next) {
        System.out.print(temp.data + " ");
      }
      System.out.println();

    }

  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    list.addLast(10);
    // list.display();
    // System.out.println(list.size());

    list.addLast(20);
    // list.display();
    // System.out.println(list.size());

    list.addLast(30);
    list.addLast(40);
    list.addLast(50);

    list.addAt(4, 1000);
    list.display(); // 10 20 30 40 50 => 10 20 30 40 1000 50

  }

}
