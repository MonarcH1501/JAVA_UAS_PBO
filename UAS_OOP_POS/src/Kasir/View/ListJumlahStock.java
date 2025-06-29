/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Kasir.View;
import Admin.Controller.ProductCRUD;
import Admin.Model.Product;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class ListJumlahStock extends javax.swing.JFrame {

   private ProductCRUD productDB;
   private DefaultTableModel tableModel;
   
    public ListJumlahStock() throws SQLException {
        initComponents();
        productDB = new ProductCRUD();
        tableModel = new DefaultTableModel(new String[]{"ID Produk", "Nama Produk", "Total Stok"}, 0);
        tbl_jmlhstock.setModel(tableModel);
        loadData();
        txt_searchproduct.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
    public void insertUpdate(javax.swing.event.DocumentEvent e) {
        searchProduct();
    }

    public void removeUpdate(javax.swing.event.DocumentEvent e) {
        searchProduct();
    }

    public void changedUpdate(javax.swing.event.DocumentEvent e) {
        searchProduct();
    }
});
    }

    private void loadData() {
        try {
            List<Product> list = productDB.getAllProductStock(); // pastikan method ini ada di ProductCRUD
            tableModel.setRowCount(0); // Clear isi tabel
            for (Product p : list) {
                tableModel.addRow(new Object[]{
                    p.getId_product(),
                    p.getProduct_name(),
                    p.getTotal_stok()
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void searchProduct() {
    String keyword = txt_searchproduct.getText().trim();
    try {
        List<Product> list;
        if (keyword.isEmpty()) {
            list = productDB.getAllProductStock();
        } else {
            list = productDB.searchStockProduct(keyword, "pr.product_name"); // Ganti kolom filter sesuai kebutuhan
        }
        tableModel.setRowCount(0); // Clear isi tabel
        for (Product p : list) {
            tableModel.addRow(new Object[]{
                p.getId_product(),
                p.getProduct_name(),
                p.getTotal_stok()
            });
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_jmlhstock = new javax.swing.JTable();
        txt_searchproduct = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbl_jmlhstock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_jmlhstock);

        txt_searchproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchproductActionPerformed(evt);
            }
        });

        jLabel1.setText("Cari Produk :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Jumlah Stock Barang");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(275, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_searchproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(269, 269, 269))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_searchproduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_searchproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchproductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchproductActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    java.awt.EventQueue.invokeLater(() -> {
        try {
            new ListJumlahStock().setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_jmlhstock;
    private javax.swing.JTextField txt_searchproduct;
    // End of variables declaration//GEN-END:variables
}
