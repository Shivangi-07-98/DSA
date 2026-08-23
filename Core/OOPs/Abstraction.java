package OOPs;

/*
 * Abstraction means showing only the necessary details
 * and hiding the implementation details.
 *
 * Example:
 * Employee knows that every employee has to doWork().
 * But Employee does not need to know HOW every employee works.
 *
 * HREmployee      -> creates payroll
 * SoftwareEmployee -> writes code
 * OperationsEmployee -> does operations
 *
 * In Java, abstraction can be achieved using:
 * 1. Abstract classes
 * 2. Interfaces
 */

import java.io.*;
import java.util.*;

public class Abstraction {

  static abstract class Employee {
    String name;
    int empid;

    Employee(String name, int empid) {
      this.name = name;
      this.empid = empid;
    }

    // Common method
    void markAttendance() {
      System.out.println(name + " is present");
    }

    // Abstract method:
    // Employee says every employee must doWork(),
    // but does not provide the implementation.
    abstract void doWork();
  }

  static class HREmployee extends Employee {
    HREmployee(String name, int empid) {
      super(name, empid);
    }

    void doWork() {
      System.out.println(name + " creates payroll");
    }
  }

  static class SoftwareEmployee extends Employee {
    SoftwareEmployee(String name, int empid) {
      super(name, empid);
    }

    void doWork() {
      System.out.println(name + " writes code");
    }
  }

  public static void main(String[] args) {
    Employee obj = new HREmployee("A", 10);
    obj.markAttendance();
    obj.doWork();

    obj = new SoftwareEmployee("B", 20);
    obj.markAttendance();
    obj.doWork();
  }
}

/*
 * We cannot do:
 * Employee obj = new Employee("A", 10);
 * because Employee is abstract.
 *
 * Employee only says:
 * abstract void doWork();
 * It does NOT say how doWork() should work.
 *
 * HREmployee provides:
 * creates payroll
 *
 * SoftwareEmployee provides:
 * writes code
 *
 * So the implementation details are provided by the
 * specific child classes.
 *
 * 1. An abstract class cannot be instantiated directly.
 *
 * 2. An abstract class can have:
 * - normal methods
 * - abstract methods
 * - variables
 * - constructors
 *
 * 3. An abstract method has no body:
 * abstract void doWork();
 *
 * 4. A child class must implement the abstract methods,
 * unless the child class is also abstract.
 *
 * 5. Abstraction can be achieved using abstract classes
 * and interfaces.
 *
 * Abstraction means showing only the necessary details
 * and hiding the implementation details
 */
