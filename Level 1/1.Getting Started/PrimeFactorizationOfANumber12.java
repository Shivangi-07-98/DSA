import java.util.*;
public class PrimeFactorizationOfANumber12{
public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    for(int i = 2; i<=n; i++){
        if( n%i == 0 )
        {
            n = n/i;
            System.out.print(i + " ");
        }
    }

    if(n>1){
        System.out.print(n); 
    }
    
 }
}