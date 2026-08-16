package OOPs;
import java.io.*;
import java.util.*;

class f4 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    
  }

  static class Person {
    final int maxScore = 100;
    void fun(){
      maxScore++;
      System.out.println("Max score is = " + maxScore);
    }
  }

}

// error - The final field f4.Person.maxScore cannot be assigned
