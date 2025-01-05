import java.util.*;
public class GetKpcQ86 {
   public static void main (String [] args){
    Scanner scn = new Scanner(System.in);
    String n = scn.nextLine(); // input in numbers eg- 96

    ArrayList <String> ans = getkpc(n);
    System.out.println(ans);
   }

   public static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"}; // from 0-9

   public static ArrayList <String> getkpc (String n) {
    if(n.length() == 0){
      ArrayList <String> bres = new ArrayList <>();
      bres.add("");
      return bres;
    }

    char ch = n.charAt(0);
    String ros = n.substring(1);
    ArrayList <String> rres = getkpc(ros); 
    ArrayList <String> newal = new ArrayList<>();

    String code = codes[ch - '0'];
 
    for(int i = 0; i < code.length(); i++){
      char chi = code.charAt(i);
      for(String rstr: rres){
        newal.add(chi + rstr);
      }
    }

    // Bad Loop

    // for(String res: rres){
    //   for(int i = 0; i < code.length(); i++){
    //     char chi = code.charAt(i);
    //     newal.add(chi + res);
    //   }
    // }

    return newal;
  }
}
