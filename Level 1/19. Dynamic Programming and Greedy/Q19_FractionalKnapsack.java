import java.io.*;
import java.util.*;

public class Q19_FractionalKnapsack {

  public static class Item implements Comparable<Item> {
    int val;
    int wt;
    double vwRatio;

    public int compareTo(Item o) {
      if (this.vwRatio < o.vwRatio) {
        return -1;
      } else if (this.vwRatio > o.vwRatio) {
        return +1;
      } else {
        return 0;
      }
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 10

    int[] values = new int[n];
    int[] weights = new int[n];
    for (int i = 0; i < n; i++) { // 33 14 50 9 8 11 6 40 2 15
      values[i] = scn.nextInt();
    }
    for (int i = 0; i < n; i++) { // 7 2 5 9 3 2 1 10 3 3
      weights[i] = scn.nextInt();
    }
    int cap = scn.nextInt(); // 5

    System.out.println(fractionalKnapsack(values, weights, cap));
  }

  // Greedy solution
  public static double fractionalKnapsack(int[] values, int[] weights, int cap) {
    int n = values.length;
    Item[] items = new Item[n];

    for (int i = 0; i < n; i++) {
      items[i] = new Item();
      items[i].val = values[i];
      items[i].wt = weights[i];
      items[i].vwRatio = (items[i].val * 1.0) / items[i].wt;
    }

    Arrays.sort(items);
    double vib = 0; // value in bag
    int rc = cap; // remaining capacity
    int i = n - 1;

    while (rc > 0) {
      if (rc >= items[i].wt) {
        vib = vib + items[i].val;
        rc = rc - items[i].wt;
      } else {
        vib += (rc * items[i].val * 1.0) / items[i].wt;
        rc = 0;
        break;
      }
      i--;
    }

    return vib;
  }

}
// greedy: sort by value/weight ratio, take items greedily
// can take fraction of items
// maximize value within capacity, bag mai value maximum krni hai

/*
 * Sample Input:
 * 10
 * 33 14 50 9 8 11 6 40 2 15 (value)
 * 7 2 5 9 3 2 1 10 3 3 (weight)
 * 5 (bag of 5 kg capacity)
 * 
 * Sample Output:
 * 50.0
 */
