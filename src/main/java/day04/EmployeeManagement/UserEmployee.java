package day04.EmployeeManagement;

import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

import day04.EmployeeManagement.exceptions.EmployeeNotFound;
import day04.EmployeeManagement.models.Address;
import day04.EmployeeManagement.models.Employee;
import day04.EmployeeManagement.services.EmployeeService;
import day04.EmployeeManagement.services.EmployeeServiceImpl;
import day04.EmployeeManagement.utils.g;

public class UserEmployee {
  private static final Logger logger = Logger.getLogger(UserEmployee.class.getName());

  public static void main(String[] args) {
    EmployeeService svc = new EmployeeServiceImpl();

    boolean flag = true;
    while (flag) {
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
        case 0: { // Add an Employee
          System.out.println("Enter a ID for the new Employee");
          Employee emp = new Employee();
          emp.setEmpNo(g.getNextInt());
          System.out.println("Enter a name for the new Employee");
          emp.setEmpName(g.getNextString());
          System.out.println("Enter a salary for the new Employee");
          emp.setSalary(g.getNextDouble());
          Address addr = new Address();
          System.out.println("Enter a State for the new Employee");
          addr.setState(g.getNextString());
          System.out.println("Enter a City for the new Employee");
          addr.setCity(g.getNextString());
          emp.setAddress(addr);
          svc.addEmployee(emp);
          break;
        }
        case 1: // List all employee
          svc.displayAllEmployees();
          break;
        case 2: { // Display Yearly Salary
          System.out.println("== Display Yearly Salary ==");
          System.out.println("Enter an employee id:");
          int id = g.getNextInt();
          Employee e1 = svc.findByEmployeeNo(id);
          System.out.println(svc.calculateYearlySalary(e1));
          break;
        }
        case 3: { // Specific Employee Detail
          System.out.println("== Specific Employee Detail ==");
          System.out.println("Enter an employee id:");
          int id = g.getNextInt();
          Employee e1 = svc.findByEmployeeNo(id);
          System.out.println(e1);
          break;
        }
        case 4: { // Modify Employee Detail
          System.out.println("== Modify Employee Detail ==");
          System.out.println("Enter an employee id:");
          int id = g.getNextInt();
          Employee e1 = svc.findByEmployeeNo(id);
          Employee modifiedEmp = new Employee(e1);
          String str;
          double num;

          System.out.println("Enter new name (" + modifiedEmp.getEmpName() + ")");
          str = g.sc.nextLine();
          if (!str.isEmpty()) {
            modifiedEmp.setEmpName(str);
          }

          System.out.println("Enter new salary (" + modifiedEmp.getSalary() + ")");
          str = g.sc.nextLine();
          if (!str.isEmpty()) {
            num = Double.parseDouble(str);
            modifiedEmp.setSalary(num);
          }

          System.out.println("Enter new Address(State) (" + modifiedEmp.getAddress().getState() + ")");
          str = g.sc.nextLine();
          if (!str.isEmpty()) {
            modifiedEmp.getAddress().setState(str);
          }

          System.out.println("Enter new Address(City) (" + modifiedEmp.getAddress().getCity() + ")");
          str = g.sc.nextLine();
          if (!str.isEmpty()) {
            modifiedEmp.getAddress().setCity(str);
          }

          svc.updateEmployee(modifiedEmp);
          System.out.println("\nUpdate " + modifiedEmp.getEmpName() + "(" + id + ") successful\n");
          break;
        }
        case 5: { // Delete an Employee
          System.out.println("== Delete an Employee ==");
          System.out.println("Enter an employee id:");
          int id = g.getNextInt();
          Employee e1 = svc.findByEmployeeNo(id);
          svc.deleteEmployee(e1);
          System.out.println("\nDelete " + e1.getEmpName() + "(" + id + ") successful\n");
          break;
        }
        case 6:
          flag = false;
          g.Exit();
          break;
        }
      } catch (NoSuchElementException e) {
        g.Exit();
      } catch (EmployeeNotFound e) {
        logger.log(Level.INFO, "Unable to find the employee");
      }
    }
  }
}
