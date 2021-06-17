package day04.EmployeeManagement.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import daoPatternExercise.ConnectionUtil;
import day04.EmployeeManagement.exceptions.EmployeeNotFound;
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
  public Employee findByEmployeeNo(int empNo) throws EmployeeNotFound {
    logger.info("Finding employee...");
    return emps.stream().filter(e -> e.getEmpNo().equals(empNo)).findFirst().orElseThrow(() -> new EmployeeNotFound());
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
  public Boolean addEmployee(Employee emp) {
    logger.info("Adding employee...");
    String QUERY = "insert into emp_proj_emp_tb values(?,?,?)";
    String QUERY2 = "insert into emp_proj_addr_tb values(null,?,?,?)";
    int result;
    try (Connection con = ConnectionUtil.getConnection();
        PreparedStatement stmt = con.prepareStatement(QUERY);
        PreparedStatement stmt2 = con.prepareStatement(QUERY2)) {
      stmt.setInt(1, emp.getEmpNo());
      stmt.setString(2, emp.getEmpName());
      stmt.setDouble(3, emp.getSalary());
      result = stmt.executeUpdate();
      if (result > 0) {
        stmt2.setInt(1, emp.getEmpNo());
        stmt2.setString(2, emp.getAddress().getCity());
        stmt2.setString(3, emp.getAddress().getState());
        result = stmt2.executeUpdate();
        if (result > 0) {
          return true;
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }
}
