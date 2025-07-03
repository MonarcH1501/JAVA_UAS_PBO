package Kasir.Controller;

import Assets.DBConnection;
import Kasir.Model.Sale;
import Kasir.Model.SaleDetail;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoryController {

    public List<Sale> loadAllSales(String username) throws SQLException {
     List<Sale> list = new ArrayList<>();
     String sql = "SELECT id_sale, sale_date, discount, tax, sale_total_price, total_bayar, kembalian, total_price_produk, user FROM penjualan";

     if (username != null && !"Semua".equals(username)) {
         sql += " WHERE user = ?";
     }

     try (Connection c = DBConnection.getConnection();
          PreparedStatement pst = c.prepareStatement(sql)) {

         if (username != null && !"Semua".equals(username)) {
             pst.setString(1, username);
         }

         try (ResultSet rs = pst.executeQuery()) {
             while (rs.next()) {
                 String id = rs.getString("id_sale");
                 Date date = rs.getDate("sale_date");
                 double discount = rs.getDouble("discount");
                 double tax = rs.getDouble("tax");
                 double totalPrice = rs.getDouble("sale_total_price");
                 double totalBayar = rs.getDouble("total_bayar");
                 double kembalian = rs.getDouble("kembalian");
                 double totalAwal = rs.getDouble("total_price_produk");
                 String User = rs.getString("user");

                 Sale sale = new Sale(id, date, totalPrice, discount, tax, totalBayar, kembalian, totalAwal, null, User);
                 list.add(sale);
             }
         }
     }

    return list;
}



    public List<Sale> searchSales(String keyword) throws SQLException {
        List<Sale> list = new ArrayList<>();
        String sql = "SELECT id_sale, sale_date, sale_total_price, total_bayar FROM penjualan WHERE id_sale LIKE ?";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement pst = c.prepareStatement(sql)) {

            pst.setString(1, "%" + keyword + "%");

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    String id = rs.getString("id_sale");
                    Date date = rs.getDate("sale_date");
                    double totalPrice = rs.getDouble("sale_total_price");
                    double totalBayar = rs.getDouble("total_bayar");

                    Sale sale = new Sale(id, date, totalPrice, 0, 0, totalBayar, 0, 0, null, null);
                    list.add(sale);
                }
            }
        }

        return list;
    }

    public List<SaleDetail> getSaleDetailByTransactionId(int idSale) throws SQLException {
        List<SaleDetail> list = new ArrayList<>();
        String sql = """
            SELECT sd.id_sale, sd.id_product, p.product_name, sd.sale_qty, sd.sale_price
              FROM sale_details sd
              JOIN product p ON sd.id_product = p.id_product
             WHERE sd.id_sale = ?
        """;

        try (Connection c = DBConnection.getConnection();
             PreparedStatement pst = c.prepareStatement(sql)) {

            pst.setInt(1, idSale);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list.add(new SaleDetail(
                        rs.getInt("id_sale"),
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

    public Sale getSaleById(int idSale) throws SQLException {
        Sale sale = null;
        String sql = """
            SELECT id_sale, sale_date, sale_total_price, discount, tax, total_bayar, kembalian, total_price_produk
              FROM penjualan
             WHERE id_sale = ?
        """;

        try (Connection c = DBConnection.getConnection();
             PreparedStatement pst = c.prepareStatement(sql)) {

            pst.setInt(1, idSale);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    String id = rs.getString("id_sale");
                    Date date = rs.getDate("sale_date");
                    double totalPrice = rs.getDouble("sale_total_price");
                    double discount = rs.getDouble("discount");
                    double tax = rs.getDouble("tax");
                    double totalBayar = rs.getDouble("total_bayar");
                    double kembalian = rs.getDouble("kembalian");
                    double totalAwal = rs.getDouble("total_price_produk");

                    List<SaleDetail> detailList = getSaleDetailByTransactionId(idSale);

                    sale = new Sale(id, date, totalPrice, discount, tax, totalBayar, kembalian, totalAwal, detailList, null);
                }
            }
        }

        return sale;
    }

    public List<Sale> getFilteredSales(String filter, int month, int year, String username) throws SQLException {
    List<Sale> list = new ArrayList<>();

    String baseSql = switch (filter) {
        case "Bulan" -> """
            SELECT id_sale, sale_date, sale_total_price, total_bayar, user 
              FROM penjualan 
             WHERE MONTH(sale_date) = ? AND YEAR(sale_date) = ?
        """;
        case "Tahun" -> """
            SELECT id_sale, sale_date, sale_total_price, total_bayar, user 
              FROM penjualan 
             WHERE YEAR(sale_date) = ?
        """;
        default -> throw new IllegalArgumentException("Filter tidak valid: " + filter);
    };

    // Tambahkan filter user jika bukan "Semua"
    if (username != null && !"Semua".equals(username)) {
        baseSql += " AND user = ?";
    }

    try (Connection c = DBConnection.getConnection();
         PreparedStatement pst = c.prepareStatement(baseSql)) {

        if ("Bulan".equals(filter)) {
            pst.setInt(1, month);
            pst.setInt(2, year);
            if (username != null && !"Semua".equals(username)) {
                pst.setString(3, username);
            }
        } else if ("Tahun".equals(filter)) {
            pst.setInt(1, year);
            if (username != null && !"Semua".equals(username)) {
                pst.setString(2, username);
            }
        }

        try (ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                String id = rs.getString("id_sale");
                Date saleDate = rs.getDate("sale_date");
                double totalPrice = rs.getDouble("sale_total_price");
                double totalBayar = rs.getDouble("total_bayar");
                String user = rs.getString("user");

                Sale sale = new Sale(id, saleDate, totalPrice, 0, 0, totalBayar, 0, 0, null, user);
                list.add(sale);
            }
        }
    }

    return list;
}



   public List<Sale> getSalesByDay(Date date, String username) throws SQLException {
    List<Sale> list = new ArrayList<>();
    String sql = """
        SELECT id_sale, sale_date, sale_total_price, total_bayar, user 
          FROM penjualan 
         WHERE DATE(sale_date) = ?
    """;

    if (username != null && !"Semua".equals(username)) {
        sql += " AND user = ?";
    }

    try (Connection c = DBConnection.getConnection();
         PreparedStatement pst = c.prepareStatement(sql)) {

        pst.setDate(1, new java.sql.Date(date.getTime()));
        if (username != null && !"Semua".equals(username)) {
            pst.setString(2, username);
        }

        try (ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                String id = rs.getString("id_sale");
                Date saleDate = rs.getDate("sale_date");
                double totalPrice = rs.getDouble("sale_total_price");
                double totalBayar = rs.getDouble("total_bayar");
                String user = rs.getString("user");

                Sale sale = new Sale(id, saleDate, totalPrice, 0, 0, totalBayar, 0, 0, null, user);
                list.add(sale);
            }
        }
    }

    return list;
}



}
