import java.io.*;
import java.util.*;

public class delete {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // 9
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
      arr[i] = scn.nextInt(); // 2 5 9 3 1 12 6 8 7
    }

    Stack<Integer> stack = new Stack<>();
    stack.push(arr[n-1]);

    int[] ans = new int[n];
    ans[n-1] = -1;

    for(int i = n-2; i >= 0; i--){
      while(stack.size() > 0 && stack.peek() <= arr[i]){
        stack.pop();
      }
      if(stack.size() > 0 && stack.peek() > arr[i]){
        ans[i] = (stack.peek());
      }
      if(stack.size() == 0){
        ans[i] = -1;
      }
      stack.push(arr[i]);
    }
    
    for(int i = 0; i < ans.length; i++){
      System.out.print(ans[i] + " ");
    }
    System.out.println();

  }
}
