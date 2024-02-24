import java.io.*;
import java.util.*;

public class ToggleCaseQ {
    
        public static String toggleCase(String s){
            //write your code here
            StringBuilder sb = new StringBuilder (s);
            
            for (int i = 0; i < sb.length(); i++){
                
                char ch = sb.charAt(i);
                
                if (ch >= 'A' && ch <= 'Z' ){
                    char lc = (char)(ch + ('a' - 'A'));
                    sb.setCharAt(i, lc);
                }else{
                    char uc = (char)(ch + ('A' - 'a'));
                    sb.setCharAt(i, uc);
                }
            }
            return sb.toString();
        }
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            String s = scn.nextLine();
            System.out.println(toggleCase(s));
        }
    }