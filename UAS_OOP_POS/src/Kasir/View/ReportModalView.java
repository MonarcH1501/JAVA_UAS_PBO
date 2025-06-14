
package Kasir.View;
import Assets.DBConnection;
import Kasir.Model.Sale;
import Kasir.Controller.HistoryController;
import Kasir.Model.SaleDetail;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReportModalView extends javax.swing.JFrame {
    
    public ReportModalView() {
        initComponents();
        setLocationRelativeTo(null);
        initCustomLogic();
    }
    
    private void initCustomLogic() {
        cb_filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Semua", "Bulan", "Tahun"}));

        // Default disable
        jcalender_month.setEnabled(false);
        jcalendar_year.setEnabled(false);

        cb_filter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = (String) cb_filter.getSelectedItem();
                if ("Semua".equals(selected)) {
                    jcalender_month.setEnabled(false);
                    jcalendar_year.setEnabled(false);
                } else if ("Bulan".equals(selected)) {
                    jcalender_month.setEnabled(true);
                    jcalendar_year.setEnabled(true);
                } else if ("Tahun".equals(selected)) {
                    jcalender_month.setEnabled(false);
                    jcalendar_year.setEnabled(true);
                }
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLocaleChooser1 = new com.toedter.components.JLocaleChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jcalender_month = new com.toedter.calendar.JMonthChooser();
        cb_filter = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcalendar_year = new com.toedter.calendar.JYearChooser();
        btn_cetakListPenjualan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btn_cetakPenjualan = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cb_filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Filter");

        jLabel2.setText("Bulan");

        jLabel3.setText("Tahun");

        btn_cetakListPenjualan.setText("Cek List Penjualan");
        btn_cetakListPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakListPenjualanActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jLabel4.setText("List Penjualan :");

        btn_cetakPenjualan.setText("Cetak Penjualan");
        btn_cetakPenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cetakPenjualanMouseClicked(evt);
            }
        });
        btn_cetakPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakPenjualanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_cetakListPenjualan)
                                .addGap(26, 26, 26)
                                .addComponent(btn_cetakPenjualan))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cb_filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jcalender_month, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcalendar_year, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jcalender_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(jLabel3)
                    .addComponent(jcalendar_year, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cetakListPenjualan)
                    .addComponent(btn_cetakPenjualan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cetakListPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakListPenjualanActionPerformed
        String selectedFilter = (String) cb_filter.getSelectedItem();
    int month = jcalender_month.getMonth() + 1; 
    int year = jcalendar_year.getYear();

    HistoryController controller = new HistoryController();
    List<Sale> sales = new ArrayList<>();

    try {
        if ("Semua".equals(selectedFilter)) {
            sales = controller.loadAllSales();
        } else {
            sales = controller.getFilteredSales(selectedFilter, month, year);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        return;
    }

    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID Transaksi");
    model.addColumn("Tanggal");
    model.addColumn("Total Harga");
    model.addColumn("Total Bayar");

    for (Sale s : sales) {
        model.addRow(new Object[]{
            s.getTransactionNo(),
            s.getDate(),
            s.getTotalPrice(),
            s.getTotalPay()
        });
    }

    jTable2.setModel(model);
    }//GEN-LAST:event_btn_cetakListPenjualanActionPerformed

    private void btn_cetakPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakPenjualanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cetakPenjualanActionPerformed

    private void loadReport() {
    String selectedFilter = (String) cb_filter.getSelectedItem();
    int month = jcalender_month.getMonth() + 1; 
    int year = jcalendar_year.getYear();
    
    String sql = "";
    Map<String, Object> param = new HashMap<>();

    // Menentukan query berdasarkan filter yang dipilih
    switch (selectedFilter) {
        case "Bulan":
            sql = "SELECT id_sale, sale_date, DATE_FORMAT(sale_date, '%e %M %Y') AS sale_date_formatted, " +
                  "sale_total_price, FORMAT(sale_total_price, 0, 'id_ID') AS sale_total_price_formatted, " +
                  "total_bayar, FORMAT(total_bayar, 0, 'id_ID') AS total_bayar_formatted " +
                  "FROM penjualan " +
                  "WHERE MONTH(sale_date) = $P{month} AND YEAR(sale_date) = $P{year}";
            param.put("month", month);
            param.put("year", year);
            break;

        case "Tahun":
            sql = "SELECT id_sale, sale_date, DATE_FORMAT(sale_date, '%e %M %Y') AS sale_date_formatted, " +
                  "sale_total_price, FORMAT(sale_total_price, 0, 'id_ID') AS sale_total_price_formatted, " +
                  "total_bayar, FORMAT(total_bayar, 0, 'id_ID') AS total_bayar_formatted " +
                  "FROM penjualan " +
                  "WHERE YEAR(sale_date) = $P{year}";
            param.put("year", year);
            break;

        default: // All data / tanpa filter
            sql = "SELECT id_sale, sale_date, DATE_FORMAT(sale_date, '%e %M %Y') AS sale_date_formatted, " +
                  "sale_total_price, FORMAT(sale_total_price, 0, 'id_ID') AS sale_total_price_formatted, " +
                  "total_bayar, FORMAT(total_bayar, 0, 'id_ID') AS total_bayar_formatted " +
                  "FROM penjualan";
            break;
    }

    try {
        JasperDesign jd = JRXmlLoader.load("C:\\Users\\User\\Desktop\\JAVA_UAS_PBO\\UAS_OOP_POS\\src\\Kasir_report\\Cetak_Laporan_Penjualan.jrxml");

        JRDesignQuery newQuery = new JRDesignQuery();
        newQuery.setText(sql);
        jd.setQuery(newQuery);

        JasperReport js = JasperCompileManager.compileReport(jd);

        // Koneksi database
        Connection conn = DBConnection.getConnection();
        JOptionPane.showMessageDialog(null, "Connected!");

        JasperPrint jp = JasperFillManager.fillReport(js, param, conn);
        JasperViewer.viewReport(jp, false); // false = tidak exit aplikasi saat viewer ditutup
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat membuka laporan.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    
    private void btn_cetakPenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cetakPenjualanMouseClicked
        loadReport();
    }//GEN-LAST:event_btn_cetakPenjualanMouseClicked

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ReportModalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportModalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportModalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportModalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportModalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cetakListPenjualan;
    private javax.swing.JButton btn_cetakPenjualan;
    private javax.swing.JComboBox<String> cb_filter;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private com.toedter.components.JLocaleChooser jLocaleChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private com.toedter.calendar.JYearChooser jcalendar_year;
    private com.toedter.calendar.JMonthChooser jcalender_month;
    // End of variables declaration//GEN-END:variables

}
