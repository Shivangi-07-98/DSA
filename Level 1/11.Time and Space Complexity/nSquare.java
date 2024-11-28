// O(n^2)
import java.util.*;
public class nSquare {
    public static void main (String [] args){
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt(); // 4
        
        for(int i = 1, j = 1; i <= n; j++){
            // do some work k
            if (j > i){
                j = 1;
                i++;
            }
            System.out.println(i + " " + j);
        }

        
    }
}
