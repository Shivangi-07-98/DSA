import java.util.*;
  public class AnyBaseToAnyBaseQ38{
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int b1 = scn.nextInt();
       int  b2 = scn.nextInt();
       
       int decnum = GetDecNum (n1,b1);
       int destnum = GetDestNum (decnum,b2);
       System.out.print (destnum);
     }
     
     public static int GetDecNum (int n1,int b1){
         
         int ans1 = 0;
          int pow = 1;
          while (n1 > 0){
              int rem = n1 % 10;
              int quo = n1 / 10;
              n1 = quo;
              
              ans1 += rem * pow;
              pow = pow * b1 ;
              
          }
         
         return ans1;
     }
     public static int GetDestNum (int decnum,int b2){
         
         int ans2 = 0;
          int pow = 1;
          while (decnum > 0){
              int rem = decnum % b2;
              int quo = decnum / b2;
              decnum = quo;
              
              ans2 += rem * pow;
              pow = pow * 10 ;
              
          }
         
         return ans2;
     }
    }