// Time Complexity: O(n * k log k), Space Complexity: O(n * k)
// n = number of strings, k = average length of each string
import java.io.*;
import java.util.*;

public class Q23_GroupAnagrams {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    sc.nextLine(); // consume leftover newline
    String[] strs = new String[n];
    for (int i = 0; i < n; i++) {
      strs[i] = sc.nextLine();
    }

    ArrayList<ArrayList<String>> result = groupAnagrams(strs);

    for (ArrayList<String> group : result) {
      System.out.println(group);
    }
  }

  // Function to group anagrams
  public static ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
    HashMap<String, ArrayList<String>> map = new HashMap<>();

    for (String str : strs) {
      // Convert string to char array
      char[] arr = str.toCharArray();

      // Sort characters
      Arrays.sort(arr);

      // Create key from sorted characters
      String key = new String(arr);

      // Add original string to its anagram group
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }

      map.get(key).add(str);
    }

    // Convert map values to result
    return new ArrayList<>(map.values());
  }

}

/*
 * Input:
 * 6
 * eat
 * tea
 * tan
 * ate
 * nat
 * bat
 * 
 * Output:
 * [eat, tea, ate]
 * [tan, nat]
 * [bat]
 */
