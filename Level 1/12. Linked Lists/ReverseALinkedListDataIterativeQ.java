import java.io.*;
import java.util.*;

public class ReverseALinkedListDataIterativeQ {

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

    // O(n)
    Node getNodeAt(int idx) {
      Node temp = head;
      for (int i = 0; i < idx; i++) { // idx 2 means 0,1,2
        temp = temp.next;
      }
      return temp;
    }

    // O(n2)
    void ReverseALinkedListDataIterative() {

      int i = 0;
      int j = size - 1;
      while (i < j) {
        Node leftNode = getNodeAt(i);
        Node rightNode = getNodeAt(j);

        int temp = leftNode.data;
        leftNode.data = rightNode.data;
        rightNode.data = temp;
        
        i++;
        j--;
      }
      
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

    list.display(); // 10, 20, 30, 40, 50, 60, 70
    list.ReverseALinkedListDataIterative();
    list.display(); // 70, 60, 50, 40, 30, 20, 10

  }

}
