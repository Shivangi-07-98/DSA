import java.io.*;
import java.util.*;

public class FoldaLLQ {

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


    void foldHelper(Node right, int floor) {
      if (right == null) {
        return;
      }
      foldHelper(right.next, floor + 1);
      if (floor >= size / 2) {
        int temp = left.data;
        left.data = right.data;
        right.data = temp;
        left = left.next;
      }

    }

    Node left = null;
    void fold() {
      left = head;
      foldHelper(head, 0);
    }

  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);
    list.addLast(5);

    list.display(); // 1, 2, 3, 4, 5
    list.fold();
    list.display(); // 1, 5, 2, 4, 3
    // 1 2 3 4 5 6 => 1 6 2 5 3 4

  }

}
