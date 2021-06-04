package day04.EmployeeManagement.services;

import day04.EmployeeManagement.models.Employee;

public interface EmployeeService {
  void displayAllEmployees();

  double calculateYearlySalary(Employee e1);

  Employee findByEmployeeNo(int empNo);

  boolean updateEmployee(Employee e1);

  boolean deleteEmployee(Employee e1);
}
