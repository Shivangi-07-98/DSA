import java.util.*;

public class IsBalancedTreeQ { 

  public static class Node {
    int data;
    Node left;
    Node right;
  }

  public static class Pair {
    Node node;
    int state;
  }

  public static Node construct(Integer[] arr) {
    Stack<Pair> stack = new Stack<>();

    Node root = new Node();
    root.data = arr[0];

    // main lines
    Pair rootp = new Pair();
    rootp.node = root;
    rootp.state = 1;

    stack.push(rootp);
    int idx = 1;

    while (stack.size() > 0) {
      Pair peekp = stack.peek();

      if (peekp.state == 1) {
        // left
        if (arr[idx] != null) {
          Node lc = new Node();
          lc.data = arr[idx];
          peekp.node.left = lc;

          Pair lp = new Pair();
          lp.node = lc;
          lp.state = 1;

          stack.push(lp);
        }
        peekp.state++;
        idx++;
      } else if (peekp.state == 2) {
        // right
        if (arr[idx] != null) {
          Node rc = new Node();
          rc.data = arr[idx];
          peekp.node.right = rc;

          Pair rp = new Pair();
          rp.node = rc;
          rp.state = 1;

          stack.push(rp);
        }
        peekp.state++;
        idx++;
      } else if (peekp.state == 3) {
        // pop
        stack.pop();
      }
    }
    return root;
  }

  // leftNode parentNode rightNode
  public static void display(Node node) {
    if (node == null) {
      return;
    }
    String str = " <- " + node.data + " -> ";
    String lcstr = node.left == null ? ".." : "" + node.left.data;
    String rcstr = node.right == null ? ".." : "" + node.right.data;
    System.out.println(lcstr + str + rcstr);

    display(node.left); // will print the entire left tree
    display(node.right); // will print the entire right tree
  }

  public static void levelOrderLinewise1(Node node) {
    ArrayDeque<Node> pq = new ArrayDeque<>();
    ArrayDeque<Node> cq = new ArrayDeque<>();

    pq.add(node);
    while (pq.size() > 0) {
      Node temp = pq.remove();
      System.out.print(temp.data + " ");

      if (temp.left != null) {
        cq.add(temp.left);
      }
      if (temp.right != null) {
        cq.add(temp.right);
      }

      if (pq.size() == 0) {
        pq = cq;
        cq = new ArrayDeque<>();
        System.out.println();
      }
    }
  }

  public static int height(Node node) {
    if (node == null) {
      return -1; // edges -1, nodes 0
    }
    int lh = height(node.left);
    int rh = height(node.right);
    int height = Math.max(lh, rh) + 1;
    return height;
  }

// left ht               right ht
// gap abs[lht-rht]      isb = true/false

// is balanced true when abs[left ht-right ht] <= 1
// node isb 
// tree isb = all nodes isb true
  public static boolean treeIsbal = true;
  public static int IsBalanced(Node node){
    if (node == null) {
      return -1; // edges -1, nodes 0
    }

    int lh = IsBalanced(node.left);
    int rh = IsBalanced(node.right);
    int ht = Math.max(lh, rh) + 1;

    boolean nodeIsbal = Math.abs(lh-rh) <= 1;
    if(nodeIsbal == false){
      treeIsbal = false;
    }
    
    return ht;
  }

  public static class BalPair{
    int ht = -1;
    boolean isBal = true;
  }
  public static BalPair IsBalanced2(Node node){
    if(node == null){
      BalPair bp = new BalPair();
      // bp.ht = -1;
      // bp.isBal = true;
      return bp;
    }

    BalPair lp = IsBalanced2(node.left);
    BalPair rp = IsBalanced2(node.right);

    BalPair mp = new BalPair();
    mp.ht = Math.max(lp.ht, rp.ht) + 1; 

    boolean nodeIsbal = Math.abs(lp.ht - rp.ht) <= 1;
    mp.isBal = (lp.isBal == true) && (rp.isBal == true) && (nodeIsbal == true);
    
    return mp;
  }

  public static void main(String[] args) {
    Integer[] arr = new Integer[] { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null,
        87, null, null }; // capital integer array has null
    Node root = construct(arr);

    IsBalanced(root);
    System.out.println(treeIsbal);

    BalPair ap = IsBalanced2(root);
    System.out.println(ap.isBal);
    
  }

}
