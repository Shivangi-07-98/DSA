import java.io.*;
import java.util.*;

// print all pair of nodes in a BST such that their sum is equal to a given target sum
public class TargetSumPairAlternateApproach2Q { 

  public static class Node {
    int data;
    Node left;
    Node right;
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

  // node isbst true when all to the left are smaller and all to the right are greater
  public static Node construct(int[] sarr, int lo, int hi){
    if(lo > hi){
      return null;
    }
    int mid = (lo + hi) / 2;
    Node node = new Node();
    node.data = sarr[mid];
    node.left = construct(sarr, lo, mid - 1);
    node.right = construct(sarr, mid + 1, hi);
    
    return node;
  }

  public static boolean find(Node node, int data){
    if(node == null){
      return false;
    }

    if(data > node.data){
      return find(node.right, data);
    }
    else if(data < node.data){
      return find(node.left, data);
    }
    else{
      return true;
    }
  }

  public static void tsp(Node root, Node node, int target) {
    if (node == null) {
      return;
    }
    tsp(root, node.left, target);

    int complement = target - node.data;

    if (complement > node.data && find(root, complement)) {
      System.out.println(node.data + " " + complement);
    }

    tsp(root, node.right, target);
  }

  public static class IPair{
    Node node;
    int state;

    IPair(Node node){
      this.node = node;
      this.state = 0;
    }
  }

  public static void tsp3(Node root, int tar) {
    Stack<IPair> ls = new Stack<>();
    IPair lrp = new IPair(root);
    ls.push(lrp);

    Stack<IPair> rs = new Stack<>();
    IPair rrp = new IPair(root);
    rs.push(rrp);

    Node left = getInorder(ls);
    Node right = getReverseInorder(rs);
    
    while (left != null && right != null && left.data < right.data) {
      if (left.data + right.data < tar) {
        left = getInorder(ls);
      } else if (left.data + right.data > tar) {
        right = getReverseInorder(rs);
      }
      else{
        System.out.println(left.data + " " + right.data);
        left = getInorder(ls);
        right = getReverseInorder(rs);
    }
  }
}

  public static Node getInorder(Stack<IPair> stack) {
    while (stack.size() > 0) {
      IPair top = stack.peek();
      
      if (top.state == 0) {
        top.state++;
        if (top.node.left != null) {
          stack.push(new IPair(top.node.left));
        }
      } else if (top.state == 1) {
        top.state++;
        if (top.node.right != null) {
          stack.push(new IPair(top.node.right));
        }
        return top.node;
      } else {
        stack.pop();
      }
    }
    return null;
  }

  public static Node getReverseInorder(Stack<IPair> stack) {
    while (stack.size() > 0) {
      IPair top = stack.peek();
      
      if (top.state == 0) {
        top.state++;
        if (top.node.right != null) {
          stack.push(new IPair(top.node.right));
        }
      } else if (top.state == 1) {
        top.state++;
        if (top.node.left != null) {
          stack.push(new IPair(top.node.left));
        }
        return top.node;
      } else {
        stack.pop();
      }
    }
    return null;
  }

  public static void main(String[] args) {
    int[] arr = { 10, 20, 30, 50, 60, 70, 80 }; 
    Node root = construct(arr, 0, arr.length - 1);
    // display(root);

    tsp3(root, 100);
    
  }

}
