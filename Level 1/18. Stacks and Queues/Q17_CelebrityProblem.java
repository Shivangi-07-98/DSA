import java.io.*;
import java.util.*;

// O(n) - each person processed once in elimination, then O(n) verification
// Find celebrity: everyone knows them, they know no one
// Sample Input:
// 4
// 0000
// 1011
// 1101
// 1110
//
// Sample Output:
// 0
public class Q17_CelebrityProblem {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 4
    int[][] arr = new int[n][n]; // 4 4
    for (int i = 0; i < n; i++) { // 0 1 2 3
      String line = scn.next(); // 0000, 1011, 1101, 1110
      for (int j = 0; j < n; j++) {
        arr[i][j] = line.charAt(j) - '0'; // converting to integer
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
      if (i != pot) { // 3 3 both on col and row, check will not happen
        if (arr[i][pot] == 0 || arr[pot][i] == 1) { // col row
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
