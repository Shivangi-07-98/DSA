import java.io.*;
import java.util.*;

public class GetValueQ {

  public static class Node {
    int data; // value
    Node next; // address of next node
  }

  public static class LinkedList {
    Node head; // address of first node
    Node tail; // address of last node
    int size; // value

    // O(1)
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

    // O(1)
    int getFirst(){
      if(size == 0){
        System.out.println("List is empty");
        return -1;
      }
      else{
        return head.data;
      }
    }

    // O(1)
    int getLast(){
      if(size == 0){
        System.out.println("List is empty");
        return -1;
      }
      else{
        return tail.data;
      }
    }

    // O(n)
    int getAt(int idx){

      if (size == 0) {
        System.out.println("List is empty");
        return -1;
      } else if (idx < 0 || idx >= size) {
        System.out.println("Invalid arguments");
        return -1;
      }

      Node temp = head;
      for(int i = 0; i < idx; i++){ // idx 2 means 0,1,2
        temp = temp.next;
      }
      return temp.data;
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

    // list.getFirst();
    // list.getLast();
    int ans = list.getAt(3);
    System.out.println(ans);

  }

}
