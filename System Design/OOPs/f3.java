package OOPs;

import java.io.*;
import java.util.*;

class f3 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    Student s = new Student(10, "A");
  }

  public class DBConnection {
  }

  public class Directory {
  }

  static class Student {
    // During space allocation all data members are set to JAVA given default values
    // Parsing sets data members to Class creator's defaults (e.g. maxScore and
    // schoolName here and growthMultiple in ArrayList)
    int age;
    String name;
    String house;
    static String schoolName = "DAV";
    static int maxScore;
    DBConnection dbconnection;
    Directory studentFolder;
    int fees;

    // static block - for setting dynamic kind of static properties
    static {
      // kind of default ctor for static properties
      // maxScore = read from database and set;
    }

    // For class creator to initialize data members which are dynamic e.g. reading
    // from a file or a db
    Student() {
      // dbconnection = new DBConnection("<ip address>");
      // studentFolder = Files.read("..");
      // fees = dbconnection.getFees();
    }

    // For class user to set values to data members
    Student(int age, String name) {
      this(); // constructor chaining, if give always first line
      this.age = age;
      this.name = name;
    }

    Student(Student s) {
      this.age = s.age;
      this.name = s.name;
    }
  }

}
