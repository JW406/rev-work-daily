package day04.EmployeeManagement.exceptions;

public class EmployeeNotFound extends Exception {
  public EmployeeNotFound() {
  }

  public EmployeeNotFound(String msg) {
    super(msg);
  }
}
