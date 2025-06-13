package Kasir.View;
import Assets.DBConnection;
import Kasir.Controller.HistoryController;
import Kasir.Model.Sale;
import Kasir.Model.SaleDetail;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class DetailTransaksiView extends javax.swing.JFrame {
    private final HistoryController controller;
    private final int idSale;
    private final String tanggal;
    private final double discount;
    private final double tax;
    private final double totalPrice;
    
    public DetailTransaksiView(int idSale, String tanggal, double discount, double tax,double totalPrice) {
        this.idSale = idSale;
        this.tanggal = tanggal;
        this.discount = discount;
        this.tax = tax;
        this.totalPrice = totalPrice;
        controller = new HistoryController();
        initComponents();

        txIdSale.setText(String.valueOf(idSale));
        txTanggal.setText(tanggal);
        txDiskon.setText(String.valueOf(discount));
        txPajak.setText(String.valueOf(tax));
        txTotalBayar.setText(String.valueOf(totalPrice));
        txIdSale.setEditable(false);
        txTanggal.setEditable(false);
        txDiskon.setEditable(false);
        txPajak.setEditable(false);
        txTotalBayar.setEditable(false);

        loadDetail();
    }

    private void loadDetail() {
        DefaultTableModel model = new DefaultTableModel(
            new Object[]{"No", "Nama Produk", "Jumlah", "Harga/Satuan", "Total"}, 0
        );

        try {
            List<SaleDetail> details = controller.getSaleDetailByTransactionId(idSale);
            int no = 1;
            for (SaleDetail d : details) {
                double total = d.getQuantity() * d.getPrice();
                model.addRow(new Object[]{no++, d.getProductName(), d.getQuantity(), d.getPrice(), total});
            }
            tbl_detailtransaksi.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal load detail: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_detailtransaksi = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txIdSale = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txTanggal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txPajak = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txDiskon = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txTotalBayar = new javax.swing.JTextField();
        btn_cetak = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("History Penjualan");

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("History Penjualan");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(362, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(332, 332, 332))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbl_detailtransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_detailtransaksi);

        jLabel2.setText("Id Penjualan");

        txIdSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txIdSaleActionPerformed(evt);
            }
        });
        txIdSale.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txIdSaleKeyTyped(evt);
            }
        });

        jLabel5.setText("Tanggal");

        txTanggal.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Detail Penjualan");

        jLabel13.setText("Pajak (%)");

        txPajak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPajakActionPerformed(evt);
            }
        });

        jLabel10.setText("Diskon(%) ");

        txDiskon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDiskonActionPerformed(evt);
            }
        });

        jLabel11.setText("Total");

        txTotalBayar.setEnabled(false);
        txTotalBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTotalBayarActionPerformed(evt);
            }
        });

        btn_cetak.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_cetak.setText("Cetak Struk");
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txIdSale, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(315, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(289, 289, 289))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(btn_cetak)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txPajak, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                        .addComponent(txDiskon))
                    .addComponent(txTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txIdSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txPajak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txIdSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txIdSaleActionPerformed

    }//GEN-LAST:event_txIdSaleActionPerformed

    private void txIdSaleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txIdSaleKeyTyped
 
    }//GEN-LAST:event_txIdSaleKeyTyped

    private void txPajakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPajakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPajakActionPerformed

    private void txDiskonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDiskonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txDiskonActionPerformed

    private void txTotalBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTotalBayarActionPerformed

    }//GEN-LAST:event_txTotalBayarActionPerformed

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
  try {
        JasperDesign jd = JRXmlLoader.load("C:\\Users\\User\\Desktop\\JAVA_UAS_PBO\\UAS_OOP_POS\\src\\Kasir_report\\Cetak_Struk.jrxml");
         String sql = "SELECT \n" +
"    sd.id_sale,\n" +
"    j.sale_date,\n" +
"    j.sale_total_price,\n" +
"    COALESCE(j.discount, 0) AS discount,\n" +
"    COALESCE(j.tax, 0) AS tax,\n" +
"    j.total_bayar,\n" +
"    j.kembalian,\n" +
"    sd.id_product,\n" +
"    p.product_name,\n" +
"    sd.sale_qty,\n" +
"    sd.sale_price,\n" +
"    sd.sale_qty * sd.sale_price AS total_price_produk,\n" +
"    (sd.sale_qty * sd.sale_price) * (COALESCE(j.discount, 0) / 100) AS total_discount,\n" +
"    ((sd.sale_qty * sd.sale_price) - ((sd.sale_qty * sd.sale_price) * (COALESCE(j.discount, 0) / 100))) \n" +
"    * (COALESCE(j.tax, 0) / 100) AS total_tax\n" +
"FROM \n" +
"    sale_details sd\n" +
"JOIN \n" +
"    product p ON sd.id_product = p.id_product\n" +
"JOIN \n" +
"    penjualan j ON sd.id_sale = j.id_sale "
                 + "WHERE sd.id_sale = $P{id_sale}";
         
         JRDesignQuery newQuery = new JRDesignQuery();
         newQuery.setText(sql);
         jd.setQuery(newQuery);
         
         JasperReport js = JasperCompileManager.compileReport(jd);
         
        // Koneksi database
        Connection conn = DBConnection.getConnection();
        JOptionPane.showMessageDialog(null, "Connected!");
        
        System.out.println(idSale);
        Map<String, Object> param = new HashMap<>();
        param.put("id_sale", idSale);

        JasperPrint jp = JasperFillManager.fillReport(js, param, conn);
        JasperViewer.viewReport(jp, false); // false = tidak exit aplikasi saat viewer ditutup
         
     } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat membuka form tambah data.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btn_cetakActionPerformed

    static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DetailTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cetak;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_detailtransaksi;
    private javax.swing.JTextField txDiskon;
    private javax.swing.JTextField txIdSale;
    private javax.swing.JTextField txPajak;
    private javax.swing.JTextField txTanggal;
    private javax.swing.JTextField txTotalBayar;
    // End of variables declaration//GEN-END:variables
}
