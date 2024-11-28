// O(nlogn)
// nlogn + n = nlogn
import java.util.*;
import java.util.Arrays;
public class CheckDuplicate {
    public static void main (String[] args){

        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt(); // 6
        int [] arr = new int [n];
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt(); // 8 7 6 5 4 6
        }

        Arrays.sort(arr); // nlogn  4 5 6 6 7 8

        int dup = -1;
        for(int i = 0; i <= arr.length - 2; i++){ //n
            if (arr[i] == arr[i + 1]){
                dup = arr[i];
                break;
            }
        }
        System.out.print(dup);


    }
}