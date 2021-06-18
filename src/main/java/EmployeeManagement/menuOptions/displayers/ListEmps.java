package EmployeeManagement.menuOptions.displayers;

import java.util.List;
import java.util.logging.Level;

import EmployeeManagement.menuOptions.Displayer;
import EmployeeManagement.models.Employee;
import EmployeeManagement.services.EmployeeService;

final public class ListEmps extends Displayer {
  private final static ListEmps instance = new ListEmps();

  public static ListEmps getInstance() {
    return instance;
  }

  private ListEmps() {
  }

  @Override
  public void display(EmployeeService svc) {
    List<Employee> emps = svc.getAllEmployees();
    if (emps.isEmpty()) {
      logger.log(Level.INFO, "Currently, there is no employee in the database.");
    } else {
      emps.stream().forEach(System.out::println);
    }
  }
}
