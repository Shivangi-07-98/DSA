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

    for(Node child: node.children){
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

  public static void main(String[] args) throws Exception {
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // int n = Integer.parseInt(br.readLine());
    // int[] arr = new int[n];

    // String[] values = br.readLine().split(" ");
    // for (int i = 0; i < n; i++) {
    //   arr[i] = Integer.parseInt(values[i]);
    // }

    int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
      -1 };

    Node root = construct(arr);
    display(root);
    mirror(root);
    display(root);
  }

}

// 24
// 10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
