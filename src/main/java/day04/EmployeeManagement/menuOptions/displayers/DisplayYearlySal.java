package day04.EmployeeManagement.menuOptions.displayers;

import day04.EmployeeManagement.exceptions.EmployeeNotFound;
import day04.EmployeeManagement.menuOptions.Displayer;
import day04.EmployeeManagement.models.Employee;
import day04.EmployeeManagement.services.EmployeeService;
import day04.EmployeeManagement.utils.g;

final public class DisplayYearlySal implements Displayer {
  private final static DisplayYearlySal instance = new DisplayYearlySal();

  public static DisplayYearlySal getInstance() {
    return instance;
  }

  private DisplayYearlySal() {
  }

  @Override
  public void display(EmployeeService svc) throws EmployeeNotFound {
    System.out.println("== Display Yearly Salary ==");
    System.out.println("Enter an employee id:");
    int id = g.getNextInt();
    Employee e1 = svc.findByEmployeeNo(id);
    System.out.println(svc.calculateYearlySalary(e1));
  }
}
