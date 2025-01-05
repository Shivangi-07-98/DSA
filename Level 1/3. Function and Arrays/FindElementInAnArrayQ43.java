import java.io.*;
import java.util.*;
public class FindElementInAnArrayQ43{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner (System.in);
    int n = scn.nextInt();
    int [] golu = new int [n];
    for (int i = 0; i < golu.length; i++){
        golu [i] = scn.nextInt();
    }
    int d = scn.nextInt();
    
    int index = -1; 
    for (int i = 0; i < golu.length; i++){
        if (d == golu[i]){
            index = i;
        }
    }
    System.out.print(index);
 }

}