package OOPs;

/*
Question: Demonstrate method overloading.

Idea:
Method overloading means the method name is the same, but the parameters are different.
For example, the add() method can take two integers, three integers, or two double values.
The compiler looks at the arguments given to add() and decides which add() method should be called.
This is called compile-time polymorphism.
*/

import java.io.*;
import java.util.*;

public class MethodOverloading {

  public static void main(String[] args) {
    Calculator calculator = new Calculator();

    System.out.println(calculator.add(2, 3));
    System.out.println(calculator.add(2, 3, 4));
    System.out.println(calculator.add(2.5, 3.5));
  }

  static class Calculator {
    int add(int first, int second) {
      return first + second;
    }

    int add(int first, int second, int third) {
      return first + second + third;
    }

    double add(double first, double second) {
      return first + second;
    }
  }
}
