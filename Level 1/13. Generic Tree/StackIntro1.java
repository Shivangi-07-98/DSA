import java.util.*;

public class StackIntro1 {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        // Stack operations: push, pop, peek are all O(1) time complexity

        stack.push(10); // [10]
        stack.push(20); // [10, 20]
        stack.push(30); // [10, 20, 30]
        stack.push(40); // [10, 20, 30, 40]

        System.out.println(stack);
 
        System.out.println(stack.peek()); // 40
        stack.pop(); // [10, 20, 30]

        System.out.println(stack.peek()); // 30
        stack.pop(); // [10, 20]

        System.out.println(stack.peek()); // 20
        stack.pop(); // [10]

        System.out.println(stack.peek()); // 10
        stack.pop(); // []

        // Attempt to peek at empty stack - will throw EmptyStackException
        System.out.println(stack.peek()); // Error: EmptyStackException
        // Attempt to pop empty stack - will throw EmptyStackException
        stack.pop(); // Error: EmptyStackException

    }
}
