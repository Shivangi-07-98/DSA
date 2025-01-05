import java.io.*;
import java.util.*;

public class MaxOfAnArrayQ {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int ans = maxOfArray(a, 0);
        System.out.print(ans);
    }

    public static int maxOfArray(int[] arr, int idx) {
        if (idx == arr.length - 1) {
            return arr[idx];
        }
        int max = maxOfArray(arr, idx + 1);

        if (arr[idx] > max) {
            return arr[idx];
        } else {
            return max;
        }
        // return 0;
    }
}