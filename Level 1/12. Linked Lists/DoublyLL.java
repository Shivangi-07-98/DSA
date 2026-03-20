import java.io.*;
import java.util.*;

public class DoublyLL {

  public static class Node {
    int data; // value
    Node prev; // address of previous node
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
    void addFirst(int val) {
      Node temp = new Node();
      temp.data = val;

      if (size == 0) {
        head = tail = temp;
      } else {
        temp.next = head;
        head.prev = temp;
        head = temp;
      }

      size++;
    }

    // O(1)
    void addLast(int val) {
      Node temp = new Node();
      temp.data = val;

      if (size == 0) {
        head = tail = temp;
      } else {
        tail.next = temp;
        temp.prev = tail;
        tail = temp;
      }

      size++;
    }

    // O(n)
    void addAt(int idx, int val) {
      if (idx == 0) {
        addFirst(val);
      } else if (idx == size) {
        addLast(val);
      } else if (idx < 0 || idx > size) {
        System.out.println("Invalid arguments");
      } else {
        Node prevIdx = head;
        for (int i = 0; i < idx - 1; i++) {
          prevIdx = prevIdx.next;
        }
        Node nextIdx = prevIdx.next;

        Node temp = new Node();
        temp.data = val;

        prevIdx.next = temp;
        temp.prev = prevIdx;
        temp.next = nextIdx;
        nextIdx.prev = temp;

        size++;
      }
    }

    // O(n)
    void display() {
      for (Node temp = head; temp != null; temp = temp.next) {
        System.out.print(temp.data + " ");
      }
      System.out.println();
    }

    // O(1)
    int getFirst(){
      if (size == 0) {
        System.out.println("List is empty");
        return -1;
      } else {
        return head.data;
      }
    }

    // O(1)
    int getLast(){
      if (size == 0) {
        System.out.println("List is empty");
        return -1;
      } else {
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
      for (int i = 0; i < idx; i++) {
        temp = temp.next;
      }
      return temp.data;
    }

    void removeFirst(){
      if (size == 0) {
        System.out.println("List is empty");
      } else if (size == 1) {
        head = tail = null;
        size = 0;
      } else {
        head = head.next;
        head.prev = null;
        size--;
      }
    }

    void removeLast(){
      if (size == 0) {
        System.out.println("List is empty");
      } else if (size == 1) {
        head = tail = null;
        size = 0;
      } else {
        tail = tail.prev;
        tail.next = null;
        size--;
      }
    }

    void removeAt(int idx){
      if (idx < 0 || idx >= size) {
        System.out.println("Invalid arguments");
      } else if (idx == 0) {
        removeFirst();
      } else if (idx == size - 1) {
        removeLast();
      } else {
        Node temp = head;
        for (int i = 0; i < idx; i++) {
          temp = temp.next;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;
      }
    }

  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    list.addLast(10);
    list.addLast(20);
    list.addLast(30);
    list.display();

    list.addFirst(5);
    list.display();

    list.addAt(2, 100);
    list.display();

    System.out.println(list.getFirst());
    System.out.println(list.getLast());
    System.out.println(list.getAt(2));

    list.removeFirst();
    list.display();

    list.removeLast();
    list.display();

    list.removeAt(1);
    list.display();

    System.out.println(list.size());
  }

}
