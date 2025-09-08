// NOT AT ALL IMPORTANT - SKIP IT
// Exit point matrix is rarely asked in interviews
import java.io.*;
import java.util.*;
public class ExitPointOfaMatrixQ59 {
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

        int dir = 0;
        int i = 0;
        int j = 0;
        while(true){

                if(arr[i][j] == 1){
                    dir = 1 + dir;
                }
                dir = dir % 4;


                if (dir == 0){
                    j++;
                    if (j == arr[0].length){
                        j--;
                        break;
                    }
                }
                else if (dir == 1){
                    i++;
                    if (i == arr.length){
                        i--;
                        break;
                    }
                }
                else if (dir == 2){
                    j--;
                    if (j == -1){
                        j++;
                        break;
                    }
                }
                else if (dir == 3){
                    i--;
                    if (i == -1){
                        i++;
                        break;
                    }
                }

            }

            System.out.print(i + "," + j);



    } // outer brackets
}