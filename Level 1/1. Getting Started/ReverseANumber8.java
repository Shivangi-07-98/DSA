import java.util.*;
   
   public class ReverseANumber8 {
   
   public static void main(String[] args) {
       Scanner scn = new Scanner (System.in);
       int n = scn.nextInt();
       
       while(n != 0){
           int quo = n/10;
           int rem = n%10;
           n = quo;
           System.out.print(rem);
       }
    }
   }