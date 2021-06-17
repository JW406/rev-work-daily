package day04.EmployeeManagement.models;

public class Employee extends Person {
  private Double salary;
  private Address address;

  public Employee() {
  }

  public Employee(Integer empNo, String empName, Double salary, Address address) {
    super(empNo, empName);
    this.salary = salary;
    this.address = address;
  }

  public Employee(Employee em) {
    super(em.getEmpNo(), em.getEmpName());
    this.salary = em.salary;
    this.address = em.address;
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
    return "Employee [address=" + address + ", empName=" + getEmpName() + ", empNo=" + getEmpNo() + ", salary=" + salary
        + "]";
  }

}
