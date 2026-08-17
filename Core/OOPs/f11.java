package OOPs;

import java.io.*;
import java.util.*;

public class f11 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    // Employee obj = new Employee("A", 10); // not allowed because Employee class is abstract
    // obj.markAttendance();

    Employee obj = new HREmployee(null, "A", 10);
    obj.markAttendance();
    obj.doWork();

    obj = new SoftwareEmployee("", "A", 10);
    obj.markAttendance();
    obj.doWork();
  }

  static abstract class Employee {
    String name;
    int empid;

    Employee(String name, int empid) {
      this.name = name;
      this.empid = empid;
    }

    // final
    void markAttendance() {
      System.out.println(name + " is present");
    }

    abstract void doWork();
  }

  static class HREmployee extends Employee {
    List<Integer> salaries;

    HREmployee(List<Integer> salaries, String name, int empid) {
      super(name, empid);
      this.salaries = salaries;
    }

    void doWork() {
      System.out.println(name + " creates payroll");
    }
  }

  static class SoftwareEmployee extends Employee {
    String conn;

    SoftwareEmployee(String conn, String name, int empid) {
      super(name, empid);
      this.conn = conn;
    }

    void doWork() {
      System.out.println(name + " writes code");
    }
  }

  static class OperationsEmployee extends Employee {
    List<Integer> operations;

    OperationsEmployee(List<Integer> ops, String name, int empid) {
      super(name, empid);
      this.operations = ops;
    }

    void doWork() {
      System.out.println(name + " does operations");
    }
  }

}
