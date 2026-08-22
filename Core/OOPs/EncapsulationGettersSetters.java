package OOPs;

/*
Question: Create a class using encapsulation. Keep the data private and use
getters and setters. Prevent an invalid age from being stored.

Idea:
The field is private, so code outside Person cannot directly write an invalid
age. setAge() is the single controlled gate through which age can be changed.
*/
public class EncapsulationGettersSetters {
  static class Person {
    private String name;
    private int age;

    Person(String name, int age) {
      this.name = name;
      setAge(age); // use the same validation during object creation
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      if (age >= 0 && age <= 150) {
        this.age = age;
      } else {
        System.out.println("Age must be between 0 and 150.");
      }
    }
  }

  public static void main(String[] args) {
    Person person = new Person("Aman", 22);
    System.out.println(person.getName() + " is " + person.getAge() + " years old.");

    person.setAge(-5); // rejected; object stays valid
    person.setAge(23);
    System.out.println("Updated age: " + person.getAge());
  }
}
