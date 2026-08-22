package OOPs;

/*
Question: Demonstrate method overloading.

Idea:
The method name is the same: add.
The parameter lists are different: two integers, three integers, and two
double values. The compiler knows which add() to call from the arguments.
This is compile-time polymorphism.
*/
public class MethodOverloading {
    static class Calculator {
        int add(int first, int second) {
            return first + second;
        }

        int add(int first, int second, int third) {
            return first + second + third;
        }

        double add(double first, double second) {
            return first + second;
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println(calculator.add(2, 3));
        System.out.println(calculator.add(2, 3, 4));
        System.out.println(calculator.add(2.5, 3.5));
    }
}
