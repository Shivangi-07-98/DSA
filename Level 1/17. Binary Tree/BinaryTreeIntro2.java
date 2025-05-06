import java.util.*;

public class BinaryTreeIntro2 {

  public static class Node {
    int data;
    Node left;
    Node right;
  }

  public static class Pair {
    Node node;
    int state;
  }

  // create stack of pair
  public static Node construct(Integer[] arr) {
    Stack<Pair> stack = new Stack<>();

    Node root = new Node();
    root.data = arr[0];

    // main lines
    Pair rootp = new Pair();
    rootp.node = root;
    rootp.state = 1;

    stack.push(rootp);
    int idx = 1;

    while (stack.size() > 0) {
      Pair peekp = stack.peek();

      if (peekp.state == 1) {
        // left
        if (arr[idx] != null) {
          Node lc = new Node();
          lc.data = arr[idx];
          peekp.node.left = lc;

          Pair lp = new Pair();
          lp.node = lc;
          lp.state = 1;

          stack.push(lp);
        }
        peekp.state++;
        idx++;
      } else if (peekp.state == 2) {
        // right
        if (arr[idx] != null) {
          Node rc = new Node();
          rc.data = arr[idx];
          peekp.node.right = rc;

          Pair rp = new Pair();
          rp.node = rc;
          rp.state = 1;

          stack.push(rp);
        }
        peekp.state++;
        idx++;
      } else if (peekp.state == 3) {
        // pop
        stack.pop();
      }
    }
    return root;
  }

  // leftNode parentNode rightNode
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

  // har level ka alag line mai print hoga
  // use queue, pq cq, rpa children in cq(add non null children)
  // pq is empty, pq=cq, cq new, enter
  public static void levelOrderLinewise1(Node node) {
    ArrayDeque<Node> pq = new ArrayDeque<>();
    ArrayDeque<Node> cq = new ArrayDeque<>();

    pq.add(node);
    while (pq.size() > 0) {
      Node temp = pq.remove();
      System.out.print(temp.data + " ");

      if (temp.left != null) {
        cq.add(temp.left);
      }
      if (temp.right != null) {
        cq.add(temp.right);
      }

      if (pq.size() == 0) {
        pq = cq;
        cq = new ArrayDeque<>();
        System.out.println();
      }
    }
  }

  public static void levelOrderLinewise2(Node node) {
    ArrayDeque<Node> pq = new ArrayDeque<>();
    pq.add(node);

    while (pq.size() > 0) {
      int count = pq.size();

      for (int i = 0; i < count; i++) {
        Node temp = pq.remove();
        System.out.print(temp.data + " ");

        if (temp.left != null) {
          pq.add(temp.left);
        }
        if (temp.right != null) {
          pq.add(temp.right);
        }
      }

      System.out.println();
    }

  }

  public static void levelOrderLinewise3(Node node) {
    ArrayDeque<Node> pq = new ArrayDeque<>();
    pq.add(node);
    Node val = new Node();
    val.data = -1;
    pq.add(val);

    while (pq.size() > 0) {
      Node temp = pq.remove();

      if(temp.data == -1){
        System.out.println();
        if(pq.size() > 0){
          pq.add(temp);
        }
        continue; // loop wapas upar pauch jata hai, niche wali lines nhi chlti hai
      }
        System.out.print(temp.data + " ");
        if (temp.left != null) {
          pq.add(temp.left);
        }
        if (temp.right != null) {
          pq.add(temp.right);
        }
    }

  }

  public static void levelOrderLinewise4(Node node) {
    ArrayDeque<Pair> q = new ArrayDeque<>();
    Pair rp = new Pair();
    rp.node = node;
    rp.state = 1;
    q.add(rp);

    int state = 1;
    while (q.size() > 0) {
      Pair temp = q.remove();

      if(temp.state > state){
        state = temp.state;
        System.out.println();
      }
      System.out.print(temp.node.data + " ");
      if(temp.node.left != null){
        Pair leftp = new Pair();
        leftp.node = temp.node.left;
        leftp.state = temp.state + 1;
        q.add(leftp);
      }
      if(temp.node.right != null){
        Pair rightp = new Pair();
        rightp.node = temp.node.right;
        rightp.state = temp.state + 1;
        q.add(rightp);
      }
    }


  }


  public static void main(String[] args) {
    Integer[] arr = new Integer[] { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null,
        87, null, null }; // capital integer array has null
    Node root = construct(arr);
    // display(root);
    levelOrderLinewise4(root);
  }

}