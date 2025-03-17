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
  

  public static void main(String[] args) {
  }

}
