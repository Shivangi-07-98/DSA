import java.util.*;
public class PrintMazePathsWithJumpsQ94{
  public static void main (String[] args){
    Scanner scn = new Scanner(System.in);
    int row = scn.nextInt();
    int col = scn.nextInt();
    pmpwj(1, 1, row, col, "");
  }

  public static void pmpwj(int sr, int sc, int dr, int dc, String psf){
    if(sc == dc && sr == dr){
      System.out.print(psf + ", ");
      return;
    }

    for(int h = 1; h <= dc-sc; h++){
      pmpwj(sr, sc+h, dr, dc, psf+"h"+h);
    }
    for(int v = 1; v <= dr-sr; v++){
      pmpwj(sr+v, sc, dr, dc, psf+"v"+v);
    }
    for(int d = 1; d <= dc-sc && d <= dr-sr; d++){
      pmpwj(sr+d, sc+d, dr, dc, psf+"d"+d);
    }

  }
}
