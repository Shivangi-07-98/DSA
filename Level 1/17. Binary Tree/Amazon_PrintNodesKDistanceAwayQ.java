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
  
  public static ArrayList<Node> nodeToRootPath(Node node, int data) {
    if (node == null) {
      return new ArrayList<>();
    }
    if (node.data == data) {
      ArrayList<Node> bres = new ArrayList<>();
      bres.add(node);
      return bres;
    }

    ArrayList<Node> ans1 = nodeToRootPath(node.left, data);
    if (ans1.size() > 0) {
      ans1.add(node);
      return ans1;
    }

    ArrayList<Node> ans2 = nodeToRootPath(node.right, data);
    if (ans2.size() > 0) {
      ans2.add(node);
      return ans2;
    }

    return new ArrayList<>();
  }

  public static void printKLevelsDown(Node node, int k, Node blocker){
    if(node == null || k < 0 || node == blocker){
      return;
    }
    if(k == 0){
      System.out.print(node.data + " ");
      return;
    }
    printKLevelsDown(node.left, k - 1, blocker);
    printKLevelsDown(node.right, k - 1, blocker);
  }
  
  public static void printKNodesFar(Node node, int data, int k){
    ArrayList<Node> n2rpath = nodeToRootPath(node, data);
    for(int i = 0; i < n2rpath.size(); i++){
      // printKLevelsDown(node, k, node);
      printKLevelsDown(n2rpath.get(i), k - i, i > 0 ? n2rpath.get(i - 1) : null);
    }
  }

  public static void main(String[] args) {
    Integer[] arr = new Integer[] { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null,
        87, null, null }; // capital integer array has null
    Node root = construct(arr);
    printKNodesFar(root, 70, 3);
  }

}
