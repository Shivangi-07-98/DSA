// O(n)
import java.util.*;
public class n {
    public static void main (String [] args) {
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt(); // 10
        int c = scn.nextInt(); // 2

        // for * for but still O(n)
        for(int i = 1; i <= n; i += c){ // i = i + c  1,3,5,7,9
            for(int j = 1; j <= c; j++){ // 2,2,2,2,2
                // Do some work k
                System.out.print(":)" + " ");
            }
            System.out.println();
        }


    }
    
}
