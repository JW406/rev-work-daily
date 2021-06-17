package day04.EmployeeManagement.menuOptions;

import java.util.logging.Level;
import java.util.logging.Logger;

import day04.EmployeeManagement.exceptions.EmployeeNotFound;
import day04.EmployeeManagement.services.EmployeeService;
import day04.EmployeeManagement.utils.g;

public interface Displayer {
  Logger logger = Logger.getLogger(Displayer.class.getName());
  final public static String prefix = "day04.EmployeeManagement.menuOptions.displayers.";

  public static Displayer get(String str) {
    try {
      return (Displayer) Class.forName(prefix + str).getMethod("getInstance", (Class[]) null).invoke(null,
          (Object[]) null);
    } catch (Exception e) {
      logger.log(Level.INFO, "System failure");
      g.Exit();
      return null;
    }
  }

  void display(EmployeeService svc) throws EmployeeNotFound;
}
