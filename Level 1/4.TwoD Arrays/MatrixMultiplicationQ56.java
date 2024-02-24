import java.io.*;
import java.util.*;
public class MatrixMultiplication {
    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);

        // matrix 1
        int n1 = scn.nextInt(); // rows
        int m1 = scn.nextInt(); // columns

        int[][] a1 = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                a1[i][j] = scn.nextInt();
            }
        }

        // matrix 2
        int n2 = scn.nextInt(); // rows
        int m2 = scn.nextInt(); // columns

        int[][] a2 = new int[n2][m2];
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                a2[i][j] = scn.nextInt();
            }
        }

        if(m1 != n2){
            System.out.print("Invalid input");
            return;
            // Main mai return krne se program ends
        }

        int [][] prd = new int [n1][m2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {

                int val = 0;
                for(int k = 0; k < m1; k++) {
                    val = val + a1[i][k] * a2 [k][j];
                }

                prd [i][j] = val;

            }
        }


        display(prd);

    }


    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }



}