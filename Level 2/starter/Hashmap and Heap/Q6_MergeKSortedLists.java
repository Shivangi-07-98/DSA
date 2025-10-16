import java.io.*;
import java.util.*;

public class Q6_MergeKSortedLists {

  // comparable is an interface
  static class Pair implements Comparable<Pair> {
    int data;
    int li; // mai kis list ka hoon
    int di; // aur mera index kya hai

    // +ve => this is bigger
    // -ve => this is smaller
    // 0 => this and other are equal
    public int compareTo(Pair other) {
      return this.data - other.data;
    }
  }

  public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
    ArrayList<Integer> rv = new ArrayList<>();
    PriorityQueue<Pair> pq = new PriorityQueue<>(); // pair will implement comparable...why? for priority queue to decide the priority
    // klog(k)
    for (int li = 0; li < lists.size(); li++) {
      Pair p = new Pair();
      p.li = li;
      p.di = 0;
      p.data = lists.get(li).get(0);
      pq.add(p);
    }

    // nlog(k)
    while (pq.size() > 0) {
      Pair rp = pq.peek();
      pq.remove();

      rv.add(rp.data);

      rp.di++;
      if (rp.di < lists.get(rp.li).size()) {
        rp.data = lists.get(rp.li).get(rp.di);
        pq.add(rp);
      }
    }

    return rv;
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int k = scn.nextInt(); // 4
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      ArrayList<Integer> list = new ArrayList<>();

      int n = scn.nextInt();
      for (int j = 0; j < n; j++) {
        int val = scn.nextInt();
        list.add(val);
      }
      lists.add(list);
    }

    ArrayList<Integer> mlist = mergeKSortedLists(lists);
    for (int val : mlist) {
      System.out.print(val + " ");
    }
    System.out.println();
  }

}
// input
// 4
// 5
// 10 20 30 40 50
// 3
// 15 19 24
// 4
// 5 12 18 77
// 2
// 2 92

// output
// 2 5 10 12 15 18 19 20 24 30 40 50 77 92
