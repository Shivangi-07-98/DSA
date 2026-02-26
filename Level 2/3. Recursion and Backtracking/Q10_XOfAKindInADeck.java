// LeetCode 914: X of a Kind in a Deck of Cards
// https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
// Time Complexity: O(n), Space Complexity: O(n)
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
      int rem = n1 % n2; // n1 andar hota hai aur n2 bahar hota hai
      n1 = n2; // ab n2 andar aayega n1 bankr aur rem se divide hoga n2 bankr
      n2 = rem;
    }
    return n2;
  }

}

/*
 * Return true if and only if you can split the entire deck into 1 or more
 * groups of cards, where:
 * Each group has exactly x cards (x >= 2)
 * All the cards in each group have the same integer
 * 
 * Example 1:
 * Input: deck = [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1], [2,2], [3,3], [4,4]
 * (x = 2: each group has 2 cards, all cards in a group are same)
 * 
 * Example 2:
 * Input: deck = [1,1,1,2,2,2,3,3]
 * Output: false
 * Explanation: No possible partition
 * (Card 1 appears 3 times, Card 2 appears 3 times, Card 3 appears 2 times.
 * No single x >= 2 can satisfy: all groups must have same size x and all cards
 * in each group must be same integer)
 */
