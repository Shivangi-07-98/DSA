package OOPs;

import java.io.*;
import java.util.*;

public class Polymorphism {

  public static void main(String[] args) {
    Parent obj;

    obj = new Child1();
    obj.fun();

    obj = new Child2();
    obj.fun();
  }

  static class Parent {
    void fun() {
      System.out.println("Parent fun");
    }
  }

  static class Child1 extends Parent {
    void fun() {
      System.out.println("Child1 fun");
    }
  }

  static class Child2 extends Parent {
    void fun() {
      System.out.println("Child2 fun");
    }
  }
}

/*
 * What is polymorphism?
 * Polymorphism simply means one thing can have multiple forms.
 * 
 * There are two important types:
 * 
 * Compile-time polymorphism → Method Overloading
 * Runtime polymorphism → Method Overriding
 * 
 * Compile-time polymorphism
 * Method overloading is compile-time polymorphism. The method name is the same,
 * but the parameters are different. The compiler decides which method to call
 * by looking at the arguments.
 * 
 * Runtime polymorphism
 * Method overriding is runtime polymorphism. The parent and child have the same
 * method, and when we use a parent reference with a child object, the method of
 * the actual object is called at runtime.
 * 
 * MethodOverloading.java contains Compile-time polymorphism example
 */

// OVERLOADING
// same method name
// different parameters
//         ↓
// compiler decides
//         ↓
// compile-time polymorphism

// OVERRIDING
// same method name
// same parameters
//         ↓
// actual object decides
// (whether the object is of the parent class or an extended/child class)
//         ↓
// runtime polymorphism
