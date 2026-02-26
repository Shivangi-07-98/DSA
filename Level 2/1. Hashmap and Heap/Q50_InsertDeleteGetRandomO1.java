// Time Complexity: O(1) average, Space Complexity: O(n)

import java.io.*;
import java.util.*;

public class Q50_InsertDeleteGetRandomO1 {

  private static class RandomizedSet {
    ArrayList<Integer> list = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    Random rand = new Random();

    boolean insert(int val) {
      if (map.containsKey(val))
        return false;

      map.put(val, list.size());
      list.add(val);
      return true;
    }

    boolean remove(int val) {
      if (!map.containsKey(val))
        return false;

      int idx = map.get(val);
      int last = list.get(list.size() - 1);

      list.set(idx, last);
      map.put(last, idx);

      list.remove(list.size() - 1);
      map.remove(val);
      return true;
    }

    int getRandom() {
      int idx = rand.nextInt(list.size());
      return list.get(idx);
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int q = scn.nextInt();

    RandomizedSet rs = new RandomizedSet();

    for (int i = 0; i < q; i++) {
      String op = scn.next();
      if (op.equals("insert")) {
        System.out.println(rs.insert(scn.nextInt()));
      } else if (op.equals("remove")) {
        System.out.println(rs.remove(scn.nextInt()));
      } else {
        System.out.println(rs.getRandom());
      }
    }
  }
}

/*
 * Input:
 * 6
 * insert 1
 * remove 2
 * insert 2
 * getRandom
 * remove 1
 * insert 2
 * 
 * Output:
 * true
 * false
 * true
 * 1 or 2
 * true
 * false
 */
