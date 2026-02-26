// Time Complexity: O(1) average for get/put, Space Complexity: O(capacity)

import java.io.*;
import java.util.*;

public class Q33_LRUCache {

  private static class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  private static class LRU {
    int cap;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    LRU(int cap) {
      this.cap = cap;
      this.map = new HashMap<>();
      head = new Node(-1, -1);
      tail = new Node(-1, -1);
      head.next = tail;
      tail.prev = head;
    }

    private void remove(Node node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

    private void addLast(Node node) {
      Node prev = tail.prev;
      prev.next = node;
      node.prev = prev;
      node.next = tail;
      tail.prev = node;
    }

    int get(int key) {
      if (!map.containsKey(key))
        return -1;

      Node node = map.get(key);
      remove(node);
      addLast(node);
      return node.val;
    }

    void put(int key, int value) {
      if (map.containsKey(key)) {
        Node node = map.get(key);
        node.val = value;
        remove(node);
        addLast(node);
        return;
      }

      if (map.size() == cap) {
        Node lru = head.next;
        remove(lru);
        map.remove(lru.key);
      }

      Node node = new Node(key, value);
      addLast(node);
      map.put(key, node);
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int capacity = scn.nextInt();
    int q = scn.nextInt();

    LRU cache = new LRU(capacity);

    for (int i = 0; i < q; i++) {
      String op = scn.next();
      if (op.equals("put")) {
        int key = scn.nextInt();
        int value = scn.nextInt();
        cache.put(key, value);
      } else {
        int key = scn.nextInt();
        System.out.println(cache.get(key));
      }
    }
  }
}

/*
 * Input:
 * 2 6
 * put 1 10
 * put 2 20
 * get 1
 * put 3 30
 * get 2
 * get 3
 * 
 * Output:
 * 10
 * -1
 * 30
 */
