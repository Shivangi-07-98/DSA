import java.io.*;
import java.util.*;
public class Equals {
    public static void main (String [] args) throws Exception{
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String ("hello");
        String s4 = s1;

        // == just checks on the stack and not the content
        // equals first checks on the stack if not equal than checks the content

        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s2)); //true
        System.out.println(s1.equals(s3)); // true


    }
}
