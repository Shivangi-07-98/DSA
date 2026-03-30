// Time Complexity: O(k * 10 * 10)
// Space Complexity: O(1)
import java.io.*;
import java.util.*;

public class Q16_CrosswordPuzzle {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[][] board = new char[10][10];
    for (int i = 0; i < 10; i++) {
      board[i] = br.readLine().trim().toCharArray();
    }
    String wordsLine = br.readLine().trim();
    String[] words = wordsLine.split(";");
    solve(board, words, 0);
  }

  private static boolean canPlaceHoriz(char[][] board, String word, int r, int c) {
    if (c + word.length() > 10) return false;
    if (c > 0 && board[r][c - 1] != '+') return false;
    if (c + word.length() < 10 && board[r][c + word.length()] != '+') return false;

    for (int j = 0; j < word.length(); j++) {
      char ch = board[r][c + j];
      if (ch != '-' && ch != word.charAt(j)) return false;
    }
    return true;
  }

  private static boolean canPlaceVert(char[][] board, String word, int r, int c) {
    if (r + word.length() > 10) return false;
    if (r > 0 && board[r - 1][c] != '+') return false;
    if (r + word.length() < 10 && board[r + word.length()][c] != '+') return false;

    for (int i = 0; i < word.length(); i++) {
      char ch = board[r + i][c];
      if (ch != '-' && ch != word.charAt(i)) return false;
    }
    return true;
  }

  private static boolean[] placeHoriz(char[][] board, String word, int r, int c) {
    boolean[] placed = new boolean[word.length()];
    for (int j = 0; j < word.length(); j++) {
      if (board[r][c + j] == '-') {
        board[r][c + j] = word.charAt(j);
        placed[j] = true;
      }
    }
    return placed;
  }

  private static boolean[] placeVert(char[][] board, String word, int r, int c) {
    boolean[] placed = new boolean[word.length()];
    for (int i = 0; i < word.length(); i++) {
      if (board[r + i][c] == '-') {
        board[r + i][c] = word.charAt(i);
        placed[i] = true;
      }
    }
    return placed;
  }

  private static void unplaceHoriz(char[][] board, boolean[] placed, int r, int c) {
    for (int j = 0; j < placed.length; j++) {
      if (placed[j]) board[r][c + j] = '-';
    }
  }

  private static void unplaceVert(char[][] board, boolean[] placed, int r, int c) {
    for (int i = 0; i < placed.length; i++) {
      if (placed[i]) board[r + i][c] = '-';
    }
  }

  private static boolean solve(char[][] board, String[] words, int idx) {
    if (idx == words.length) {
      printBoard(board);
      return true;
    }

    String word = words[idx];
    for (int r = 0; r < 10; r++) {
      for (int c = 0; c < 10; c++) {
        if (board[r][c] == '-' || board[r][c] == word.charAt(0)) {
          if (canPlaceHoriz(board, word, r, c)) {
            boolean[] placed = placeHoriz(board, word, r, c);
            if (solve(board, words, idx + 1)) return true;
            unplaceHoriz(board, placed, r, c);
          }
          if (canPlaceVert(board, word, r, c)) {
            boolean[] placed = placeVert(board, word, r, c);
            if (solve(board, words, idx + 1)) return true;
            unplaceVert(board, placed, r, c);
          }
        }
      }
    }

    return false;
  }

  private static void printBoard(char[][] board) {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
  }


}

/*
 * Input:
 * +-++++++++
 * +-++++++++
 * +-++++++++
 * +-----++++
 * +-+++-++++
 * +-+++-++++
 * +++++-++++
 * ++------++
 * +++++-++++
 * +++++-++++
 * LONDON;DELHI;ICELAND;ANKARA
 *
 * Output:
 * +L++++++++
 * +O++++++++
 * +N++++++++
 * +DELHI++++
 * +O+++C++++
 * +N+++E++++
 * +++++L++++
 * ++ANKARA++
 * +++++N++++
 * +++++D++++
 */
