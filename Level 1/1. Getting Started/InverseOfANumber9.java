import java.util.*;
public class InverseOfANumber9{

public static void main(String[] args) {
    Scanner scn = new Scanner (System.in);
    int n = scn.nextInt();
    
    int p1 = 1;
    int num = 0;
    while(n != 0){
        int rem1 = n%10;
        int quo = n/10;
        
        int p2 = rem1;
        int rem2 = p1;
        num = num + rem2 * (int) Math.pow(10,p2-1);
        n = quo;
        p1++;
        
    }
    System.out.println (num);
 }
}