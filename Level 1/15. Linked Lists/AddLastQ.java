import java.util.*;

public class AddLastQ {

  public static class Node {
    int data; // value
    Node next; // address of next node
  }

  public static class LinkedList {
    Node head;
    Node tail;
    int size;

    // o1
    public void addLast(int val) {
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

    // o1
    public void addFirst(int val) {
      Node node = new Node();
      node.data = val;

      if (size == 0) {
        head = tail = node;
      } else {
        node.next = node;
        head = node;
      }
      size++;
    }

    // o1
    public int size() {
      return size;
    }

    // on
    public void display() {
      for (Node temp = head; temp != null; temp = temp.next) {
        System.out.print(temp.data + " ");
      }
      System.out.println();
    }

    //
    public void removeFirst() {
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

    // o1
    public int getFirst() {
      if (size == 0) {
        System.out.println("List is empty");
        return -1;
      }
      return head.data;
    }

    // o1
    public int getLast() {
      if (size == 0) {
        System.out.println("List is empty");
        return -1;
      }
      return tail.data;
    }

    // on
    public int getAt(int idx) {
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

    
    public void addAt(int idx, int val) {
      if (idx == 0) {
        addFirst(val);
      } else if (idx == size) {
        addLast(val);
      } else if (idx < 0 || idx > size) {
        System.out.println("Invalid arguments");
      } else {
        Node nm1 = head;
        for (int i = 0; i < idx - 1; i++) {
          nm1 = nm1.next;
        }
        Node np1 = nm1.next;

        Node node = new Node();
        node.data = val;
        node.next = np1;

        nm1.next = node;
        size++;
      }
    }


    public int KthFromLast(int k){
      Node fast = head;
      Node slow = head;

      for(int i = 0; i < k; i++){
        fast = fast.next;
      }

      // there is a gap of k between fast and slow now
      while (fast != tail){
        fast = fast.next;
        slow = slow.next;
      }
      return slow.data;
    }

  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.display();
    list.addLast(10);
    list.display();
    list.addLast(20);
    list.display();
    list.addLast(30);
    list.display();
    // list.addAt(0, 100);
  }

}
