import java.io.*;
import java.util.*;

public class AddTwoLLQ {

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

    void removeFirst(){
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

    // O(n)
    void display() {
      for(Node temp = head; temp != null; temp = temp.next){
        System.out.print(temp.data + " ");
      }
      System.out.println();

    }

    
    // o1
    public void addFirst(int val) {
      Node node = new Node();
      node.data = val;

      if (size == 0) {
        head = tail = node;
      } else {
        node.next = head;
        head = node;
      }
      size++;
    }


    // public static LinkedList AddTwoLL(LinkedList one, LinkedList two) {
      
    // }

    
    private static int addHelper(Node one, Node two, int pio, int pit, LinkedList res){
      if(one == null && two == null){
        return 0;
      }

      int data = 0;
      int carry = 0;

      if(pio > pit){
        carry = addHelper(one.next, two, pio - 1, pit, res);
        data = carry + one.data;
      }
      else if(pit > pio){
        carry = addHelper(one, two.next, pio, pit - 1, res);
        data = carry + two.data;
      }
      else{
        carry = addHelper(one.next, two.next, pio - 1, pit - 1, res);
        data = carry + one.data + two.data;
      }

      carry = data / 10;
      data = data % 10;

      res.addFirst(data);
      return carry;
      
    }

    public static LinkedList addTwoLists(LinkedList one, LinkedList two){
      LinkedList res = new LinkedList();
      int carry = addHelper(one.head, two.head, one.size, two.size, res);
      if(carry > 0){
        res.addFirst(carry);
      }
      return res;
    }


 
  }




  public static void main(String[] args) {
    LinkedList list1 = new LinkedList();

    list1.addLast(9);
    list1.addLast(5);
    list1.addLast(4);
    list1.addLast(7);
    list1.addLast(6);

    LinkedList list2 = new LinkedList();

    list2.addLast(7);
    list2.addLast(8);
    list2.addLast(7);

    list1.display();
    list2.display();

    LinkedList sum = LinkedList.addTwoLists(list1, list2);
    sum.display();

  }

}
