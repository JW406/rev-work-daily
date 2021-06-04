package day04.try_junit;

public class Employee {
  private String name;
  private double monthlySalary;
  private int age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
  * @return the monthlySalary
  */

  public double getMonthlySalary() {
    return monthlySalary;
  }

  /**
  * @param monthlySalary the monthlySalary to set
  */

  public void setMonthlySalary(double monthlySalary) {
    this.monthlySalary = monthlySalary;
  }

  /**
  * @return the age
  */
  public int getAge() {
    return age;
  }

  /**
  * @param age the age to set
  */
  public void setAge(int age) {
    this.age = age;
  }

}
