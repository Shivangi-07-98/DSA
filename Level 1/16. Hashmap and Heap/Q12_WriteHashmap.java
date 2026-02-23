import java.io.*;
import java.util.*;

public class Q12_WriteHashmap {

  public static class HashMap<K, V> {

    private class HMpair {
      K key;
      V val;

      HMpair(K key, V val) {
        this.key = key;
        this.val = val;
      }
    }

    int size;
    LinkedList<HMpair>[] buckets;

    public HashMap() {
      size = 0;
      initBuckets(4);
    }

    private void initBuckets(int N) {
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }

    public void put(K key, V val) {
      int bi = hashFunction(key);
      int di = findInBucket(key, bi);

      if (di == -1) {
        HMpair pair = new HMpair(key, val);
        buckets[bi].add(pair);
        size++;
      } else {
        HMpair pair = buckets[bi].get(di);
        pair.val = val;
      }
    }

    public V get(K key) {
      int bi = hashFunction(key);
      int di = findInBucket(key, bi);

      if (di == -1) {
        return null;
      } else {
        HMpair pair = buckets[bi].get(di);
        return pair.val;
      }
    }

    public boolean containsKey(K key) {
      int bi = hashFunction(key);
      int di = findInBucket(key, bi);

      if (di == -1) {
        return false;
      } else {
        return true;
      }
    }

    public V remove(K key) {
      int bi = hashFunction(key);
      int di = findInBucket(key, bi);

      if (di == -1) {
        return null;
      } else {
        HMpair pair = buckets[bi].remove(di);
        size--;
        return pair.val;
      }
    }

    public ArrayList<K> keyset() {
      ArrayList<K> keys = new ArrayList<>();

      for (int bi = 0; bi < buckets.length; bi++) {
        for (int di = 0; di < buckets[bi].size(); di++) {
          HMpair pair = buckets[bi].get(di);
          keys.add(pair.key);
        }
      }

      return keys;
    }

    public int size() {
      return size;
    }

    public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (int di = 0; di < buckets[bi].size(); di++) {
          HMpair pair = buckets[bi].get(di);
          System.out.print(pair.key + "@" + pair.val + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
    }

    private int hashFunction(K key) {
      int hash = key.hashCode();
      int bi = Math.abs(hash) % buckets.length;
      return bi;
    }

    private int findInBucket(K key, int bi) {
      for (int di = 0; di < buckets[bi].size(); di++) {
        HMpair pair = buckets[bi].get(di);
        if (pair.key.equals(key)) {
          return di;
        }
      }
      return -1;
    }

  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    HashMap<String, Integer> map = new HashMap<>();
    String str = scn.nextLine();

    while (str.equals("quit") == false) {

      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);

      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));

      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));

      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));

      } else if (str.startsWith("size")) {
        System.out.println(map.size());

      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());

      } else if (str.startsWith("display")) {
        map.display();
      }

      str = scn.nextLine();
    }
  }

}

/*
 * Sample Input
 * 
 * put India 135
 * put Aus 5
 * put Canada 3
 * display
 * get China
 * remove Aus
 * get Aus
 * containsKey US
 * put US 10
 * put UK 20
 * remove US
 * containsKey US
 * put Pak 80
 * put China 200
 * display
 * put Utopia 0
 * display
 * quit
 * 
 * 
 * Sample Output
 * 
 * Display Begins
 * Bucket0 .
 * Bucket1 .
 * Bucket2 Canada@3 .
 * Bucket3 India@135 Aus@5 .
 * Display Ends
 * null
 * 5
 * null
 * false
 * 10
 * false
 * Display Begins
 * Bucket0 .
 * Bucket1 .
 * Bucket2 Canada@3 UK@20 Pak@80 .
 * Bucket3 India@135 China@200 .
 * Display Ends
 * Display Begins
 * Bucket0 Utopia@0 .
 * Bucket1 .
 * Bucket2 Canada@3 UK@20 Pak@80 .
 * Bucket3 India@135 China@200 .
 * Display Ends
 */
