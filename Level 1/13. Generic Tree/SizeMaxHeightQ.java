import java.util.*;

public class SizeMaxHeightQ {
 
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
            // remove, print, add children
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

    public static void levelOrderLinewise2(Node node) {
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(node);

        while (que.size() != 0) {
            int currSize = que.size();

            // this loop first checks then decreases
            while (currSize-- > 0) {
                Node rnode = que.removeFirst();
                System.out.print(rnode.data + " ");
                for (Node child : rnode.children) {
                    que.addLast(child);
                }
            }
            System.out.println();
        }
    }

    public static void levelOrderLinewiseZigZag(Node node) {
        LinkedList<Node> que = new LinkedList<>(); // addLast, removeFirst
        LinkedList<Node> st = new LinkedList<>(); // addFirst, removeFirst

        que.addLast(node);
        int level = 0;

        while (que.size() != 0) {
            int currSize = que.size();

            while (currSize-- > 0) {
                Node rnode = que.removeFirst();
                System.out.print(rnode.data + " ");

                if (level % 2 == 0) {
                    for (int i = 0; i < rnode.children.size(); i++) {
                        st.addFirst(rnode.children.get(i));
                    }
                } else {
                    for (int i = rnode.children.size() - 1; i >= 0; i--) {
                        st.addFirst(rnode.children.get(i));
                    }
                }
            }

            level++;
            System.out.println();
            LinkedList<Node> temp = que;
            que = st;
            st = temp;
        }

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

    public static void main(String[] args) {
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };
        Node root = construct(arr);

        int sz = size(root);
        System.out.println("size is " + sz);

        int max = max(root);
        System.out.println("max is " + max);

        int height = height(root);
        System.out.println("height is " + height);

        // levelOrder(root);
        levelOrderLinewise(root);
    }

}
