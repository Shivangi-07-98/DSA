// O(nlogn)
// nlogn + nlogn = 2nlogn = nlogn
import java.util.*;
import java.util.Arrays;
public class TargetSumPairWithBinarySearch {
    public static void main (String [] args) {
        Scanner scn = new Scanner (System.in);
        int tar = scn.nextInt(); // 25
        int n = scn.nextInt(); // 8
        int [] arr = new int [n];
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt(); // 18 5 4 20 7 22 19 25
        }

        Arrays.sort(arr); // nlogn  4 5 7 18 19 20 22 25

        // Binary search the compliment
        for(int i = 0; i < arr.length; i++){ // n
            int OtherNumber = tar - arr[i];

        // Binary search the new Target
        int left = i + 1;
        int right = arr.length - 1;
        while(left <= right){ // log n
            int mid = (left + right)/2;

            if(OtherNumber < arr[mid]){
                right = mid-1;
            } else if(OtherNumber > arr[mid]){
                left = mid+1;
            }else{
                System.out.print(arr[i] + " " + arr[mid]);
                break;
            }


        }

        }


    }
}