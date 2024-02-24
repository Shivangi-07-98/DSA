import java.io.*;
import java.util.*;

public class PrintAllPalindromicSubstringsQ {

    public static void solution(String s) {
        // write your code here
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);

                boolean ans = true;
                int left = 0;
                int right = sub.length() - 1;
                while (left < right) {
                    char leftletter = sub.charAt(left);
                    char rightletter = sub.charAt(right);

                    if (leftletter == rightletter) {
                        left++;
                        right--;
                    } else {
                        ans = false;
                        break;
                    }
                }

                if (ans == true) {
                    System.out.println(sub);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        solution(s);
    }
}