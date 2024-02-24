import java.util.*;
public class PrintSubsequenceQ {
    public static void main (String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        pss(str," ");
    }

    public static void pss(String str, String asf){
        if(str.length() == 0){
        System.out.print(asf + ",");
        return;
        }
        char ch = str.charAt(0); // line 1
        String ros = str.substring(1); // line 2

        pss(ros, asf + ch); // line 3
        pss(ros, asf + "_"); // line 4
        

    }
}