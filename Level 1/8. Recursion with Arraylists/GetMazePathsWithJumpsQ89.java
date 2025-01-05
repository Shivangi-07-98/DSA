import java.util.*;

public class GetMazePathsWithJumpsQ89 {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int row = scn.nextInt();
    int col = scn.nextInt();
    ArrayList<String> ans = pmpwj(1, 1, row, col);
    ;
    System.out.println(ans);
  }

  public static ArrayList<String> pmpwj(int sr, int sc, int dr, int dc) {
    if (sc == dc && sr == dr) {
      ArrayList<String> bres = new ArrayList<>();
      bres.add("");
      return bres;
    }

    ArrayList<String> ans = new ArrayList<>();

    for (int h = 1; h <= dc - sc; h++) {
      ArrayList<String> hpaths = pmpwj(sr, sc + h, dr, dc);
      for (String rres : hpaths) {
        ans.add("h" + h + rres);
      }
    }

    for (int v = 1; v <= dr - sr; v++) {
      ArrayList<String> vpaths = pmpwj(sr + v, sc, dr, dc);
      for (String rres : vpaths) {
        ans.add("v" + v + rres);
      }
    }

    for (int d = 1; d <= dc - sc && d <= dr - sr; d++) {
      ArrayList<String> dpaths = pmpwj(sr + d, sc + d, dr, dc);
      for (String rres : dpaths) {
        ans.add("d" + d + rres);
      }
    }

    return ans;

  }
}
