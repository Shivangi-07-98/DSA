import java.io.*;
import java.util.*;

public class Q22_QueueToStackAdapterPopEfficient {

  public static class QueueToStackAdapter {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackAdapter() {
      mainQ = new ArrayDeque<>();
      helperQ = new ArrayDeque<>();
    }

    int size() {
      return mainQ.size();
    }

    void push(int val) {
      helperQ.add(val);

      // move everything to helper
      while (mainQ.size() > 0) {
        helperQ.add(mainQ.remove());
      }

      // swap queues
      Queue<Integer> temp = mainQ;
      mainQ = helperQ;
      helperQ = temp;
    }

    void push2(int val) {
      // move everything to helper
      while (mainQ.size() > 0) {
        helperQ.add(mainQ.remove());
      }

      // add new value to main
      mainQ.add(val);

      // bring everything back
      while (helperQ.size() > 0) {
        mainQ.add(helperQ.remove());
      }
    }

    int pop() {
      if (mainQ.size() == 0) {
        System.out.println("Stack underflow");
        return -1;
      }
      return mainQ.remove();
    }

    int top() {
      if (mainQ.size() == 0) {
        System.out.println("Stack underflow");
        return -1;
      }
      return mainQ.peek();
    }

  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    QueueToStackAdapter st = new QueueToStackAdapter();

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
      }
    }

    scn.close();
  }
  
}

/*
 * INPUT:
 * push 10
 * push 20
 * push 30
 * top
 * pop
 * size
 * quit
 * 
 * OUTPUT:
 * 30
 * 30
 * 2
 */
