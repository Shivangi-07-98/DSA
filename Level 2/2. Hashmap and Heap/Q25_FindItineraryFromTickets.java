// https://www.geeksforgeeks.org/find-itinerary-from-a-given-list-of-tickets/

// Time O(n)
// Space O(n)

import java.io.*;
import java.util.*;

public class Q25_FindItineraryFromTickets {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    HashMap<String, String> mapIn = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String src = scn.next();
      String dest = scn.next();
      mapIn.put(src, dest);
    }
    solution(mapIn);
  }

  public static void solution(HashMap<String, String> mapIn) {
    HashMap<String, Boolean> map = new HashMap<>();

    // for (String src : mapIn.keySet()) {
    // String dest = mapIn.get(src);
    // map.put(dest, false);
    // if (map.containsKey(src) == false) {
    // map.put(src, true);
    // }
    // }

    for (String src : mapIn.keySet()) {
      String dest = mapIn.get(src);
      map.put(src, true);
      map.put(dest, false);
    }

    String source = "";

    for (String city : map.keySet()) {
      if (map.get(city) == true) {
        source = city;
        break;
      }
    }

    // print
    while (mapIn.containsKey(source)) {
      System.out.print(source + " -> ");
      source = mapIn.get(source);
    }

    // print last one, as bangalore source toh bn gya but wo kbhi hashmap mai as a
    // key nhi hoga, only as a value
    System.out.println(source + ".");
  }
}

// Input
// 4
// Chennai Bangalore
// Bombay Delhi
// Goa Chennai
// Delhi Goa

// Output
// Bombay -> Delhi -> Goa -> Chennai -> Bangalore.
