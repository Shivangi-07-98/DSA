// Time Complexity: O(n), Space Complexity: O(n)
import java.io.*;
import java.util.*;

public class Q29_WordPattern {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String pattern = scn.next();
    scn.nextLine(); // consume leftover newline
    String str = scn.nextLine();
    System.out.println(solution(pattern, str));
  }

  public static boolean solution(String pattern, String str) {
    String[] words = str.split(" ");
    if (pattern.length() != words.length)
      return false;

    HashMap<Character, String> map = new HashMap<>();
    HashMap<String, Boolean> used = new HashMap<>();

    for (int i = 0; i < pattern.length(); i++) {
      char ch = pattern.charAt(i);
      String word = words[i];
      if (map.containsKey(ch)) {
        if (!map.get(ch).equals(word)) {
          return false; // conflict
        }
      } else {
        if (used.containsKey(word)) {
          return false; // duplicate mapping
        }
        map.put(ch, word);
        used.put(word, true);
      }
    }

    return true;
  }
}

/*
 * Input:
 * abba
 * dog cat cat dog
 * 
 * Output:
 * true
 */
