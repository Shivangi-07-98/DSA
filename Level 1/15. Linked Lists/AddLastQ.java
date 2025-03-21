// import java.util.*;

public class AddLastQ {

  public static class Node {
    int data; // value
    Node next; // address of next node
  }

  public static class LinkedList {
    Node head; // address of first node
    Node tail; // address of last node
    int size; // value

    // o(n)
    public void display() {
      if (size == 0) {
        return;
      }
      for (Node temp = head; temp != null; temp = temp.next) {
        System.out.print(temp.data + " ");
      }
      System.out.println();
    }

    // o(1)
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

    public int KthFromLast(int k) {
      Node fast = head;
      Node slow = head;

      for (int i = 0; i < k; i++) {
        fast = fast.next;
      }

      // there is a gap of k between fast and slow now
      while (fast != tail) {
        fast = fast.next;
        slow = slow.next;
      }
      return slow.data;
    }

    public int mid() {
      Node fast = head;
      Node slow = head;

      while (fast.next != null && fast.next.next != null) {
        fast = fast.next.next;
        slow = slow.next;
      }
      return slow.data;
    }

    // reverseDI n2
    public Node getNodeAt(int idx) {
      Node temp = head;
      for (int i = 0; i < idx; i++) {
        temp = temp.next;
      }
      return temp;
    }

    public void reverseDI() {
      int li = 0;
      int ri = size - 1;
      while (li < ri) {
        Node left = getNodeAt(li);
        Node right = getNodeAt(ri);

        int temp = left.data;
        left.data = right.data;
        right.data = temp;

        li++;
        ri--;
      }
    }

    public void reversePI() {
      Node prev = null;
      Node curr = head;

      while (curr != null) {
        Node next = curr.next;
        curr.next = prev;

        prev = curr;
        curr = next;
      }

      Node temp = head;
      head = tail;
      tail = temp;
    }

    public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
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

    public static Node midNode(Node head, Node tail) {
      Node fast = head;
      Node slow = head;

      while (fast != tail && fast.next != tail) {
        fast = fast.next.next;
        slow = slow.next;
      }
      return slow;
    }

    public static LinkedList mergeSort(Node head, Node tail) {
      if (head == tail) {
        LinkedList baseList = new LinkedList();
        baseList.addLast(head.data);
        return baseList;
      }

      Node mid = midNode(head, tail);
      LinkedList fsh = mergeSort(head, mid);
      LinkedList ssh = mergeSort(mid.next, tail);
      LinkedList fullSortedList = mergeTwoSortedLists(fsh, ssh);
      return fullSortedList;

    }

    public void removeDuplicates() {
      LinkedList res = new LinkedList();

      while (this.size() > 0) {
        int val = this.getFirst();
        this.removeFirst();

        if (res.size == 0 || res.tail.data != val) {
          res.addLast(val);
        }
      }

      this.head = res.head;
      this.tail = res.tail;
      this.size = res.size;
    }

    public void kReverse(int k) {
      LinkedList prev = null;
      LinkedList curr = new LinkedList();

      while (this.size() > 0) {

        if (this.size() < k) {
          int sz = this.size();

          for (int i = 0; i < sz; i++) {
            int val = this.getFirst();
            this.removeFirst();
            curr.addLast(val);
          }
        } else {
          for (int i = 0; i < k; i++) {
            int val = this.getFirst();
            this.removeFirst();
            curr.addFirst(val);
          }
        }

        if (prev == null) {
          prev = curr;
          curr = new LinkedList();
        } else {
          prev.tail.next = curr.head;
          prev.tail = curr.tail;
          prev.size += curr.size;
          curr = new LinkedList();
        }
      }

      this.head = prev.head;
      this.tail = prev.tail;
      this.size = prev.size;
    }

    public void oddEven() {
      LinkedList odd = new LinkedList();
      LinkedList even = new LinkedList();

      while (this.size() > 0) {
        int val = this.getFirst();
        this.removeFirst();

        if (val % 2 == 0) {
          even.addLast(val);
        } else {
          odd.addLast(val);
        }
      }

      odd.tail.next = even.head;
      this.head = odd.head;
      this.tail = even.tail;
      this.size = odd.size + even.size;

      if (odd.size > 0 && even.size > 0) {
        odd.tail.next = even.head;
        this.head = odd.head;
        this.tail = even.tail;
        this.size = odd.size + even.size;
      } else if (odd.size > 0) {
        this.head = odd.head;
        this.tail = odd.tail;
        this.size = odd.size;
      } else if (even.size > 0) {
        this.head = even.head;
        this.tail = even.tail;
        this.size = even.size;
      }

    }

    private void displayReverseHelper(Node node) {
      if (node == null) {
        return;
      }
      displayReverseHelper(node.next);
      System.out.print(node.data + " ");
    }

    public void displayReverse() {
      displayReverseHelper(head);
      System.out.println();
    }

    public void removeLast() {
      if (size == 0) {
        System.out.println("List is empty");
      } else if (size == 1) {
        head = tail = null;
        size = 0;
      } else {
        Node s1 = head;
        for (int i = 0; i < size - 2; i++) {
          s1 = s1.next;
        }

        this.tail = s1;
        this.tail.next = null;
        this.size--;

      }
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

    private void reversePRHelper(Node node) {
      if (node.next == null) {
        return;
      }
      reversePRHelper(node.next);
      node.next.next = node;
    }

    public void reversePR() {
      reversePRHelper(head);
      Node temp = head;
      head = tail;
      tail = temp;
      tail.next = null;
    }


    // The most important question (infinitely)
    private void reverseDRHelper(Node right, int floor){
      if(right == null){
        return;
      }
      reverseDRHelper(right.next, floor + 1);
      if(floor >= size / 2){
        int temp = left.data;
      left.data = right.data;
      right.data = temp;
      left = left.next;
      } 
    }

    Node left = null;

    public void reverseDR() {
      left = head;
      reverseDRHelper(head, 0);
    }


    private boolean IsPalindromeHelper(Node right){
      if(right == null){
        return true;
      }
      boolean res = IsPalindromeHelper(right.next);
      if(res == false){
        return false;
      }
      else if(left.data != right.data){
        return false;
      }
      else{
        left = left.next;
        return true;
      }
    }

    // Node left = null;
    public boolean IsPalindrome(){
      left = head;
      return IsPalindromeHelper(head);
    }


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
    LinkedList list = new LinkedList();
    // list.display();
    list.addLast(10);
    // list.display();
    list.addLast(20);
    // list.display();
    list.addLast(30);
    list.addLast(40);
    list.display();
    int val = list.KthFromLast(0);
    System.out.println(val);
  }

}
