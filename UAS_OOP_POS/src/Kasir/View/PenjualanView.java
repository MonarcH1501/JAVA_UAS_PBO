package Kasir.View;

import Kasir.Controller.SaleController;
import Kasir.Model.Sale;
import Kasir.Model.SaleDetail;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PenjualanView extends javax.swing.JFrame {

     private DefaultTableModel model;
    private SaleController saleController;
    private List<SaleDetail> saleDetails;

  public PenjualanView() {
        initComponents();

        model = new DefaultTableModel();
        jTable1.setModel(model);

        model.addColumn("No Transaksi");
        model.addColumn("ID Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        model.addColumn("Total");

        saleController = new SaleController();
        saleDetails = new ArrayList<>();
        txPajak.setText("11");
        txDiskon.setText("0");

        initForm();
    }

    private void initForm() {

        txDiskon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                updateTotalBayar();
            }
        });

        txPajak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                updateTotalBayar();
            }
        });

        txBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                hitungKembalian();
            }
        });

        try {
            txNoTransaksi.setText(saleController.generateTransactionNo());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal generate nomor transaksi");
        }
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        txTanggal.setText(sdf.format(now));

        clearPaymentFields();
        clearInputFields();
        updateTotalBayar();
    }

    private void clearInputFields() {
        txIDBarang.setText("");
        txNamaBarang.setText("");
        txHarga.setText("");
        txJumlah.setText("");
    }

    private void clearPaymentFields() {
        txTotalBayar.setText("0");
        txBayar.setText("0");
        txKembalian.setText("0");
        txTampil.setText("Rp. 0");
    }

   private void updateTotalBayar() {
            double total = 0;
            for (SaleDetail detail : saleDetails) {
                total += detail.getTotal();
            }
            txTotalawal.setText(String.format("%.2f", total));
            
            double discount = 0;
            double tax = 0;

            try {
                discount = Double.parseDouble(txDiskon.getText());
                tax = Double.parseDouble(txPajak.getText());
            } catch (NumberFormatException e) {
                // dibiarkan 0 jika input salah
            }

            double afterDiscount = total - (total * discount / 100);

            double afterTax = afterDiscount + (afterDiscount * tax / 100);

            txTotalBayar.setText(String.format("%.2f", afterTax));
            txTampil.setText("Rp " + String.format("%.2f", afterTax));
        }


    private void loadTable() {
        model.setRowCount(0); // clear existing rows
        for (SaleDetail detail : saleDetails) {
            model.addRow(new Object[]{
                txNoTransaksi.getText(),
                detail.getProductId(),
                detail.getProductName(),
                detail.getQuantity(),
                detail.getPrice(),
                detail.getTotal()
            });
        }
    }
            private void hitungKembalian() {
            try {
                double totalBayar = Double.parseDouble(txTotalBayar.getText());
                double bayar = Double.parseDouble(txBayar.getText());

                if (bayar < totalBayar) {
                    txKembalian.setText("0");
                } else {
                    double kembalian = bayar - totalBayar;
                    txKembalian.setText(String.format("%.2f", kembalian));
                }
            } catch (NumberFormatException e) {
                txKembalian.setText("0");
            }
        }

    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txNoTransaksi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txTanggal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txIDBarang = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txNamaBarang = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txHarga = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txJumlah = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        txTampil = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txPajak = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txBayar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txDiskon = new javax.swing.JTextField();
        txTotalBayar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txKembalian = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txTotalawal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("KASIR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(355, 355, 355))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel2.setText("No Transaksi");

        txNoTransaksi.setEnabled(false);

        jLabel5.setText("Tanggal");

        jLabel6.setText("ID Barang");

        txIDBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txIDBarangActionPerformed(evt);
            }
        });

        jLabel7.setText("Nama Barang");

        jLabel8.setText("Harga");

        jLabel9.setText("Jumlah");

        txJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txJumlahActionPerformed(evt);
            }
        });

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

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        txTampil.setBackground(new java.awt.Color(255, 153, 153));
        txTampil.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txTampil.setText("Rp. 0");

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        jLabel13.setText("Pajak (%)");

        txPajak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPajakActionPerformed(evt);
            }
        });

        jLabel14.setText("Bayar");

        txBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txBayarActionPerformed(evt);
            }
        });

        jLabel10.setText("Diskon ");

        txTotalBayar.setEnabled(false);
        txTotalBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTotalBayarActionPerformed(evt);
            }
        });

        jLabel12.setText("Kembalian");

        txKembalian.setEnabled(false);

        jLabel11.setText("Total");

        jLabel15.setText("Total Awal");

        txTotalawal.setEnabled(false);
        txTotalawal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTotalawalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(txIDBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                    .addGap(28, 28, 28)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(txJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnTambah))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(51, 51, 51)
                                .addComponent(txNoTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(252, 252, 252)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txTampil, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(txDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txPajak, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel15))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txKembalian)
                                                .addComponent(txBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txTotalawal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txNoTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txIDBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txTampil, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 109, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txTotalawal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13)
                            .addComponent(txPajak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
         try {
            int idBarang = Integer.parseInt(txIDBarang.getText());
            String namaBarang = txNamaBarang.getText();
            double harga = Double.parseDouble(txHarga.getText());
            double jumlah = Double.parseDouble(txJumlah.getText());

            SaleDetail detail = new SaleDetail(0,idBarang, namaBarang, jumlah, harga);
            saleDetails.add(detail);

            loadTable();
            updateTotalBayar();
            clearInputFields();
            txIDBarang.requestFocus();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan jumlah dan harga yang valid!");
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            saleDetails.remove(row);
            loadTable();
            updateTotalBayar();
            clearPaymentFields();
        } else {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
       if (saleDetails.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tidak ada data transaksi untuk disimpan.");
            return;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date tanggal = sdf.parse(txTanggal.getText());
            double discount = Double.parseDouble(txDiskon.getText());
            double tax = Double.parseDouble(txPajak.getText());
            double totalPay = Double.parseDouble(txBayar.getText());
            double kembalian = Double.parseDouble(txKembalian.getText());
            double Totalawal = Double.parseDouble(txTotalawal.getText());

            double totalBayar = Double.parseDouble(txTotalBayar.getText());

            Sale sale = new Sale(txNoTransaksi.getText(), tanggal, totalBayar,discount, tax, totalPay, kembalian,Totalawal , saleDetails);
            saleController.saveSale(sale);

            JOptionPane.showMessageDialog(this, "Transaksi berhasil disimpan!");

            // Reset form
            saleDetails.clear();
            loadTable();
            initForm();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan transaksi: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed

        ListBarang a = new ListBarang();
        a.setVisible(true);
    }//GEN-LAST:event_btnCariActionPerformed

    private void txJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txJumlahActionPerformed

    }//GEN-LAST:event_txJumlahActionPerformed

    private void txBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txBayarActionPerformed

    private void txTotalBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTotalBayarActionPerformed
         try {
                double totalBayar = Double.parseDouble(txTotalBayar.getText());
                double bayar = Double.parseDouble(txBayar.getText());

                if (bayar < totalBayar) {
                    JOptionPane.showMessageDialog(this, "Uang tidak cukup untuk melakukan pembayaran");
                } else {
                    double kembalian = bayar - totalBayar;
                    txKembalian.setText(String.format("%.2f", kembalian));
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Masukkan nilai yang valid untuk pembayaran.");
            }
    }//GEN-LAST:event_txTotalBayarActionPerformed

    private void txPajakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPajakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPajakActionPerformed

    private void txIDBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txIDBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txIDBarangActionPerformed

    private void txTotalawalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTotalawalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txTotalawalActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(PenjualanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PenjualanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PenjualanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PenjualanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PenjualanView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txBayar;
    private javax.swing.JTextField txDiskon;
    public static javax.swing.JTextField txHarga;
    public static javax.swing.JTextField txIDBarang;
    public static javax.swing.JTextField txJumlah;
    private javax.swing.JTextField txKembalian;
    public static javax.swing.JTextField txNamaBarang;
    private javax.swing.JTextField txNoTransaksi;
    private javax.swing.JTextField txPajak;
    private javax.swing.JTextField txTampil;
    private javax.swing.JTextField txTanggal;
    private javax.swing.JTextField txTotalBayar;
    private javax.swing.JTextField txTotalawal;
    // End of variables declaration//GEN-END:variables
}
