import java.io.*;
import java.util.*;

public class IntersectionPointOfLLQ {

  public static class Node {
    int data; // value
    Node next; // address of next node
  }

  public static class LinkedList {
    Node head; // address of first node
    Node tail; // address of last node
    int size; // value

    int size(){
      return size;
    }

    // O(1)
    void addLast(int val) {
      Node temp = new Node();
      temp.data = val;
      temp.next = null;

      if(size == 0){
        head = tail = temp;
      }
      else{
        tail.next = temp;
        tail = temp;
      }
      
      size++;
    }

    // O(n)
    void display() {
      for(Node temp = head; temp != null; temp = temp.next){
        System.out.print(temp.data + " ");
      }
      System.out.println();

    }

    
    public static int findIntersection(LinkedList one, LinkedList two) {

      Node otemp = one.head;
      Node ttemp = two.head;

      int gap = Math.abs(one.size - two.size);
      if (one.size > two.size) {
        for (int i = 0; i < gap; i++) {
          otemp = otemp.next;
        }
      } else if (two.size > one.size) {
        for (int i = 0; i < gap; i++) {
          ttemp = ttemp.next;
        }
      }

      while (otemp != ttemp) {
        otemp = otemp.next;
        ttemp = ttemp.next;
      }

      return otemp.data;
    }


    // public static int findIntersection(LinkedList one, LinkedList two){

    //   return 0;
    // }

  }



  public static void main(String[] args) {
    LinkedList list1 = new LinkedList();
    LinkedList list2 = new LinkedList();

    // Create common nodes that will be shared
    Node commonNode1 = new Node();
    commonNode1.data = 50;
    
    Node commonNode2 = new Node();
    commonNode2.data = 60;
    
    Node commonNode3 = new Node();
    commonNode3.data = 70;
    
    commonNode1.next = commonNode2;
    commonNode2.next = commonNode3;
    commonNode3.next = null;

    // 10, 20, 30, 40, 50, 60, 70
    list1.addLast(10);
    list1.addLast(20);
    list1.addLast(30);
    list1.addLast(40);
    list1.tail.next = commonNode1;
    list1.tail = commonNode3;
    list1.size += 3;

    // 100, 200, 50, 60, 70
    list2.addLast(100);
    list2.addLast(200);
    list2.tail.next = commonNode1;
    list2.tail = commonNode3;
    list2.size += 3;

    int inter = LinkedList.findIntersection(list1, list2);
    System.out.println(inter); 
  }

}
