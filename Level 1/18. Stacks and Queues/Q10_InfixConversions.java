import java.io.*;
import java.util.*;

// O(n) - each character processed once
// Convert infix expression to prefix and postfix using two stacks
public class Q10_InfixConversions {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String exp = scn.nextLine();

    Stack<Character> ostack = new Stack<>(); // stack for operators and brackets
    Stack<String> pre = new Stack<>(); // stack for prefix expressions
    Stack<String> post = new Stack<>(); // stack for postfix expressions

    for (int i = 0; i < exp.length(); i++) {
      char ch = exp.charAt(i);

      if (ch == '(') {
        ostack.push(ch);
      } else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
        // Operand: push to both prefix and postfix stacks as string
        pre.push(ch + "");
        post.push(ch + "");
      } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
        // Process operators with higher or equal precedence first
        while (ostack.size() > 0 && ostack.peek() != '(' 
            && precedence(ostack.peek()) >= precedence(ch)) {
          conversion(ostack, pre, post);
        }
        ostack.push(ch);
      } else if (ch == ')') {
        // Process until we find matching opening bracket
        while (ostack.size() > 0 && ostack.peek() != '(') {
          conversion(ostack, pre, post);
        }
        ostack.pop(); // remove the opening bracket
      }
    }

    // Process remaining operators
    while (ostack.size() > 0) {
      conversion(ostack, pre, post);
    }

    System.out.println(post.peek()); // postfix expression
    System.out.println(pre.peek()); // prefix expression
    scn.close();
  }

  static void conversion(Stack<Character> ostack, Stack<String> pre, Stack<String> post) {
    char op = ostack.pop();
    
    // Prefix: operator comes first (op + val1 + val2)
    String preval2 = pre.pop();
    String preval1 = pre.pop();
    pre.push(op + preval1 + preval2);
    
    // Postfix: operator comes last (val1 + val2 + op)
    String postval2 = post.pop();
    String postval1 = post.pop();
    post.push(postval1 + postval2 + op);
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
}

// Conversion rules:
// infix = v1 op v2  (e.g., a+b)
// prefix = op v1 v2 (e.g., +ab)
// postfix = v1 v2 op (e.g., ab+)

// Sample Input:
// a*(b-c+d)/e
//
// Sample Output:
// abc-d+*e/  (postfix)
// /*a+-bcde  (prefix)
