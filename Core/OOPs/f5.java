package OOPs;
import java.io.*;
import java.util.*;

public class f5 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    P obj = null;

    obj = new C();

    obj.fun();
  }

  static class P {
    final void fun(){
      System.out.println("P's fun");
    }
  }

  static class C extends P {
    void fun(){
      System.out.println("C's fun");
    }
  }

}

// error - Cannot override the final method from f5.P
// P ka fun() method final hai.
// final method ko child class override nahi kar sakti.

// final method → cannot be overridden
// normal method → can be overridden

/*
Overriding:
Jab child class, parent class ke same method ko use karti hai, usse method overriding kehte hain.

class P {
    void fun() {
        System.out.println("hello");
    }
}

class C extends P {
    void fun() {
        System.out.println("hello");
    }
}

Yahan C ne P ke fun() method ko override kiya hai
*/
