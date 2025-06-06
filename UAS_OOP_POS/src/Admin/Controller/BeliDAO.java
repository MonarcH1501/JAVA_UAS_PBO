
package Admin.Controller;
import Admin.Model.Beli;
import Admin.Model.comboBox;
import Assets.DBConnection;
import Admin.View.Pembelian;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;





public class BeliDAO {
private Connection connection;
public BeliDAO () throws SQLException{
     connection = DBConnection.getConnection();
}


// create pembelian
public int insertPembelian (Beli beli) throws SQLException{
    int idProduct = 0;
    int idSupplier = 0;
    try {
    String sqlProduct = "SELECT id_product FROM product WHERE product_name=?";
    PreparedStatement stmtProduct = connection.prepareStatement(sqlProduct);
    stmtProduct.setString(1, beli.getProduct());
    ResultSet rsProduct = stmtProduct.executeQuery();
    if (rsProduct.next()){
        idProduct = rsProduct.getInt("id_product");
    } else {
        System.out.println("Product not found: " + idProduct);
    }
    
    String sqlSupplier = "SELECT id_supplier FROM supplier WHERE supp_name=?";
    PreparedStatement stmtSupplier = connection.prepareStatement(sqlSupplier);
    stmtSupplier.setString(1, beli.getSupplier());
    ResultSet rsSupplier = stmtSupplier.executeQuery();
    if (rsSupplier.next()){
        idSupplier = rsSupplier.getInt("id_supplier");
    } else {
        System.out.println("Supplier not found: " + idSupplier);
    }
    
    String sql = "INSERT INTO pembelian (id_product, id_supplier, purchase_date, purchase_qty, total_price) "
            + "VALUES (?, ?, ?, ?, ?)";
    PreparedStatement stmt = connection.prepareStatement(sql);
    stmt.setInt(1, idProduct);
    stmt.setInt(2, idSupplier);
    stmt.setDate(3, new java.sql.Date(beli.getDate().getTime()));
    stmt.setInt(4, beli.getQty());
    stmt.setFloat(5, beli.getTotalPrice());
    stmt.executeUpdate();   
    return 1;
    } catch (SQLException e) {
    return 0;
}
}

// select/read Pembelian
public List<Beli> getBeli() {
List<Beli> membeli = new ArrayList<>();

try {

    String sql = "SELECT id_purchase, product.product_name, supplier.supp_name, purchase_date, "
            + "purchase_qty, product.product_unit, total_price "
            + "FROM pembelian "
            + "left join product on pembelian.id_product = product.id_product "
            + "left join supplier on pembelian.id_supplier = supplier.id_supplier;";
    PreparedStatement stmt =connection.prepareStatement(sql);
    
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
          int idBeli = rs.getInt("id_purchase");
          String nameProduct = rs.getString("product_name");
          String nameSupplier = rs.getString("supp_name");
          Date tglBeli = rs.getDate("purchase_date");
          int qtyBeli = rs.getInt("purchase_qty");
          String unitProduct = rs.getString("product_unit");
          float totalHarga = rs.getFloat("total_price");
        membeli.add(new Beli(idBeli, nameProduct, nameSupplier, tglBeli, qtyBeli, unitProduct, totalHarga));
    }
    
} catch (SQLException e) {
    e.printStackTrace();
}

return membeli;
}

// Select/read Combo Box
public List<comboBox> getComboBox(String name) {
    List<comboBox> namaBox = new ArrayList<>();
    String a, b, c;
    switch (name) {
        case "Supplier":
        a = "supplier.supp_name";
        b = "supplier";
        c = "supplier.id_supplier = supplier.id_supplier";
        break;
        case "Product":
        a = "product.product_name";
        b = "product";
        c = "product.id_product = product.id_product";
        break;
        default:
        a = "supplier.supp_name";
        b = "supplier";
        c = "supplier.id_supplier = supplier.id_supplier";   
    }
     try {
     String sql = "SELECT DISTINCT " + a + " FROM pembelian left join " + b + " on " + c;
     PreparedStatement stmt =connection.prepareStatement(sql); 
     ResultSet rs = stmt.executeQuery();
     while (rs.next()) {
         String nam = rs.getString(a);
         namaBox.add(new comboBox(nam));
     }
     
     
     } catch (SQLException e) {
    e.printStackTrace();
} return namaBox;
}

// select satuan product
public String getSatuanProduct (String namaProduct) {
   String satuanProduct = null;
    try {
        String sql = "SELECT product_unit FROM product WHERE product_name=?";
        PreparedStatement stmt =connection.prepareStatement(sql); 
        stmt.setString(1, namaProduct);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()){
         satuanProduct = rs.getString("product_unit");
        } else {
         System.out.println("Product not found: " + namaProduct);
        }
    } catch (SQLException e) {
    e.printStackTrace();
} 
    return satuanProduct; }

// Update Pembelian
public int updatePembelian (Beli beli) throws SQLException{
    int idProduct = 0;
    int idSupplier = 0;
    try {
    String sqlProduct = "SELECT id_product FROM product WHERE product_name=?";
    PreparedStatement stmtProduct = connection.prepareStatement(sqlProduct);
    stmtProduct.setString(1, beli.getProduct());
    ResultSet rsProduct = stmtProduct.executeQuery();
    if (rsProduct.next()){
        idProduct = rsProduct.getInt("id_product");
    } else {
        System.out.println("Product not found: " + idProduct);
    }
    
    String sqlSupplier = "SELECT id_supplier FROM supplier WHERE supp_name=?";
    PreparedStatement stmtSupplier = connection.prepareStatement(sqlSupplier);
    stmtSupplier.setString(1, beli.getSupplier());
    ResultSet rsSupplier = stmtSupplier.executeQuery();
    if (rsSupplier.next()){
        idSupplier = rsSupplier.getInt("id_supplier");
    } else {
        System.out.println("Supplier not found: " + idSupplier);
    }  
    
    String sql = "UPDATE pembelian SET id_supplier=?, id_product=?, purchase_date=?, purchase_qty=?, total_price=? WHERE id_purchase=?";
    PreparedStatement stmt = connection.prepareStatement(sql);
    stmt.setInt(1, idSupplier);
    stmt.setInt(2, idProduct);
    stmt.setDate(3, new java.sql.Date(beli.getDate().getTime()));
    stmt.setInt(4, beli.getQty());
    stmt.setFloat(5, beli.getTotalPrice());
    stmt.setInt(6, beli.getId());
    stmt.executeUpdate();  
    return 1;
    } catch (SQLException e) {
    return 0;
} 
}



// Delete Pembelian
public void deletePembelian(int id) {
    try {
        String sql = "DELETE FROM pembelian WHERE id_purchase=?";
        PreparedStatement stmt =connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }catch(SQLException e){
        e.printStackTrace(); 
    }
}

public List<Beli> searchPembelian(String text, String column) {
    List<Beli> Pembelian = new ArrayList<>();
    String idCari = ""; 

    try {
    switch (column) { 
    case "Nama Product":
    String sqlProduct = "SELECT id_product FROM product WHERE product_name LIKE ?";
    PreparedStatement stmtProduct = connection.prepareStatement(sqlProduct);
    stmtProduct.setString(1,"%" + text + "%");
    ResultSet rsProduct = stmtProduct.executeQuery();
    if (rsProduct.next()) {
        idCari = String.valueOf(rsProduct.getInt("id_product")); 
    } else {
        System.out.println("Product not found: " + text);
    }
    break;

    case "Nama Supplier":
    String sqlSupplier = "SELECT id_supplier FROM supplier WHERE supp_name LIKE ?";
    PreparedStatement stmtSupplier = connection.prepareStatement(sqlSupplier);
    stmtSupplier.setString(1,"%" + text + "%");
    ResultSet rsSupplier = stmtSupplier.executeQuery();
    if (rsSupplier.next()) {
        idCari = String.valueOf(rsSupplier.getInt("id_supplier"));
    } else {
        System.out.println("Supplier not found: " + text);
    }
    break;

    case "Satuan":
    String sqlSatuan = "SELECT id_product FROM product WHERE product_unit =?";
    PreparedStatement stmtSatuan = connection.prepareStatement(sqlSatuan);
    stmtSatuan.setString(1,"%" + text + "%");
    ResultSet rsSatuan = stmtSatuan.executeQuery();
    if (rsSatuan.next()) {
        idCari = String.valueOf(rsSatuan.getInt("id_product")); 
    } else {
        System.out.println("Satuan Product not found: " + text);
    }
    break;

    default:
    idCari = text; 
        }
    String sql = "SELECT id_purchase, product.product_name, supplier.supp_name, purchase_date, "
            + "purchase_qty, product.product_unit, total_price "
            + "FROM pembelian "
            + "left join product on pembelian.id_product = product.id_product "
            + "left join supplier on pembelian.id_supplier = supplier.id_supplier "
            + "WHERE " + column + " LIKE ?";
    PreparedStatement stmt =connection.prepareStatement(sql);
    stmt.setString(1,"%" + idCari + "%");
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
          int idBeli = rs.getInt("id_purchase");
          String nameProduct = rs.getString("product_name");
          String nameSupplier = rs.getString("supp_name");
          Date tglBeli = rs.getDate("purchase_date");
          int qtyBeli = rs.getInt("purchase_qty");
          String unitProduct = rs.getString("product_unit");
          float totalHarga = rs.getFloat("total_price");    
          
          Pembelian.add(new Beli(idBeli, nameProduct, nameSupplier, tglBeli, qtyBeli, unitProduct, totalHarga));        
    }

}catch (SQLException e) {
        e.printStackTrace();
    }
    return Pembelian;
} } 



