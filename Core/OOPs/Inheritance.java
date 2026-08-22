package OOPs;

/*
 * Definition:
 * Inheritance means a child class gets/uses the properties
 * and methods of a parent class using "extends"
 *
 * Employee
 *    ↓
 * HREmployee
 * SoftwareEmployee
 * OperationsEmployee
 *
 * IMPORTANT:
 * Parent class = Employee
 * Child classes = HREmployee, SoftwareEmployee, OperationsEmployee
 *
 * "extends" is used to create inheritance.
 *
 * Example:
 * class HREmployee extends Employee
 * This means HREmployee is a child of Employee.
 *
 * WHY INHERITANCE?
 * Common properties and methods can be written in the parent
 * instead of writing the same code again in every child class
 */

import java.io.*;
import java.util.*;

public class Inheritance {

  static class Employee {
    String name;
    int empid;

    void markAttendance() {
      System.out.println(name + " is present");
    }
  }

  static class HREmployee extends Employee {
    void createPayroll() {
      System.out.println(name + " creates payroll");
    }
  }

  static class SoftwareEmployee extends Employee {
    void writeCode() {
      System.out.println(name + " writes code");
    }
  }

  public static void main(String[] args) {
    HREmployee hr = new HREmployee();

    hr.name = "A";
    hr.empid = 10;

    // markAttendance() belongs to Employee,
    // but HREmployee can use it because of inheritance.
    hr.markAttendance();

    // createPayroll() belongs to HREmployee.
    hr.createPayroll();
  }
}

/*
 * A child class can use the accessible properties and methods
 * of its parent class.
 * The child can also have its own properties and methods.
 * Multiple child classes can extend the same parent.
 *
 * Java supports single inheritance for classes:
 * One class can extend only one direct parent class.
 *
 * Constructors are NOT inherited.
 * The child has its own constructor.
 * A parent constructor can be called using super().
 *
 * SIMPLE INTERVIEW EXPLANATION:
 * Inheritance means a child class can use the properties and
 * methods of a parent class using extends. It helps us reuse
 * common code instead of writing the same code in every child
 */
