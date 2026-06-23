// Time O(n)
// Space O(1)
import java.io.*;
import java.util.*;

public class Q32_FirstNonRepeatingCharacter {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    System.out.println(solution(str));
  }

  public static char solution(String str) {
    int[] freq = new int[256];

    for (int i = 0; i < str.length(); i++) {
      freq[str.charAt(i)]++;
    }

    for (int i = 0; i < str.length(); i++) {
      if (freq[str.charAt(i)] == 1) {
        return str.charAt(i);
      }
    }

    return '$';
  }
}

// Input:
// swiss
// 
// Output:
// w
