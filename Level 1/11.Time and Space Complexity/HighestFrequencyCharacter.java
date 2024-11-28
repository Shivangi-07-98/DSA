// O(n)
// a = 97 
// z = 122
import java.util.*;
public class HighestFrequencyCharacter {
    public static void main(String [] args) {
        Scanner scn = new Scanner (System.in);
        String str = scn.nextLine(); 

        int [] arr = new int [26];
        // 0 par a ki freq, 1 par b ki freq
        for(int i = 0; i < str.length(); i++){ // string array hota h? haa
            char ch = str.charAt(i);
            int idx = ch - 'a';
            arr[idx]++;
        }

        int max = 0;
        for(int i = 1; i < arr.length; i++){
            if (arr[i] > arr[max]){
                max = i;
            }
        }

        char mfc = (char)(max + 'a');
        System.out.print(mfc);

    }
}
