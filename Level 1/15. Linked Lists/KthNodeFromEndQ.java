import java.io.*;
import java.util.*;

public class KthNodeFromEndQ {

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

    // 3
    int KthNodeFromEnd(int idx){ // 10, 20, 30, 40, 50, 60 => 40

      Node a = head;
      Node b = head;
      for(int i = 0; i < idx; i++){
        a = a.next;
      }

      while(a.next != null){
        a = a.next;
        b = b.next; 

      }

      return b.next.data; // if asked on position
      // return b.data; // if asked on idx
      
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

    int ans = list.KthNodeFromEnd(3); // 10, 20, 30, 40, 50, 60 => 40
    System.out.println(ans); 


  }

}
