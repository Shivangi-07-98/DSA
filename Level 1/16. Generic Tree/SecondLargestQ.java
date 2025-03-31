import java.util.*;

public class SecondLargestQ {

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

  static int largest = Integer.MIN_VALUE;
  static int slargest = Integer.MIN_VALUE;

  public static void secondLargest(Node node) {
    if (node.data >= largest) {
      // If current node is larger than largest, update both values
      slargest = largest; // Previous largest becomes second largest
      largest = node.data; // Current node becomes new largest
    } else if (node.data > slargest) {
      // If current node is between largest and second largest
      slargest = node.data; // Update just the second largest
    }

    for (Node child : node.children) {
      secondLargest(child);
    }
  }

  public static class MoverForSlargest {
    int largest = Integer.MIN_VALUE;
    int slargest = Integer.MIN_VALUE;
  }

  public static void secondLargest2(Node node, MoverForSlargest mover) {
    if (node.data >= mover.largest) {
      // If current node is larger than largest, update both values
      mover.slargest = mover.largest; // Previous largest becomes second largest
      mover.largest = node.data; // Current node becomes new largest
    } else if (node.data > mover.slargest) {
      // If current node is between largest and second largest
      mover.slargest = node.data; // Update just the second largest
    }

    for (Node child : node.children) {
      secondLargest2(child, mover);
    }
  }

  public static void main(String[] args) {

    int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
        -1 };
    Node root = construct(arr);

    secondLargest(root);
    System.out.println(largest + " " + slargest);

    MoverForSlargest mover = new MoverForSlargest();
    secondLargest2(root, mover);
    System.out.println(mover.largest + " " + mover.slargest);

  }

}
