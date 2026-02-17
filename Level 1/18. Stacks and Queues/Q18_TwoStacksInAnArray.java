import java.io.*;
import java.util.*;

// Implement two stacks in a single array
// Stack 1 grows from left (index 0), Stack 2 grows from right (index n-1)
public class Q18_TwoStacksInAnArray {
  public static class TwoStack {
    int[] data;
    int tos1; // top of stack 1 (points to top element)
    int tos2; // top of stack 2 (points to top element)

    public TwoStack(int cap) {
      data = new int[cap];
      tos1 = -1; // stack 1 empty
      tos2 = data.length; // stack 2 empty
    }

    int size1() {
      return tos1 + 1;
    }

    int size2() {
      return data.length - tos2;
    }

    void push1(int val) {
      if (tos1 == tos2 - 1) {
        System.out.println("Stack overflow");
        return;
      }
      tos1++;
      data[tos1] = val;
    }

    void push2(int val) {
      if (tos1 == tos2 - 1) {
        System.out.println("Stack overflow");
        return;
      }
      tos2--;
      data[tos2] = val;
    }

    int pop1() {
      if (tos1 == -1) {
        System.out.println("Stack underflow");
        return -1;
      }
      int val = data[tos1];
      tos1--;
      return val;
    }

    int pop2() {
      if (tos2 == data.length) {
        System.out.println("Stack underflow");
        return -1;
      }
      int val = data[tos2];
      tos2++;
      return val;
    }

    int top1() {
      if (tos1 == -1) {
        System.out.println("Stack underflow");
        return -1;
      }
      return data[tos1];
    }

    int top2() {
      if (tos2 == data.length) {
        System.out.println("Stack underflow");
        return -1;
      }
      return data[tos2];
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    TwoStack st = new TwoStack(n);

    String str = scn.nextLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push1")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push1(val);
      } else if (str.startsWith("pop1")) {
        int val = st.pop1();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top1")) {
        int val = st.top1();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size1")) {
        System.out.println(st.size1());
      } else if (str.startsWith("push2")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push2(val);
      } else if (str.startsWith("pop2")) {
        int val = st.pop2();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top2")) {
        int val = st.top2();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size2")) {
        System.out.println(st.size2());
      }
      str = scn.nextLine();
    }
    scn.close();
  }
}

// Two stacks in one array:
// Stack 1: grows from left (tos1 starts at -1, increments)
// Stack 2: grows from right (tos2 starts at n, decrements)
// Overflow when: tos2 == tos1 + 1 (stacks meet)

// Sample Input:
// 5
// push1 10
// push1 20
// push2 30
// push2 40
// push2 50
// push1 60
// top1
// pop1
// top1
// pop1
// top2
// pop2
// top2
// pop2
// top1
// pop1
// top2
// pop2
// quit
//
// Sample Output:
// Stack overflow
// 20
// 20
// 10
// 10
// 50
// 50
// 40
// 40
// 30
// 30
