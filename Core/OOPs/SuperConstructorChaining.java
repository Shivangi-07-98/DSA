package OOPs;

/*
 * QUESTION:
 * What is constructor chaining using super()?
 *
 * CONSTRUCTOR CHAINING:
 * Constructor chaining means one constructor calls another constructor.
 *
 * super():
 * super() calls the constructor of the PARENT class.
 *
 * IMPORTANT:
 * 1. super() must be the first statement inside a child constructor.
 * 2. super() is used to call the parent class constructor.
 * 3. It is commonly used when the parent class handles common data
 *    and the child class handles its own specific data.
 */

import java.io.*;
import java.util.*;

public class SuperConstructorChaining {

  public static void main(String[] args) {
    // HREmployee object is created.
    HREmployee obj = new HREmployee("A", 10);

    System.out.println(obj.name); // A
    System.out.println(obj.empid); // 10
  }

  static class Employee {
    String name;
    int empid;

    // Parent constructor
    Employee(String name, int empid) {
      this.name = name;
      this.empid = empid;
    }
  }

  static class HREmployee extends Employee {
    // Child constructor
    HREmployee(String name, int empid) {
      // super() calls the PARENT class constructor.
      // Here Employee(String name, int empid) is called.
      super(name, empid);
    }
  }
}

/*
 * CONSTRUCTOR CHAIN:
 *
 * new HREmployee("A", 10)
 *          ↓
 * HREmployee("A", 10)
 *          ↓
 * super("A", 10)
 *          ↓
 * Employee("A", 10)
 *
 *
 * INHERITANCE:
 *
 * HREmployee extends Employee
 *
 * This means HREmployee is a child class of Employee
 * and gets the properties/methods of Employee.
 *
 *
 * WHY super()?
 *
 * Employee is responsible for initializing:
 *
 * name
 * empid
 *
 * Therefore HREmployee calls the Employee constructor
 * using super(name, empid).
 *
 *
 * "super" vs "super()":
 *
 * super.name
 * → refers to the parent class's variable.
 *
 * super.fun()
 * → calls the parent class's method.
 *
 * super(...)
 * → calls the parent class's constructor.
 *
 *
 * IMPORTANT:
 *
 * If the child constructor does not explicitly write super(...),
 * Java automatically tries to call super() (the parent's no-argument
 * constructor).
 *
 * Therefore, if the parent has no no-argument constructor,
 * the child must explicitly call the appropriate super(...).
 */
