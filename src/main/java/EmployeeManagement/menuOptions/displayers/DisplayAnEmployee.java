package EmployeeManagement.menuOptions.displayers;

import EmployeeManagement.exceptions.EmployeeNotFound;
import EmployeeManagement.menuOptions.Displayer;
import EmployeeManagement.models.Employee;
import EmployeeManagement.services.EmployeeService;
import EmployeeManagement.utils.g;

final public class DisplayAnEmployee extends Displayer {
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
