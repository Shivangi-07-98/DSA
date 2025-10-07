import java.io.*;
import java.util.*;

public class SizeSumMaxMinFindQ { 

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

  
  public static int size(Node node){
    if(node == null){
      return 0;
    }
    int ls = size(node.left);
    int rs = size(node.right);
    int ts = ls + rs + 1;

    return ts;
  }

  public static int sum(Node node){
    if(node == null){
      return 0;
    }
    int ls = sum(node.left);
    int rs = sum(node.right);
    int ts = ls + rs + node.data;

    return ts;
  }

  public static int max(Node node){
    if(node.right != null){
      return max(node.right);
    }
    else{
      return node.data;
    }
  }

  public static int min(Node node){
    if(node.left != null){
      return min(node.left);
    }
    else{
      return node.data;
    }
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

  public static void main(String[] args) {
    int[] arr = { 12, 25, 37, 50, 62, 75, 87 }; 
    Node root = construct(arr, 0, arr.length - 1);
    // display(root);

    int size = size(root);
    int sum = sum(root);
    int max = max(root);
    int min = min(root);
    boolean find = find(root, 62);
    System.out.println("size = " + size + " sum = " + sum + " max = " + max + " min = " + min + " find = " + find );

  }

}
