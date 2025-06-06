/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin.Controller;
import Admin.Model.*;
import java.sql.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class TableStock {
    private ProductCRUD productDB;
    
    public TableStock() throws SQLException {
        productDB = new ProductCRUD();
    }
    
    public void LoadTableProductStock(JTable productStockTable) {
        DefaultTableModel tb = (DefaultTableModel) productStockTable.getModel();
        productStockTable.setModel(tb);
        
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
            List<Product> productStock = productDB.getProductStock();
            
            for(Product p : productStock) {
                tb.addRow(new Object[] {
                    p.getId_product(),
                    p.getProduct_code() + " - " + p.getProduct_name() + " - " + p.getProduct_unit() + " - " 
//                            + p.getId_supplier() 
                            + "(" + p.getSupp_name() + ")",
                    p.getPurchase_qty(),
                    p.getSale_qty(),
                    p.getStok_rusak(),
                    p.getTotal_stok(),
                });
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil data stok produk" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        

    } 
}
