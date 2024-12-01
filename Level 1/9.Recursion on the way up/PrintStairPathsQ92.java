import java.util.*; 
public class PrintStairPathsQ92 {
  public static void main (String [] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    ArrayList <String> cont = new ArrayList<>();
    gsp(n, "", cont); 
    System.out.print(cont);

  }

  public static void gsp(int n, String bres, ArrayList <String> cont){

    if(n == 0){
      // System.out.print(bres + ",");
      cont.add(bres);
    }
    else if(n < 0){
      return;
    }
    
    gsp(n-1, bres + "1", cont);
    gsp(n-2, bres + "2", cont);
    gsp(n-3, bres + "3", cont);
    
  }
  
}
