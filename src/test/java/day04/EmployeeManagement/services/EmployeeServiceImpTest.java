package day04.EmployeeManagement.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import day04.EmployeeManagement.models.Address;
import day04.EmployeeManagement.models.Employee;

public class EmployeeServiceImpTest {
  private static EmployeeService svc = null;
  private static Employee emp = null;

  @BeforeAll
  public static void init() {
    emp = new Employee(999, "Lisa", 15000.0, new Address("Los Angeles", "California"));
    svc = new EmployeeServiceImpl();
    svc.addEmployee(emp);
  }

  @AfterAll
  public static void tear() {
    svc.deleteEmployee(svc.findByEmployeeNo(999));
  }

  @Test
  void testCalculateYearlySalary() {
    assertEquals(emp.getSalary() * 12, svc.calculateYearlySalary(emp));
  }

  @Test
  void testFindByEmployeeNo() {
    assertEquals(emp, svc.findByEmployeeNo(999));
    assertEquals(null, svc.findByEmployeeNo(9999));
  }

  @Test void testUpdateEmployee() {
    svc.updateEmployee(new Employee(999, "Bart", 16666.60, null));
    assertNotNull(svc.findByEmployeeNo(999));
    assertEquals("Bart", svc.findByEmployeeNo(999).getEmpName());
  }

  @Test void testAddRemoveEmployee() {
    Employee tmp = new Employee(10000, "Lucy", 14999.0, new Address("Los Angeles", "California"));
    svc.addEmployee(tmp);
    assertNotNull(svc.findByEmployeeNo(10000));
    svc.deleteEmployee(tmp);
    assertNull(svc.findByEmployeeNo(10000));
  }
}
