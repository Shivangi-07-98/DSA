import java.io.*;
import java.util.*;

public class delete {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    // ((a+b) = more opening
    // (a+b)) = more closing
    // {[(a+b) + c} + c] = bracket mismatch
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (ch == '(' || ch == '{' || ch == '[') {
        stack.push(ch);
      } else if (ch == ')') {
        if (stack.size() > 0 && stack.peek() == '(') {
          stack.pop();
        } else {
          System.out.println("bracket mismatch or extra closing bracket");
          return;
        }
      } else if (ch == '}') {
        if (stack.size() > 0 && stack.peek() == '{') {
          stack.pop();
        } else {
          System.out.println("bracket mismatch or extra closing bracket");
          return;
        }
      } else if (ch == ']') {
        if (stack.size() > 0 && stack.peek() == '[') {
          stack.pop();
        } else {
          System.out.println("bracket mismatch or extra closing bracket");
          return;
        }
      }
    }

    if (stack.size() != 0) {
      System.out.println("unbalanced brackets");
    } else {
      System.out.println("balanced brackets");
    }

  }
}
