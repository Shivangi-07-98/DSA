package OOPs;

import java.io.*;
import java.util.*;

public class f9 {
  public static void main(String[] args) {
    P obj = new P();
    obj.fun();
  }

  static class P {
    final int maxScore;

    {
      maxScore = 100; // ✅ Allowed
    }

    void fun(){
      System.out.println("maxScore is " + maxScore);
    }
  }
}
