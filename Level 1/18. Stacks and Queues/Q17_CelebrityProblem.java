import java.io.*;
import java.util.*;

// O(n) - each person processed once in elimination, then O(n) verification
// Find celebrity: everyone knows them, they know no one
public class Q17_CelebrityProblem {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[][] arr = new int[n][n];
    for (int j = 0; j < n; j++) {
      String line = scn.next();
      for (int k = 0; k < n; k++) {
        arr[j][k] = line.charAt(k) - '0';
      }
    }
    findCelebrity(arr);
    scn.close();
  }

  public static void findCelebrity(int[][] arr) {
    // if a celebrity is there print it's index (not position), if there is not then
    // print "none"
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      st.push(i);
    }

    while (st.size() != 1) {
      int i = st.pop();
      int j = st.pop();
      if (arr[i][j] == 1) { // i knows j, so i can't be celebrity
        st.push(j);
      } else { // i doesn't know j, j can't be celebrity
        st.push(i);
      }
    }

    int pot = st.pop();
    boolean flag = true;
    for (int i = 0; i < arr.length; i++) {
      if (i != pot) {
        if (arr[i][pot] == 0 || arr[pot][i] == 1) {
          flag = false;
          break;
        }
      }
    }

    if (flag == true) {
      System.out.println(pot);
    } else {
      System.out.println("none");
    }
  }
  
}

// Algorithm:
// 1. Push all indices onto stack
// 2. Eliminate candidates: if i knows j, eliminate i; else eliminate j
// 3. Verify remaining candidate: check if everyone knows them and they know no one

// Sample Input:
// 4
// 0000
// 1011
// 1101
// 1110
//
// Sample Output:
// 0
