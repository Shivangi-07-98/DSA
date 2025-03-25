import java.util.*;

public class StackIntro1 {
    public static void main(String[] args) {

        // Create a new stack of integers
        Stack<Integer> stack = new Stack<>();
        // Stack operations: push, pop, peek are all O(1) time complexity

        // Push elements onto the stack
        stack.push(10); // [10]
        stack.push(20); // [10, 20]
        stack.push(30); // [10, 20, 30]
        stack.push(40); // [10, 20, 30, 40]

        // Peek at the top element (40) and print it
        System.out.println(stack.peek()); // 40
        // Remove the top element (40)
        stack.pop(); // [10, 20, 30]

        // Peek at the new top element (30) and print it
        System.out.println(stack.peek()); // 30
        // Remove the top element (30)
        stack.pop(); // [10, 20]

        // Peek at the new top element (20) and print it
        System.out.println(stack.peek()); // 20
        // Remove the top element (20)
        stack.pop(); // [10]

        // Peek at the new top element (10) and print it
        System.out.println(stack.peek()); // 10
        // Remove the top element (10)
        stack.pop(); // []

        // Attempt to peek at empty stack - will throw EmptyStackException
        System.out.println(stack.peek()); // Error: EmptyStackException
        // Attempt to pop empty stack - will throw EmptyStackException
        stack.pop(); // Error: EmptyStackException

    }
}
