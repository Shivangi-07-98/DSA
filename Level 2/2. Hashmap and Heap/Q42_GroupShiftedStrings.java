// Time O(total chars)
// Space O(total chars)

import java.io.*;
import java.util.*;

public class Q42_GroupShiftedStrings {

  public static ArrayList<ArrayList<String>> groupShiftedStrings(String[] strs) {
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
    String code = "";
    for (int i = 1; i < str.length(); i++) {
      char chi = str.charAt(i);
      char chim1 = str.charAt(i - 1);
      int diff = chi - chim1;

      if (diff < 0) {
        diff += 26;
      }

      code += diff + "*";
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
    ArrayList<ArrayList<String>> shiftedGrouped = groupShiftedStrings(arr);
    for (ArrayList<String> lst : shiftedGrouped) {
      Collections.sort(lst);
    }
    shiftedGrouped.sort(new ListComparator());
    display(shiftedGrouped);
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
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < currList.size(); j++) {
        if (j > 0)
          sb.append(' ');
        sb.append(currList.get(j));
      }
      System.out.println(sb.toString());
    }
  }

}

// Input:
// 6
// abc bcd acef xyz az ba

// Output:
// abc bcd xyz
// az ba
// acef
