import java.util.*;

public class StackIntro2 {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        // Stack operations: push, pop, peek are all O(1) time complexity

        stack.push("Hello"); // ["Hello"]
        stack.push("Bye"); // ["Hello", "Bye"]
        stack.push("World"); // ["Hello", "Bye", "World"]

        // Loop while stack is not empty
        while (stack.size() > 0) {
            String tos = stack.peek();
            System.out.println(tos);
            stack.pop();
        }
    }
} 
