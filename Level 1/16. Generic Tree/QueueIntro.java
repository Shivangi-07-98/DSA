import java.util.*;

public class QueueIntro {
    public static void main(String[] args) {

        // Create a queue using ArrayDeque (FIFO - First In First Out)
        Queue<Integer> queue = new ArrayDeque<>();

        // Add elements to the queue (enqueue operation)
        queue.add(10); // [10]
        queue.add(20); // [10, 20]
        queue.add(30); // [10, 20, 30]

        System.out.println(queue); // [10, 20, 30]

        // Peek at the front element without removing it
        System.out.println(queue.peek()); // 10 (Queue remains: [10, 20, 30])
        // Remove the front element (dequeue operation)
        queue.remove(); // [20, 30]

        System.out.println(queue); // [20, 30]
        // Peek at the new front element
        System.out.println(queue.peek()); // 20 (Queue remains: [20, 30])
        // Remove the front element
        queue.remove(); // [30]

        System.out.println(queue); // [30]
        // Peek at the new front element
        System.out.println(queue.peek()); // 30 (Queue remains: [30])
        // Remove the last element
        queue.remove(); // []

        System.out.println(queue);

    }
}
