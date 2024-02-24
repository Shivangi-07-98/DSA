import java.io.*;
import java.util.*;

public class PrintAllPermutationsOfAStringIterativelyQ {
    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}
	
	public static int factorial(int x){
	    int val = 1;
	    for(int i = 1; i <= x; i++){
	        val *= i;
	    }
	    return val;
	}

	public static void solution(String str){
		// write your code here
		int n = str.length();
		int fact = factorial(n);
		
		for(int i = 0; i < fact; i++){
		 StringBuilder sb = new StringBuilder(str);
		    int temp = i;
		for(int j = n; j >= 1; j--){
		        int q = temp / j;
		        int r = temp % j;
		        temp = q;
		 System.out.print(sb.charAt(r));
		       sb.deleteCharAt(r);
		        
		    }
		 System.out.println();   
		    
		}
	}
}