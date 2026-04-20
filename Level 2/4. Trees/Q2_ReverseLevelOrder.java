import java.io.*;
import java.util.*;

public class Q2_ReverseLevelOrder {

  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  // leftNode parentNode rightNode
  // 25 50 75
  // 12 25 37
  // 12
  // 30 37
  // 30
  // 62 75 87
  // 62 70
  // 70
  // 87
  public static void display(Node node) {
    if (node == null) {
      return;
    }
    String str = " <- " + node.data + " -> ";
    String lcstr = node.left == null ? ".." : "" + node.left.data;
    String rcstr = node.right == null ? ".." : "" + node.right.data;
    System.out.println(lcstr + str + rcstr);

    display(node.left); // will print the entire left tree
    display(node.right); // will print the entire right tree
  }

  public static void levelOrderLW(Node node) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    queue.add(null);

    while (queue.size() > 0) {
      Node temp = queue.remove();

      if (temp != null) {
        System.out.print(temp.data + " ");

        if (temp.left != null) {
          queue.add(temp.left);
        }

        if (temp.right != null) {
          queue.add(temp.right);
        }
      } else {
        System.out.println();

        if (queue.size() > 0) {
          queue.add(null);
        }
      }
    }

  }

  public static void reverseLevelOrder1(Node node) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    queue.add(null);

    Stack<String> st = new Stack<>();

    String res = "";

    while (queue.size() > 0) {
      Node temp = queue.remove();

      if (temp != null) {
        res += temp.data + " ";

        if (temp.left != null) {
          queue.add(temp.left);
        }

        if (temp.right != null) {
          queue.add(temp.right);
        }
      } else {
        st.push(res);
        res = "";

        if (queue.size() > 0) {
          queue.add(null);
        }
      }
    }

    while (st.size() > 0) {
      res = st.pop();
      System.out.println(res);
    }
  }

  // https://www.geeksforgeeks.org/dsa/reverse-level-order-traversal/
  public static ArrayList<Integer> reverseLevelOrder2(Node node) {
    ArrayList<Integer> ret = new ArrayList<>();

    Queue<Node> queue = new LinkedList<>();
    queue.add(node);

    while (queue.size() > 0) {
      Node temp = queue.remove();

      ret.add(temp.data);
      if (temp.right != null) {
        queue.add(temp.right);
      }

      if (temp.left != null) {
        queue.add(temp.left);
      }
    }

    Collections.reverse(ret);
    return ret;
  }

  // https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
  public static List<List<Integer>> levelOrderBottom(Node root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (queue.size() > 0) {
      int size = queue.size();

      ArrayList<Integer> level = new ArrayList<>();

      for (int i = 0; i < size; i++) {
        Node temp = queue.remove();
        level.add(temp.data);

        if (temp.left != null) {
          queue.add(temp.left);
        }

        if (temp.right != null) {
          queue.add(temp.right);
        }
      }

      result.add(level);
    }

    Collections.reverse(result);
    return result;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    // levelOrderLW(root);
    // reverseLevelOrder1(root);

    // ArrayList<Integer> ans = reverseLevelOrder2(root);
    // System.out.println(ans);

    List<List<Integer>> ans = levelOrderBottom(root);
    for (List<Integer> level : ans) {
      for (int val : level) {
        System.out.print(val + " ");
      }
      System.out.println();
    }

  }

}

// Input:
// 19
// 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
