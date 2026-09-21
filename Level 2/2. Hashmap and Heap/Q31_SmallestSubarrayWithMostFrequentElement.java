// https://leetcode.com/problems/degree-of-an-array/description/

// Time O(n)
// Space O(n)

import java.util.*;

public class Q31_SmallestSubarrayWithMostFrequentElement {

  static class Pair {
    int freq;
    int fi;
    int li;

    Pair(int freq, int fi, int li) {
      this.freq = freq;
      this.fi = fi;
      this.li = li;
    }
  }

  public static void solution(int[] arr) {
    HashMap<Integer, Pair> map = new HashMap<>();

    int mfi = arr[0];
    int mfiKiFreq = 1;
    int mfiKaSi = 0;
    int mfiKiLen = 1;

    map.put(arr[0], new Pair(1, 0, 0));

    for (int i = 1; i < arr.length; i++) {
      int val = arr[i];

      if (map.containsKey(val)) {
        Pair p = map.get(val);
        p.freq++;
        p.li = i;

        int len = i - p.fi + 1;

        if (p.freq > mfiKiFreq) {
          mfi = val;
          mfiKiFreq = p.freq;
          mfiKaSi = p.fi;
          mfiKiLen = len;
        } else if (p.freq == mfiKiFreq && len < mfiKiLen) {
          mfi = val;
          mfiKiFreq = p.freq;
          mfiKaSi = p.fi;
          mfiKiLen = len;
        } else if (p.freq == mfiKiFreq && len == mfiKiLen && p.fi < mfiKaSi) {
          mfi = val;
          mfiKiFreq = p.freq;
          mfiKaSi = p.fi;
          mfiKiLen = len;
        }
      } else {
        map.put(val, new Pair(1, i, i));
      }
    }

    System.out.println(mfi);
    System.out.println(mfiKaSi);
    System.out.println(mfiKaSi + mfiKiLen - 1);
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    solution(arr);
  }

}

// Input:
// 9
// 1 2 2 3 1 4 2 1 1
//
// Output:
// 1
// 0
// 8
