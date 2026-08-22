package OOPs;

/*
Question: Show constructor chaining in inheritance using super().

Idea:
In inheritance, when a child constructor calls the parent constructor using:
super(...)
that is constructor chaining between the child and parent constructors.

Constructor chaining means:
One constructor calls another constructor
*/
public class ConstructorChaining {
    static class Person {
        String name;

        Person(String name) {
            this.name = name;
            System.out.println("Person constructor: name is set");
        }
    }

    static class Student extends Person {
        int rollNumber;

        Student(String name, int rollNumber) {
            super(name); // must be the first line of a child constructor
            this.rollNumber = rollNumber;
            System.out.println("Student constructor: roll number is set");
        }

        void display() {
            System.out.println(name + " has roll number " + rollNumber);
        }
    }

    public static void main(String[] args) {
        Student student = new Student("Riya", 101);
        student.display();
    }
}
