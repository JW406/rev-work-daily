package day03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
  int rollno;
  String name;
  int age;

  @Override
  public int compareTo(Student o) {
    return o.age - age;
    // return age - o.age;
  }

  public Student(int rollno, String name, int age) {
    this.rollno = rollno;
    this.name = name;
    this.age = age;
  }
}

@FunctionalInterface
interface Shape {
  void draw();
}

public class ClassSessionSnippets {
  private static void objComparable() {
    List<Student> l = new ArrayList<>();
    l.add(new Student(100, "a", 18));
    l.add(new Student(101, "a", 17));
    Collections.sort(l);
    for (Student st : l) {
      System.out.println(st.age + " " + st.name);
    }
  }

  private static void readAfile() {
    try {
      FileInputStream fin = new FileInputStream("./.gitignore");
      int i;
      while ((i = fin.read()) != -1) {
        System.out.print((char) i);
      }
      fin.close();
    } catch (IOException e) {
    }
  }

  private static void outputTofile() {
    try {
      FileOutputStream fout = new FileOutputStream("./foobar");
      String str = "foobar";
      fout.write(str.getBytes());
      fout.close();
    } catch (IOException e) {
    }
  }

  private static void fileWriter() {
    try {
      FileWriter fw = new FileWriter("./foobar");
      fw.write("foobarr");
      fw.close();
    } catch (IOException e) {
    }
  }

  private static void AnonymousClass() {
    Shape d = () -> {
      System.out.println("foo");
    };
    /*
    Shape d = new Shape() {
      @Override
      public void draw() {
        System.out.println("foobar");
      }
    }; */
    d.draw();
  }

  private static void listEnsureCapacity() {
    //1. Ways to declare an arrayList
    ArrayList<String> list1 = new ArrayList<String>(); //First Method //  //'list' can hold 10 elements (Default Initial Capacity)
    ArrayList<Integer> list2 = new ArrayList<Integer>(20); //Second Method
    ArrayList<Integer> list3 = new ArrayList<Integer>(list2); //Third Method

    // Add elements
    list1.add("ONE");
    list1.add("TWO");
    list1.add("THREE");
    list1.add("FOUR");
    list1.add("ONE");

    //find the number of elements present in an ArrayList
    System.out.println(list1.size()); //5
    list1.ensureCapacity(20);

    //Check empty
    System.out.println(list1.isEmpty()); //True/false

    //Check availability
    System.out.println(list1.contains("TWO"));

    //check position System.out.println(list1.indexOf("ONE"));
    System.out.println(list1.lastIndexOf("ONE"));
  }

  private static void iterateArrayList() {
    ArrayList<String> c1 = new ArrayList<String>();
    c1.add("Red");
    c1.add("Green");
    c1.add("Black");
    c1.add("White");
    c1.add("Pink");
    System.out.println("\nOriginal array list: " + c1);
    System.out.println("\nPrint using index of an element: ");
    int no_of_elements = c1.size();
    for (int index = 0; index < no_of_elements; index++) {
      System.out.println(c1.get(index));
    }
  }

  public static void main(String[] args) {
    /*
    List<Integer> arr = new LinkedList<>(Arrays.asList(1, 2, 3));
    // for (int n : arr) {
    //   System.out.println(n);
    // }
    // ListIterator<Integer> iter = arr.listIterator();
    Iterator<Integer> iter = arr.listIterator();
    // arr.iterator()
    System.out.println(iter.next());
    // System.out.println(iter.previous()); */
    // objComparable();
    // readAfile();
    // outputTofile();
    // fileWriter();
    AnonymousClass();
  }
}
