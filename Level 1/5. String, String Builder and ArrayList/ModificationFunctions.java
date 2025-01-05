import java.util.*;
public class ModificationFunctions {
    public static void main (String [] args){

        StringBuilder sb = new StringBuilder ("hello");

        char golu = sb.charAt(0);
        System.out.println(golu);

        sb.setCharAt(0,'b');
        System.out.println(sb);

        sb.deleteCharAt(0);
        System.out.println(sb);

        sb.insert(0,'t');
        System.out.println(sb);

        String s = sb.toString();
        System.out.println(s);

    }
}
