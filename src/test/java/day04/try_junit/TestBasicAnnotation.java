package day04.try_junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBasicAnnotation {

  Employee employee = new Employee();

  @BeforeAll
  // specifies that method will be invoked only once, before starting all the tests.
  public static void setup() {
    System.out.println(" It will execute before all test cases");
  }

  @BeforeEach
  public void setupThis() {
    System.out.println(" It will execute before each test.");
  }

  @Test
  public void method() {
    System.out.println(" This my test case");
  }

  @AfterEach
  public void tearThis() {
    System.out.println("It will execute after each test.");
  }

  @AfterAll
  public static void tear() {
    System.out.println(" It will execute before all test cases");
  }
}
