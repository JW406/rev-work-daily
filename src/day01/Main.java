package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car {
  private String brand;
  private Integer price;

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Car(String brand, Integer price) {
    this.brand = brand;
    this.price = price;
  }

  Car highestPriceCar(Car c) {
    return c.getPrice() < this.getPrice() ? this : c;
  }
}

public class Main {
  public static void main(String[] args) {
    t09(4, 15);
  }

  private static void t01() {
    System.out.println("isbn:");
    String isbn = sc.nextLine();

    System.out.println("name:");
    String name = sc.nextLine();

    System.out.println("author:");
    String author = sc.nextLine();

    System.out.println("price:");
    Double price = sc.nextDouble();

    System.out.println("how many copies:");
    int copies = sc.nextInt();
    System.out.println("isbn: " + isbn + "\n" + "name: " + name + "\n" + "author: " + author + "\n" + "price: " + price
        + "\n" + "copies: " + copies);
  }

  private static void t02() {
    System.out.println("Enter num1:");
    int num1 = sc.nextInt();
    System.out.println("Enter num2:");
    int num2 = sc.nextInt();
    int quot = num1 / num2;
    int rem = num1 % num2;
    System.out.println("quotient: " + quot);
    System.out.println("remainder: " + rem);
  }

  private static void t03() {
    int a = 1;
    int b = 2;
    System.out.println("a=" + a + " b=" + b);
    int tmp = a;
    a = b;
    b = tmp;
    System.out.println("a=" + a + " b=" + b);
  }

  private static void t04() {
    int a = 1;
    int b = 2;
    System.out.println("a=" + a + " b=" + b);
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
    System.out.println("a=" + a + " b=" + b);
  }

  private static boolean t05_isVowel_if(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }

  private static void t06_isVowel_switch(char c) {
    switch (c) {
    case 'a':
    case 'e':
    case 'i':
    case 'o':
    case 'u':
      System.out.println("this is a vowel");
      break;
    default:
      System.out.println("this is a consonant");
      break;
    }
  }

  private static boolean t07(int year) {
    return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
  }

  private static void t08(int n) {
    if (n < 0) {
      System.out.println("n is negative");
    } else {
      System.out.println("n is positive");
    }
  }

  private static void t09(int a, int b) {
    List<Integer> res = new ArrayList<>();
    for (int k = a; k <= b; ++k) {
      boolean flag = true;
      for (int i = 2; i < k - 1; ++i) {
        if (k % i == 0) {
          flag = false;
          break;
        }
      }
      if (flag) {
        res.add(k);
      }
    }
    System.out.println(res);
  }

  private static int t10(int n, int p) {
    if (p == 1) {
      return n;
    }
    return n * t10(n, p - 1);
  }

  private static void t11(String str) {
    int vowels = 0, consonant = 0, digits = 0, spaces = 0;
    for (char c : str.toCharArray()) {
      if (c == ' ') {
        spaces++;
        continue;
      }
      if ('0' <= c && c <= '9') {
        digits++;
      } else if (t05_isVowel_if(c)) {
        vowels++;
      } else {
        consonant++;
      }
    }
    System.out.println("vowels: " + vowels + "\n" + "consonant: " + consonant + "\n" + "digits: " + digits + "\n"
        + "spaces: " + spaces + "\n");
  }

  private static Scanner sc = new Scanner(System.in);
}
