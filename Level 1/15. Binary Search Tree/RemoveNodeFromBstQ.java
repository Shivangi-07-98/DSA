import java.io.*;
import java.util.*;

public class RemoveNodeFromBstQ { 

  public static class Node {
    int data;
    Node left;
    Node right;
    
    // Node(int data, Node left, Node right){
    //   this.data = data;
    //   this.left = left;
    //   this.right = right;
    // }
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

  public static Node add(Node node, int data) {
    if(node == null){
      Node temp = new Node();
      temp.data = data;
      return temp;
    }
    if(data > node.data){
      node.right = add(node.right, data);
    }
    else if(data < node.data){
      node.left = add(node.left, data);
    }
    else{
      // already there no need to add
    }
    return node; 
  }

  public static int max(Node node){
    if(node.right != null){
      return max(node.right);
    }
    else{
      return node.data;
    }
  }

  public static Node remove(Node node, int data) {
    if(node == null){
      return null;
    }
    if(data > node.data){
      node.right = remove(node.right, data);
      return node;
    }
    else if(data < node.data){
      node.left = remove(node.left, data);
      return node;
    }
    else{
      if(node.left != null && node.right != null){
        int lmax = max(node.left);
        node.data = lmax;
        node.left = remove(node.left, lmax);
        return node;
      }
      else if(node.left != null){
        return node.left;
      }
      else if(node.right != null){
        return node.right;
      }
      else{
        return null;
      }
    }
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

  public static void main(String[] args) {
    int[] arr = { 10, 20, 30, 50, 60, 70, 80 }; 
    Node root = construct(arr, 0, arr.length - 1);
    
    root = remove(root, 60);
    display(root);

    // System.out.println(lca);

  }

}
