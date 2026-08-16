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
