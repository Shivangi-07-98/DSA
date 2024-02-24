import java.io.*;
import java.util.*;
public class arraylist {
    public static void main(String [] args)throws Exception {

        ArrayList<Integer> list; // declare
        list = new ArrayList<>(); // define
        System.out.println(list.size() + "->" + list); // 0 -> []

        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list.size() + "->" + list); // 3 -> [10,20,30]

        list.set(1,200);
        System.out.println(list.size() + "->" + list); // 3 -> [10,200,30]

        list.add(1,2000);
        System.out.println(list.size() + "->" + list); // 4 -> [10,2000,200,30]

        int val = list.get(1);
        System.out.println(val); // 2000
        System.out.println(list.size() + "->" + list); // 4 -> [10,2000,200,30]

        list.remove(1);
        System.out.println(list.size() + "->" + list); // 3 -> [10,200,30]

        for(int i = 0; i < list.size(); i++){
            int val1 = list.get(i);
            System.out.println(val1); 
        }

        for(int val2 : list){
            System.out.println(val2);
        }
        
    }
}