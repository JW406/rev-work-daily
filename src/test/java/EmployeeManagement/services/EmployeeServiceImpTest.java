package EmployeeManagement.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import EmployeeManagement.exceptions.EmployeeNotFound;
import EmployeeManagement.models.Address;
import EmployeeManagement.models.Employee;

public class EmployeeServiceImpTest {
  private static EmployeeService svc = null;
  private static Employee emp = null;
  private static Integer testRecordId = 9999;

  @BeforeAll
  public static void init() {
    emp = new Employee(testRecordId, "Lisa", 15000.0, new Address("Los Angeles", "California"));
    svc = new EmployeeServiceImpl();
    svc.addEmployee(emp, true);
  }

  @AfterAll
  public static void tear() {
    svc.deleteEmployee(testRecordId);
  }

  @Test
  void testCalculateYearlySalary() {
    assertEquals(emp.getSalary() * 12, svc.calculateYearlySalary(emp));
  }

  @Test
  void testFindByEmployeeNo() {
    assertDoesNotThrow(() -> {
      assertEquals(emp.getEmpNo(), svc.findByEmployeeNo(testRecordId).getEmpNo());
    });
    assertThrows(EmployeeNotFound.class, () -> {
      svc.findByEmployeeNo(99999);
    });
  }

  @Test
  void testUpdateEmployee() {
    svc.updateEmployee(new Employee(testRecordId, "Bart", 16666.60, new Address("Boston", "Massachusett")));
    assertDoesNotThrow(() -> {
      assertEquals("Bart", svc.findByEmployeeNo(testRecordId).getEmpName());
      assertEquals("Boston", svc.findByEmployeeNo(testRecordId).getAddress().getCity());
    });
  }

  @Test
  void testAddRemoveEmployee() {
    int testRecordId = 100000;
    Employee tmp = new Employee(testRecordId, "Lucy", 14999.0, new Address("Los Angeles", "California"));
    svc.addEmployee(tmp, true);
    assertDoesNotThrow(() -> {
      assertNotNull(svc.findByEmployeeNo(testRecordId));
    });

    svc.deleteEmployee(tmp.getEmpNo());
    assertThrows(EmployeeNotFound.class, () -> {
      assertNull(svc.findByEmployeeNo(testRecordId));
    });
  }
}
