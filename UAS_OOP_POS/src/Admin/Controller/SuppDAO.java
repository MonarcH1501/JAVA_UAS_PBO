
package Admin.Controller;
import Admin.Model.Supp;
import Assets.DBConnection;
import Admin.View.Supplier;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class SuppDAO {
private Connection connection;
public SuppDAO () throws SQLException{
     connection = DBConnection.getConnection();
}

// create supplier
public int insertSupplier(Supp supp) {
try {
String sql = "INSERT INTO supplier (supp_code, supp_name, contact, address) VALUES(?,?,?,?)";
PreparedStatement stmt = connection.prepareStatement(sql);
stmt.setString(1, supp.getCodeSupplier());
stmt.setString(2, supp.getNameSupplier());
stmt.setString(3, supp.getContactSupplier());
stmt.setString(4, supp.getAddressSupplier());
stmt.executeUpdate();
    return 1;
} catch(SQLException e) {
    return 0;
} 
}

// select/read Supplier
public List<Supp> getSuppliers() {
List<Supp> suppliers = new ArrayList<>();

try {
    String sql = "SELECT * FROM supplier";
    PreparedStatement stmt =connection.prepareStatement(sql);
    
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
        int idSupp = rs.getInt("id_supplier");
        String codeSupp = rs.getString("supp_code");
        String nameSupp = rs.getString("supp_name");
        String contact = rs.getString("contact");
        String address = rs.getString("address");
        
        suppliers.add(new Supp(idSupp, codeSupp, nameSupp, contact, address));
    }
    
} catch (SQLException e) {
    e.printStackTrace();
}

return suppliers;
}

// update supplier
public int updateSupplier(Supp supp) {
try {
String sql = "UPDATE supplier SET supp_code=?, supp_name=?, contact=?, address=? WHERE id_supplier=?";
PreparedStatement stmt = connection.prepareStatement(sql);
stmt.setString(1, supp.getCodeSupplier());
stmt.setString(2, supp.getNameSupplier());
stmt.setString(3, supp.getContactSupplier());
stmt.setString(4, supp.getAddressSupplier());
stmt.setInt(5, supp.getId());
stmt.executeUpdate();
    return 1;
} catch(SQLException e) {
    return 0;
} 
}

// Delete Supplier
public void deleteSupplier(int id) {
    try {
        String sql = "DELETE FROM supplier WHERE id_supplier=?";
        PreparedStatement stmt =connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }catch(SQLException e){
        e.printStackTrace(); 
    }
}

// Search Supplier
public List<Supp> searchSuppliers(String text, String column) {
List<Supp> suppliers = new ArrayList<>();

try {
    String sql = "SELECT * FROM supplier WHERE " + column + " LIKE ?";
    PreparedStatement stmt =connection.prepareStatement(sql);
    stmt.setString(1,"%" + text + "%");
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
        int idSupp = rs.getInt("id_supplier");
        String codeSupp = rs.getString("supp_code");
        String nameSupp = rs.getString("supp_name");
        String contact = rs.getString("contact");
        String address = rs.getString("address");
        
        suppliers.add(new Supp(idSupp, codeSupp, nameSupp, contact, address));
    }
    
} catch (SQLException e) {
    e.printStackTrace();
}

return suppliers;
}
}


