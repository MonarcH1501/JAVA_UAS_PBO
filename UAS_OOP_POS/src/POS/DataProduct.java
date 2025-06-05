/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package POS;

import backend_POS_2.Product;
import backend_POS_2.ProductCRUD;
import backend_POS_2.TableProduct;
import backend_POS_2.TableProductSearch;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author user
 */
public class DataProduct extends javax.swing.JPanel {
    private TableProduct tableProduct;
    private TableProductSearch tableSearchProduct;
    private int selectedProductId = -1; // untuk mengambil data table yang ingin diupdate atau dihapus
    /**
     * Creates new form data_product
     */
    public DataProduct() {
        initComponents();
        loadSupplierCombo();
        searchHint();
        setupSearchListener();
        
        
        try {
            tableProduct = new TableProduct();
            tableProduct.LoadProductTable(productTable);
            
        } catch(SQLException e) {
            
        }
    }
    
    private void loadSupplierCombo() {
        try {
            ProductCRUD productDB = new ProductCRUD();
            List<String> suppliers = productDB.getSupplierList();
            
            supplierCombo.removeAllItems();
            for(String supplier : suppliers) {
                supplierCombo.addItem(supplier);
            } 
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(jPanel1, "Gagal Mengambil Data Supplier: " + e.getMessage());
        }
    }
    
    private void clearForm() {
        txt_productCode.setText("");
        txt_productName.setText("");
        txt_priceBuy.setText("");
        txt_priceSell.setText("");
        txt_productUnit.setText("");
        supplierCombo.setSelectedIndex(0);
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
                tableProduct.LoadProductTable(productTable);
            } else {
                tableSearchProduct = new TableProductSearch();
                tableSearchProduct.LoadTableProductSearch(productTable, searchText, filterSelected);
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error saat mencari produk: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_productCode = new javax.swing.JTextField();
        txt_priceBuy = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_productName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_priceSell = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_productUnit = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        supplierCombo = new javax.swing.JComboBox<>();
        btn_reset = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        filterCombo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1270, 700));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 200));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data Product Management");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Product Code:");

        txt_productCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_productCodeActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Price Buy:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Product Name:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Price Sell:");

        btn_add.setBackground(new java.awt.Color(0, 204, 102));
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(0, 102, 204));
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(204, 51, 0));
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Product Unit:");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Id Supplier:");

        supplierCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_reset.setBackground(new java.awt.Color(0, 204, 204));
        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Search:");

        filterCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id Product", "Supplier Name", "Product Code", "Product Name", "Product Unit" }));
        filterCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_productName, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txt_priceSell, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_productCode, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txt_priceBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_productUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_delete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_reset))
                            .addComponent(supplierCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filterCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(460, 460, 460)
                        .addComponent(btn_add)
                        .addGap(30, 30, 30)
                        .addComponent(btn_update))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(524, 524, 524)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_productCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_priceBuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_productUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_productName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txt_priceSell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(supplierCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(filterCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add)
                    .addComponent(btn_update)
                    .addComponent(btn_delete)
                    .addComponent(btn_reset))
                .addGap(27, 27, 27))
        );

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1270, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
            String iS = supplierCombo.getSelectedItem().toString();
            String productCode = txt_productCode.getText().trim();
            String productName = txt_productName.getText().trim();
            String pB = txt_priceBuy.getText().trim();
            String pS = txt_priceSell.getText().trim();
            String productUnit = txt_productUnit.getText().trim();
            
            if(iS.isEmpty() || productCode.isEmpty() || productName.isEmpty() || pB.isEmpty() || pS.isEmpty() || productUnit.isEmpty()) {
                JOptionPane.showMessageDialog(jPanel1, "Harap isi semua kolom!", "Input Kosong", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Konversi ke tipe data yang sesuai
            String[] parts = iS.split(" - "); // Memisahkan ID dan Nama
            int idSupplier = Integer.parseInt(parts[0]); // Mengambil ID sebagai int
            BigDecimal priceBuy = new BigDecimal(pB);
            BigDecimal priceSell = new BigDecimal(pS);

            // Objek Baru
            Product newProduct = new Product(idSupplier, productCode, productName, priceBuy, priceSell, productUnit);
            ProductCRUD productDB = new ProductCRUD();
            
            try {
                int newProductId = productDB.insertProduct(newProduct);
                if(newProductId != -1) {
                    JOptionPane.showMessageDialog(jPanel1, "Product Berhasil Ditambahkan dengan ID: " + newProductId + " Nama Produk: " + newProduct.getProduct_name());
                    tableProduct.LoadProductTable(productTable); // Memperbaharui Table
                    clearForm(); // Mengosongkan Text_Field
                } else {
                    JOptionPane.showMessageDialog(jPanel1, "Product Gagal Ditambahkan", "Error", JOptionPane.ERROR_MESSAGE);
                } 
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(jPanel1, "Kesalahan Database: " + e.getMessage(), "Kesalahan SQL", JOptionPane.ERROR_MESSAGE);
            }
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(jPanel1, "Harap masukkan angka yang valid untuk kode produk, harga beli, harga jual dan stock ", "Kesalahan Format", JOptionPane.ERROR_MESSAGE);
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(jPanel1, "Kesalahan Database: " + ex.getMessage(), "Kesalahan SQL", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(jPanel1, "Terjadi Kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try {
            if(selectedProductId == -1) {
                JOptionPane.showMessageDialog(jPanel1 ,"Silahkan pilih produk yang ingin dihapus!", "Error", JOptionPane.ERROR_MESSAGE);
                
                return;
            }
            
            Product deletedProduct = new Product(selectedProductId);
            ProductCRUD productDB = new ProductCRUD();
            
            int confirmDelete = JOptionPane.showConfirmDialog(jPanel1, "Apakah kamu yakin ingin menghapus produk ini?", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirmDelete == JOptionPane.YES_OPTION)  {
                productDB.deleteProduct(deletedProduct);
                JOptionPane.showMessageDialog(jPanel1, "Produk Berhasil dihapus");
                tableProduct.LoadProductTable(productTable);
            } else {
                JOptionPane.showMessageDialog(jPanel1, "Produk gagal dihapus");
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(jPanel1, "Kesalahan SQL: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void txt_productCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_productCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_productCodeActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        try {
            String iS = supplierCombo.getSelectedItem().toString();
            String productCode = txt_productCode.getText().trim();
            String productName = txt_productName.getText().trim();
            String pB = txt_priceBuy.getText().trim();
            String pS = txt_priceSell.getText().trim();
            String productUnit = txt_productUnit.getText().trim();
            
            if(iS.isEmpty() || productCode.isEmpty() || productName.isEmpty() || pB.isEmpty() || pS.isEmpty() || productUnit.isEmpty()) {
                JOptionPane.showMessageDialog(jPanel1, "Harap isi semua kolom!", "Input Kosong", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            // Dapatkan ID Product yang ingin dipilih
            if(selectedProductId == -1) {
                JOptionPane.showMessageDialog(jPanel1, "Silahkan pilih yang ingin diupdate", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Konversi Tipe Data
            String[] parts = iS.split(" - "); // Memisahkan ID dan Nama
            int idSupplier = Integer.parseInt(parts[0]);
            BigDecimal priceBuy = new BigDecimal(pB);
            BigDecimal priceSell = new BigDecimal(pS);
            
            // Membuat Objek Produk Baru
            Product updatedProduct = new Product(selectedProductId, idSupplier, productCode, productName, priceBuy, priceSell, productUnit);
            ProductCRUD productDB = new ProductCRUD();
            
            int updateResult = productDB.updateProduct(updatedProduct);
            if (updateResult > 0) {
                JOptionPane.showMessageDialog(jPanel1, "Product Berhasil Diperbarui");
                
                // Refresh Table Setelah Diperbaharui
                tableProduct.LoadProductTable(productTable);
                clearForm();
            } else {
                JOptionPane.showMessageDialog(jPanel1, "Product Gagal Diperbaharui", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(jPanel1, "Harap masukkan angka yang valid untuk harga beli, harga jual, dan stok", "Error", JOptionPane.ERROR_MESSAGE);
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(jPanel1, "Kesalahan database: " + ex.getMessage(), "Kesalahan SQL", JOptionPane.ERROR_MESSAGE);
        }
            
    }//GEN-LAST:event_btn_updateActionPerformed

    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked
        int selectedRow = productTable.getSelectedRow();
        if(selectedRow != -1) {
            // Mengambil Nilai Data dari baris yang diplih
            selectedProductId = Integer.parseInt(productTable.getValueAt(selectedRow, 0).toString());
            String supplierId = productTable.getValueAt(selectedRow, 1).toString();
            String productCode = productTable.getValueAt(selectedRow, 2).toString();
            String productName = productTable.getValueAt(selectedRow, 3).toString();
            String priceBuy = productTable.getValueAt(selectedRow, 4).toString();
            String priceSell = productTable.getValueAt(selectedRow, 5).toString();
            String productUnit = productTable.getValueAt(selectedRow, 6).toString();
            
            // Memasukkan nilai ke dalam field input
            txt_productCode.setText(productCode);
            txt_productName.setText(productName);
            txt_priceBuy.setText(priceBuy);
            txt_priceSell.setText(priceSell);
            txt_productUnit.setText(productUnit);
            
            // Set Nilai supplierCombo
            for(int i = 0; i < supplierCombo.getItemCount(); i++) {
                if(supplierCombo.getItemAt(i).startsWith(supplierId + " - ")) {
                    supplierCombo.setSelectedIndex(i);
                    break;
                }
            }
        }
    }//GEN-LAST:event_productTableMouseClicked

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        clearForm();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed

    }//GEN-LAST:event_txt_searchActionPerformed

    private void filterComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterComboActionPerformed

    }//GEN-LAST:event_filterComboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> filterCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productTable;
    private javax.swing.JComboBox<String> supplierCombo;
    private javax.swing.JTextField txt_priceBuy;
    private javax.swing.JTextField txt_priceSell;
    private javax.swing.JTextField txt_productCode;
    private javax.swing.JTextField txt_productName;
    private javax.swing.JTextField txt_productUnit;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
