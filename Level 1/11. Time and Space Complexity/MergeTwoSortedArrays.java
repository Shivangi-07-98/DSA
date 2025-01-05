// O(nlogn)
import java.util.*;
public class MergeTwoSortedArrays {
    public static void main (String [] args){
        Scanner scn = new Scanner (System.in);

        int a = scn.nextInt();
        int [] one = new int [a];
        for(int i = 0; i < a; i++){
            one[i] = scn.nextInt();
        }

        int b = scn.nextInt();
        int [] two = new int [b];
        for(int i = 0; i < b; i++){
            two[i] = scn.nextInt();
        }

        int [] ans = new int [a+b];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < one.length && j < two.length){
            if (one[i] < two[j]){
                ans[k] = one[i];
                i++;
                k++;
            }
            else{
                ans[k] = two[j];
                j++;
                k++;
            }
        }

        if (i == one.length){
            while(j < two.length){
            ans[k] = two[j];
            j++;
            k++;
            }
        }
        else if (j == two.length){
            while(i < one.length){
            ans[k] = one[i];
            i++;
            k++;
        }
    }


        for(int x = 0; x < ans.length; x++) {
            System.out.print( ans[x] + " ");
        }


    }
}