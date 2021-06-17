package day04.EmployeeManagement.services;

import day04.EmployeeManagement.exceptions.EmployeeNotFound;
import day04.EmployeeManagement.models.Employee;

public interface EmployeeService {
  void displayAllEmployees();

  double calculateYearlySalary(Employee emp);

  Employee findByEmployeeNo(int empNo) throws EmployeeNotFound;

  void updateEmployee(Employee emp);

  void deleteEmployee(Employee emp);

  Boolean addEmployee(Employee emp);
}
