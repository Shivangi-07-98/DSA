// Time O(n log k)
// Space O(k)

import java.io.*;
import java.util.*;

public class Q64_ReorganizeString {

  private static class Pair {
    char ch;
    int freq;

    Pair(char ch, int freq) {
      this.ch = ch;
      this.freq = freq;
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s = scn.next();

    System.out.println(solution(s));
  }

  public static String solution(String s) {
    int[] freq = new int[26];
    for (char ch : s.toCharArray())
      freq[ch - 'a']++;

    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
    for (int i = 0; i < 26; i++) {
      if (freq[i] > 0)
        pq.add(new Pair((char) ('a' + i), freq[i]));
    }

    StringBuilder sb = new StringBuilder();
    Pair prev = null;

    while (!pq.isEmpty()) {
      Pair curr = pq.remove();
      sb.append(curr.ch);
      curr.freq--;

      if (prev != null && prev.freq > 0)
        pq.add(prev);

      prev = curr;
    }

    return sb.length() == s.length() ? sb.toString() : "";
  }
}

// Input:
// aab
// 
// Output:
// aba
