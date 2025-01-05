import java.util.*;
public class GetMazePathsQ88 {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int r = scn.nextInt(); // 3
    int c = scn.nextInt(); // 3

    ArrayList<String> ans = gmp(1, 1, r, c);
    System.out.println(ans);
  }

  public static ArrayList<String> gmp(int sr, int sc, int dr, int dc) {
    if(sr > dr || sc > dc){
      ArrayList <String> bres = new ArrayList<>();
      return bres;
    }
    else if(sr == dr && sc == dc){
      ArrayList <String> bres = new ArrayList<>();
      bres.add("");
      return bres;
    }

    ArrayList <String> hpaths = gmp(sr, sc + 1, dr, dc);
    ArrayList <String> vpaths = gmp(sr + 1, sc, dr, dc);
    ArrayList <String> ans = new ArrayList<>();

    for(String rres: hpaths){
      ans.add("h" + rres);
    }

    for(String rres: vpaths){
      ans.add("v" + rres);
    }

    return ans;
  }

}
