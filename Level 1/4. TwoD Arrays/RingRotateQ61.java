import java.io.*;
import java.util.*;
public class RingRotateQ61 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt(); // rows
        int m = scn.nextInt(); // columns

        int[][] twod = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                twod[i][j] = scn.nextInt();
            }
        }

        int s = scn.nextInt();
        int r = scn.nextInt();

        int[] oned = getOnedFromShell(twod, s);
        rotate(oned, r);
        fillTwodShellFromOned(oned, twod, s);

        display(twod);

    }

    public static int[] getOnedFromShell(int[][] twod, int s) {

        int rows = twod.length;
        int cols = twod[0].length;
        int minr = s - 1;
        int maxr = rows - s;
        int minc = s - 1;
        int maxc = cols - s;

        int vwcount = maxr - minr + 1;
        int hwcount = maxc - minc + 1;
        int sz = 2 * vwcount + 2 * hwcount - 4;

        int[] oned = new int[sz];
        int idx = 0;

        // Left Wall
        for (int i = minr, j = minc; i <= maxr; i++) {
            oned[idx] = twod[i][j];
            idx++;
        }
        minc++;

        // Bottom Wall
        for (int i = maxr, j = minc; j <= maxc; j++) {
            oned[idx] = twod[i][j];
            idx++;
        }
        maxr--;

        // Right Wall
        for (int i = maxr, j = maxc; i >= minr; i--) {
            oned[idx] = twod[i][j];
            idx++;
        }
        maxc--;

        // Top Wall
        for (int i = minr, j = maxc; j >= minc; j--) {
            oned[idx] = twod[i][j];
            idx++;
        }
        minr++;
        return oned;
    }

    public static void fillTwodShellFromOned(int[] oned, int[][] twod, int s) {
        int rows = twod.length;
        int cols = twod[0].length;
        int minr = s - 1;
        int maxr = rows - s;
        int minc = s - 1;
        int maxc = cols - s;

        int idx = 0;

        // Left Wall
        for (int i = minr, j = minc; i <= maxr; i++) {
            twod[i][j] = oned[idx];
            idx++;
        }
        minc++;

        // Bottom Wall
        for (int i = maxr, j = minc; j <= maxc; j++) {
            twod[i][j] = oned[idx];
            idx++;
        }
        maxr--;

        // Right Wall
        for (int i = maxr, j = maxc; i >= minr; i--) {
            twod[i][j] = oned[idx];
            idx++;
        }
        maxc--;

        // Top Wall
        for (int i = minr, j = maxc; j >= minc; j--) {
            twod[i][j] = oned[idx];
            idx++;
        }
        minr++;

    }

    public static void rotate(int[] oned, int r) {
        r = r % oned.length;
        if (r < 0) {
            r += oned.length;
        }
        reverse(oned, 0, oned.length - r - 1);
        reverse(oned, oned.length - r, oned.length - 1);
        reverse(oned, 0, oned.length - 1);

    }

    public static void reverse (int [] oned, int left, int right) {
        while (left < right) {
            int temp = oned [left];
            oned [left] = oned [right];
            oned [right] = temp;
        left++;
        right--;
        }
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }



}