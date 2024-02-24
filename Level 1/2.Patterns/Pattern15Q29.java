import java.util.*;
public class Pattern15Q29  {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int st = 1;
        int sp = n/2;
        int val = 1;
        for (int i = 1; i <= n; i++){
            
            for (int j = 1; j <= sp; j++){
            System.out.print("\t");
            }
            int golu = val;
            for (int j = 1; j <= st; j++){
            System.out.print(golu + "\t");
            if(j<=st/2){
                golu++;
            }else{
                golu--;
            }
            
            }
            
        
        if (i<=n/2){
            val++;
            sp--;
            st+=2;
        }
        else{
            val--;
            sp++;
            st-=2;
        }
        
            System.out.println();
        }
    }
}