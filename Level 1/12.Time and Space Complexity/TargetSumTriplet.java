// O(n^2)
// nlogn + n^2 = n^2
import java.util.*;
import java.util.Arrays;
public class TargetSumTriplet {
    public static void main(String[] args){
        Scanner scn = new Scanner (System.in);
        int tar = scn.nextInt(); // 25
        int n = scn.nextInt(); // 11

        int [] arr = new int [n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt(); // 1 9 6 4 8 3 12 14 24 10 15
        }

        Arrays.sort(arr); // nlogn  1 3 4 6 8 9 10 12 14 15 24

        for(int i = 0; i < arr.length; i++){ // n
            int newtar = tar - arr[i]; 

            int left = i+1;
            int right = arr.length-1;
            while(left < right){ // n
            if(arr[left] + arr[right] > newtar){
                right--;
            }
            else if(arr[left] + arr[right] < newtar){
                left++;
            }
            else{
                System.out.println(arr[i] + " " + arr[left] + " " + arr[right]);
                left++;
                right--;
            }
        }


        }

    }
    
}