package EmployeeManagement.models;

public class Person {
  private Integer empNo;
  private String empName;

  public Person() {
  }

  public Person(Integer empNo, String empName) {
    this.empNo = empNo;
    this.empName = empName;
  }

  public Integer getEmpNo() {
    return empNo;
  }

  public void setEmpNo(Integer empNo) {
    this.empNo = empNo;
  }

  public String getEmpName() {
    return empName;
  }

  public void setEmpName(String empName) {
    this.empName = empName;
  }

}
