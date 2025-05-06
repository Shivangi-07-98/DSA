import java.util.*;

public class Amazon_PrintNodesKDistanceAwayQ {

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

  public static boolean find(Node node, int data) {
    if (node == null) {
      return false;
    }
    if (node.data == data) {
      return true;
    }

    boolean ans1 = find(node.left, data);
    if (ans1 == true) {
      return true;
    }
    boolean ans2 = find(node.right, data);
    if (ans2 == true) {
      return true;
    }

    return false;
  }

  public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
    if (node == null) {
      return new ArrayList<>();
    }
    if (node.data == data) {
      ArrayList<Integer> bres = new ArrayList<>();
      bres.add(node.data);
      return bres;
    }

    ArrayList<Integer> ans1 = nodeToRootPath(node.left, data);
    if (ans1.size() > 0) {
      ans1.add(node.data);
      return ans1;
    }

    ArrayList<Integer> ans2 = nodeToRootPath(node.right, data);
    if (ans2.size() > 0) {
      ans2.add(node.data);
      return ans2;
    }

    return new ArrayList<>();
  }

  public static void main(String[] args) {
    Integer[] arr = new Integer[] { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null,
        87, null, null }; // capital integer array has null
    Node root = construct(arr);
    // display(root);
    // levelOrderLinewise4(root);
    boolean ans = find(root, 70);
    System.out.println(ans);

    ArrayList<Integer> path = nodeToRootPath(root, 70);
    System.out.println(path);

  }

}
