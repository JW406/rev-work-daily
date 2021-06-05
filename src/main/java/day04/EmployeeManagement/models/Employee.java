package day04.EmployeeManagement.models;

public class Employee {
  private Integer empNo;
  private String empName;
  private Double salary;
  private Address address;

  public Employee(Integer empNo, String empName, Double salary, Address address) {
    this.empNo = empNo;
    this.empName = empName;
    this.salary = salary;
    this.address = address;
  }

  public Employee(Employee em) {
    this.empNo = em.empNo;
    this.empName = em.empName;
    this.salary = em.salary;
    this.address = em.address;
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

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "Employee [address=" + address + ", empName=" + empName + ", empNo=" + empNo + ", salary=" + salary + "]";
  }
}
