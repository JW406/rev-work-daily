package day04.EmployeeManagement.utils;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class g {
  public static Scanner sc = new Scanner(System.in);

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

  public static void Exit() {
    System.out.println("\nThank you for using the software.\n");
    System.exit(0);
  }
}
