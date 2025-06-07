package Login.Controller;

import Assets.DBConnection;
import Login.Model.Login_Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {
private Connection connection;
public LoginDAO() throws SQLException{
     connection = DBConnection.getConnection();
}

/// Create User
public int insertUser(Login_Model login) throws SQLException {
    try {
        String sql = "INSERT INTO login (id_role, username, passwords, full_name)  "
            + "VALUES (2, ?, ?, ?)";
    PreparedStatement stmt = connection.prepareStatement(sql);
    stmt.setString(1, login.getUsername());
    stmt.setString(2, login.getPass());
    stmt.setString(3, login.getFullname());
    stmt.executeUpdate();
    return 1;
    }
    catch (SQLException e) {
    return 0;
}
}

// select/read login
public List<Login_Model> getLogin (String username) {
List<Login_Model> login = new ArrayList<>();
try {
    String sql = "SELECT * FROM login LEFT JOIN role ON login.id_role = role.id_role "
            + "WHERE username = ?";
    PreparedStatement stmt =connection.prepareStatement(sql);
    stmt.setString(1, username);
    
    ResultSet rs = stmt.executeQuery();
    
    if(rs.next()) {
    int id = rs.getInt("id_user");
    String role = rs.getString("role");
    String user = rs.getString("username");
    String pass = rs.getString("passwords");
    String fullname = rs.getString("full_name");
    login.add(new Login_Model(id, role, user, pass, fullname));
    }

}

catch (SQLException e) {
    e.printStackTrace();
}
return login;
}
    
}