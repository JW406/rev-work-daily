package day04.EmployeeManagement.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import daoPatternExercise.ConnectionUtil;
import day04.EmployeeManagement.exceptions.EmployeeNotFound;
import day04.EmployeeManagement.models.Address;
import day04.EmployeeManagement.models.Employee;

public class EmployeeServiceImpl implements EmployeeService {
  private static final Logger logger = Logger.getLogger(EmployeeServiceImpl.class.getName());

  public EmployeeServiceImpl() {
  }

  @Override
  public List<Employee> getAllEmployees() {
    logger.info("getting all employees...");
    String QUERY = "select a.empNo, empName, salary, city, state from emp_proj_emp_tb a left join emp_proj_addr_tb b on a.empNo = b.empNo";
    List<Employee> res = new ArrayList<>();
    try (Connection con = ConnectionUtil.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY)) {
      while (rs.next()) {
        Employee emp = new Employee();
        emp.setEmpNo(rs.getInt("empNo"));
        emp.setEmpName(rs.getString("empName"));
        emp.setSalary(rs.getDouble("salary"));
        Address addr = new Address();
        addr.setCity(rs.getString("city"));
        addr.setState(rs.getString("state"));
        emp.setAddress(addr);
        res.add(emp);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return res;
  }

  @Override
  public double calculateYearlySalary(Employee e1) {
    logger.info("Calculating yearly salary for " + e1.getEmpName() + "...");
    return e1.getSalary() * 12;
  }

  @Override
  public Employee findByEmployeeNo(int empNo) throws EmployeeNotFound {
    logger.info("Finding employee...");
    String QUERY = "select a.empNo, empName, salary, city, state from emp_proj_emp_tb a left join emp_proj_addr_tb b on a.empNo = b.empNo where a.empNo = ?";

    Employee emp = null;
    try (Connection conn = ConnectionUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(QUERY)) {
      stmt.setInt(1, empNo);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        emp = new Employee();
        emp.setEmpNo(rs.getInt("empNo"));
        emp.setEmpName(rs.getString("empName"));
        emp.setSalary(rs.getDouble("salary"));
        Address addr = new Address();
        addr.setCity(rs.getString("city"));
        addr.setState(rs.getString("state"));
        emp.setAddress(addr);
      }
    } catch (SQLException e) {
      System.out.println("The employee cannot be found.");
      e.printStackTrace();
    }
    return emp;
  }

  @Override
  public void updateEmployee(Employee e1) {
    logger.info("Updating employee...");
  }

  @Override
  public Boolean deleteEmployee(Integer empNo) {
    logger.info("Deleting employee...");
    int row;
    String QUERY = "Delete from emp_proj_emp_tb where empNo = ?";
    try (Connection conn = ConnectionUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(QUERY)) {
      stmt.setInt(1, empNo);
      row = stmt.executeUpdate();
      if (row > 0) {
        return true;
      } else {
        logger.log(Level.INFO, "Employee No. " + empNo + " does not exist");
      }
    } catch (SQLException e) {
      logger.log(Level.INFO, "Row cannot be deleted");
      e.printStackTrace();
    }
    return false;
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
      System.out.println(">>:" + e.getErrorCode());
      e.printStackTrace();
    }
    return false;
  }
}
