package day04.try_junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestAssertion {
  EmployeeService empservice = new EmployeeService();
  Employee employee = new Employee();

  //test to check appraisal
  @Test
  public void testCalculateAppriasal() {
    employee.setName("Rajeev");
    employee.setAge(25);
    employee.setMonthlySalary(8000);

    double appraisal = empservice.calculateAppraisal(employee);
    assertEquals(500, appraisal, 0.0);

  }

  // test to check yearly salary
  @Disabled
  @Test
  public void testCalculateYearlySalary() {
    employee.setName("Rajeev");
    employee.setAge(25);
    employee.setMonthlySalary(8000);

    double salary = empservice.calculateYearlySalary(employee);
    // assertEquals(96000, salary, 0.0);
    assertNotEquals(96000, salary);
  }

  @Test
  void testExpectedExceptionFail() {
    //Code does not throw any exception
    //This assetion will fail
    assertThrows(IllegalArgumentException.class, () -> {
      Integer.parseInt("asd");
      //Integer.parseInt("1");
    });

  }
}
