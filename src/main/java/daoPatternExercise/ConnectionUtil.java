package daoPatternExercise;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

  public static Connection getConnection() {
    Properties props = new Properties();
    Connection con = null;
    try {
      props.load(new FileInputStream("db.properties"));
      Class.forName(props.getProperty("DB_DRIVER_CLASS"));

      con = DriverManager.getConnection(props.getProperty("DB_URL"), props.getProperty("DB_USERNAME"),
          props.getProperty("DB_PASSWORD"));
    } catch (IOException | ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
    return con;
  }
}
