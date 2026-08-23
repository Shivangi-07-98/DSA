package OOPs;

/*
 * Definition:
 * Encapsulation means keeping data and the methods that operate
 * on that data together inside a class, and controlling direct
 * access to the data.
 *
 * In Java, we commonly achieve this by:
 * 1. Making data members private.
 * 2. Providing public getter/setter methods when needed.
 *
 * Example:
 * private int age;
 * Outside code cannot directly do:
 * person.age = -5;       // NOT allowed
 * Instead, it uses:
 * person.setAge(-5);
 * The setter can check the value before storing it.
 */

import java.io.*;
import java.util.*;

public class Encapsulation {

  static class Person {
    private String name;
    private int age;

    Person(String name, int age) {
      this.name = name;
      setAge(age);
    }

    // Getter = gets/reads the value
    int getAge() {
      return age;
    }

    // Setter = sets/changes the value
    void setAge(int age) {
      if (age >= 0 && age <= 150) {
        this.age = age;
      }
    }
  }

  public static void main(String[] args) {
    Person person = new Person("A", 22);
    System.out.println(person.getAge()); // 22

    person.setAge(-5); // not stored
    person.setAge(23); // stored
    System.out.println(person.getAge()); // 23
  }
}

/*
 * Getter:
 * A method used to GET/READ a private value.
 *
 * Setter:
 * A method used to SET/CHANGE a private value.
 *
 * Why use them?
 * Because the class can control how its private data is accessed
 * or changed.
 * For example, setAge() can reject an invalid age.
 *
 * IMPORTANT:
 * Getter and setter are NOT compulsory for every private variable.
 *
 * If we don't want outside code to change a value,
 * we can provide only a getter and no setter.
 *
 * We can also put validation, calculations, or other rules
 * inside a setter.
 *
 * Encapsulation means controlling access to the data of a class.
 * We commonly make data private and provide public methods such
 * as getters and setters to read or modify that data in a controlled way
 */
