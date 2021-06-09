package day04.EmployeeManagement.services;

import day04.EmployeeManagement.exceptions.EmployeeNotFound;
import day04.EmployeeManagement.models.Employee;

public interface EmployeeService {
  void displayAllEmployees();

  double calculateYearlySalary(Employee e1);

  Employee findByEmployeeNo(int empNo) throws EmployeeNotFound;

  void updateEmployee(Employee e1);

  void deleteEmployee(Employee e1);

  void addEmployee(Employee e1);
}
