package day04.EmployeeManagement.services;

import java.util.List;

import day04.EmployeeManagement.exceptions.EmployeeNotFound;
import day04.EmployeeManagement.models.Employee;

public interface EmployeeService {
  List<Employee> getAllEmployees();

  double calculateYearlySalary(Employee emp);

  Employee findByEmployeeNo(int empNo) throws EmployeeNotFound;

  Boolean updateEmployee(Employee emp);

  Boolean deleteEmployee(Integer empNo);

  Boolean addEmployee(Employee emp);

  Boolean addEmployee(Employee emp, Boolean isTest);
}
