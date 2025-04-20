import java.util.*;

public class QueueIntro {  
    public static void main(String[] args) {

        // Create a queue using ArrayDeque (FIFO - First In First Out)
        Queue<Integer> queue = new ArrayDeque<>();

        // Add elements to the queue (enqueue operation)
        queue.add(10); 
        queue.add(20); 
        queue.add(30); 
        System.out.println(queue); // [10, 20, 30]

        System.out.println(queue.peek()); // 10 
        queue.remove(); // Remove the front element (dequeue operation)
        System.out.println(queue); // [20, 30]

        System.out.println(queue.peek()); // 20 
        queue.remove(); 
        System.out.println(queue); // [30]
        
        System.out.println(queue.peek()); // 30 
        queue.remove();
        System.out.println(queue); // []

    }
}
 