/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin.Controller;
import Admin.Model.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class TableProduct {
    private ProductCRUD productDB;
    
    public TableProduct() throws SQLException {
        productDB = new ProductCRUD();
    }
    
    // Versi awal untuk memuat semua produk
    public void LoadProductTable(JTable productTable) {
        DefaultTableModel tb = (DefaultTableModel) productTable.getModel();
        productTable.setModel(tb);
        
        tb.setColumnIdentifiers(new Object[] {
           "ID PRODUCT",
           "SUPPLIER",
           "PRODUCT CODE",
           "PRODUCT NAME",
           "PRICE BUY",
           "PRICE SELL",
           "PRODUCT UNIT",
        });
        
        tb.setRowCount(0);
        
         DecimalFormat formatHarga = new DecimalFormat("#,###");
        
        try {
            List<Product> products = productDB.getProduct();
            
            
            for(Product p : products) {
            String hargaBeli = formatHarga.format(p.getPrice_buy());
            String hargaJual = formatHarga.format(p.getPrice_sell());
                tb.addRow(new Object[] {
                    p.getId_product(),
//                    p.getId_supplier() + " - " + 
                    p.getSupp_name(),
                    p.getProduct_code(),
                    p.getProduct_name(),
                    hargaBeli,
                    hargaJual,
                    p.getProduct_unit(),
                });
            } 
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil data produk" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
