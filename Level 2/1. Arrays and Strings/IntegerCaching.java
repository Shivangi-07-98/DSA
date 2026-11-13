import java.io.*;
import java.util.*;

public class IntegerCaching {
  public static void main(String[] args) {

    // 1. int (small i)
    // Always use == for value comparison.
    // .equals() is NOT available for primitive int.

    int a = 500, b = 500;
    System.out.println(a == b); // true

    // 2. Integer (capital I)
    // Safest: Always use .equals() for value comparison.
    // Integer Cache: -128 to 127 (default range)

    Integer x = 127, y = 127;
    System.out.println(x == y);      // true (cached object)
    System.out.println(x.equals(y)); // true (same value)

    Integer p = 128, q = 128;
    System.out.println(p == q);      // false (different objects)
    System.out.println(p.equals(q)); // true (same value)
  }
}
