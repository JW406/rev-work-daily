package day04.EmployeeManagement.exceptions;

public class InvalidDisplayerName extends Exception {
  public InvalidDisplayerName() {
  }

  public InvalidDisplayerName(String msg) {
    super(msg);
  }
}
