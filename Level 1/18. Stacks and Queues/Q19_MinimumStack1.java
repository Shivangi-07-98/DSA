import java.io.*;
import java.util.*;

public class Q19_MinimumStack1 {

  public static class MinStack {
    Stack<Integer> allData;
    Stack<Integer> minData;

    public MinStack() {
      allData = new Stack<>();
      minData = new Stack<>();
    }

    int size() {
      return allData.size();
    }

    void push(int val) {
      allData.push(val);
      if (minData.size() == 0 || val <= minData.peek()) {
        minData.push(val);
      }
    }

    int pop() {
      if (allData.size() == 0) {
        System.out.println("Stack underflow");
        return -1;
      }

      if (allData.peek() == minData.peek()) {
        minData.pop();
        return allData.pop();
      } else {
        return allData.pop();
      }
    }

    int top() {
      if (allData.size() == 0) {
        System.out.println("Stack underflow");
        return -1;
      }
      return allData.peek();
    }

    int min() {
      if (minData.size() == 0) {
        System.out.println("Stack underflow");
        return -1;
      }
      return minData.peek();
    }
    
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    MinStack st = new MinStack();

    while (true) {
      String str = scn.nextLine();

      if (str.equals("quit")) {
        break;
      } else if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      } else if (str.startsWith("min")) {
        int val = st.min();
        if (val != -1) {
          System.out.println(val);
        }
      }
    }

    scn.close();
  }

}

/*
 * INPUT:
 * push 10
 * push 20
 * push 5
 * min
 * pop
 * min
 * top
 * size
 * quit
 * 
 * OUTPUT:
 * 5
 * 5
 * 10
 * 20
 * 2
 */
