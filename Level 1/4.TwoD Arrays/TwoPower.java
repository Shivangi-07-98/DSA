import java.util.*;
public class TwoPower {
    public static void main (String[]args){
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        
        int pow = (1 << n); //2^n
        System.out.println(pow);
        
    }
    
}
