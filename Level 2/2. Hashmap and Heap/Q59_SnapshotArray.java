// Time Complexity: set O(1), snap O(1), get O(log n), Space Complexity: O(total updates)

import java.io.*;
import java.util.*;

public class Q59_SnapshotArray {

  private static class SnapshotArray {
    int snapId;
    ArrayList<TreeMap<Integer, Integer>> arr;

    SnapshotArray(int length) {
      snapId = 0;
      arr = new ArrayList<>();
      for (int i = 0; i < length; i++) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        arr.add(map);
      }
    }

    void set(int index, int val) {
      arr.get(index).put(snapId, val);
    }

    int snap() {
      return snapId++;
    }

    int get(int index, int sid) {
      return arr.get(index).floorEntry(sid).getValue();
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int length = scn.nextInt();
    int q = scn.nextInt();

    SnapshotArray sa = new SnapshotArray(length);

    for (int i = 0; i < q; i++) {
      String op = scn.next();
      if (op.equals("set")) {
        sa.set(scn.nextInt(), scn.nextInt());
      } else if (op.equals("snap")) {
        System.out.println(sa.snap());
      } else {
        System.out.println(sa.get(scn.nextInt(), scn.nextInt()));
      }
    }
  }
}

/*
 * Input:
 * 3 4
 * set 0 5
 * snap
 * set 0 6
 * get 0 0
 * 
 * Output:
 * 0
 * 5
 */
