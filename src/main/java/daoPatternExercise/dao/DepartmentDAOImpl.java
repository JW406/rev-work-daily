package daoPatternExercise.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import daoPatternExercise.ConnectionUtil;
import daoPatternExercise.models.Department;

public class DepartmentDAOImpl implements DepartmentDAO {
  @Override
  public List<Department> getAllDepartments() {
    String QUERY = "select deptno,dname,loc from dept_jdbc";
    List<Department> res = new ArrayList<>();
    try (Connection con = ConnectionUtil.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY)) {
      while (rs.next()) {
        Department dept = new Department();
        dept.setDeptno(rs.getInt("deptno"));
        dept.setDname(rs.getString("dname"));
        dept.setLoc(rs.getString("loc"));
        res.add(dept);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return res;
  }

  @Override
  public Boolean addDepartment(Department dept) {
    String QUERY = "insert into dept_jdbc values(?,?,?)";
    try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(QUERY)) {
      stmt.setInt(1, dept.getDeptno());
      stmt.setString(2, dept.getDname());
      stmt.setString(3, dept.getLoc());
      int result = stmt.executeUpdate();
      if (result == 1) {
        return true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (NumberFormatException e) {
      System.out.println("Number expected, please try again");
    }
    return false;
  }

  @Override
  public Boolean updateDepartment(Department dept) {
    int row = 0;
    String QUERY = "UPDATE dept_jdbc SET dname=? WHERE deptno=?";
    try (Connection conn = ConnectionUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(QUERY)) {
      stmt.setString(1, dept.getDname());
      stmt.setInt(2, dept.getDeptno());
      row = stmt.executeUpdate();
      if (row > 0) {
        return true;
      }
    } catch (SQLException e) {
      System.out.println("Row cannot be updated");
    }
    return false;
  }

  @Override
  public Boolean deleteDepartment(Integer deptNo) {
    int row = 0;
    String QUERY = "Delete from dept_jdbc where deptno = ?";
    try (Connection conn = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
      preparedStatement.setInt(1, deptNo);
      row = preparedStatement.executeUpdate();
      if (row > 0) {
        return true;
      }
    } catch (SQLException e) {
      System.out.println("Row cannot be deleted");
    }
    return false;
  }

  @Override
  public Department getDepartmentByNo(Integer deptNo) {
    String QUERY = "select deptno, dname, loc from dept_jdbc where deptno = ?";
    Department dept = null;
    try (Connection conn = ConnectionUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(QUERY)) {
      stmt.setInt(1, deptNo);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        dept = new Department();
        dept.setDeptno(rs.getInt("deptno"));
        dept.setDname(rs.getString("dname"));
        dept.setLoc(rs.getString("loc"));
      }
    } catch (SQLException e) {
      System.out.println("Department cannot be found.");
    }
    return dept;
  }

  @Override
  public Boolean addImageForDepartment(Integer deptNo, String fileName) {
    String QUERY = "UPDATE dept_jdbc SET image=? WHERE deptno=?";
    try (Connection conn = ConnectionUtil.getConnection();
        PreparedStatement stmt = conn.prepareStatement(QUERY);
        FileInputStream fin = new FileInputStream(fileName)) {
      stmt.setBinaryStream(1, fin, fin.available());
      stmt.setInt(2, deptNo);
      int rows = stmt.executeUpdate();
      if (rows > 0) {
        return true;
      }
    } catch (SQLException e) {
      System.out.println("Image adding failed");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public Boolean retrieveImageForDepartment(Integer deptNo, String fileName) {
    String QUERY = "select image from dept_jdbc where deptno = ?";
    try (Connection conn = ConnectionUtil.getConnection();
        PreparedStatement stmt = conn.prepareStatement(QUERY);
        FileOutputStream fout = new FileOutputStream(fileName)) {
      stmt.setInt(1, deptNo);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        Blob b = rs.getBlob(1);
        byte image[] = b.getBytes(1, (int) b.length());
        fout.write(image);
        return true;
      }
    } catch (SQLException e) {
      System.out.println("Image retrieval failed.");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }
}
