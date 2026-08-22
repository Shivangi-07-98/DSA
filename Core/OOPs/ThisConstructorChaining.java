package OOPs;

/*
 * QUESTION:
 * What is constructor chaining using this()?
 *
 * CONSTRUCTOR CHAINING:
 * Constructor chaining means one constructor calls another constructor.
 *
 * this():
 * this() calls another constructor of the SAME class.
 * 
 * inside one constructor
 * Java allows only one constructor call as the first statement
 *
 * IMPORTANT:
 * 1. this() must be the first statement inside a constructor.
 * 2. this() is used to call another constructor in the same class.
 * 3. The constructor being called can have different parameters.
 */

import java.io.*;
import java.util.*;

public class ThisConstructorChaining {

  public static void main(String[] args) {
    // No values are passed here.
    // Therefore Employee() is called.
    Employee obj = new Employee();

    System.out.println(obj.name); // B
    System.out.println(obj.empid); // 20
  }

  static class Employee {
    String name;
    int empid;

    // No-argument constructor
    Employee() {
      // this() calls another constructor of the SAME class.
      // It passes "B" and 20 to the parameterized constructor.
      this("B", 20);
    }

    // Parameterized constructor
    Employee(String name, int empid) {
      this.name = name;
      this.empid = empid;
    }
  }
}

/*
 * IMPORTANT:
 * If Employee() was empty:
 *
 * Employee() {
 * }
 *
 * then name would be null and empid would be 0,
 * because no constructor would initialize them.
 *
 * DEFAULT CONSTRUCTOR:
 *
 * If we do not write ANY constructor,
 * Java automatically provides a no-argument constructor.
 *
 * But if we write our own constructor, Java does not
 * automatically provide the no-argument constructor.
 *
 * "this" vs "this()":
 *
 * this.name
 * → refers to the current object's variable.
 *
 * this()
 * → calls another constructor of the same class.
 */
