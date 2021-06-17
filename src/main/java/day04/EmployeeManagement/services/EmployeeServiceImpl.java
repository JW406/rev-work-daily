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
    String QUERY = "select a.empNo, empName, salary, city, state"
        + " from emp_proj_emp_tb a left join emp_proj_addr_tb b" //
        + " on a.empNo = b.empNo order by empName";
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
    if (emp == null) {
      throw new EmployeeNotFound();
    }
    return emp;
  }

  @Override
  public Boolean updateEmployee(Employee emp) {
    logger.info("Updating employee...");
    int row;
    String QUERY1 = "UPDATE emp_proj_emp_tb SET empName=?, salary=? WHERE empNo=?";
    String QUERY2 = "UPDATE emp_proj_addr_tb SET city=?, state=? WHERE empNo=?";
    try (Connection conn = ConnectionUtil.getConnection();
        PreparedStatement stmt1 = conn.prepareStatement(QUERY1);
        PreparedStatement stmt2 = conn.prepareStatement(QUERY2)) {
      stmt1.setString(1, emp.getEmpName());
      stmt1.setDouble(2, emp.getSalary());
      stmt1.setDouble(3, emp.getEmpNo());
      row = stmt1.executeUpdate();
      if (row > 0) {
        stmt2.setString(1, emp.getAddress().getCity());
        stmt2.setString(2, emp.getAddress().getState());
        stmt2.setInt(3, emp.getEmpNo());
        row = stmt2.executeUpdate();
        if (row > 0) {
          return true;
        } else {
          String QUERY3 = "insert into emp_proj_addr_tb values(null,?,?,?)";
          PreparedStatement stmt3 = conn.prepareStatement(QUERY3);
          stmt3.setInt(1, emp.getEmpNo());
          stmt3.setString(2, emp.getAddress().getCity());
          stmt3.setString(3, emp.getAddress().getState());
          row = stmt3.executeUpdate();
          stmt3.close();
          if (row > 0) {
            return true;
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Row cannot be updated");
    }
    return false;
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
  public Boolean addEmployee(Employee emp, Boolean isTest) {
    logger.info("Adding employee...");
    String QUERY = "insert into emp_proj_emp_tb values(?,?,?)";
    String QUERY2 = "insert into emp_proj_addr_tb values(";
    if (isTest) {
      QUERY2 += emp.getEmpNo();
    } else {
      QUERY2 += "null";
    }
    QUERY2 += ",?,?,?)";
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
      if (e.getErrorCode() == 1) {
        logger.log(Level.INFO, "Sorry, the ID has been taken");
      } else {
        e.printStackTrace();
      }
    }
    return false;

  }

  @Override
  public Boolean addEmployee(Employee emp) {
    return addEmployee(emp, false);
  }
}
