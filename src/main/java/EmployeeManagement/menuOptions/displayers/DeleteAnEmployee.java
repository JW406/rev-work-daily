package EmployeeManagement.menuOptions.displayers;

import java.util.logging.Level;

import EmployeeManagement.menuOptions.Displayer;
import EmployeeManagement.services.EmployeeService;
import EmployeeManagement.utils.g;

final public class DeleteAnEmployee implements Displayer {
  private final static DeleteAnEmployee instance = new DeleteAnEmployee();

  public static DeleteAnEmployee getInstance() {
    return instance;
  }

  private DeleteAnEmployee() {
  }

  @Override
  public void display(EmployeeService svc) {
    System.out.println("== Delete an Employee ==");
    System.out.println("Enter an employee id:");
    int id = g.getNextInt();
    if (svc.deleteEmployee(id)) {
      logger.log(Level.INFO, "Delete " + id + " successful");
    } else {
      logger.log(Level.INFO, "Delete " + id + " failed");
    }
  }
}
