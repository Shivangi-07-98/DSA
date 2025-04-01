import java.util.*;

public class IterableAndIteratorQ { 

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

  static Node msn = null;
  static int msum = Integer.MIN_VALUE;

  public static int question(Node node) {
    int sum = node.data;

    for (Node child: node.children) {
      int csum = question(child);
      sum += csum;
    }

    if (sum > msum) {
      msum = sum;
      msn = node;
    }

    return sum;
  }

  public static void main(String[] args) {
    int[] arr1 = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
        -1 };
    Node root1 = construct(arr1);

    int[] arr2 = { -10, 20, 50, -1, -60, -1, -1, 30, -70, -1, 80, 110, -1, -120, -1, -1, -90, -1, -1, 40, 100, -1, -1,
        -1 };
    Node root2 = construct(arr2);

    question(root2);
    System.out.println(msn.data + "@" + msum);

  }

}
