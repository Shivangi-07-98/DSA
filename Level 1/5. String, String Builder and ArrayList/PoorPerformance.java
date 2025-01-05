import java.util.*;
public class PoorPerformance {
    public static void main (String[] args) {

        long start = System.currentTimeMillis();

        String s = " ";
        for (int i = 0; i < 1000000; i++){
            s += i;
        }

        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println(duration);

    }
}
