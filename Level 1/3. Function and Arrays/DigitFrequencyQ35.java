import java.util.*;
public class DigitFrequencyQ35{
    public static void main(String []args){
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();
        int f = GetDigitFrequency(n,d);
        System.out.println(f);
    }
    
    public static int GetDigitFrequency(int num,int dig){
        
        int f = 0;
        while (num > 0){
            int rem = num % 10;
            int quo = num /10;
            num = quo;
            if (rem == dig){
                f++;
            }
        }
        
        return f;
    }
    
}