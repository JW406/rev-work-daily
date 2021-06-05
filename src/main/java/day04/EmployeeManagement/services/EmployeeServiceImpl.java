package day04.EmployeeManagement.services;

import java.util.ArrayList;
import java.util.List;

import day04.EmployeeManagement.models.Address;
import day04.EmployeeManagement.models.Employee;

public class EmployeeServiceImpl implements EmployeeService {
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
    emps.stream().forEach(System.out::println);
  }

  @Override
  public double calculateYearlySalary(Employee e1) {
    return e1.getSalary() * 12;
  }

  @Override
  public Employee findByEmployeeNo(int empNo) {
    return emps.stream().filter(e -> e.getEmpNo() == empNo).findFirst().orElse(null);
  }

  @Override
  public boolean updateEmployee(Employee e1) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean deleteEmployee(Employee e1) {
    return emps.remove(e1);
  }
}
