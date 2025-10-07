import java.io.*;
import java.util.*;

// print all pair of nodes in a BST such that their sum is equal to a given target sum
public class TargetSumPairAlternateApproach1Q { 

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

  public static void tsp2(Node node, ArrayList<Integer> list) {
    if (node == null) {
      return;
    }
    tsp2(node.left, list);
    list.add(node.data);
    tsp2(node.right, list);
  }

  public static void main(String[] args) {
    int[] arr = { 10, 20, 30, 50, 60, 70, 80 }; 
    Node root = construct(arr, 0, arr.length - 1);
    // display(root);

    // tsp(root, root, 100);
    ArrayList<Integer> list = new ArrayList<>();
    tsp2(root, list);

    int li = 0;
    int ri = list.size() - 1;
    int data = 100;
    while (li < ri) {
      if(list.get(li) + list.get(ri) < data){
        li++;
      }
      else if(list.get(li) + list.get(ri) > data){
        ri--;
      }
      else{
        System.out.println(list.get(li) + " " + list.get(ri));
        li++;
        ri--;
      }
    }
  }

}
