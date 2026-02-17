import java.io.*;
import java.util.*;

public class Q20_MinimumStackConstantSpace {

  public static class MinStack {
    Stack<Integer> data;
    int min;

    public MinStack() {
      data = new Stack<>();
    }

    int size() {
      return data.size();
    }

    void push(int val) {
      if (data.size() == 0) {
        data.push(val);
        min = val;
      } else if (val >= min) {
        data.push(val);
      } else {
        int encodedVal = val + (val - min); // 2*val - min
        data.push(encodedVal);
        min = val;
      }
    }

    int pop() {
      if (data.size() == 0) {
        System.out.println("Stack underflow");
        return -1;
      } else if (data.peek() >= min) {
        return data.pop();
      } else {
        int rval = min;
        int encodedVal = data.pop();
        min = 2 * min - encodedVal;
        return rval;
      }
    }

    int top() {
      if (data.size() == 0) {
        System.out.println("Stack underflow");
        return -1;
      } else if (data.peek() >= min) {
        return data.peek();
      } else {
        return min;
      }
    }

    int min() {
      if (data.size() == 0) {
        System.out.println("Stack underflow");
        return -1;
      }
      return min;
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
