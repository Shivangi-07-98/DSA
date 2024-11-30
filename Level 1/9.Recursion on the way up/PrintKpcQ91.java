import java.util.*;
public class PrintKpcQ91 {
   public static void main (String [] args){
    Scanner scn = new Scanner(System.in);
    String n = scn.nextLine(); // input in numbers eg- 96
    ArrayList <String> cont = new ArrayList <>();
    printkpc(n, "", cont);
    System.out.println(cont);
   }

   public static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"}; // from 0-9

   public static void printkpc (String n, String bres, ArrayList <String> cont){
      if(n.length() == 0){
         cont.add(bres);
         return;
      }

      char ch = n.charAt(0); 
      String ros = n.substring(1);


      String code = codes[ch - '0'];

      for(int i = 0; i < code.length(); i++){
         char chi = code.charAt(i);
         printkpc(ros, bres + chi, cont );
      }

   }
}
