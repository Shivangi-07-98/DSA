import java.io.*;
import java.util.*;

public class delete {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine(); // ((a+b))

    Stack<Character> st = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (ch == ')') {
        if (st.peek() == '(') {
          System.out.println("true have duplicate brackets");
          return;
          // break;
        } else {
          while (st.peek() != '(') {
            st.pop();
          }
          st.pop();
        }
      } else {
        st.push(ch);
      }
      
    }

    System.out.println("false no duplicate brackets");

  }
}
