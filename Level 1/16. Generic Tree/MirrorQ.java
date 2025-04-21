import java.util.*;

public class MirrorQ {

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

  public static void mirror(Node node) {
    for (Node child : node.children) {
      mirror(child);
    }
    // Collections.reverse(node.children); // this is for arraylists

    // Reverse the order of children
    int li = 0;
    int ri = node.children.size() - 1;
    while (li < ri) {
      Node left = node.children.get(li);
      Node right = node.children.get(ri);
      node.children.set(li, right);
      node.children.set(ri, left);
      li++;
      ri--;
    }

  }

  public static void myMirror(Node node) {
    for (Node child : node.children) {
      myMirror(child);
    }

    int a = 0;
    int b = node.children.size() - 1;

    while (a < b) {
      Node left = node.children.get(a);
      Node right = node.children.get(b);
      node.children.set(a, right);
      node.children.set(b, left);

      a++;
      b--;
    }

  }

  public static void main(String[] args) throws Exception {
    int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
        -1 };

    Node root = construct(arr);
    // display(root);
    // mirror(root);
    // display(root);

    levelOrderLinewise(root);
    // mirror(root);
    myMirror(root);
    levelOrderLinewise(root);
  }

}

// 24
// 10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
