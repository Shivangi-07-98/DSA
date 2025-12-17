// LeetCode 914: X of a Kind in a Deck of Cards
// https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
// Time Complexity: O(n)
// Space Complexity: O(n)
import java.io.*;
import java.util.*;

public class Q10_XOfAKindInADeck {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    boolean ans = hasGroupsSizeX(arr);
    System.out.println(ans);
  }

  // check if arr can be partitioned into groups of size x (x >= 2)
  static boolean hasGroupsSizeX(int[] arr) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int val : arr) {
      if (map.containsKey(val)) {
        map.put(val, map.get(val) + 1);
      } else {
        map.put(val, 1);
      }
    }

    int counter = 0;
    int gcd = 1;

    for (int key : map.keySet()) {
      if (counter == 0) {
        gcd = map.get(key);
      } else {
        int num = map.get(key);
        gcd = getGCD(num, gcd);
      }
      counter++;
    }

    return gcd >= 2;
  }

  static int getGCD(int n1, int n2) {
    while (n1 % n2 != 0) {
      int rem = n1 % n2;
      n1 = n2;
      n2 = rem;
    }
    return n2;
  }

}

/*
 * Sample Input:
 * 8
 * 1 2 3 4 4 3 2 1
 * 
 * Sample Output:
 * true
 * 
 * Explanation:
 * Every set size should be equal and every set should have same element.
 * (Each set should have only one type of data and all sets should have equal
 * size)
 */
