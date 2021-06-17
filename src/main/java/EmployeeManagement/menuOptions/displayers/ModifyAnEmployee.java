package EmployeeManagement.menuOptions.displayers;

import java.util.logging.Level;

import EmployeeManagement.exceptions.EmployeeNotFound;
import EmployeeManagement.menuOptions.Displayer;
import EmployeeManagement.models.Employee;
import EmployeeManagement.services.EmployeeService;
import EmployeeManagement.utils.g;

final public class ModifyAnEmployee implements Displayer {
  private final static ModifyAnEmployee instance = new ModifyAnEmployee();

  public static ModifyAnEmployee getInstance() {
    return instance;
  }

  private ModifyAnEmployee() {
  }

  @Override
  public void display(EmployeeService svc) throws EmployeeNotFound {
    System.out.println("== Modify Employee Detail ==");
    System.out.println("Enter an employee id:");
    int id = g.getNextInt();
    Employee e1 = svc.findByEmployeeNo(id);
    Employee modifiedEmp = new Employee(e1);
    String str;
    double num;

    System.out.println("Enter new name (" + modifiedEmp.getEmpName() + ")");
    str = g.getNextString(true);
    if (!str.isEmpty()) {
      modifiedEmp.setEmpName(str);
    }

    System.out.println("Enter new salary (" + modifiedEmp.getSalary() + ")");
    str = g.getNextString(true);
    if (!str.isEmpty()) {
      num = Double.parseDouble(str);
      modifiedEmp.setSalary(num);
    }

    System.out.println("Enter new Address(State) (" + modifiedEmp.getAddress().getState() + ")");
    str = g.getNextString(true);
    if (!str.isEmpty()) {
      modifiedEmp.getAddress().setState(str);
    }

    System.out.println("Enter new Address(City) (" + modifiedEmp.getAddress().getCity() + ")");
    str = g.getNextString(true);
    if (!str.isEmpty()) {
      modifiedEmp.getAddress().setCity(str);
    }

    if (svc.updateEmployee(modifiedEmp)) {
      logger.log(Level.INFO, "Update " + modifiedEmp.getEmpName() + "(" + id + ") successful");
    } else {
      logger.log(Level.INFO, "Update " + modifiedEmp.getEmpName() + "(" + id + ") failed");
    }
  }
}
