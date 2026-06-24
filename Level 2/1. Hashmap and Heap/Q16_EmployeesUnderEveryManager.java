// Time O(n)
// Space O(n)

// WHAT IS THE QUESTION ASKING?
// Given employee-manager pairs, count number of employees under each manager
// Build a tree structure and use DFS to count subtree sizes

import java.io.*;
import java.util.*;

public class Q16_EmployeesUnderEveryManager {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = Integer.parseInt(scn.nextLine());

    HashMap<String, ArrayList<String>> tree = new HashMap<>();
    String root = "";

    for (int i = 0; i < n; i++) {
      String[] parts = scn.nextLine().split(" ");
      if (parts[0].equals(parts[1])) {
        root = parts[0];
      } else if (tree.containsKey(parts[1])) {
        tree.get(parts[1]).add(parts[0]);
      } else {
        tree.put(parts[1], new ArrayList<>());
        tree.get(parts[1]).add(parts[0]);
      }
    }

    HashMap<String, Integer> res = new HashMap<>();
    size(root, tree, res);

    for (String key : res.keySet()) {
      System.out.println(key + " " + res.get(key));
    }
  }

  static int size(String root, HashMap<String, ArrayList<String>> tree, HashMap<String, Integer> res) {
    if (tree.containsKey(root) == false) {
      res.put(root, 0);
      return 1;
    }

    int sz = 0;
    for (String child : tree.get(root)) {
      int cs = size(child, tree, res);
      sz += cs;
    }

    res.put(root, sz);
    return sz + 1;
  }

}

// Input:
// 6
// A C
// B C
// C F
// D E
// E F
// F F
// 
// Output:
// A 0
// B 0
// C 2
// D 0
// E 1
// F 5
