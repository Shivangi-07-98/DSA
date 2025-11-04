import java.io.*;
import java.util.*;

// O(n)
// Check if brackets are balanced - every opening bracket has corresponding closing bracket
public class Q2_BalancedBrackets {
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();

    Stack<Character> st = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (ch == '(' || ch == '[' || ch == '{') {
        st.push(ch);
      } 
      else if (ch == ')') {
        if (st.size() == 0) { // extra closing brackets
          System.out.println(false);
          return;
        } 
        else if (st.peek() != '(') { // mismatch
          System.out.println(false);
          return;
        } 
        else {
          st.pop();
        }
      } 
      else if (ch == ']') {
        if (st.size() == 0) { // extra closing brackets
          System.out.println(false);
          return;
        }
        else if (st.peek() != '[') { // mismatch
          System.out.println(false);
          return;
        } 
        else {
          st.pop();
        }
      } 
      else if (ch == '}') {
        if (st.size() == 0) { // extra closing brackets
          System.out.println(false);
          return;
        } 
        else if (st.peek() != '{') { // mismatch
          System.out.println(false);
          return;
        } 
        else {
          st.pop();
        }
      }
    }

    if (st.size() == 0) {
      System.out.println(true);
    } else {
      System.out.println(false); // extra opening brackets
    }

  }
}

// [{(a+b) + c} + d] = true, has balanced brackets
// (a + (b+c) + d = false, has unbalanced brackets, extra opening brackets
// (a + (b + (c+d)))) = false, has unbalanced brackets, extra closing brackets
// [{(a+b)]} = false, has unbalanced brackets, mismatched brackets
