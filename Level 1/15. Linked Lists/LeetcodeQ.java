import java.io.*;
import java.util.*;

public class LeetcodeQ {

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  // 876. Middle of the Linked List
  public ListNode middleNode(ListNode head) {
    if (head == null || head.next == null)
      return head;

    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  // 206. Reverse Linked List
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null)
      return head;

    ListNode prev = null, curr = head;
    while (curr != null) {
      ListNode forw = curr.next;

      curr.next = prev;

      prev = curr;
      curr = forw;
    }
    return prev;
  }

  // 143. Reorder List
  public void reorderList(ListNode head) {
    
  }

  // 21. Merge Two Sorted Lists 
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode ans = new ListNode();
    return ans;
  }

  // 23. Merge k Sorted Lists 
  public ListNode mergeKLists(ListNode[] lists) {
    ListNode ans = new ListNode();
    return ans;
  }

  public static void main(String[] args) {
  }

}
