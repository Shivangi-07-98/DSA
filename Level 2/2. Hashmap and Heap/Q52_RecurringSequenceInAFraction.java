// Time O(log10(denominator))
// Space O(denominator)

import java.io.*;
import java.util.*;

public class Q52_RecurringSequenceInAFraction {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int numerator = scn.nextInt();
    int denominator = scn.nextInt();

    System.out.println(solution(numerator, denominator));
  }

  public static String solution(int numerator, int denominator) {
    if (numerator == 0)
      return "0";

    StringBuilder sb = new StringBuilder();

    if ((numerator < 0) ^ (denominator < 0)) {
      sb.append("-");
    }

    long n = Math.abs((long) numerator);
    long d = Math.abs((long) denominator);

    sb.append(n / d);
    long rem = n % d;

    if (rem == 0)
      return sb.toString();

    sb.append('.');

    HashMap<Long, Integer> seen = new HashMap<>();

    while (rem != 0) {
      if (seen.containsKey(rem)) {
        int idx = seen.get(rem);
        sb.insert(idx, '(');
        sb.append(')');
        break;
      }

      seen.put(rem, sb.length());
      rem *= 10;
      sb.append(rem / d);
      rem %= d;
    }

    return sb.toString();
  }
}

// Input:
// 4 333
// 
// Output:
// 0.(012)
