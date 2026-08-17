package OOPs;

import java.io.*;
import java.util.*;

public class f10 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    Employee obj = new Employee("A", 10); // not allowed because Employee class is abstract
    obj.markAttendance();

    obj = new HREmployee(null, "A", 10);
    obj.markAttendance();

    obj = new SoftwareEmployee("", "A", 10);
    obj.markAttendance();
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

    // abstract void doWork();
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

  // static class OperationsEmployee extends Employee {
  // List<Integer> operations;

  // SoftwareEmployee(List<Integer> ops, String name, int empid){
  // super(name, empid);
  // this.operations = ops;
  // }

  // void doWork() {
  // System.out.println(name + " does operations");
  // }
  // }

}

// super(name, empid);
// means call the constructor of my parent class (Employee) and give it name and
// empid

// class HREmployee extends Employee {
//   int salary;

//   HREmployee(String name, int empid, int salary) {
//     super(name, empid); // Parent handles name and empid
//     this.salary = salary; // Child handles salary
//   }
// }
