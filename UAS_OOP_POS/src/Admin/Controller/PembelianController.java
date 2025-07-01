package Admin.Controller;
import Admin.Model.Beli;
import Admin.Model.comboBox;
import Assets.DBConnection;
import Admin.View.Pembelian;
import java.math.BigDecimal;
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

public class PembelianController {

    public List<Beli> loadAllPembelian() throws SQLException {
        List<Beli> list = new ArrayList<>();

        String query = "SELECT id_purchase, product.product_name, supplier.supp_name, purchase_date, " +
                       "purchase_qty, product.product_unit, total_price " +
                       "FROM pembelian " +
                       "LEFT JOIN product ON pembelian.id_product = product.id_product " +
                       "LEFT JOIN supplier ON pembelian.id_supplier = supplier.id_supplier";
        Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Beli beli = new Beli(
                rs.getInt("id_purchase"),
                rs.getString("product_name"),
                rs.getString("supp_name"),
                rs.getDate("purchase_date"),
                rs.getInt("purchase_qty"),
                rs.getString("product_unit"),
                rs.getBigDecimal("total_price")
            );
            list.add(beli);
        }

        return list;
    }

    public List<Beli> getFilteredPembelian(String filter, int month, int year) throws SQLException {
    List<Beli> list = new ArrayList<>();
    String sql = "";

    if ("Bulan".equals(filter)) {
        sql = "SELECT p.id_purchase, pr.product_name, s.supp_name, p.purchase_date, " +
              "p.purchase_qty, pr.product_unit, p.total_price " +
              "FROM pembelian p " +
              "LEFT JOIN product pr ON p.id_product = pr.id_product " +
              "LEFT JOIN supplier s ON p.id_supplier = s.id_supplier " +
              "WHERE MONTH(p.purchase_date) = ? AND YEAR(p.purchase_date) = ?";
    } else if ("Tahun".equals(filter)) {
        sql = "SELECT p.id_purchase, pr.product_name, s.supp_name, p.purchase_date, " +
              "p.purchase_qty, pr.product_unit, p.total_price " +
              "FROM pembelian p " +
              "LEFT JOIN product pr ON p.id_product = pr.id_product " +
              "LEFT JOIN supplier s ON p.id_supplier = s.id_supplier " +
              "WHERE YEAR(p.purchase_date) = ?";
    }

    Connection conn = DBConnection.getConnection();
    PreparedStatement stmt = conn.prepareStatement(sql);

    if ("Bulan".equals(filter)) {
        stmt.setInt(1, month);
        stmt.setInt(2, year);
    } else if ("Tahun".equals(filter)) {
        stmt.setInt(1, year);
    }

    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
        Beli beli = new Beli(
            rs.getInt("id_purchase"),
            rs.getString("product_name"),
            rs.getString("supp_name"),
            rs.getDate("purchase_date"),
            rs.getInt("purchase_qty"),
            rs.getString("product_unit"),
            rs.getBigDecimal("total_price")
        );
        list.add(beli);
    }

    return list;
}


    public List<Beli> getPembelianByDay(java.util.Date day) throws SQLException {
    List<Beli> list = new ArrayList<>();
    java.sql.Date sqlDate = new java.sql.Date(day.getTime());

    String sql = """
        SELECT p.id_purchase, pr.product_name, s.supp_name, p.purchase_date,
               p.purchase_qty, pr.product_unit, p.total_price
        FROM pembelian p
        JOIN product pr ON p.id_product = pr.id_product
        JOIN supplier s ON p.id_supplier = s.id_supplier
        WHERE p.purchase_date = ?
    """;

    Connection conn = DBConnection.getConnection();
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setDate(1, sqlDate);

    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
        list.add(new Beli(
            rs.getInt("id_purchase"),
            rs.getString("product_name"),
            rs.getString("supp_name"),
            rs.getDate("purchase_date"),
            rs.getInt("purchase_qty"),
            rs.getString("product_unit"),
            rs.getBigDecimal("total_price")
        ));
    }

    return list;
}
}
