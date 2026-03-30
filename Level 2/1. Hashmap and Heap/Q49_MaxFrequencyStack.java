// Time Complexity: push O(1), pop O(1), Space Complexity: O(n)

import java.io.*;
import java.util.*;

public class Q49_MaxFrequencyStack {

  private static class FreqStack {
    HashMap<Integer, Integer> freq = new HashMap<>();
    HashMap<Integer, Stack<Integer>> group = new HashMap<>();
    int maxFreq = 0;

    public void push(int val) {
      int f = freq.getOrDefault(val, 0) + 1;
      freq.put(val, f);
      maxFreq = Math.max(maxFreq, f);

      group.putIfAbsent(f, new Stack<>());
      group.get(f).push(val);
    }

    public int pop() {
      int val = group.get(maxFreq).pop();
      freq.put(val, freq.get(val) - 1);

      if (group.get(maxFreq).isEmpty()) {
        maxFreq--;
      }

      return val;
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int q = scn.nextInt();

    FreqStack fs = new FreqStack();

    for (int i = 0; i < q; i++) {
      String op = scn.next();
      if (op.equals("push")) {
        int val = scn.nextInt();
        fs.push(val);
      } else {
        System.out.println(fs.pop());
      }
    }
  }
}

/*
 * Input:
 * 9
 * push 5
 * push 7
 * push 5
 * push 7
 * push 4
 * push 5
 * pop
 * pop
 * pop
 * 
 * Output:
 * 5
 * 7
 * 5
 */
