package Kasir.Controller;

import Assets.DBConnection;
import Kasir.Model.SaleDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryController {

    public List<SaleDetail> loadAllSales() throws SQLException {
        List<SaleDetail> list = new ArrayList<>();
        String sql = "SELECT sd.id_product, p.product_name, sd.sale_qty, sd.sale_price " +
                     "FROM sale_details sd " +
                     "LEFT JOIN product p ON sd.id_product = p.id_product";

        try (Connection c = DBConnection.getConnection();
             Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new SaleDetail(
                        rs.getInt("id_product"),
                        rs.getString("product_name"),
                        rs.getDouble("sale_qty"),
                        rs.getDouble("sale_price")
                ));
            }
        }

        return list;
    }

    public List<SaleDetail> searchSales(String keyword) throws SQLException {
        List<SaleDetail> list = new ArrayList<>();
        String sql = "SELECT sd.id_product, p.product_name, sd.sale_qty, sd.sale_price " +
                     "FROM sale_details sd " +
                     "LEFT JOIN product p ON sd.id_product = p.id_product " +
                     "WHERE sd.id_sale LIKE ? OR p.product_name LIKE ?";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement pst = c.prepareStatement(sql)) {

            String search = "%" + keyword + "%";
            pst.setString(1, search);
            pst.setString(2, search);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list.add(new SaleDetail(
                            rs.getInt("id_product"),
                            rs.getString("product_name"),
                            rs.getDouble("sale_qty"),
                            rs.getDouble("sale_price")
                    ));
                }
            }
        }

        return list;
    }
}
