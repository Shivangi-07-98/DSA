import java.io.*;
import java.util.*;

public class ReverseAnArrayQ47{
  public static void display(int[] a){
    stringbuilder sb = new stringbuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
  }

  public static void reverse(int[] a){
    // write your code here
    
    // Scanner scn = new Scanner (System.in);
    // int n = scn.nextInt();
        // a = new int [n];
    // for (int i = 0; i < a.length; i++){
        // a[i] = scn.nextInt();
    // }
    int left = 0;
    int right = a.length - 1;
    // int temp = 0;
    
    while (left < right){
         int temp = a[left];
         a[left] = a[right];
         a[right] = temp;
        
        left++;
        right--;
    }
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    reverse(a);
    display(a);
 }

}