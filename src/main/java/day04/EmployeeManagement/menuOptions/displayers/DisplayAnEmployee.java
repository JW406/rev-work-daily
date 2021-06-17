package day04.EmployeeManagement.menuOptions.displayers;

import day04.EmployeeManagement.exceptions.EmployeeNotFound;
import day04.EmployeeManagement.menuOptions.Displayer;
import day04.EmployeeManagement.models.Employee;
import day04.EmployeeManagement.services.EmployeeService;
import day04.EmployeeManagement.utils.g;

final public class DisplayAnEmployee implements Displayer {
  private final static DisplayAnEmployee instance = new DisplayAnEmployee();

  public static DisplayAnEmployee getInstance() {
    return instance;
  }

  private DisplayAnEmployee() {
  }

  @Override
  public void display(EmployeeService svc) throws EmployeeNotFound {
    System.out.println("== Specific Employee Detail ==");
    System.out.println("Enter an employee id:");
    int id = g.getNextInt();
    Employee e1 = svc.findByEmployeeNo(id);
    System.out.println(e1);
  }
}
