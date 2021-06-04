package day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class InvalidAge extends Exception {
  InvalidAge(String message) {
    super(message);
  }
}

public class Main {
  public static void main(String[] args) throws Exception {
    // System.out.println(t02(5));
    // t98();
    // System.out.println(t04(120));
    // System.out.println(t05(2,3));
    // System.out.println(t06(new int[] { 1, 2, 3 }));
    /*
    // t07
    try {
      int[][] a = new int[][] { { 1, 2, 3 } };
      t07(a, new int[][] { { 2, 3, 4 } });
      for (int i = 0; i < a.length; i++) {
        System.out.println(Arrays.toString(a[0]));
      }
    } catch (Exception e) {
    } */
    // t09(5);
    // System.out.println(t10("foo bar 123 "));
    // System.out.println(t10(" foo bar 123 "));
    // t97();
    // System.out.println(t11("foo", 'o'));
    // System.out.println(t12(" foo bar "));
    // t96(15);
    // System.out.println(t16("ffoo"));
    // System.out.println(t17("alila"));
    // System.out.println(Arrays.toString(t18()));
    // t95();
    // t19();
    t15();
  }

  private static void t01() {
    for (int i = 1; i <= 9; ++i) {
      for (int j = 1; j <= 9; ++j) {
        System.out.print(i + " * " + j + " = " + (i * j) + " ");
      }
      System.out.println();
    }
  }

  private static List<Integer> t02(int n) {
    int a = 1, b = 1, c = 0;
    List<Integer> res = new ArrayList<>();
    if (n >= 1) {
      res.add(a);
    }
    if (n >= 2) {
      res.add(b);
    }
    for (int i = 0; i < n - 2; i++) {
      c = a + b;
      a = b;
      b = c;
      res.add(c);
    }
    return res;
  }

  private static void t03() {
    for (char c = 'a'; c <= 'z'; ++c) {
      System.out.print(c + " ");
    }
    System.out.println();
  }

  private static int t04(int n) {
    int res = 0;
    while (n > 0) {
      int rem = n % 10;
      n /= 10;
      res = res * 10 + rem;
    }
    return res;
  }

  private static int t05(int n, int p) {
    int res = 1;
    for (int i = 0; i < p; i++) {
      res *= n;
    }
    return res;
  }

  private static int t06(int[] arr) {
    int res = 0;
    for (int i = 0; i < arr.length; i++) {
      res += arr[i];
    }
    return res / arr.length;
  }

  private static int[][] t07(int[][] a, int[][] b) throws Exception {
    if (a.length != b.length || a[0].length != b[0].length) {
      throw new Exception();
    }
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[0].length; j++) {
        a[i][j] += b[i][j];
      }
    }
    return a;
  }

  private static void t08(String str) {
    int vowels = 0, consonant = 0, digits = 0, spaces = 0;
    for (char c : str.toCharArray()) {
      if (c == ' ') {
        spaces++;
        continue;
      }
      if ('0' <= c && c <= '9') {
        digits++;
      } else if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        vowels++;
      } else {
        consonant++;
      }
    }
    System.out.println("vowels: " + vowels + "\n" + "consonant: " + consonant + "\n" + "digits: " + digits + "\n"
        + "spaces: " + spaces + "\n");
  }

  private static void t09(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  private static int t10(String str) {
    int res = 0;
    int i = -1;
    while (str.charAt(++i) == ' ') {
    }
    while (i < str.length()) {
      while (i < str.length() && str.charAt(i) != ' ') {
        ++i;
      }
      ++res;
      ++i;
    }
    return res;
  }

  private static int t11(String str, char c) {
    int res = 0;
    for (char cc : str.toCharArray()) {
      if (cc == c) {
        ++res;
      }
    }
    return res;
  }

  private static String t12(String str) {
    StringBuilder sb = new StringBuilder();
    for (char c : str.toCharArray()) {
      if (c != ' ') {
        sb.append(c);
      }
    }
    return sb.toString();
  }

  private static void t15() {
    String str = "Hello, World";
    int o = -1, comma = -1;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == 'o') {
        o = i;
      }
      if (str.charAt(i) == ',') {
        comma = i;
      }
    }
    System.out.println("o at " + o + ", " + "comma at: " + comma);
  }

  private static char t16(String str) {
    int[] freq = new int[128];
    for (char c : str.toCharArray()) {
      ++freq[c];
    }
    char res = 0;
    int mx = 0;
    for (int i = 0; i < freq.length; i++) {
      if (freq[i] > mx) {
        res = (char) i;
        mx = freq[i];
      }
    }
    return res;
  }

  private static boolean t17(String str) {
    char[] c = str.toCharArray();
    for (int i = 0, j = c.length - 1; i < j; ++i, --j) {
      if (c[i] != c[j]) {
        return false;
      }
    }
    return true;
  }

  private static String[] t18() {
    String str = "This is an umbrella";
    String[] res = new String[] { "", "" };
    int last = 0;
    for (int i = 0; i <= str.length(); ++i) {
      if (i == str.length() || str.charAt(i) == ' ') {
        if (res[0].length() == 0 || i - last < res[0].length()) {
          res[0] = str.substring(last, i);
        }
        if (i - last > res[1].length()) {
          res[1] = str.substring(last, i);
        }
        last = i;
      }
    }
    return res;
  }

  private static void t19() {
    String[] names = new String[] { "sa", "fe", "ti", "la", "tk", "in", "lk", "pk", "nm", "dn" };
    System.out.println(Arrays.toString(names));
    Arrays.sort(names);
    System.out.println(Arrays.toString(names));
  }

  private static void t99() {
    int[] arr = new int[5];
    arr[0] = 25;
    for (int x : arr) {
      System.out.println(x);
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  private static void t98() {
    int[][] arr = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, };
    int res = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + " ");
        res += arr[i][j];
      }
      System.out.println();
    }
    System.out.println("sum: " + res);
  }

  private static void t97() {
    int num1, num2;
    try {
      num1 = 0;
      num2 = 62 / num1;
      System.out.println(num2);
      System.out.println("end of try block");
    } catch (ArithmeticException e) {
      System.out.println("divide by zero");
    }
    System.out.println("out");
  }

  private static void t96(int age) throws InvalidAge {
    if (age < 20) {
      throw new InvalidAge("less than 20");
    } else {
      System.out.println("valid age");
    }
  }

  private static void t95() {
    StringTokenizer str = new StringTokenizer("Hello friends How are you", " ");
    while (str.hasMoreTokens()) {
      System.out.println(str.nextToken());
    }
  }
}
