import java.util.*;
public class Replace {
    public static void main(String[] args){
        String s = "hello";
        char ch = s.charAt(0);
        System.out.println(ch);

        s.replace('h','b');
        System.out.println(s);

        s = s.replace('h','b');
        System.out.println(s);
        
    }
}
