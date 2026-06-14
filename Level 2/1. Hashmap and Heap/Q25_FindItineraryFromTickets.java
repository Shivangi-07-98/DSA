// https://www.geeksforgeeks.org/find-itinerary-from-a-given-list-of-tickets/

// Time O(n)
// Space O(n)

import java.io.*;
import java.util.*;

public class Q25_FindItineraryFromTickets {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    HashMap<String, String> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String src = scn.next();
      String dest = scn.next();
      map.put(src, dest);
    }
    solution(map);
  }

  public static void solution(HashMap<String, String> map) {
    HashMap<String, Boolean> start = new HashMap<>();

    // for (String src : map.keySet()) {
    // String dest = map.get(src);
    // start.put(dest, false);
    // if (start.containsKey(src) == false) {
    // start.put(src, true);
    // }
    // }

    for (String src : map.keySet()) {
      String dest = map.get(src);
      start.put(src, true);
      start.put(dest, false);
    }

    String source = "";

    for (String city : start.keySet()) {
      if (start.get(city) == true) {
        source = city;
        break;
      }
    }

    // print
    while (map.containsKey(source)) {
      System.out.print(source + " -> ");
      source = map.get(source);
    }

    // print last one, as bangalore source toh bn gya but wo kbhi hashmap mai as a
    // key nhi hoga, only as a value
    System.out.println(source + ".");
  }
}

/*
 * Sample Input
 * 
 * 4
 * Chennai Bangalore
 * Bombay Delhi
 * Goa Chennai
 * Delhi Goa
 * 
 * Output
 * Bombay -> Delhi -> Goa -> Chennai -> Bangalore.
 */
