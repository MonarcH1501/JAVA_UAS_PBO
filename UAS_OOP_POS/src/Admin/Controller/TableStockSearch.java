/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin.Controller;
import Admin.Model.*;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class TableStockSearch {
    private ProductCRUD productDB;
    
    public TableStockSearch() throws SQLException {
        productDB = new ProductCRUD();
    }
    
    public void LoadTableStockSearch(JTable searchStock, String text, String filter) {
        DefaultTableModel tb = (DefaultTableModel) searchStock.getModel();
        searchStock.setModel(tb);
        
        tb.setColumnIdentifiers(new Object[] {
            "ID PRODUK",
            "PRODUK",
            "STOK AWAL",
            "TOTAL STOK JUAL",
            "TOTAL STOK RUSAK",
            "TOTAL STOCK",
        });
        
        tb.setRowCount(0);
        
        try {
            List<Product> productStock = productDB.searchStockProduct(text, filter);
            
            for(Product p : productStock) {
                tb.addRow(new Object [] {
                    p.getId_product(),
                    p.getProduct_code() + " - " + p.getProduct_name() + " - " + p.getProduct_unit() + " - " + p.getId_supplier() + "(" + p.getSupp_name() + ")",
                    p.getPurchase_qty(),
                    p.getSale_qty(),
                    p.getTotal_stok(),
                });
            } 
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil data stock produk" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
