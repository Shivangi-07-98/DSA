import java.util.*;

public class Q11_WriteHashmap {

  public static class MyPriorityQueue {
    ArrayList<Integer> data;

    public MyPriorityQueue() {
      data = new ArrayList<>();
    }

    public MyPriorityQueue(int[] arr) {
      data = new ArrayList<>();

      for (int val : arr) {
        data.add(val);
      }
      // n = 11
      for (int i = data.size() / 2 - 1; i >= 0; i--) { // 4, 3, 2, 1, 0
        downheapify(i);
      }
    }

    // O(log n)
    public void add(int val) {
      data.add(val);
      upheapify(data.size() - 1);
    }

    // O(log n)
    public int remove() {
      if (data.size() == 0) {
        System.out.println("Underflow");
        return -1;
      }

      swap(0, data.size() - 1);
      int val = data.remove(data.size() - 1);
      downheapify(0);
      return val;
    }

    // O(1)
    public int peek() {
      if (data.size() == 0) {
        System.out.println("Underflow");
        return -1;
      }
      return data.get(0);
    }

    // O(log n)
    public void upheapify(int i) {
      if (i == 0) {
        return;
      }

      int pi = (i - 1) / 2;
      if (data.get(pi) > data.get(i)) {
        swap(pi, i);
        upheapify(pi);
      }
    }

    // O(log n)
    public void downheapify(int i) {
      int mini = i;

      int li = 2 * i + 1;
      if (li < data.size() && data.get(li) < data.get(mini)) {
        mini = li;
      }

      int ri = 2 * i + 2;
      if (ri < data.size() && data.get(ri) < data.get(mini)) {
        mini = ri;
      }

      if (mini != i) {
        swap(i, mini);
        downheapify(mini);
      }
    }

    public void swap(int i, int j) {
      int ith = data.get(i);
      int jth = data.get(j);
      data.set(i, jth);
      data.set(j, ith);
    }

    // O(1)
    public int size() {
      return data.size();
    }

  }

  public static class Student implements Comparable<Student> {
    String name;
    int ht;
    int wt;
    int marks;

    Student(String name, int ht, int wt, int marks) {
      this.name = name;
      this.ht = ht;
      this.wt = wt;
      this.marks = marks;
    }

    public String toString() {
      return this.name + "->" + this.ht + "," + this.wt + "," + this.marks;
    }

    public int compareTo(Student other) {
      return this.ht - other.ht;
    }
  }

  public static class StudentWeightComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
      return s1.wt - s2.wt;
    }
  }

  public static class StudentMarksComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
      return s1.marks - s2.marks;
    }
  }

  public static void main(String[] args) throws Exception {
    Student[] students = new Student[5];
    students[0] = new Student("A", 180, 75, 90);
    students[1] = new Student("B", 150, 85, 33);
    students[2] = new Student("C", 185, 72, 99);
    students[3] = new Student("D", 165, 65, 75);
    students[4] = new Student("E", 177, 55, 88);

    // agar aap comparator provide krte ho toh wo comparable ko use nhi krta fir wo
    // comparator use krta hai
    PriorityQueue<Student> pqHt = new PriorityQueue<>();
    PriorityQueue<Student> pqWt = new PriorityQueue<>(new StudentWeightComparator());
    PriorityQueue<Student> pqMarks = new PriorityQueue<>(new StudentMarksComparator());

    for (Student student : students) {
      pqHt.add(student);
      pqWt.add(student);
      pqMarks.add(student);
    }

    System.out.println("On the basis of height");
    while (pqHt.size() > 0) {
      Student student = pqHt.peek();
      pqHt.remove();
      System.out.println(student);
    }

    System.out.println("On the basis of weight");
    while (pqWt.size() > 0) {
      Student student = pqWt.peek();
      pqWt.remove();
      System.out.println(student);
    }

    System.out.println("On the basis of marks");
    while (pqMarks.size() > 0) {
      Student student = pqMarks.peek();
      pqMarks.remove();
      System.out.println(student);
    }
  }

}
// interface is a contract of functions
// agar koi class interface ko implement krti hai toh usse interface ke function
// ki body provide krni pdti hai
//