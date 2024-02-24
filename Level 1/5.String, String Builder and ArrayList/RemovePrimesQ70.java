import java.io.*;
import java.util.*;

public class RemovePrimesQ {

    public static void solution(ArrayList<Integer> al) {
        // write your code here
        for (int i = al.size() - 1; i >= 0; i--) {
            int ISPRIME = isPrime(al.get(i));
            if (ISPRIME == 0) {
                al.remove(i);
            }
        }
    }

    public static int isPrime(int n) {
        int count = 0;
        for (int i = 2; i * i <= n; i++) {
            int div = i;
            int rem = n % div;
            if (rem == 0) {
                count = 1;
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(scn.nextInt());
        }
        solution(al);
        System.out.println(al);
    }

}