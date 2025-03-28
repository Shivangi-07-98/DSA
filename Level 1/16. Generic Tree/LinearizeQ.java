import java.io.*;
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

  public static int size(Node node) {
    int s = 0;
    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;
    return s;
  }

  public static void traversals(Node node) {
    // Node Pre
    System.out.println("Node Pre " + node.data);

    // Loop, before call is Edge Pre, after call is Edge Post
    for (Node child : node.children) {
      System.out.println("Edge Pre " + node.data + "--" + child.data);
      traversals(child);
      System.out.println("Edge Post " + node.data + "--" + child.data);
    }

    // Node Post
    System.out.println("Node Post " + node.data);
  }

  public static void levelOrderLinewiseZZ(Node node) {
    // if (node == null)
    //   return;

    Stack<Node> stack = new Stack<>();
    stack.add(node);

    Stack<Node> cstack = new Stack<>();
    int level = 0;

    while (stack.size() > 0) {
      node = stack.pop();
      System.out.print(node.data + " ");

      if (level % 2 == 0) {
        for (int i = 0; i < node.children.size(); i++) {
          Node child = node.children.get(i);
          cstack.push(child);
        }
      } else {
        for (int i = node.children.size() - 1; i >= 0; i--) {
          Node child = node.children.get(i);
          cstack.push(child);
        }
      }

      if (stack.size() == 0) {
        stack = cstack;
        cstack = new Stack<>();
        level++;
        System.out.println();
      }
    }
  }

  public static void removeLeaves(Node node) {
    // remove your own leaves
    for (int i = node.children.size() - 1; i >= 0; i--) {
        Node child = node.children.get(i);
        if (child.children.size() == 0) {
            node.children.remove(i);
        }
    }

    // request the children
    for (Node child : node.children) {
        removeLeaves(child);
    }
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


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    
    removeLeaves(root);
    display(root);
  }

}

// 24
// 10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
