import java.io.*;
import java.util.*;

public class RotateAnArrayQ48{
  public static void display(int[] a){
    stringbuilder sb = new stringbuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
  }

  public static void rotate(int[] a, int k, int n){
    // write your code here
    k = k % n;
    if (k < 0){
        k = k + n;
    }
     reverse (a, 0, a.length-1-k);
     reverse (a, a.length-k, a.length-1);
     reverse (a, 0, a.length-1);
  }
  
  public static void reverse (int []a, int left, int right){
      
    // left = 0;
    // right = a.length - 1;
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
    int k = Integer.parseInt(br.readLine());

    rotate(a, k, n);
    display(a);
 }

}