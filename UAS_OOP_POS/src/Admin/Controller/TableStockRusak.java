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
public class TableStockRusak {
    private ProductCRUD productDB;
    
    public TableStockRusak() throws SQLException {
        productDB = new ProductCRUD();
    }
    
    public void LoadTableStockRusak(JTable stockRusakTable) {
        DefaultTableModel tb = (DefaultTableModel) stockRusakTable.getModel();
        stockRusakTable.setModel(tb);
        
        tb.setColumnIdentifiers(new Object[] {
            "ID STOCK",
            "TANGGAL",
            "STOCK RUSAK",
        });
        
        tb.setRowCount(0);
        
        try {
            List<StockRusak> stockRusak = productDB.getStockRusak();
            
            for(StockRusak s : stockRusak) {
                tb.addRow(new Object[] {
                    s.getId_stock(),
                    s.getTanggal(),
                    s.getStockRusak(),
                });
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil data stock rusak" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        

    }
    
}