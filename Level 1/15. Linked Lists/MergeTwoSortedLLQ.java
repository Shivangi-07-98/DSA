import java.io.*;
import java.util.*;

public class MergeTwoSortedLLQ {

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

    public static LinkedList MergeTwoSortedLL(LinkedList l1, LinkedList l2) {
      LinkedList res = new LinkedList();

      Node one = l1.head;
      Node two = l2.head;
      while (one != null && two != null) {
        if (one.data < two.data) {
          res.addLast(one.data);
          one = one.next;
        } else {
          res.addLast(two.data);
          two = two.next;
        }
      }

      if (one == null) {
        while (two != null) {
          res.addLast(two.data);
          two = two.next;
        }
      } else if (two == null) {
        while (one != null) {
          res.addLast(one.data);
          one = one.next;
        }
      }

      return res;
    }


    public static LinkedList MyMergeTwoSortedLL(LinkedList l1, LinkedList l2) {
      LinkedList res = new LinkedList();

      Node one = l1.head;
      Node two = l2.head;
      while(one != null && two != null){
        if(one.data < two.data){
          res.addLast(one.data);
          one = one.next;
        }
        else{
          res.addLast(two.data);
          two = two.next;
        }
      }

      while(one != null){
        res.addLast(one.data);
          one = one.next;
      }

      while(two != null){
        res.addLast(two.data);
          two = two.next;
      }

      return res;
    }

  }

  public static void main(String[] args) {
    LinkedList list1 = new LinkedList();

    list1.addLast(10);
    list1.addLast(20);
    list1.addLast(30);
    list1.addLast(40);
    list1.addLast(50);

    list1.display(); // 10, 20, 30, 40, 50

    LinkedList list2 = new LinkedList();

    list2.addLast(11);
    list2.addLast(15);
    list2.addLast(17);
    list2.addLast(19);
    list2.addLast(33);
    list2.addLast(55);
    list2.addLast(66);

    list2.display(); // 11, 15, 17, 19, 33, 55, 66

    LinkedList ans = LinkedList.MyMergeTwoSortedLL(list1, list2); // 10, 11, 15, 17, 19, 20, 30, 33, 40, 50, 55, 66
    ans.display();

  }

}
