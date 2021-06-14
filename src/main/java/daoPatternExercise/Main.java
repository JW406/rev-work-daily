package daoPatternExercise;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import daoPatternExercise.dao.DepartmentDAO;
import daoPatternExercise.dao.DepartmentDAOImpl;
import daoPatternExercise.models.Department;

public class Main {
  public static void main(String[] args) {
    DepartmentDAO departmentDAO = new DepartmentDAOImpl();
    int choice = 0;
    do {
      System.out.println("Choose an Option");
      System.out.println("1. List a deprtment");
      System.out.println("2. Add a deprtment");
      System.out.println("3. Update a deprtment");
      System.out.println("4. Delete a deprtment");
      System.out.println("5. Insert using StoredProcedure");

      choice = Integer.parseInt(g.sc.nextLine());
      switch (choice) {
      case 1: {
        departmentDAO.listDepartments().stream().forEach(System.out::println);
        break;
      }
      case 2: {
        System.out.println("Enter New Department No.:");
        Department dept = new Department();
        dept.setDeptno(Integer.parseInt(g.sc.nextLine()));
        System.out.println("Enter New Department Name:");
        dept.setDname(g.sc.nextLine());
        System.out.println("Enter New Department Location:");
        dept.setLoc(g.sc.nextLine());
        if (departmentDAO.addDepartment(dept)) {
          System.out.println("Adding department has been successful");
        }
        break;
      }
      case 3: {
        System.out.println("Enter The Department No. to update:");
        Department dept = departmentDAO.getDepartmentByNo(Integer.parseInt(g.sc.nextLine()));
        System.out.println("Enter New Department Name:");
        String str;
        if (!(str = g.sc.nextLine()).equals("")) {
          dept.setDname(str);
        }
        System.out.println("Enter New Department Location:");
        if (!(str = g.sc.nextLine()).equals("")) {
          dept.setLoc(str);
        }
        if (departmentDAO.updateDepartment(dept)) {
          System.out.println("Update has been successful");
        }
        break;
      }
      case 4: {
        System.out.println("Enter the Department No. to delete:");
        int deptNo = Integer.parseInt(g.sc.nextLine());
        if (departmentDAO.deleteDepartment(deptNo)) {
          System.out.println("Delete has been successful");
        }
        break;
      }
      case 5: {
        insertUsingProcedure();
        System.out.println("Row inserted using procedure");
        break;
      }
      }
    } while (choice != 6);
  }

  private static void insertUsingProcedure() {
    try (Connection conn = ConnectionUtil.getConnection();
        // CallableStatement stmt = conn.prepareCall("{call INSERTROWS_JDBC(?,?,?)}")) {
        CallableStatement stmt = conn.prepareCall("{call INSERT_AN_DEPT_JDBC(?,?,?)}")) {
      stmt.setInt(1, 77);
      stmt.setString(2, "dept77");
      stmt.setString(3, "loc77");
      stmt.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
