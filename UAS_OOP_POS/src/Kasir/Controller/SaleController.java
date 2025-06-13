package Kasir.Controller;

import Assets.DBConnection;
import Kasir.Model.*;

import java.sql.*;
import java.util.List;

public class SaleController {

    public String generateTransactionNo() throws SQLException {
    Connection c = DBConnection.getConnection();
    Statement s = c.createStatement();
    ResultSet r = s.executeQuery("SELECT id_sale FROM penjualan ORDER BY id_sale DESC LIMIT 1");

    String transactionNo;
    if (r.next()) {
        int idSale = r.getInt("id_sale") + 1;
        transactionNo = "TR-" + idSale;
    } else {
        transactionNo = "TR-1";
    }

    r.close();
    s.close();
    return transactionNo;
}

    public void saveSale(Sale sale) throws Exception {
        Connection c = DBConnection.getConnection();
        String sql = "INSERT INTO penjualan (sale_date, discount, tax,sale_total_price, total_bayar,kembalian,total_price_produk) VALUES (?, ?, ?, ?,?,?,?)";
        PreparedStatement pst = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        pst.setDate(1, new java.sql.Date(sale.getDate().getTime()));
        pst.setDouble(2, sale.getDiscount());
        pst.setDouble(3, sale.getTax());
        pst.setDouble(4, sale.getTotalPrice());
        pst.setDouble(5, sale.gettotalPay());
        pst.setDouble(6, sale.getkembalian());
        pst.setDouble(7, sale.getTotalAwal());
        pst.executeUpdate();

        ResultSet rs = pst.getGeneratedKeys();
        int lastSaleId = 0;
        if (rs.next()) {
            lastSaleId = rs.getInt(1);
        }

        rs.close();
        pst.close();

        for (SaleDetail detail : sale.getSaleDetails()) {
            String detailSql = "INSERT INTO sale_details (id_sale, id_product, sale_qty, sale_price) VALUES (?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(detailSql);
            p.setInt(1, lastSaleId);
            p.setInt(2, detail.getProductId());
            p.setDouble(3, detail.getQuantity());
            p.setDouble(4, detail.getPrice());
            p.executeUpdate();
            p.close();
        }
    }
}
