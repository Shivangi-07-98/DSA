import java.io.*;
import java.util.*;

public class Q3_GetCommonElements2 {



  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);

    int n1 = scn.nextInt();
    int[] arr1 = new int[n1]; // 7
    for(int i = 0; i < arr1.length; i++){
      arr1[i] = scn.nextInt(); // [1 1 1 2 2 3 5]
    }

    int n2 = scn.nextInt();
    int[] arr2 = new int[n2]; // 7
    for(int i = 0; i < arr2.length; i++){
      arr2[i] = scn.nextInt(); // [1 1 2 2 2 4 5]
    }

    // output 1, 1, 2, 2, 5
    
    // travel through arr1 and fill hashmap
    HashMap<Integer, Integer> fmap = new HashMap<>();
    for(int val: arr1){
      if(fmap.containsKey(val) == false){
        fmap.put(val, 1);
      }
      else{
        int of = fmap.get(val);
        int nf = of + 1;
        fmap.put(val, nf); 
      }
    }
  
    // travel through arr2, print and reduce freq
    for(int val: arr2){
      if(fmap.containsKey(val) == true && fmap.get(val) > 0){
        System.out.print(val + " ");

        int of = fmap.get(val);
        int nf = of - 1;
        fmap.put(val, nf); 
      }
    }
    
  }
  
}
