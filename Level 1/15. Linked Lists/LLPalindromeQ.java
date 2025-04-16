import java.io.*;
import java.util.*;

public class LLPalindromeQ {

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

    boolean isPalindromeHelper(Node right) {
      if (right == null) {
        return true;
      }
      boolean res = isPalindromeHelper(right.next);
      if (res == false) {
        return false;
      } else if (left.data != right.data) {
        return false;
      } else {
        left = left.next;
        return true;
      }

    }

    Node left = null;
    boolean isPalindrome() {
      left = head;
      return isPalindromeHelper(head);
    }

  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    list.addLast(5);
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);
    list.addLast(20);
    list.addLast(10);
    list.addLast(5);

    list.display(); 
    boolean ans = list.isPalindrome();
    System.out.println(ans);

  }

}
