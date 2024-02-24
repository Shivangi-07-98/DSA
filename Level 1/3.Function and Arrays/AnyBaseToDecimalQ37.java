import java.util.*;
public class AnyBaseToDecimalQ37{
    public static void main (String []args){
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int decnum = GetDecNum (n,b);
        System.out.print (decnum);
    }
    
    public static int GetDecNum (int num,int base){
        
        int decnum = 0;
        int pow = 1;
        while (num > 0){
            int rem = num % 10;
            int quo = num / 10;
            num = quo;
            
            decnum += rem * pow;
            pow = pow * base ;
            
        }
        return decnum;
    }
    
}