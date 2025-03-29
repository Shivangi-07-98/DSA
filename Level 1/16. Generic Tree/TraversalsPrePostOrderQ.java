import java.util.*;

public class TraversalsPrePostOrderQ {

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
        int size = 0;
        for (Node child : node.children) {
            size += size(child);
        }
        return size + 1;
    }

    public static int max(Node node) {
        int maxChild = node.data;
        for (Node child : node.children) {
            int recAns = max(child);
            maxChild = Math.max(recAns, maxChild);
        }
        return maxChild;
    }

    public static int height(Node node) {
        int height = -1;
        for (Node child : node.children) {
            int recAns = height(child);
            height = Math.max(recAns, height);
        }
        return height + 1;
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
        traversals(root);
    }

}

// 24
// 10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
