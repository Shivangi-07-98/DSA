import java.util.*;

public class ArraylistQ {
  
  public static class MyArrayList{ // size, data, capacity
    int size;
    int[] data; // data points to an array 
    // size equals to data.length then new array with double capacity
    static final int DEFAULT_CAPACITY = 5;

    MyArrayList(){
      this(DEFAULT_CAPACITY);
    }

    MyArrayList(int cap){
      size = 0;
      data = new int[cap];
    }

    int get(int idx){
      if(idx < 0 || idx >= size){
        System.out.println("Invalid arguments");
        return -1;
      }
      return data[idx];
    }

    void set(int idx, int val){
      if(idx < 0 || idx >= size){
        System.out.println("Invalid arguments");
        return;
      }
      data[idx] = val;
    }
    
    int size(){
      return size;
    }

    void display(){
      for(int i = 0; i < size; i++){
        System.out.print(data[i] + " ");
      }
      for(int i = size; i < data.length; i++){
        System.out.print(" - ");
      }
      // System.out.println(".");
      System.out.println("");
    }

    void add(int idx, int val){
      if(idx < 0 || idx > size){
        System.out.println("Invalid arguments");
        return;
      }

      // if necessary resize
      if(size == data.length){
        System.out.println("Resizing up");

        int [] ndata = new int[data.length * 2];
        for(int i = 0; i < size; i++){
          ndata[i] = data[i];
        }
        data = ndata;
      }
      for(int i = size; i >= idx + 1; i--){
        data[i] = data[i - 1];
      }
      data[idx] = val;
      size++;
    }

    void remove(int idx){
      if(idx < 0 || idx >= size){
        System.out.println("Invalid arguments");
        return;
      }

      for(int i = idx; i <= size - 2; i++){
        data[i] = data[i + 1];
      }
      data[size - 1] = 0;
      size--;

      if(size == data.length / 4){
        System.out.println("Resizing down");

        int [] ndata = new int[data.length / 2];
        for(int i = 0; i < size; i++){
          ndata[i] = data[i];
        }
        data = ndata;
      }
    }

  }

  public static void main(String[] args){
    MyArrayList list = new MyArrayList(4);
    list.add(0, 10);
    list.display();
    list.add(1, 20);
    list.display();
    list.add(2, 30);
    list.display();
    list.add(3, 40);
    list.display();
    list.add(4, 50);
    list.display();

    list.set(2, 300);
    list.display();

    list.add(2, 3000);
    list.display();

    list.add(4, 88);
    list.display();
    list.add(6, 34);
    list.display();
    list.add(2, 77);
    list.display();

    list.remove(1);
    list.display();
    list.remove(1);
    list.display();
    list.remove(1);
    list.display();
    list.remove(1);
    list.display();
    list.remove(1);
    list.display();

    list.remove(1);
    list.display();
    list.remove(1);
    list.display();
    list.remove(1);
    list.display();

  }

}
