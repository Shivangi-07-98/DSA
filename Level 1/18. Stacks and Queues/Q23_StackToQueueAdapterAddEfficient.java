import java.io.*;
import java.util.*;

public class Q23_StackToQueueAdapterAddEfficient {

  public static class StackToQueueAdapter {
    Stack<Integer> mainS;
    Stack<Integer> helperS;

    public StackToQueueAdapter() {
      mainS = new Stack<>();
      helperS = new Stack<>();
    }

    int size() {
      return mainS.size();
    }

    void add(int val) {
      mainS.push(val);
    }

    int remove() {
      if (mainS.size() == 0) {
        System.out.println("Queue underflow");
        return -1;
      }

      // move elements except last
      while (mainS.size() > 1) {
        helperS.push(mainS.pop());
      }

      int val = mainS.pop();

      // restore
      while (helperS.size() > 0) {
        mainS.push(helperS.pop());
      }

      return val;
    }

    int peek() {
      if (mainS.size() == 0) {
        System.out.println("Queue underflow");
        return -1;
      }

      while (mainS.size() > 1) {
        helperS.push(mainS.pop());
      }

      int val = mainS.peek();
      helperS.push(mainS.pop());

      // restore
      while (helperS.size() > 0) {
        mainS.push(helperS.pop());
      }

      return val;
    }

  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    StackToQueueAdapter q = new StackToQueueAdapter();

    while (true) {
      String str = scn.nextLine();

      if (str.equals("quit")) {
        break;
      } else if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        q.add(val);
      } else if (str.startsWith("remove")) {
        int val = q.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = q.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(q.size());
      }
    }

    scn.close();
  }
  
}

/*
 * INPUT:
 * add 10
 * add 20
 * add 30
 * peek
 * remove
 * size
 * quit
 * 
 * OUTPUT:
 * 10
 * 10
 * 2
 */
