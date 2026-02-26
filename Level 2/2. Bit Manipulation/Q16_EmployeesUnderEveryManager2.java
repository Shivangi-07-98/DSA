// Time Complexity: O(n), Space Complexity: O(n)

// WHAT IS THE QUESTION ASKING?
// Question #16: Number of Employees Under Every Manager
// Solution 2: Using HashSet instead of ArrayList
import java.io.*;
import java.util.*;

public class Q16_EmployeesUnderEveryManager2 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    HashMap<String, String> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.put(scn.next(), scn.next());
    }

    findCount(map);
  }

  private static void findCount(HashMap<String, String> map) {
    HashMap<String, HashSet<String>> tree = new HashMap<>();
    String ceo = "";

    for (String emp : map.keySet()) {
      String man = map.get(emp);
      if (man.equals(emp)) {
        ceo = man;
      } else {
        if (tree.containsKey(man)) {
          HashSet<String> emps = tree.get(man);
          emps.add(emp);
        } else {
          HashSet<String> emps = new HashSet<>();
          emps.add(emp);
          tree.put(man, emps);
        }
      }
    }

    HashMap<String, Integer> result = new HashMap<>();
    getSize(tree, ceo, result);

    for (String key : result.keySet()) {
      System.out.println(key + " " + result.get(key));
    }
  }

  public static int getSize(HashMap<String, HashSet<String>> tree, String man, HashMap<String, Integer> result) {
    if (tree.containsKey(man) == false) {
      result.put(man, 0);
      return 1;
    }

    int sz = 0;
    for (String emp : tree.get(man)) {
      int cs = getSize(tree, emp, result);
      sz += cs;
    }

    result.put(man, sz);
    return sz + 1;
  }

}

/*
 * Input:
 * 6
 * A C
 * B C
 * C F
 * D E
 * E F
 * F F
 * 
 * Output:
 * A 0
 * B 0
 * C 2
 * D 0
 * E 1
 * F 5
 */
