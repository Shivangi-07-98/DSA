import java.io.*;
import java.util.*;

// O(n) - each character processed once
// Evaluate prefix expression and convert to infix and postfix
public class Q12_PrefixEvaluationAndConversions {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String exp = scn.nextLine();

    Stack<Integer> vs = new Stack<>(); // value stack for evaluation
    Stack<String> is = new Stack<>(); // infix string stack
    Stack<String> ps = new Stack<>(); // postfix string stack

    // Process from right to left (reverse of postfix)
    for (int i = exp.length() - 1; i >= 0; i--) {
      char ch = exp.charAt(i);

      if (ch >= '0' && ch <= '9') {
        // Operand: push to all three stacks
        vs.push(ch - '0');
        is.push(ch + "");
        ps.push(ch + "");
      } else {
        // operator like +-*/
        // Note: v1 is on top this time (opposite of postfix)
        int v1 = vs.pop();
        int v2 = vs.pop();
        int res = operation(v1, v2, ch);
        vs.push(res);

        String iv1 = is.pop();
        String iv2 = is.pop();
        is.push("(" + iv1 + ch + iv2 + ")"); // infix: (v1 op v2)

        String pv1 = ps.pop();
        String pv2 = ps.pop();
        ps.push(pv1 + pv2 + ch); // postfix: v1 v2 op
      }
    }

    System.out.println(vs.peek()); // evaluated value
    System.out.println(is.peek()); // infix expression
    System.out.println(ps.peek()); // postfix expression
    scn.close();
  }

  static int operation(int v1, int v2, char op) {
    if (op == '+') {
      return v1 + v2;
    } else if (op == '-') {
      return v1 - v2;
    } else if (op == '*') {
      return v1 * v2;
    } else { // divide
      return v1 / v2;
    }
  }
}

// Conversion rules:
// infix = v1 op v2  (e.g., a+b)
// prefix = op v1 v2 (e.g., +ab)
// postfix = v1 v2 op (e.g., ab+)

// Prefix evaluation: process right to left, when operator found, apply to next two operands
// Prefix to Infix: (v1 op v2) with parentheses
// Prefix to Postfix: v1 v2 op (operands first, operator last)

// Sample Input:
// -+2/*6483
//
// Sample Output:
// 2 (evaluated value)
// ((2+((6*4)/8))-3) (infix)
// 264*8/+3- (postfix)
