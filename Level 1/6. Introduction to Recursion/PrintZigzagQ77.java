import java.io.*;
import java.util.*;
public class PrintZigzagQ {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pzz(n);
    }

    public static void pzz(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " "); // line1
        pzz(n - 1); // line2
        System.out.print(n + " "); // line3
        pzz(n - 1); // line4
        System.out.print(n + " "); // line5

    }

}