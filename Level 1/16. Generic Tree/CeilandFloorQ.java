import java.util.*;

public class CeilandFloorQ {

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

  static int ceil = Integer.MAX_VALUE; // smallest among larger values
  static int floor = Integer.MIN_VALUE; // largest among smaller values

  public static void ceilAndFloor1(Node node, int data) {
    if (node.data > data) {
      if (node.data < ceil) {
        ceil = node.data;
      }
    }

    if (node.data < data) {
      if (node.data > floor) {
        floor = node.data;
      }
    }

    for (Node child : node.children) {
      ceilAndFloor1(child, data); 
    }
  }

  public static class MoverForCeilFloor {
    int ceil = Integer.MAX_VALUE; // smallest among larger values
    int floor = Integer.MIN_VALUE; // largest among smaller values
  }

  public static void ceilAndFloor2(Node node, int data, MoverForCeilFloor mover) {
    if (node.data > data) {
      if (node.data < mover.ceil) {
        mover.ceil = node.data;
      }
    }

    if (node.data < data) {
      if (node.data > mover.floor) {
        mover.floor = node.data;
      }
    }

    for (Node child : node.children) {
      ceilAndFloor2(child, data, mover); 
    }
  }

  public static void main(String[] args) {
    int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
        -1 };
    Node root = construct(arr);
    int d = 35;

    ceilAndFloor1(root, d);
    System.out.println("ceil1 = " + ceil + " " + "floor1 = " + floor);

    MoverForCeilFloor mover = new MoverForCeilFloor();
    ceilAndFloor2(root, d, mover);
    System.out.println("ceil2 = " + mover.ceil + " " + "floor2 = " + mover.floor);

  }

}
