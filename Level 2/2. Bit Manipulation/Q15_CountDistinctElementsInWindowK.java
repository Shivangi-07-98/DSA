// Time Complexity: O(n), Space Complexity: O(k)

// WHAT IS THE QUESTION ASKING?
// For each window of size k in the string, count the number of distinct characters
import java.io.*;
import java.util.*;

public class Q15_CountDistinctElementsInWindowK {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    int k = scn.nextInt();

    countDistinctInWindow(str, k);
  }

  static void countDistinctInWindow(String str, int k) {
    HashMap<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < k; i++) {
      char ch = str.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    System.out.print(map.size() + " ");

    int j = 0;
    for (int i = k; i < str.length(); i++) {
      char ch = str.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);

      char removeCh = str.charAt(j);
      if (map.get(removeCh) == 1) {
        map.remove(removeCh);
      } else {
        map.put(removeCh, map.get(removeCh) - 1);
      }

      System.out.print(map.size() + " ");
      System.out.println();

      j++;
    }
  }

}

/*
 * Input:
 * aabcbcdbca
 * 4
 * 
 * Output:
 * 3
 * 3
 * 2
 * 3
 * 3
 * 3
 * 4
 */
