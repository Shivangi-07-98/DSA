// O(n)
import java.util.*;
public class Polynomial {
    public static void main (String [] args) {
        Scanner scn = new Scanner (System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();

        int cons = n;
        int pox = x;
        int ans = 0;
        while(cons > 0){
            int term = cons * pox;
            ans += term;
            pox = pox * x;
            cons--;
        }
        System.out.print(ans);
    }
}
