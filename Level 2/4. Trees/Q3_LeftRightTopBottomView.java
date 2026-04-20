// https://leetcode.com/problems/binary-tree-right-side-view/

import java.io.*;
import java.util.*;

public class Q3_LeftRightTopBottomView {

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

  // https://www.geeksforgeeks.org/print-left-view-binary-tree/
  public static ArrayList<Integer> leftView(Node root) {
    ArrayList<Integer> retVal = new ArrayList<>();
    if (root == null) {
      return retVal;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (queue.size() > 0) {
      int lsize = queue.size();

      for (int i = 0; i < lsize; i++) {
        Node temp = queue.remove();

        if (i == 0) {
          retVal.add(temp.data);
        }
        if (temp.left != null) {
          queue.add(temp.left);
        }
        if (temp.right != null) {
          queue.add(temp.right);
        }
      }
    }

    return retVal;
  }

  // https://leetcode.com/problems/binary-tree-right-side-view/
  public static ArrayList<Integer> rightView(Node root) {
    ArrayList<Integer> retVal = new ArrayList<>();
    if (root == null) {
      return retVal;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (queue.size() > 0) {
      int lsize = queue.size();

      for (int i = 0; i < lsize; i++) {
        Node temp = queue.remove();

        if (i == lsize - 1) {
          retVal.add(temp.data);
        }
        if (temp.left != null) {
          queue.add(temp.left);
        }
        if (temp.right != null) {
          queue.add(temp.right);
        }
      }
    }

    return retVal;
  }

  public static class VPair {
    Node node;
    int hd; // horizontal distance

    VPair(Node node, int hd) {
      this.node = node;
      this.hd = hd;
    }
  }

  // https://www.geeksforgeeks.org/top-view-of-a-binary-tree/
  public static ArrayList<Integer> topView(Node root) {
    ArrayList<Integer> retVal = new ArrayList<>();
    if (root == null) {
      return retVal;
    }

    Queue<VPair> queue = new LinkedList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    int leftMin = 0;
    int rightMax = 0;

    queue.add(new VPair(root, 0));

    while (queue.size() > 0) {
      VPair rem = queue.remove();

      if (!map.containsKey(rem.hd)) {
        map.put(rem.hd, rem.node.data);
      }

      if (rem.hd < leftMin) {
        leftMin = rem.hd;
      }
      if (rem.hd > rightMax) {
        rightMax = rem.hd;
      }

      if (rem.node.left != null) {
        queue.add(new VPair(rem.node.left, rem.hd - 1));
      }
      if (rem.node.right != null) {
        queue.add(new VPair(rem.node.right, rem.hd + 1));
      }
    }

    for (int i = leftMin; i <= rightMax; i++) {
      if (map.containsKey(i)) {
        retVal.add(map.get(i));
      }
    }

    return retVal;
  }

  // https://www.geeksforgeeks.org/bottom-view-binary-tree/
  public static ArrayList<Integer> bottomView(Node root) {
    ArrayList<Integer> retVal = new ArrayList<>();
    if (root == null) {
      return retVal;
    }

    Queue<VPair> queue = new LinkedList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    int leftMin = 0;
    int rightMax = 0;

    queue.add(new VPair(root, 0));

    while (queue.size() > 0) {
      VPair rem = queue.remove();

      map.put(rem.hd, rem.node.data);

      if (rem.hd < leftMin) {
        leftMin = rem.hd;
      }
      if (rem.hd > rightMax) {
        rightMax = rem.hd;
      }

      if (rem.node.left != null) {
        queue.add(new VPair(rem.node.left, rem.hd - 1));
      }
      if (rem.node.right != null) {
        queue.add(new VPair(rem.node.right, rem.hd + 1));
      }
    }

    for (int i = leftMin; i <= rightMax; i++) {
      if (map.containsKey(i)) {
        retVal.add(map.get(i));
      }
    }

    return retVal;
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

    // ArrayList<Integer> left = leftView(root);
    // System.out.println(left);

    // ArrayList<Integer> right = rightView(root);
    // System.out.println(right);

    ArrayList<Integer> top = topView(root);
    System.out.println(top);

    // ArrayList<Integer> bottom = bottomView(root);
    // System.out.println(bottom);
  }

}

// Input:
// 19
// 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
