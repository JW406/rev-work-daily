package day03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

@FunctionalInterface
interface FindSquare {
  int apply(int x);
}

public class Main {
  public static void main(String[] args) {
    /*
    String[] strs = {"foo", "bar"};
    System.out.println(Arrays.toString(strs));
    t01(strs, 0, 1);
    System.out.println(Arrays.toString(strs)); */
    /*
    ArrayList<Integer> myarr = new ArrayList<>(Arrays.asList(1, 2, 3));
    ArrayList<Integer> other = t02(myarr);
    myarr.set(0, 99);
    System.out.println(other.get(0)); */
    /*
    t03(); */
    /*
    LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3));
    t04(list, 4);
    System.out.println(list); */

    /*
    List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
    System.out.println(t05(list, 3)); */
    /*
    List<Integer> a = new ArrayList<>(Arrays.asList(1,2,3));
    List<Integer> b = new ArrayList<>(Arrays.asList(4,5,6));
    t06(a, b);
    System.out.println(a); */

    /*
    System.out.println(t09("./.gitignore")); */

    t10();
  }

  private static void t01(String[] strs, int i, int j) {
    String tmp = strs[i];
    strs[i] = strs[j];
    strs[j] = tmp;
  }

  private static <T> ArrayList<T> t02(ArrayList<T> arr) {
    return (ArrayList<T>) arr.clone();
  }

  private static void t03() {
    List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3));
    ListIterator<Integer> iter = list.listIterator(list.size());
    while (iter.hasPrevious()) {
      System.out.print(iter.previous() + " ");
    }
    System.out.println();
  }

  private static <T> void t04(LinkedList<T> linkedList, T elm) {
    linkedList.offerLast(elm);
  }

  private static Integer t05(List<Integer> arr, Integer elm) {
    int l = 0, r = arr.size() - 1;
    while (l <= r) {
      int m = l + ((r - l) >> 1);
      if (arr.get(m).equals(elm)) {
        return m;
      } else if (arr.get(m) < elm) {
        l = m + 1;
      } else {
        r = m - 1;
      }
    }
    return -1;
  }

  private static void t06(List<Integer> a, List<Integer> b) {
    a.addAll(b);
  }

  private static String t09(String path) {
    StringBuilder result = new StringBuilder();
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
      String s = null;
      while ((s = br.readLine()) != null) {
        result.append(s + System.lineSeparator());
      }
      br.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result.toString();
  }

  private static void t10() {
    FindSquare fs = (x) -> x * x;
    System.out.println(fs.apply(5));
  }
}
