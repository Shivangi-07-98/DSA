import java.io.*;
import java.util.*;

// O(n)
// Assume brackets are balanced Only brackets that don't have content in it are duplicate brackets
public class Q1_DuplicateBrackets {
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();

    Stack<Character> st = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (ch == ')') {
        if (st.peek() == '(') {
          System.out.println(true); // if found duplicate print true
          return;
        } else {
          while (st.size() > 0 && st.peek() != '(') {
            st.pop();
          }
          st.pop(); // remove the opening bracket
        }
      } else {
        st.push(ch); // opening bracket or some char
      }

    }

    System.out.println(false);
  }
}

// (a+b) + (c+d) + (e + (f+g)) = false, no duplicate brackets
// (((a+b) + (c+d))) = true, has duplicate brackets
// (a+b) + ((c+d)) = true, has duplicate brackets
