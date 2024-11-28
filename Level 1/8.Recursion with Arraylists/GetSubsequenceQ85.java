import java.util.*;
public class GetSubsequenceQ85 {
    public static void main(String [] args) throws Exception {
        Scanner scn = new Scanner (System.in);
        String str = scn.nextLine();

        ArrayList <String> ans = gss(str);
        System.out.print(ans);
    }

        public static ArrayList <String> gss(String str){
            if(str.length() == 0){
                ArrayList <String> abc = new ArrayList<>();
                abc.add("");
                return abc;
            }

            char ch = str.charAt(0); // line 1
            String ros = str.substring(1); // line 2
            ArrayList <String> def = gss(ros); // line 3l 3r

            ArrayList <String> ghi = new ArrayList<>();
            for(String jkl : def){ // line 4
                jkl = "_" + jkl; //mno
                ghi.add(jkl);
                System.out.print(jkl + " ");
                System.out.println("end 1");
            }

            for(String jkl : def){ // line 5
                 jkl = ch + jkl;
                ghi.add(jkl);
                System.out.print(jkl + " ");
                System.out.println("end 2");
            }

            return ghi;
        }
    }
    