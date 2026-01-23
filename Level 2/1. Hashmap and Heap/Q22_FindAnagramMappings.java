// Time Complexity: O(n), Space Complexity: O(n)
import java.io.*;
import java.util.*;

public class Q22_FindAnagramMappings {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];

    for (int i = 0; i < a.length; i++) {
      a[i] = s.nextInt();
    }

    for (int j = 0; j < b.length; j++) {
      b[j] = s.nextInt();
    }

    int[] res = anagramMappings(a, b);
    for (int j = 0; j < res.length; j++) {
      System.out.print(res[j] + " ");
    }
  }

  public static int[] anagramMappings(int[] arr1, int[] arr2) {
    HashMap<Integer, Queue<Integer>> map = new HashMap<>();

    // store indices of arr2
    for (int i = 0; i < arr2.length; i++) {
      if (!map.containsKey(arr2[i])) {
        map.put(arr2[i], new LinkedList<>());
      }
      map.get(arr2[i]).add(i);
    }

    int[] res = new int[arr1.length];

    // map arr1 elements to indices in arr2
    for (int i = 0; i < arr1.length; i++) {
      res[i] = map.get(arr1[i]).remove();
    }

    return res;
  }

}

/*
 * Input
 * 4 12 28 46 32
 * 28 12 32 46
 * 
 * Output
 * 1 0 3 2
 */
