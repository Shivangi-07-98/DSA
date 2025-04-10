import java.io.*;
import java.util.*;

public class BasicSetupLL {

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

    void addLast(int val) {
      
    }

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
    list.display();
    System.out.println(list.size());

  }

}
