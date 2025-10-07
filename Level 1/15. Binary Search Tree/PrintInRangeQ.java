import java.io.*;
import java.util.*;

public class PrintInRangeQ { 

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

  public static void pir(Node node, int d1, int d2){
    if(node == null){
      return;
    }
    
    if(node.data < d1 && node.data < d2){
      pir(node.right, d1, d2);
    }
    
    else if(node.data > d1 && node.data > d2){
      pir(node.left, d1, d2);
    }
    
    else{
      pir(node.left, d1, d2);
      System.out.println(node.data);
      pir(node.right, d1, d2);
    }
  }

  public static void main(String[] args) {
    // int[] arr = { 10, 20, 30, 50, 60, 70, 80 }; 
    int[] arr = { 12, 25, 37, 30, 40, 50, 60, 62, 70, 75, 87 }; 
    Node root = construct(arr, 0, arr.length - 1);
    // display(root);
    pir(root, 35, 65);

  }

}
