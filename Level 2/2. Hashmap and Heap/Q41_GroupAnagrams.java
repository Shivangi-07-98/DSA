// Time O(n * k log k)
// Space O(n * k)

import java.io.*;
import java.util.*;

public class Q41_GroupAnagrams {

  public static ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
    HashMap<String, ArrayList<String>> map = new HashMap<>();

    for (String str : strs) {
      String code = getCode(str);
      if (map.containsKey(code)) {
        ArrayList<String> list = map.get(code);
        list.add(str);
        map.put(code, list);
      } else {
        ArrayList<String> list = new ArrayList<>();
        list.add(str);
        map.put(code, list);
      }
    }

    ArrayList<ArrayList<String>> res = new ArrayList<>();
    for (String code : map.keySet()) {
      ArrayList<String> list = map.get(code);
      res.add(list);
    }

    return res;
  }

  public static String getCode(String str) {
    HashMap<Character, Integer> fmap = new HashMap<>();
    for (char ch : str.toCharArray()) {
      fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
    }

    String code = "";
    for (Character key : fmap.keySet()) {
      code += key + "" + fmap.get(key);
    }

    return code;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int N = scn.nextInt();
    String[] arr = new String[N];
    for (int i = 0; i < N; i++) {
      arr[i] = scn.next();
    }
    ArrayList<ArrayList<String>> anagramsGrouped = groupAnagrams(arr);
    for (ArrayList<String> lst : anagramsGrouped) {
      Collections.sort(lst);
    }
    anagramsGrouped.sort(new ListComparator());
    display(anagramsGrouped);
  }

  // it is used to make the result unique
  static class ListComparator implements Comparator<List<String>> {
    @Override
    public int compare(List<String> l1, List<String> l2) {
      if (l1.size() != l2.size()) {
        return l2.size() - l1.size();
      }

      String l1str = l1.get(0);
      String l2str = l2.get(0);
      return l1str.compareTo(l2str);
    }
  }

  public static void display(ArrayList<ArrayList<String>> list) {
    for (int i = 0; i < list.size(); i++) {
      ArrayList<String> currList = list.get(i);
      for (int j = 0; j < currList.size(); j++) {
        System.out.print(currList.get(j) + " ");
      }
      System.out.println();
    }
  }
}

// Input:
// 5
// pepcoding codingpep pepper rapper repepp

// Output:
// codingpep pepcoding
// pepper repepp
// rapper
