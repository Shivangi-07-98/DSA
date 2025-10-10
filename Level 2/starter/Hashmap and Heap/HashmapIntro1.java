import java.util.*;

public class HashmapIntro1 {

  public static void main(String[] args) throws Exception {
    // key value
    HashMap<String, Integer> pmap = new HashMap<>();

    pmap.put("India", 130); // O(1)
    pmap.put("Utopia", 0); // add
    pmap.put("Utopia", 100); // update (as already present)
    System.out.println(pmap);

    System.out.println(pmap.get("India")); // O(1)
    System.out.println(pmap.get("uk")); // null or catch it in capital Integer to avoid error it gives using small int

    pmap.remove("India"); // O(1)
    System.out.println(pmap.containsKey("India")); // O(1)

    Set<String> keys = pmap.keySet(); // // O(n)
    for (String key : keys) {
      System.out.println(key);
      System.out.println(pmap.get(key));
    }

  }

}

// int vs Integer
// int(primitive integer)(it is made on stack)
// Integer(class integer)(it can store null)(as it is made on heap and address
// is stored on stack)
