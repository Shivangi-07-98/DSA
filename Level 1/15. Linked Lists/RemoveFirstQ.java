import java.io.*;
import java.util.*;

public class RemoveFirstQ {

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

    list.removeFirst();
    list.display();

  }

}
