// Time Complexity: O(n), Space Complexity: O(n)

// WHAT IS THE QUESTION ASKING?
// Anagram: Two strings are anagrams if they contain the same characters with same frequency
// Example: "listen" and "silent" are anagrams
// hme batana hai pehli string ke andar dusri string kis kis index pr chuppi hai
import java.io.*;
import java.util.*;

public class Q19_FindAllAnagrams {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.next();
    String s2 = scn.next();
    findAnagrams(s1, s2);
  }

  public static void findAnagrams(String s1, String s2) {
    int[] map1 = new int[26];
    for (int i = 0; i < s2.length(); i++) {
      char ch = s1.charAt(i);
      map1[ch - 'a']++;
    }

    int[] map2 = new int[26];
    for (int i = 0; i < s2.length(); i++) {
      char ch = s2.charAt(i);
      map2[ch - 'a']++;
    }

    ArrayList<Integer> res = new ArrayList<>();
    if (areAnagram(map1, map2) == true) {
      res.add(0);
    }

    int i = s2.length();
    int j = 0;

    while (i < s1.length()) {
      char chi = s1.charAt(i);
      map1[chi - 'a']++;

      char chj = s1.charAt(j);
      map1[chj - 'a']--;

      if (areAnagram(map1, map2) == true) {
        res.add(j + 1);
      }

      i++;
      j++;
    }

    System.out.println(res.size());
    for (int val : res) {
      System.out.print(val + " ");
    }
  }

  // Constant time complexity
  public static boolean areAnagram(int[] map1, int[] map2) {
    for (int i = 0; i < 26; i++) {
      if (map1[i] != map2[i]) {
        return false;
      }
    }
    return true;
  }

}

// Algorithm - acquire release, pehli string mai dusri string ke length ka window aur freq map maintain krenge acquire release ke tym, aur pehli aur dusri string ke freq map ko match krenge

/*
 * Input:
 * cbaebababacd
 * abc
 * 
 * Output:
 * 2
 * 06
 */
