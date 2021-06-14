package daoPatternExercise.dao;

import java.util.List;

import daoPatternExercise.models.Department;

public interface DepartmentDAO {
  List<Department> listDepartments();
  Department getDepartmentByNo(Integer deptNo);
  Boolean addDepartment(Department dept);
  Boolean updateDepartment(Department dept);
  Boolean deleteDepartment(Integer deptNo);
}
