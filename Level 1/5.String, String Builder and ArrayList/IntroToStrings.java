import java.util.*;
public class IntroToStrings {
    public static void main (String[] args){

        System.out.println("------------------------------------------------");

        String golu = "hello";
        System.out.println(golu);
        System.out.println(golu.length());
        
        System.out.println("------------------------------------------------");

        for (int i = 0; i < golu.length(); i++){

            char momo = golu.charAt(i);
            System.out.println(momo);
        }

        System.out.println("------------------------------------------------");

        golu += " world";
        System.out.println(golu);

        System.out.println("------------------------------------------------");

        System.out.println(10 + 20 + "hello" + 10 + 20);

        System.out.println("------------------------------------------------");

        System.out.println(golu.substring(0));
        System.out.println(golu.substring(0,3));
        System.out.println(golu.substring(0,5));
        System.out.println(golu.substring(0,6));
        System.out.println(golu.substring(0,7));
        System.out.println(golu.substring(3));

        System.out.println("------------------------------------------------");

        String momo = "chicken";
        System.out.println(momo.substring(0));
        System.out.println(momo.substring(0,3));
        System.out.println(momo.substring(0,5));
        System.out.println(momo.substring(0,6));
        System.out.println(momo.substring(0,7));
        System.out.println(momo.substring(3));


    }
}
