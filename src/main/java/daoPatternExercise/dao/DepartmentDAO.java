package daoPatternExercise.dao;

import java.util.List;

import daoPatternExercise.models.Department;

public interface DepartmentDAO {
  List<Department> getAllDepartments();
  Department getDepartmentByNo(Integer deptNo);
  Boolean addDepartment(Department dept);
  Boolean updateDepartment(Department dept);
  Boolean deleteDepartment(Integer deptNo);
  Boolean addImageForDepartment(Integer deptNo, String fileName);
  Boolean retrieveImageForDepartment(Integer deptNo, String fileName);
}
