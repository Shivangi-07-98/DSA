import java.util.*;
   public class RotateANumber10{
   
   public static void main(String[] args) {
       Scanner scn = new Scanner (System.in);
       int n = scn.nextInt();
       int k = scn.nextInt();
       
       int nod = 0;
       int temp = n;
       while(temp>0){
           temp = temp/10;
           nod++;
       }
       k = k%nod;
       if (k<0){
           k = k+nod;
           
       }
       int div = 1;
       int mult = 1;
       
    //   div = (int) Math.pow(10,k);
    //   mult = (int) Math.pow(10,nod-k);
    
    for (int i=1; i<=nod; i++){
        if(i<=k){
            div = div * 10;
        }
        else{
            mult = mult *10;
        }
    }
    
       int rem = n%div;
       int quo = n/div;
       int rot = rem*mult + quo;
       System.out.println(rot);
       
    }
   }