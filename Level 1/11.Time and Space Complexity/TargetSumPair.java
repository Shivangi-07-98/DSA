// O(nlogn)
// nlogn + n = nlogn
import java.util.*;
import java.util.Arrays;
public class TargetSumPair {
    public static void main(String[] args){
        Scanner scn = new Scanner (System.in);
        int tar = scn.nextInt(); // 25
        int n = scn.nextInt(); // 8
        int [] arr = new int [n];
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt(); // 18 5 4 20 7 22 19 25
        }

        Arrays.sort(arr); // nlogn  4 5 7 18 19 20 22 25

        // meet in the middle
        int left = 0;
        int right = arr.length - 1;
        while(left < right){ // n
            if(arr[left] + arr[right] > tar){
                right--;
            }
            else if(arr[left] + arr[right] < tar){
                left++;
            }
            else{
                System.out.println(arr[left] + " " + arr[right]);
                left++;
                right--;
            }
        }
    }
}