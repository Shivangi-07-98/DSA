import java.io.*;
import java.util.*;

public class hfcQ {
  



  public static void main(String[] args) throws Exception{
    
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine(); // abcdefabcdefabcdefaabbbeeeeeef

    HashMap<Character, Integer> fmap = new HashMap<>();

    // System.out.println(str.length());
    for(int i = 0; i < str.length(); i++){
      char ch = str.charAt(i); 
      // System.out.print(ch + " ");

      if(fmap.containsKey(ch) == false){
        fmap.put(ch, 1);
      }
      else{
        int oldf = fmap.get(ch);
        int newf = oldf + 1;
        fmap.put(ch, newf);
      }

    }

    // approach 1
    Set<Character> keys = fmap.keySet();
    char maxChar = ' ';
    int maxFreq = 0;
    
    for(char key : keys){
      int freq = fmap.get(key);
      if(freq > maxFreq){
        maxFreq = freq;
        maxChar = key;
        // System.out.println(maxChar + " " + maxFreq);
      }
    }
    System.out.println(maxChar + " " + maxFreq);


    // approach 2
    char mfch = str.charAt(0);
    for(int i = 1; i < str.length(); i++){
      char ch = str.charAt(i);

      if(fmap.get(ch) > fmap.get(mfch)){
        mfch = ch;
      }
    }
    System.out.println(mfch);

    
    // approach 3
    char mfch2 = str.charAt(0);
    Set<Character> uChar = fmap.keySet(); 
    for(char ch : uChar){
      if(fmap.get(ch) > fmap.get(mfch2)){
        mfch2 = ch;
      }
    }
    System.out.println(mfch2);

  }
}
