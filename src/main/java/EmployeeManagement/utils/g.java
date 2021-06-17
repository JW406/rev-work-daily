package EmployeeManagement.utils;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class g {
  private static Scanner sc = new Scanner(System.in);

  public static int getNextInt() {
    int res = -1;
    while (true) {
      try {
        res = sc.nextInt();
        sc.nextLine();
        break;
      } catch (InputMismatchException e) {
        sc.nextLine();
        System.out.println("Invalid input, please enter a valid number");
      } catch (NoSuchElementException e) {
        Exit();
      }
    }
    return res;
  }

  public static String getNextString(Boolean allowEmpty) {
    String res = "";
    while (true) {
      try {
        res = sc.nextLine().trim();
        if (allowEmpty || !res.equals("")) {
          break;
        }
      } catch (NoSuchElementException e) {
        Exit();
      }
    }
    return res;
  }

  public static double getNextDouble() {
    double res;
    while (true) {
      try {
        res = sc.nextDouble();
        sc.nextLine();
        break;
      } catch (InputMismatchException e) {
        sc.nextLine();
        System.out.println("Invalid input, please enter a valid number");
      } catch (NoSuchElementException e) {
        Exit();
      }
    }
    return res;
  }

  public static void Exit() {
    System.out.println("\nThank you for using the software.\n");
    System.exit(0);
  }
}
