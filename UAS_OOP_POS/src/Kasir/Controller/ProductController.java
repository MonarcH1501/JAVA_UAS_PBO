package Kasir.Controller;

import Assets.DBConnection;
import Kasir.Model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductController {

    public List<Product> getAllProducts() throws SQLException {
        List<Product> list = new ArrayList<>();
        Connection c = DBConnection.getConnection();
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM product");

        while (rs.next()) {
            list.add(new Product(
                rs.getString("id_product"),
                rs.getString("id_supplier"),
                rs.getString("product_code"),
                rs.getString("product_name"),
                rs.getDouble("price_sell")
            ));
        }

        rs.close();
        stmt.close();
        return list;
    }

    public List<Product> searchProducts(String keyword) throws SQLException {
        List<Product> list = new ArrayList<>();
        Connection c = DBConnection.getConnection();
        String query = "SELECT * FROM product WHERE product_code LIKE ? OR product_name LIKE ?";
        PreparedStatement ps = c.prepareStatement(query);
        String search = "%" + keyword + "%";
        ps.setString(1, search);
        ps.setString(2, search);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            list.add(new Product(
                rs.getString("id_product"),
                rs.getString("id_supplier"),
                rs.getString("product_code"),
                rs.getString("product_name"),
                rs.getDouble("price_sell")
            ));
        }

        rs.close();
        ps.close();
        return list;
    }
}
