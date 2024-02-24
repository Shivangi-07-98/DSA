import java.util.*;
public class Pattern13Q27ii{
    public static void main(String[]args){
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        
        for (int i = 1; i<=n; i++){
            for(int j = 1; j<=i; j++){
                System.out.print("*\t");
            }

            System.out.println();
        }
    }
}
// for n = 5
//  i  j
//  1  1
//  2  1 2
//  3  1 2 3
//  4  1 2 3 4
//  5  1 2 3 4 5
 