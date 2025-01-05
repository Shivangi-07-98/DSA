import java.io.*;
import java.util.*;

public class StringCompressionQ {

	public static String compression1(String str){
		// write your code here
		String ans = "";
		for (int i = 0; i < str.length()-1; i++){
		    if (str.charAt(i)== str.charAt(i+1)){
		        
		    }
		    else{
		        ans += str.charAt(i);
		    }
		}
		ans += str.charAt(str.length()-1);
		
		return ans;
	}

	public static String compression2(String str){
		// write your code here
        String ans = "";
        int count = 1;
		for (int i = 0; i < str.length()-1; i++){
		    
		    if (str.charAt(i)== str.charAt(i+1)){
		        count++;
		    }
		    else{
		        ans += str.charAt(i);
		        if (count != 1){
		            ans += count;
		        }
		        count = 1;
		        }
		}
		
		ans += str.charAt(str.length()-1);
		        if (count != 1){
		            ans += count;
		        }
		
		return ans;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}
}