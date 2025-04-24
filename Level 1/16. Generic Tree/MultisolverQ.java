import java.util.*;

public class MultisolverQ {

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

  static int sum = 0;
  static int max = Integer.MIN_VALUE;
  static int min = Integer.MAX_VALUE;
  static int height = -1;

  public static void multisolver(Node node, int depth) {
    sum += node.data;
    if (node.data > max)
      max = node.data;
    if (node.data < min)
      min = node.data;
    if (depth > height)
      height = depth;

    for (Node child : node.children) {
      multisolver(child, depth + 1);
    }
  }

  public static class HeapMover {
    int sum = 0;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    int height = -1;
  }

  public static void multisolver2(Node node, int depth, HeapMover mover) {
    mover.sum += node.data;
    if (node.data > mover.max)
      mover.max = node.data;
    if (node.data < mover.min)
      mover.min = node.data;
    if (depth > mover.height)
      mover.height = depth;

    for (Node child : node.children) {
      multisolver2(child, depth + 1, mover);
    }
  }

  public static void main(String[] args) {
    int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
        -1 };
    Node root = construct(arr);
    int data = 120;
    
    // multisolver(root, 0);
    // System.out.println("Sum = " + sum);
    // System.out.println("Max = " + max);
    // System.out.println("Min = " + min);
    // System.out.println("Height = " + height);

    HeapMover mover = new HeapMover();
    multisolver2(root, 0, mover);
    System.out.println("Sum = " + mover.sum);
    System.out.println("Max = " + mover.max);
    System.out.println("Min = " + mover.min);
    System.out.println("Height = " + mover.height);

  }

}
