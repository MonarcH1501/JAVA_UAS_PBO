/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend_POS_2;

import java.sql.SQLException;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author user
 */
public class SearchProduct {
    private JComboBox<String> filterCombo;
    private JTextField txt_search;
    private JTable productTable;
    private JTable stockTable;
    private TableProduct tableProduct;
    private TableStock tableStock;
    private TableProductSearch tableProductSearch;
    private TableStockSearch tableStockSearch;
    
    public SearchProduct(JComboBox<String> filterCombo, JTextField txt_search, JTable productTable, JTable stockTable) {
        this.filterCombo = filterCombo;
        this.txt_search = txt_search;
        this.productTable = productTable;
        this.stockTable = stockTable;
    }
    
    public void searchHint() {
        String selectedFilter = filterCombo.getSelectedItem().toString();
        String hintText = "Search by " + selectedFilter + "...";
        
        txt_search.setText(hintText);
        txt_search.setForeground(Color.GRAY);
        
        txt_search.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(txt_search.getText().equals(hintText)) {
                    txt_search.setText("");
                    txt_search.setForeground(Color.BLACK);
                }
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if(txt_search.getText().isEmpty()) {
                    txt_search.setText(hintText);
                    txt_search.setForeground(Color.GRAY);
                }
            }
        });
        
        filterCombo.addActionListener((ActionEvent e) -> {
            searchHint();
        });
    }
    
   private String mapFilterToColumn(String filter) {
    switch (filter) {
        case "Id Product":
            return "pr.id_product";
        case "Id Supplier":
            return "pr.id_supplier";
        case "Supplier Name":
            return "sp.supp_name";
        case "Product Code":
            return "pr.product_code";
        case "Product Name":
            return "pr.product_name";
        case "Product Unit":
            return "pr.product_unit";
        default:
            return "pr.id_product";
    }
}

    
    public void searchExecute() {
        String filterSelected = mapFilterToColumn(filterCombo.getSelectedItem().toString());
        String searchText = txt_search.getText().trim();
        
        if(filterCombo.getSelectedItem().toString().equals("Id Supplier")) {
            try {
                String[] parts = searchText.split(" - ");
                searchText = parts[0];
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Format ID Supplier tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        try {
            if(searchText.equals("Search by " + filterCombo.getSelectedItem().toString() + "...")) {
                if(productTable != null) {
                    tableProduct = new TableProduct();
                    tableProduct.LoadProductTable(productTable);
                }
                if(stockTable != null) {
                    tableStock = new TableStock();
                    tableStock.LoadTableProductStock(stockTable);
                }
            } else {
                if(productTable != null) {
                    tableProductSearch = new TableProductSearch();
                    tableProductSearch.LoadTableProductSearch(productTable, searchText, filterSelected);
                }
                if(stockTable != null) {
                    tableStockSearch = new TableStockSearch();
                    tableStockSearch.LoadTableStockSearch(stockTable, searchText, filterSelected);
                }
            } 
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error saat mencari produk: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void setupSearchListener(JTextField txt_search) {
        txt_search.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchExecute();
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                searchExecute();
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                searchExecute();
            }
        });
    }
}
