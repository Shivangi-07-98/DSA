// Time Complexity: O(1) average, Space Complexity: O(n)

import java.io.*;
import java.util.*;

public class Q51_InsertDeleteGetRandomO1DuplicatesAllowed {

  private static class RandomizedCollection {
    ArrayList<Integer> list = new ArrayList<>();
    HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    Random rand = new Random();

    boolean insert(int val) {
      boolean isNew = !map.containsKey(val) || map.get(val).isEmpty();

      map.putIfAbsent(val, new HashSet<>());
      map.get(val).add(list.size());
      list.add(val);

      return isNew;
    }

    boolean remove(int val) {
      if (!map.containsKey(val) || map.get(val).isEmpty())
        return false;

      int idx = map.get(val).iterator().next();
      map.get(val).remove(idx);

      int lastIdx = list.size() - 1;
      int lastVal = list.get(lastIdx);

      if (idx != lastIdx) {
        list.set(idx, lastVal);

        map.get(lastVal).remove(lastIdx);
        map.get(lastVal).add(idx);
      }

      list.remove(lastIdx);
      return true;
    }

    int getRandom() {
      return list.get(rand.nextInt(list.size()));
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int q = scn.nextInt();

    RandomizedCollection rc = new RandomizedCollection();

    for (int i = 0; i < q; i++) {
      String op = scn.next();
      if (op.equals("insert")) {
        System.out.println(rc.insert(scn.nextInt()));
      } else if (op.equals("remove")) {
        System.out.println(rc.remove(scn.nextInt()));
      } else {
        System.out.println(rc.getRandom());
      }
    }
  }
}

/*
 * Input:
 * 7
 * insert 1
 * insert 1
 * insert 2
 * getRandom
 * remove 1
 * getRandom
 * remove 2
 * 
 * Output:
 * true
 * false
 * true
 * 1 or 2
 * true
 * 1 or 2
 * true
 */
