package day04.EmployeeManagement.menuOptions;

import java.util.logging.Logger;

import day04.EmployeeManagement.exceptions.EmployeeNotFound;
import day04.EmployeeManagement.services.EmployeeService;

public interface Displayer {
  Logger logger = Logger.getLogger(Displayer.class.getName());

  void display(EmployeeService svc) throws EmployeeNotFound;
}
