import java.util.*;
import java.io.*;

public class pr3Intro{



  public static void main(String[] args) throws Exception{
    HashMap<String, Integer> pmap = new HashMap<>();

    // add O(1) time complexity
    // if key is not present then it adds 
    pmap.put("India", 130);
    pmap.put("China", 200);
    pmap.put("Aus", 50);
    pmap.put("Utopia", 0);
    System.out.println(pmap);

    // update O(1) time complexity
    // if key is already present then it updates 
    pmap.put("Aus", 51);
    System.out.println(pmap);

    // remove O(1) time complexity
    pmap.remove("China");
    System.out.println(pmap);

    // get O(1) time complexity
    int ipop = pmap.get("India");
    System.out.println(ipop);

    // use capital Integer to handle null pointer exception
    Integer uspop = pmap.get("Us"); // key is not present so gives null 
    System.out.println(uspop);

    // O(1) time complexity
    System.out.println(pmap.containsKey("Us"));
    System.out.println(pmap.containsKey("India"));

    // O(n) time complexity
    // to get all keys
    Set<String> keys = pmap.keySet();
    for(String key: keys){
      System.out.println(key);
      System.out.println(pmap.get(key));
    }


  }

}