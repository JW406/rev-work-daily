package day04.EmployeeManagement;

import java.util.logging.Level;
import java.util.logging.Logger;

import day04.EmployeeManagement.exceptions.EmployeeNotFound;
import day04.EmployeeManagement.menuOptions.Displayer;
import day04.EmployeeManagement.services.EmployeeService;
import day04.EmployeeManagement.services.EmployeeServiceImpl;
import day04.EmployeeManagement.utils.g;

public class Main {
  private static final Logger logger = Logger.getLogger(Main.class.getName());

  public static void main(String[] args) {
    EmployeeService svc = new EmployeeServiceImpl();

    while (true) {
      System.out.println();
      System.out.println("0. Add an employee");
      System.out.println("1. List all employee");
      System.out.println("2. Display Yearly Salary");
      System.out.println("3. Display Specific Employee Detail");
      System.out.println("4. Modify Employee Detail");
      System.out.println("5. Delete an Employee");
      System.out.println("6. Quit");
      System.out.println();
      try {
        switch (g.getNextInt()) {
        case 0:
          Displayer.get("AddEmp").display(svc);
          break;
        case 1:
          Displayer.get("ListEmps").display(svc);
          break;
        case 2:
          Displayer.get("DisplayYearlySal").display(svc);
          break;
        case 3:
          Displayer.get("DisplayAnEmployee").display(svc);
          break;
        case 4:
          Displayer.get("ModifyAnEmployee").display(svc);
          break;
        case 5:
          Displayer.get("DeleteAnEmployee").display(svc);
          break;
        case 6:
          g.Exit();
          break;
        }
      } catch (EmployeeNotFound e) {
        logger.log(Level.INFO, "Unable to find the employee");
      }
    }
  }
}
