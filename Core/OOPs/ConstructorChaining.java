package OOPs;

/*
Question: Show constructor chaining in inheritance using super().

Idea:
In inheritance, when a child constructor calls the parent constructor using:
super(...)
that is constructor chaining between the child and parent constructors.

Constructor chaining means:
One constructor calls another constructor

this()  → calls another constructor of the SAME class
super() → calls the constructor of the PARENT class

One important rule:
this() or super() must be the first statement inside a constructor.

Also, a constructor can have either this() or super() as its first statement, not both.
*/

import java.io.*;
import java.util.*;

public class ConstructorChaining {

  public static void main(String[] args) {
    HREmployee obj = new HREmployee("A", 10);

    System.out.println(obj.name);
    System.out.println(obj.empid);
  }

  static class Employee {
    String name;
    int empid;

    Employee() {
      this("Unknown", 0);
    }

    Employee(String name, int empid) {
      this.name = name;
      this.empid = empid;
    }
  }

  static class HREmployee extends Employee {
    HREmployee(String name, int empid) {
      super(name, empid);
    }
  }
}
