// Time Complexity: O(n), Space Complexity: O(n)

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

    HashMap<String, Boolean> potentialStart = new HashMap<>();

    // Mark cities
    for (String src : map.keySet()) {
      String dest = map.get(src);

      potentialStart.put(src, true);
      potentialStart.put(dest, false);
    }

    // Find starting city
    String start = "";

    for (String city : potentialStart.keySet()) {
      if (potentialStart.get(city) == true) {
        start = city;
        break;
      }
    }

    // Print itinerary
    while (map.containsKey(start)) {
      System.out.print(start + " -> ");
      start = map.get(start);
    }

    System.out.print(start + ".");
  }
}

/*
 * Input:
 * 3
 * Chennai Bangalore
 * Bombay Delhi
 * Goa Chennai
 * 
 * Output:
 * Goa -> Chennai -> Bangalore.
 */
