/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend_POS_2;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class TableProductSearch {
    private ProductCRUD productDB;
    
    public TableProductSearch() throws SQLException {
        productDB = new ProductCRUD();
    }
    
    // Versi awal untuk memuat semua produk
    public void LoadTableProductSearch(JTable searchProduct, String text, String filter) {
        DefaultTableModel tb = (DefaultTableModel) searchProduct.getModel();
        searchProduct.setModel(tb);
        
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
        
        try {
            List<Product> products = productDB.searchDataProduct(text, filter);
            
            for(Product p : products) {
                tb.addRow(new Object[] {
                    p.getId_product(),
//                    p.getId_supplier() + " - " + 
                    p.getSupp_name(),
                    p.getProduct_code(),
                    p.getProduct_name(),
                    p.getPrice_buy(),
                    p.getPrice_sell(),
                    p.getProduct_unit(),
                });
            } 
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil data produk" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        

    }
}
