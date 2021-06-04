package day04.EmployeeManagement.models;

public class Employee {
  private int empNo;
  private String empName;
  private double salary;
  private Address address;

  public Employee(int empNo, String empName, double salary, Address address) {
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

  public int getEmpNo() {
    return empNo;
  }

  public void setEmpNo(int empNo) {
    this.empNo = empNo;
  }

  public String getEmpName() {
    return empName;
  }

  public void setEmpName(String empName) {
    this.empName = empName;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
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
