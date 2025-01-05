import java.util.*;
public class stringbuilder {
    public static void main(String[]args){

        long start = System.currentTimeMillis();

        // String s = " ";
        // for (int i = 0; i < 1000000; i++){
        //     s += i;
        // }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++){
               sb.append(i);
        }

        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println(duration);
        System.out.println(sb);
    }
}
