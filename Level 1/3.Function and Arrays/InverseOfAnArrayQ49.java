import java.io.*;
import java.util.*;

public class InverseOfAnArrayQ49{
  public static void display(int[] a){
    stringbuilder sb = new stringbuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

  public static int[] inverse(int[] a){  // did not understood
    // write your code here
    int [] inv = new int [a.length]; // did not understood
    for (int i = 0; i < a.length; i++){
       inv [a[i]] = i;
    }
    return inv;
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] inv = inverse(a);
    display(inv);
 }

}