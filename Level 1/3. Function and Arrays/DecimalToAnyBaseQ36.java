import java.util.*;
public class DecimalToAnyBaseQ36{
    public static void main (String []args){
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int newnum = GetNewNum (n,b);
        System.out.print (newnum);
    }
    
    public static int GetNewNum (int num, int base){
        
        int newnum = 0;
        int pow = 1;
        while (num > 0){
            int rem = num % base;
            int quo = num / base;
            num = quo;
            
            newnum += rem * pow;
            pow = pow * 10;
            
        }
        return newnum;
    }
    
}