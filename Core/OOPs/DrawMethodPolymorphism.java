package OOPs;

/*
Question: Demonstrate run-time polymorphism by overriding a draw() method.

Idea:
Shape is the common parent type. Circle and Rectangle each give their own
meaning to draw(). A Shape reference is allowed to point to either child.
At run time, Java checks the actual object and runs that child's draw().
*/
public class DrawMethodPolymorphism {
    static class Shape {
        void draw() {
            System.out.println("Drawing a general shape");
        }
    }

    static class Circle extends Shape {
        @Override
        void draw() {
            System.out.println("Drawing a circle");
        }
    }

    static class Rectangle extends Shape {
        @Override
        void draw() {
            System.out.println("Drawing a rectangle");
        }
    }

    public static void main(String[] args) {
        Shape firstShape = new Circle();
        Shape secondShape = new Rectangle();

        firstShape.draw();  // Circle's draw() runs
        secondShape.draw(); // Rectangle's draw() runs
    }
}
