import java.io.*;
import java.util.*;

public class MergeSortLLQ {

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
      while (one != null && two != null) {
        if (one.data < two.data) {
          res.addLast(one.data);
          one = one.next;
        } else {
          res.addLast(two.data);
          two = two.next;
        }
      }

      while (one != null) {
        res.addLast(one.data);
        one = one.next;
      }

      while (two != null) {
        res.addLast(two.data);
        two = two.next;
      }

      return res;
    }

    public static Node mid(Node num1, Node num2) {
      Node fast = num1;
      Node slow = num1;
      while (fast != num2 && fast.next != num2) {
        // while(fast != tail && fast.next != tail){
        fast = fast.next.next;
        slow = slow.next;
      }

      return slow;
    }

    public static LinkedList mergeSort(Node head, Node tail) {

      if(head == tail){
        LinkedList baseList = new LinkedList();
        baseList.addLast(head.data);
        return baseList;
      }

      Node mid = mid(head, tail);
      LinkedList fsh = mergeSort(head, mid);
      LinkedList ssh = mergeSort(mid.next, tail);
      LinkedList fullSortedList = MergeTwoSortedLL(fsh, ssh);
      return fullSortedList;
    }

  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    list.addLast(55);
    list.addLast(66);
    list.addLast(10);
    list.addLast(20);
    list.addLast(11);
    list.addLast(15);
    list.addLast(17);
    list.addLast(19);
    list.addLast(33);
    list.addLast(30);
    list.addLast(40);
    list.addLast(50);

    Node midNode = LinkedList.mid(list.head, list.tail);
    System.out.println(midNode.data);

    list.display(); // 55, 66, 10, 20, 11, 15, 17, 19, 33, 30, 40, 50
    LinkedList ans = LinkedList.mergeSort(list.head, list.tail);
    ans.display(); // 10, 11, 15, 17, 19, 20, 30, 33, 40, 50, 55, 66

  }

}
