// NOT AT ALL IMPORTANT - SKIP IT
// Snake pattern traversal is rarely asked in high-paying company interviews
import java.util.*;
public class TheStateOfWakanda1Q57 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // rows
        int m = scn.nextInt(); // columns

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        for (int i = 0; i < arr[0].length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[j][i] + " ");

                }
            }
                else {
                    for (int j = arr.length-1; j >=0; j--) {
                        System.out.print(arr[j][i] + " ");
    
                    }

                }
            }


        }
    }