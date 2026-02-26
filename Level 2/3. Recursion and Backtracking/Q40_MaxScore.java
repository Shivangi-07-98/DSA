// Time Complexity: O(2^n)
// Space Complexity: O(1)
import java.util.*;

public class Q40_MaxScore {

  private static int solve(String[] words, int idx, int[] freq, int[] score) {
    if (idx == words.length) return 0;

    int max = solve(words, idx + 1, freq, score);

    String w = words[idx];
    int wordScore = 0;
    boolean canTake = true;
    int[] used = new int[26];

    for (int i = 0; i < w.length(); i++) {
      int ch = w.charAt(i) - 'a';
      used[ch]++;
      if (used[ch] > freq[ch]) {
        canTake = false;
        break;
      }
      wordScore += score[ch];
    }

    if (canTake) {
      for (int i = 0; i < 26; i++) freq[i] -= used[i];
      max = Math.max(max, wordScore + solve(words, idx + 1, freq, score));
      for (int i = 0; i < 26; i++) freq[i] += used[i];
    }

    return max;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    String[] words = new String[n];
    for (int i = 0; i < n; i++) words[i] = scn.next();
    String letters = scn.next();
    int[] freq = new int[26];
    for (int i = 0; i < letters.length(); i++) freq[letters.charAt(i) - 'a']++;
    int[] score = new int[26];
    for (int i = 0; i < 26; i++) score[i] = scn.nextInt();
    System.out.println(solve(words, 0, freq, score));
  }

}

/*
 * Input:
 * 4
 * dog cat dad good
 * aatddog
 * 1 0 9 5 0 0 3 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
 *
 * Output:
 * 17
 */
