import java.util.*;
public class GetSubsequence {
  public static void main (String [] args) {
    Scanner scn = new Scanner (System.in);
    String input = scn.nextLine();

    ArrayList <String> ans = gss(input);
    System.out.println(ans);
  }

  public static ArrayList <String> gss (String input) {

    if(input.length() == 0){
      ArrayList <String> bres = new ArrayList<>();
      bres.add("");
      return bres;
    }

    char ch = input.charAt(0);
    String ros = input.substring(1);
    ArrayList <String> rres = gss(ros);
    ArrayList <String> ans = new ArrayList<>();

    for(String abc : rres){
      ans.add("_" + abc);
    }

    for(String abc : rres){
      ans.add(ch + abc);
    }

    return ans;
  }

}
