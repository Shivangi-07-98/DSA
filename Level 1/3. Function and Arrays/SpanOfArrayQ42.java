// import java.io.*;
import java.util.*;
public class SpanOfArrayQ42{

public static void main(String[] args) // throws Exception 
{
    Scanner scn = new Scanner (System.in);
    int n = scn.nextInt();
    int [] elements = new int [n];
    for (int i = 0; i < elements.length; i++){
        elements [i] = scn.nextInt();
    }
    
    int min = elements [0];
    int max = elements [0];
    for (int i = 1; i < elements.length; i++){
        if (elements [i] < min){
            min = elements [i];
        }
        if (elements [i] > max){
            max = elements [i];
        }
        
    }
    int span = max - min;
    System.out.print(span);
 }

}