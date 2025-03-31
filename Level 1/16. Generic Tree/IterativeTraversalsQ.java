import java.util.*;

public class IterativeTraversalsQ {

  public static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();

    Node(int data) {
      this.data = data;
    }
  }

  public static void levelOrder(Node root) {
    Queue<Node> queue = new ArrayDeque<Node>();
    queue.add(root);

    while (queue.size() > 0) {
      // remove, print, add
      Node temp = queue.remove();
      System.out.print(temp.data + " ");
      for (Node child : temp.children) {
        queue.add(child);
      }
    }

    System.out.println(".");
  }

  public static void levelOrderLinewise(Node root) {
    Queue<Node> queue = new ArrayDeque<Node>();
    Queue<Node> cqueue = new ArrayDeque<Node>();
    queue.add(root);

    while (queue.size() > 0) {
      Node temp = queue.remove();
      System.out.print(temp.data + " ");

      for (Node child : temp.children) {
        cqueue.add(child);
      }

      if (queue.size() == 0) {
        queue = cqueue;
        cqueue = new ArrayDeque<>();
        System.out.println(".");
      }
    }
  }

  public static Node construct(int[] arr) {
    // using the array create a tree and return root
    Node root = null;
    Stack<Node> stack = new Stack<>();

    for (int val : arr) {
      if (val != -1) {
        Node node = new Node(val);
        stack.push(node);
      } else {
        Node node = stack.pop();

        if (stack.size() > 0) {
          Node parent = stack.peek();
          parent.children.add(node);
        } else {
          root = node;
        }
      }
    }
    return root;
  }

  public static void preorder(Node node) {
    System.out.print(node.data + " ");
    for (Node child : node.children) {
      preorder(child);
    }
  }

  public static class Pair {
    int state;
    Node node;
  }

  public static void main(String[] args) {
    int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
        -1 };
    Node root = construct(arr);
    // preorder(root);

    String preorder = "";
    String postorder = "";
    Stack<Pair> stack = new Stack<>();

    Pair rootp = new Pair();
    rootp.state = -1;
    rootp.node = root;

    stack.push(rootp);

    while (stack.size() > 0) {
      Pair peekp = stack.peek();

      if (peekp.state == -1) {
        // pre
        preorder += peekp.node.data + " ";
        peekp.state++;
      } 
      else if (peekp.state >= 0 && peekp.state < peekp.node.children.size()) {
        // child
        Pair childp = new Pair();
        childp.state = -1;
        childp.node = peekp.node.children.get(peekp.state);
        stack.push(childp);
        peekp.state++;
      } 
      else if (peekp.state == peekp.node.children.size()) {
        // post
        postorder += peekp.node.data + " ";
        peekp.state++;
      } 
      else {
        stack.pop();
      }
    }

      System.out.println(preorder);
      System.out.println(postorder);
    }

  }
