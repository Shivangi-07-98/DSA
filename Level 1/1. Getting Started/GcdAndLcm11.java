import java.util.*;
    public class GcdAndLcm11{
    
    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);
        int num1 = scn.nextInt();
        int num2 = scn.nextInt();
        
        int n1 = num1;
        int n2 = num2;
        while (n1 % n2 != 0){
            
            int R = n1 % n2;
            int Q = n1 / n2;
            n1 = n2;
            n2 = R;
        }
        int gcd = n2;
        int lcm = num1 *num2 / gcd;
        System.out.println(gcd);
        System.out.println(lcm);
        
     }
    }