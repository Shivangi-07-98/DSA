import java.util.*;
public class RotateBy90DegreesQ60 {
    public static void main(String [] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); 
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // swap(arr, arr[i][j], arr[j][i]);
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        
        for(int i = 0; i < arr.length; i++){
             // why inside for loop - for while loop to access
            // for(int j = 0; j < arr[0].length; j++){
                int left = 0;
                int right = arr[0].length-1;
            while(left < right){
            // swap (arr, arr[i][left], arr[i][right]);
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;

                left++;
                right--;
            }
        // }
        }

        display(arr);


    }


    // public static void swap(int[][] arr, int a, int b){
    //     int temp = a;
    //     a = b;
    //     b = temp;
    // }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }




}