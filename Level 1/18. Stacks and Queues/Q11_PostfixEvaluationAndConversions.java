import java.io.*;
import java.util.*;

// O(n) - each character processed once
// Evaluate postfix expression and convert to infix and prefix
public class Q11_PostfixEvaluationAndConversions {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String exp = scn.nextLine();

    Stack<Integer> vs = new Stack<>(); // value stack for evaluation
    Stack<String> is = new Stack<>(); // infix string stack
    Stack<String> ps = new Stack<>(); // prefix string stack

    for (int i = 0; i < exp.length(); i++) {
      char ch = exp.charAt(i);

      if (ch >= '0' && ch <= '9') {
        // Operand: push to all three stacks
        vs.push(ch - '0');
        is.push(ch + "");
        ps.push(ch + "");
      } else {
        // operator like +-*/
        int v2 = vs.pop();
        int v1 = vs.pop();
        int res = operation(v1, v2, ch);
        vs.push(res);

        String iv2 = is.pop();
        String iv1 = is.pop();
        is.push("(" + iv1 + ch + iv2 + ")"); // infix: (v1 op v2)

        String pv2 = ps.pop();
        String pv1 = ps.pop();
        ps.push(ch + pv1 + pv2); // prefix: op v1 v2
      }
    }

    System.out.println(vs.peek()); // evaluated value
    System.out.println(is.peek()); // infix expression
    System.out.println(ps.peek()); // prefix expression
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

// Postfix to Infix: (v1 op v2) with parentheses
// Postfix to Prefix: op v1 v2 (operator first)

// Sample Input:
// 264*8/+3-
//
// Sample Output:
// 2 (evaluated value)
// ((2+((6*4)/8))-3) (infix)
// -+2/*6483 (prefix)
