import java.util.*; 
public class PrintMazePathsQ93 {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int r = scn.nextInt(); // 3
    int c = scn.nextInt(); // 3

    ArrayList<String> ans = new ArrayList<>();
    gmp(1, 1, r, c, "", ans);
    System.out.println(ans);
  }

  public static void gmp(int sr, int sc, int dr, int dc, String bres, ArrayList<String> cont) {
    if(sr > dr || sc > dc){
      return;
    }
    else if(sr == dr && sc == dc){
      cont.add(bres);
    }

    gmp(sr, sc + 1, dr, dc, bres + "h", cont);
    gmp(sr + 1, sc, dr, dc, bres + "v", cont);
    
  }

}
