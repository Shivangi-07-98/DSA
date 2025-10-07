import java.util.*;

public class AreGtMirrorInShapeQ {

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

    public static boolean areMirror(Node n1, Node n2) {
        // Base case: if both are null, they are mirrors
        // if (n1 == null && n2 == null) {
        //     return true;
        // }
        // If one is null and the other isn't, they're not mirrors
        // if (n1 == null || n2 == null) {
        //     return false;
        // }
        if (n1.children.size() != n2.children.size()) {
            return false;
        }
    
        // Check children in opposite order
        for (int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(n2.children.size() - 1 - i);
    
            if (areMirror(c1, c2) == false) {
                return false;
            }
        }
    
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };
        Node root1 = construct(arr1);

        int[] arr2 = { 5, 10, 50, -1, 60, -1, -1, 30, 70, -1, 80, 115, -1, 125, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };
        Node root2 = construct(arr2);

        boolean mirror = areMirror(root1, root2);
        System.out.println(mirror);

        // levelOrder(root);
        // levelOrderLinewise(root);
    }

}
