package EmployeeManagement.menuOptions.displayers;

import java.util.logging.Level;

import EmployeeManagement.menuOptions.Displayer;
import EmployeeManagement.models.Address;
import EmployeeManagement.models.Employee;
import EmployeeManagement.services.EmployeeService;
import EmployeeManagement.utils.g;

final public class AddEmp implements Displayer {
  private final static AddEmp instance = new AddEmp();

  public static AddEmp getInstance() {
    return instance;
  }

  private AddEmp() {
  }

  @Override
  public void display(EmployeeService svc) {
    Employee emp = new Employee();
    System.out.println("Enter a ID for the new Employee");
    emp.setEmpNo(g.getNextInt());
    System.out.println("Enter the Name for the new Employee");
    emp.setEmpName(g.getNextString(false));
    System.out.println("Enter the Salary for the new Employee");
    emp.setSalary(g.getNextDouble());
    Address addr = new Address();
    System.out.println("Enter the State for the new Employee");
    addr.setState(g.getNextString(false));
    System.out.println("Enter the City for the new Employee");
    addr.setCity(g.getNextString(false));
    emp.setAddress(addr);
    if (svc.addEmployee(emp)) {
      logger.log(Level.INFO, "Add employee success");
    } else {
      logger.log(Level.INFO, "Add employee failed");
    }
  }
}
