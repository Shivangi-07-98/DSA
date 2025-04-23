import java.util.*;

public class LinearizeQ {

  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
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
        System.out.println();
      }
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }
        st.push(t);
      }
    }

    return root;
  }

  public static Node getTail(Node node) {
    while (node.children.size() > 0) {
      node = node.children.get(0);
    }
    return node;
  }

  public static void linearize(Node node) {
    for (Node child : node.children) {
      linearize(child);
    }
    while (node.children.size() > 1) {
      Node last = node.children.remove(node.children.size() - 1);
      Node slast = node.children.get(node.children.size() - 1);
      Node slastKiTail = getTail(slast);
      slastKiTail.children.add(last);
    }
  }

  public static void myLinearize(Node node) {
    for (int i = node.children.size() - 1; i >= 0; i--) {
      if (node.children.size() > 1) {
        Node val = node.children.remove(i);
        Node parent = node.children.get(i - 1);
        parent.children.add(val);
      }
    }
    for (Node child : node.children) {
      myLinearize(child);
    }
  }

  // linearizes and returns the tail
  public static Node linearizeEfficient(Node node) {
    if (node.children.size() == 0) {
      return node;
    }

    Node lastChild = node.children.get(node.children.size() - 1);
    Node lastKiTail = linearizeEfficient(lastChild);

    while (node.children.size() > 1) {
      Node slastChild = node.children.get(node.children.size() - 2);
      Node slastKiTail = linearizeEfficient(slastChild);
      slastKiTail.children.add(lastChild);

      node.children.remove(node.children.size() - 1);
      lastChild = slastChild;
    }

    return lastKiTail;
  }
  

  public static void main(String[] args) throws Exception {
    int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
        -1 };
    Node root = construct(arr);

    // linearize(root);
    // myLinearize(root);
    // display(root);
    // levelOrderLinewise(root);

    linearizeEfficient(root);
    // display(root);
    levelOrderLinewise(root);

  }

}
