package day04.EmployeeManagement.services;

import java.util.List;

import day04.EmployeeManagement.models.Employee;

public class EmployeeServiceImpl implements EmployeeService {
  private List<Employee> emps;

  public EmployeeServiceImpl(List<Employee> emps) {
    this.emps = emps;
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
