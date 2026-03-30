// Time Complexity: O(1) average, Space Complexity: O(number of urls)

import java.io.*;
import java.util.*;

public class Q60_EncodeAndDecodeTinyURL {

  private static class Codec {
    HashMap<String, String> longToShort = new HashMap<>();
    HashMap<String, String> shortToLong = new HashMap<>();
    int id = 1;
    String base = "http://tinyurl.com/";

    String encode(String longUrl) {
      if (longToShort.containsKey(longUrl))
        return longToShort.get(longUrl);

      String shortUrl = base + id++;
      longToShort.put(longUrl, shortUrl);
      shortToLong.put(shortUrl, longUrl);
      return shortUrl;
    }

    String decode(String shortUrl) {
      return shortToLong.get(shortUrl);
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    scn.nextLine();
    String longUrl = scn.nextLine();

    Codec codec = new Codec();
    String shortUrl = codec.encode(longUrl);

    System.out.println(shortUrl);
    System.out.println(codec.decode(shortUrl));
  }
}

/*
 * Input:
 * https://leetcode.com/problems/design-tinyurl
 * 
 * Output:
 * http://tinyurl.com/1
 * https://leetcode.com/problems/design-tinyurl
 */
