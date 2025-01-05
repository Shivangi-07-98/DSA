// O(nlogn)
import java.util.*;
public class MergeSort {
    public static void main(String [] args){
        Scanner scn = new Scanner (System.in);


        int n = scn.nextInt();
        int [] arr = new int [n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }

        int [] ans = mergeSort(arr, 0, arr.length-1);
        print(ans);
    }

    

    public static int [] mergeSort(int [] arr, int lo, int hi){
        if(lo == hi){
            int [] ba = new int[1];
            ba[0] = arr[lo];
            return ba;
        }        

        int mid = (lo+hi)/2;
        int [] fsh = mergeSort(arr, lo, mid);
        int [] ssh = mergeSort(arr, mid+1, hi);
        int [] fsa = mergeTwoSortedArrays(fsh, ssh);

        return fsa;
    
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
          }
        }
    
    public static int [] mergeTwoSortedArrays(int [] a, int [] b){
        
        int i = 0, j =0, k = 0;
        int[] ans = new int[a.length + b.length];
        while(i < a.length && j < b.length){
            if(a[i] <= b[j]){
              ans[k] = a[i];
              i++;
              k++;
            }else{
              ans[k] = b[j];
              j++;
              k++;
            }
        }
    
        while(i < a.length){
          ans[k] = a[i];
          k++;
          i++;
        }
    
        while(j < b.length){
          ans[k] = b[j];
          k++;
          j++;
        }
        
        return ans;
      }
    
}
