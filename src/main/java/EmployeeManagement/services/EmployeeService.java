package EmployeeManagement.services;

import java.util.List;

import EmployeeManagement.exceptions.EmployeeNotFound;
import EmployeeManagement.models.Employee;

public interface EmployeeService {
  List<Employee> getAllEmployees();

  double calculateYearlySalary(Employee emp);

  Employee findByEmployeeNo(int empNo) throws EmployeeNotFound;

  Boolean updateEmployee(Employee emp);

  Boolean deleteEmployee(Integer empNo);

  Boolean addEmployee(Employee emp);

  Boolean addEmployee(Employee emp, Boolean isTest);
}
