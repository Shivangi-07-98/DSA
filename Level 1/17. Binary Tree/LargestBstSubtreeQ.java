import java.util.*;

public class LargestBstSubtreeQ { 

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

// node isbst true when all to the left are smaller and all to the right are greater
// tree isbst = all nodes isbst true
  public static class BstTriplet{ 
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    boolean isBst = true;
  }
  public static BstTriplet IsBst(Node node){
    if(node == null){
      return new BstTriplet();
    }

    BstTriplet lt = IsBst(node.left);
    BstTriplet rt = IsBst(node.right);

    BstTriplet mt = new BstTriplet();
    mt.min = Math.min(node.data, Math.min(lt.min, rt.min));
    mt.max = Math.max(node.data, Math.max(lt.max, rt.max));

    boolean nodeIsbst = node.data > lt.max && node.data < rt.min;
    mt.isBst = (lt.isBst == true) && (rt.isBst == true) && (nodeIsbst == true);
    
    return mt;
  }

  public static void main(String[] args) {
    Integer[] arr = new Integer[] { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null,
        87, null, null }; // capital integer array has null
    Node root = construct(arr);

    BstTriplet at = IsBst(root);
    System.out.println(at.isBst);
    
  }

}
