package Assets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
   public static Connection getConnection() throws SQLException{
       String url = "jdbc:mysql://localhost:3306/uas_oop2";
       String user = "root";
       String password = "";
       
       return DriverManager.getConnection(url, user, password);
   } 
}
