package EmployeeManagement;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import EmployeeManagement.exceptions.EmployeeNotFound;
import EmployeeManagement.menuOptions.Displayer;
import EmployeeManagement.services.EmployeeService;
import EmployeeManagement.services.EmployeeServiceImpl;
import EmployeeManagement.utils.g;

public class Main {
  private static final Logger logger = Logger.getLogger(Main.class.getName());

  public static void main(String[] args) {
    EmployeeService svc = new EmployeeServiceImpl();
    Map<Integer, Object[]> UIMap = new TreeMap<Integer, Object[]>() {
      {
        put(0, new Object[] { "0. Add an employee", Displayer.get("AddEmp") });
        put(1, new Object[] { "1. List all employee", Displayer.get("ListEmps") });
        put(2, new Object[] { "2. Display Yearly Salary", Displayer.get("DisplayYearlySal") });
        put(3, new Object[] { "3. Display Specific Employee Detail", Displayer.get("DisplayAnEmployee") });
        put(4, new Object[] { "4. Modify Employee Detail", Displayer.get("ModifyAnEmployee") });
        put(5, new Object[] { "5. Delete an Employee", Displayer.get("DeleteAnEmployee") });
      }
    };

    while (true) {
      System.out.println();
      for (Entry<Integer, Object[]> e : UIMap.entrySet()) {
        System.out.println(e.getValue()[0]);
      }
      System.out.println("6. Quit");
      System.out.println();
      try {
        int sel = g.getNextInt();
        if (sel < UIMap.size()) {
          ((Displayer) UIMap.get(sel)[1]).display(svc);
        } else if (sel == UIMap.size()) {
          break;
        }
      } catch (EmployeeNotFound e) {
        logger.log(Level.INFO, "Unable to find the employee");
      }
    }
    g.Exit();
  }
}
