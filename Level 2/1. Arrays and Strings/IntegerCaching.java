import java.io.*;
import java.util.*;

public class IntegerCaching {
  public static void main(String[] args) {
    // Integer Cache: -128 to 127 (default range)

    // 1. Values within cache range
    Integer a = 127;
    Integer b = 127;

    System.out.println(a == b); // true (same cached object)
    System.out.println(a.equals(b)); // true (same value)

    // 2. Values outside cache range
    Integer x = 128;
    Integer y = 128;

    System.out.println(x == y); // false (different objects)
    System.out.println(x.equals(y)); // true (same value)

    // 3. Using new Integer() - explicitly creates separate objects
    Integer p = new Integer(10);
    Integer q = new Integer(10);

    System.out.println(p == q); // false (different objects)
    System.out.println(p.equals(q)); // true (same value)

    // 4. Using primitive int
    int i = 128;
    int j = 128;

    System.out.println(i == j); // true (compares values)

    // 5. Integer object compared with primitive int
    Integer m = 128;
    int n = 128;

    System.out.println(m == n); // true (unboxing happens)
    System.out.println(m.equals(n)); // true (value comparison)
  }
}
