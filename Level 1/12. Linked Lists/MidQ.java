import java.io.*;
import java.util.*;

public class MidQ {

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

    int mid1() {
      int val = size / 2;
      Node temp = head;
      for (int i = 0; i < val -1; i++) {
        temp = temp.next;
      }
      if (size % 2 == 0) { // even
        return temp.data;
      } else { // odd
        return temp.next.data;
      }

    }

    int mid2(){
      Node fast = head;
      Node slow = head;
      while(fast.next != null && fast.next.next != null){
      // while(fast != tail && fast.next != tail){
        fast = fast.next.next;
        slow = slow.next;
      }

      return slow.data;
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
    list.addLast(60);
    list.addLast(70);

    // System.out.println(list.size());

    // int ans = list.mid1();
    // System.out.println(ans);

    int ans = list.mid2();
    System.out.println(ans);

  }

}
