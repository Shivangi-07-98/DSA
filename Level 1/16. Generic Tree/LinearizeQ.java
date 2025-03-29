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
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // int n = Integer.parseInt(br.readLine());
    // int[] arr = new int[n];

    // String[] values = br.readLine().split(" ");
    // for (int i = 0; i < n; i++) {
    // arr[i] = Integer.parseInt(values[i]);
    // }

    int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
        -1 };

    Node root = construct(arr);

    linearize(root);
    display(root);

    linearizeEfficient(root);
    display(root);
  }

}

// 24
// 10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
