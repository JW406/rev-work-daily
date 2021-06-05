package day04.EmployeeManagement.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    return emps.stream().filter(e -> e.getEmpNo().equals(empNo)).findFirst().orElse(null);
  }

  @Override
  public void updateEmployee(Employee e1) {
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
    emps.remove(e1);
  }
}
