import java.io.*;
import java.util.*;

// O(n) - each character processed once
// Evaluate infix expression using two stacks (operands and operators)
public class Q9_InfixEvaluation {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String exp = scn.nextLine(); // 2+6*4/8-3

    Stack<Integer> vstack = new Stack<>(); // stack for values/operands
    Stack<Character> ostack = new Stack<>(); // stack for operators and brackets

    for (int i = 0; i < exp.length(); i++) {
      char ch = exp.charAt(i);
 
      if (ch == '(') {
        ostack.push(ch);
      } else if (ch >= '0' && ch <= '9') {
        // '0' and '9' are CHARACTERS (single quotes), not strings
        // Characters have numeric values: '0'=48, '1'=49, ..., '9'=57
        // So we can compare them directly: '0' <= ch <= '9' means ch is a digit
        // ch - '0' converts char to int: '5' - '0' = 53 - 48 = 5
        vstack.push(ch - '0');
      } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
        // Process operators with higher or equal precedence first
        // Example: If stack has '/' (precedence 2) and current is '+' (precedence 1)
        //   precedence('/') >= precedence('+') → 2 >= 1 → true → do operation
        // Example: If stack has '+' (precedence 1) and current is '-' (precedence 1)
        //   precedence('+') >= precedence('-') → 1 >= 1 → true → do operation (left to right)
        // Example: If stack has '+' (precedence 1) and current is '*' (precedence 2)
        //   precedence('+') >= precedence('*') → 1 >= 2 → false → don't do operation, just push
        while (ostack.size() > 0 && ostack.peek() != '('
            && precedence(ostack.peek()) >= precedence(ch)) {
          char op = ostack.pop();
          int v2 = vstack.pop();
          int v1 = vstack.pop();
          int res = operation(v1, v2, op);
          vstack.push(res);
        }
        ostack.push(ch); // Push current operator after processing higher precedence ones
      } else if (ch == ')') {
        // Process until we find matching opening bracket
        while (ostack.size() > 0 && ostack.peek() != '(') {
          char op = ostack.pop();
          int v2 = vstack.pop();
          int v1 = vstack.pop();
          int res = operation(v1, v2, op);
          vstack.push(res);
        }
        ostack.pop(); // remove the opening bracket '('
      }
    }

    // After processing all characters, process remaining operators in stack
    // This handles operators that didn't get processed during the loop
    while (ostack.size() > 0) {
      char op = ostack.pop();
      int v2 = vstack.pop();
      int v1 = vstack.pop();
      int res = operation(v1, v2, op);
      vstack.push(res);
    }

    System.out.println(vstack.peek());
    scn.close();
  }

  static int precedence(char op) {
    if (op == '+') {
      return 1;
    } else if (op == '-') {
      return 1;
    } else if (op == '*') {
      return 2;
    } else { // divide
      return 2;
    }
  }

  static int operation(int v1, int v2, char op) {
    if (op == '+') {
      return v1 + v2;
    } else if (op == '-') {
      return v1 - v2;
    } else if (op == '*') {
      return v1 * v2;
    } else {
      return v1 / v2;
    }
  }
}

// Operator precedence:
// + and - have precedence 1 (equal, left to right)
// * and / have precedence 2 (equal, left to right)
// * and / have higher precedence than + and -

// Sample Input:
// 2+6*4/8-3
//
// Sample Output:
// 2

// Another Sample Input:
// (2+6)*4/8-3
//
// Sample Output:
// 0

// basically solve an expression in the ques but rule is not same as bodmas
