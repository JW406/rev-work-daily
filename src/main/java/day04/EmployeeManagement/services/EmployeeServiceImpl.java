package day04.EmployeeManagement.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import day04.EmployeeManagement.models.Address;
import day04.EmployeeManagement.models.Employee;

public class EmployeeServiceImpl implements EmployeeService {
  private static final Logger logger = Logger.getLogger(EmployeeServiceImpl.class.getName());

  private static List<Employee> emps = new ArrayList<Employee>() {
    {
      add(new Employee(1, "Lisa", 15000.0, new Address("Los Angeles", "California")));
      add(new Employee(2, "Lucy", 14000.0, new Address("San Francisco", "California")));
      add(new Employee(3, "Tom", 13000.0, new Address("Seattle", "Washington")));
    }
  };

  public EmployeeServiceImpl() {
  }

  @Override
  public void displayAllEmployees() {
    logger.info("Displaying all employees...");
    emps.stream().forEach(System.out::println);
  }

  @Override
  public double calculateYearlySalary(Employee e1) {
    logger.info("Calculating yearly salary for " + e1.getEmpName() + "...");
    return e1.getSalary() * 12;
  }

  @Override
  public Employee findByEmployeeNo(int empNo) {
    logger.info("Finding employee...");
    return emps.stream().filter(e -> e.getEmpNo().equals(empNo)).findFirst().orElse(null);
  }

  @Override
  public void updateEmployee(Employee e1) {
    logger.info("Updating employee...");
    emps = emps.stream().map((e) -> {
      if (e.getEmpNo().equals(e1.getEmpNo())) {
        return e1;
      } else {
        return e;
      }
    }).collect(Collectors.toList());
  }

  @Override
  public void deleteEmployee(Employee e1) {
    logger.info("Deleting employee...");
    emps = emps.stream().filter((e) -> !e.getEmpNo().equals(e1.getEmpNo())).collect(Collectors.toList());
  }

  @Override
  public void addEmployee(Employee e1) {
    logger.info("Adding employee...");
    EmployeeServiceImpl.emps.add(e1);
  }
}
