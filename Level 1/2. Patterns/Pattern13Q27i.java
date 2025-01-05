import java.util.*;
public class Pattern13Q27i{
    public static void main(String[]args){
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        
        for (int i = 0; i<n; i++){
            for(int j = 0; j<=i; j++){
                System.out.print("*\t");
            }

            System.out.println();
        }
    }
}
// for n = 5
//  i  j
//  0  0
//  1  0 1
//  2  0 1 2
//  3  0 1 2 3
//  4  0 1 2 3 4
 