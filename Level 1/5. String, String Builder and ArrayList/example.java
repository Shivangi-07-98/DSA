import java.util.*;
public class example {
    public static void main (String[] args){
        Scanner scn = new Scanner (System.in);
        String s = scn.nextLine();

        // checking if the last element prints if loop does not go the last element
        for (int i = 0; i < s.length()-1; i++){
            // System.out.println(s.charAt(i));
            System.out.println(s.charAt(i + 1));
        }
    }
}