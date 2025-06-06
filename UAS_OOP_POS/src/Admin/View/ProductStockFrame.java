/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Admin.View;
import Admin.Controller.TableStockSearch;
import Admin.Controller.TableStock;
import Admin.Model.StockRusak;
import Admin.Controller.ProductCRUD;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 *
 * @author user
 */
public class ProductStockFrame extends javax.swing.JPanel {
    private TableStock tableStock;
    private TableStockSearch tableStockSearch;
    private int selectedProductId = -1;
    
    public ProductStockFrame() {
        initComponents();
        searchHint();
        setupSearchListener();
        try {
            tableStock = new TableStock();
            tableStock.LoadTableProductStock(productStockTable);
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(jPanel1, "Gagal Mengenerate Table: " + e.getMessage());
        }
    }
    
    private void clearForm() {
        txt_product.setText("");
        txt_stokRusak.setText("");
    }
    
    private void searchHint() {
        String selectedFilter = filterCombo.getSelectedItem().toString();
        String hintText = "Search by " + selectedFilter + "...";
        
        txt_search.setText(hintText);
        txt_search.setForeground(Color.GRAY);
        
        // Menambahkan Focus Listener untuk Mengatur Hint
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

    
    private void setupSearchListener() {
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
    
    private void searchExecute() {
        String filterSelected = mapFilterToColumn(filterCombo.getSelectedItem().toString());
        String searchText = txt_search.getText().trim();
 
        try {
            if(searchText.equals("Search by " + filterCombo.getSelectedItem().toString() + "...")) {
                tableStock.LoadTableProductStock(productStockTable);
            } else {
                tableStockSearch = new TableStockSearch();
                tableStockSearch.LoadTableStockSearch(productStockTable, searchText, filterSelected);
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error saat mencari produk: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        txt_stokRusak = new javax.swing.JTextField();
        txt_product = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        filterCombo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        productStockTable = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1280, 700));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel1.setText("PENGATURAN STOCK PRODUK");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel2.setText("Input Stock Rusak :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel3.setText("Pilih Produk :");

        btn_add.setBackground(new java.awt.Color(51, 255, 0));
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_reset.setBackground(new java.awt.Color(0, 255, 204));
        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        txt_product.setEditable(false);
        txt_product.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel4.setText("Search :");

        filterCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id Product", "Id Supplier", "Supplier Name", "Product Code", "Product Name", "Product Unit" }));

        productStockTable.setBackground(new java.awt.Color(204, 255, 255));
        productStockTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "title 1", "title 2", "title 3", "title 4", "title 5", "title 6"
            }
        ));
        productStockTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productStockTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productStockTable);
        if (productStockTable.getColumnModel().getColumnCount() > 0) {
            productStockTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            productStockTable.getColumnModel().getColumn(1).setPreferredWidth(400);
            productStockTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            productStockTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            productStockTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            productStockTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_product)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_stokRusak, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_add)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_reset)))
                                .addGap(28, 28, 28)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(filterCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 226, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1256, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(txt_product, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_stokRusak, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(filterCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(547, 547, 547))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void productStockTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productStockTableMouseClicked
        int selectedRow = productStockTable.getSelectedRow();
        if(selectedRow != -1) {
            selectedProductId = Integer.parseInt(productStockTable.getValueAt(selectedRow, 0).toString());
            String productInfo = productStockTable.getValueAt(selectedRow, 1).toString();
            
            txt_product.setText(productInfo);
        }
    }//GEN-LAST:event_productStockTableMouseClicked

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
            String sR = txt_stokRusak.getText().trim();
            
            if(selectedProductId == -1) {
                JOptionPane.showMessageDialog(jPanel1, "Silahkan pilih produk dari tabel yang ingin ditambahkan stok rusaknya", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            if(sR.isEmpty()) {
                JOptionPane.showMessageDialog(jPanel1, "Masukkan jumlah stok yang rusak!", "Input Kosong", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            int stokRusak = Integer.parseInt(sR);
            StockRusak newStockRusak = StockRusak.forAdd(selectedProductId, stokRusak);
            ProductCRUD stockDB = new ProductCRUD();
            
            try{
                int stock_rusak = stockDB.inputStokRusak(newStockRusak);
                if(stock_rusak > 0) {
                    JOptionPane.showMessageDialog(jPanel1, "Stock Produk yang rusak berhasil ditambahkan dengan ID Produk: " + newStockRusak.getId_product());
                    tableStock.LoadTableProductStock(productStockTable);
                    clearForm();
                } else {
                    JOptionPane.showMessageDialog(jPanel1, "Stock Produk yang rusak gagal ditambahkan", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(jPanel1, "Kesalahan Database: " + e.getMessage(), "Kesalahan SQL", JOptionPane.ERROR_MESSAGE);
            }
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(jPanel1, "Harap masukkan angka yang valid untuk input stok yang rusak", "Kesalahan Format", JOptionPane.ERROR_MESSAGE);
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(jPanel1, "Terjadi kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
if (selectedProductId == -1) {
        JOptionPane.showMessageDialog(jPanel1, "Silakan pilih produk dari tabel yang ingin direset stoknya.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(jPanel1, "Apakah Anda yakin ingin mereset stok produk ini?", "Konfirmasi Reset", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {    
        try {
            ProductCRUD productCRUD = new ProductCRUD();
            boolean isReset = productCRUD.resetProductStock(selectedProductId);

            if (isReset) {
                JOptionPane.showMessageDialog(jPanel1, "Stok produk berhasil direset.", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
                tableStock.LoadTableProductStock(productStockTable); // Memuat ulang tabel
            } else {
                JOptionPane.showMessageDialog(jPanel1, "Gagal mereset stok produk.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jPanel1, "Kesalahan Database: " + e.getMessage(), "Kesalahan SQL", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    }//GEN-LAST:event_btn_resetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_reset;
    private javax.swing.JComboBox<String> filterCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productStockTable;
    private javax.swing.JTextField txt_product;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_stokRusak;
    // End of variables declaration//GEN-END:variables
}
