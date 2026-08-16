package OOPs;

import java.io.*;
import java.util.*;

class Parent {
  /*
   * OVERLOADING:
   * Same method name + DIFFERENT parameters
   * The definition of overloading itself requires the parameters to be different.
   *
   * Example:
   * fun()
   * fun(int)
   *
   * Both have the same name, but different parameters,
   * so they are overloaded methods.
   */

  // FINAL METHOD
  // Child cannot override this method.
  final void fun() {
    System.out.println("Hello");
  }

  // OVERLOADING
  // Same method name "fun", but different parameters.
  // This is allowed even though fun() is final.
  final void fun(int a) {
    System.out.println("Hello");
  }
}

class Child extends Parent {
  // OVERLOADING
  // Same method name "fun", but different parameters.
  // Parent has fun() and fun(int).
  // Child can also have fun(int, int).
  final void fun(int a, int b) {
    System.out.println("Hello");
  }

  /*
   * OVERRIDING:
   * Same method name + SAME parameters in Parent and Child.
   *
   * Parent: fun()
   * Child: fun()
   *
   * Normally, this would be overriding.
   * BUT Parent's fun() is final,
   * so Child CANNOT override it.
   */

  // void fun() {
  // System.out.println("Hello");
  // }
  // ERROR: cannot override the final method from Parent
}

public class f6 {
  public static void main(String[] args) {

    Child obj = new Child();

    obj.fun(); // Parent's fun()
    obj.fun(10); // Parent's fun(int)
    obj.fun(10, 20); // Child's fun(int, int)
  }
}

/*
 * ==================================================
 * OVERLOADING
 * ==================================================
 * 
 * Definition:
 * Same method name + DIFFERENT parameters.
 * 
 * Example:
 * 
 * fun()
 * fun(int)
 * fun(int, int)
 * 
 * These are overloaded because their parameters are different.
 * 
 * The method body can be exactly the same.
 * The parameters must be different.
 * 
 * IMPORTANT:
 * If the method name AND parameters are both the same,
 * it is NOT overloading.
 * 
 * 
 * ==================================================
 * OVERRIDING
 * ==================================================
 * 
 * Definition:
 * When a Child class provides its own version of a method
 * that already exists in the Parent class,
 * with the SAME method name and SAME parameters.
 * 
 * Example:
 * 
 * Parent: fun()
 * Child: fun()
 * 
 * This is overriding.
 * 
 * The method body can be SAME or DIFFERENT.
 * 
 * BUT:
 * If the Parent method is final,
 * the Child cannot override it.
 * 
 * 
 * ==================================================
 * INHERITANCE
 * ==================================================
 * 
 * If Child does NOT write its own fun(),
 * it can still use Parent's fun().
 * 
 * This is inheritance, NOT overriding.
 * 
 * Example:
 * 
 * class Parent {
 * void fun() {
 * System.out.println("Hello");
 * }
 * }
 * 
 * class Child extends Parent {
 * // no fun() here
 * }
 * 
 * Child obj = new Child();
 * obj.fun(); // inherited from Parent
 * 
 * 
 * ==================================================
 * POLYMORPHISM
 * ==================================================
 * 
 * Definition:
 * Polymorphism means "one thing, many forms."
 * 
 * In OOP, the same method call can behave differently
 * depending on the actual object.
 * 
 * Example:
 * 
 * class Parent {
 * void fun() {
 * System.out.println("Parent");
 * }
 * }
 * 
 * class Child extends Parent {
 * void fun() {
 * System.out.println("Child");
 * }
 * }
 * 
 * Parent obj = new Child();
 * 
 * obj.fun(); // Child
 * 
 * Here:
 * 
 * Reference type = Parent
 * Actual object = Child
 * 
 * The same call:
 * 
 * obj.fun();
 * 
 * runs Child's fun() because Child has overridden it.
 * 
 * This is called Runtime Polymorphism.
 * 
 * Runtime Polymorphism happens through Method Overriding.
 */
