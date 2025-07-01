    package Kasir.View;

    import Assets.DBConnection;
    import Kasir.Controller.SaleController;
    import Admin.Model.Product;
    import Admin.Controller.ProductCRUD;
    import Kasir.Model.Sale;
    import Kasir.Model.SaleDetail;
import java.math.BigDecimal;
    import java.sql.Connection;
import java.sql.SQLException;
    import java.text.NumberFormat;
    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.ArrayList;
    import java.util.Date;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Locale;
    import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
                String formattedTotal = rupiah.format(total).replace(",00", "").replace("Rp", "Rp ");
                txTotalawal.setText(formattedTotal);

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

                String formatted = rupiah.format(afterTax).replace(",00", "").replace("Rp", "Rp ");
                txTotalBayar.setText(formatted);
                txTampil.setText(formatted);

            }


       private void loadTable() {
            model.setRowCount(0); // clear existing rows
            NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
            for (SaleDetail detail : saleDetails) {
            String formattedPrice = rupiah.format(detail.getPrice()).replace(",00", "").replace("Rp", "Rp ");
            String formattedTotal = rupiah.format(detail.getTotal()).replace(",00", "").replace("Rp", "Rp ");
                model.addRow(new Object[]{
                    txNoTransaksi.getText(),
                    detail.getProductId(),
                    detail.getProductName(),
                    detail.getQuantity(),
                    formattedPrice,
                    formattedTotal
                });
            }
        }
           private void hitungKembalian() {
            try {
                double totalBayar = parseHargaToDouble(txTotalBayar.getText());
                double bayar = parseHargaToDouble(txBayar.getText());

                if (bayar < totalBayar) {
                    txKembalian.setText("0");
                } else {
                     double kembalian = bayar - totalBayar;
                     NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
                     String formatted = rupiah.format(kembalian).replace(",00", "").replace("Rp", "Rp ");
                     txKembalian.setText(formatted);
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
        btncheckstok = new javax.swing.JButton();

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

        txTanggal.setEnabled(false);

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

        jLabel10.setText("Diskon (%)");

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

        btncheckstok.setText("Cek Stock");
        btncheckstok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncheckstokActionPerformed(evt);
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
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btncheckstok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addContainerGap(18, Short.MAX_VALUE))
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
                        .addComponent(btncheckstok, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
    
   private double parseHargaToDouble(String hargaText) {
    if (hargaText == null || hargaText.trim().isEmpty()) return 0;
    String clean = hargaText.replace("Rp", "")
                            .replace(" ", "")
                            .replace(".", "")       // Hapus pemisah ribuan
                            .replace(",", ".")      // Ubah koma jadi titik (untuk desimal)
                            .trim();
    return Double.parseDouble(clean);
}

    
    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
         
        try {
        int idBarang = Integer.parseInt(txIDBarang.getText());
        String namaBarang = txNamaBarang.getText();
        double harga = parseHargaToDouble(txHarga.getText());
        double jumlah = Double.parseDouble(txJumlah.getText());

        if (jumlah <= 0 || harga <= 0) {
            JOptionPane.showMessageDialog(this, "Jumlah dan harga harus lebih dari 0!");
            return;
        }

        // ✅ Ambil stok dari SaleController (bukan ProductCRUD)
        Product stokProduk = saleController.getProductStockById(idBarang);
        if (stokProduk == null) {
            JOptionPane.showMessageDialog(this, "Produk tidak ditemukan!");
            return;
        }

        int stokTersedia = stokProduk.getTotal_stok();
        double totalQtyDiTabel = jumlah;

        for (SaleDetail detail : saleDetails) {
            if (detail.getProductId() == idBarang) {
                totalQtyDiTabel += detail.getQuantity();
            }
        }

        if (totalQtyDiTabel > stokTersedia) {
            JOptionPane.showMessageDialog(this,
                "Stok tidak cukup!\nStok tersedia: " + stokTersedia,
                "Peringatan",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 🔧 Update atau tambah item ke list saleDetails
        boolean found = false;
        for (SaleDetail detail : saleDetails) {
            if (detail.getProductId() == idBarang) {
                detail.setQuantity(detail.getQuantity() + jumlah);
                detail.setPrice(harga); // update harga jika berubah
                found = true;
                break;
            }
        }

        if (!found) {
            SaleDetail detail = new SaleDetail(0, idBarang, namaBarang, jumlah, harga);
            saleDetails.add(detail);
        }

        loadTable();
        updateTotalBayar();
        clearInputFields();
        txIDBarang.requestFocus();

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Masukkan jumlah dan harga yang valid!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage());
    }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            saleDetails.remove(row);
            loadTable();
            updateTotalBayar();
            hitungKembalian();
//            clearPaymentFields();
        } else {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private double parseDoubleLocale(String text) throws ParseException {
     NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);
    return nf.parse(text).doubleValue();
}
    
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
       if (saleDetails.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tidak ada data transaksi untuk disimpan.");
            return;
        }

        try {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date tanggal = sdf.parse(txTanggal.getText());

        double discount   = parseHargaToDouble(txDiskon.getText());
        double tax        = parseHargaToDouble(txPajak.getText());
        double totalPay   = parseHargaToDouble(txBayar.getText());
        double kembalian  = parseHargaToDouble(txKembalian.getText());
        double totalAwal  = parseHargaToDouble(txTotalawal.getText());
        double totalBayar = parseHargaToDouble(txTotalBayar.getText());


            Sale sale = new Sale(txNoTransaksi.getText(), tanggal, totalBayar,discount, tax, totalPay, kembalian, totalAwal , saleDetails);
            int generatedId = saleController.saveSale(sale);
            System.out.println(generatedId);
            saleDetails.clear();
            loadTable();
            initForm();

             if (generatedId > 0) {
            JOptionPane.showMessageDialog(this, "Transaksi berhasil disimpan!\nID Sale: " + generatedId);

            loadReport(generatedId);

        } 

        } catch (Exception e) {
            e.printStackTrace(); 
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
//                double totalBayar = Double.parseDouble(txTotalBayar.getText());
//                double bayar = Double.parseDouble(txBayar.getText());
                double totalBayar = parseDoubleLocale(txTotalBayar.getText());
                double bayar = parseDoubleLocale(txBayar.getText());

                if (bayar < totalBayar) {
                    JOptionPane.showMessageDialog(this, "Uang tidak cukup untuk melakukan pembayaran");
                } else {
                    double kembalian = bayar - totalBayar;
                    txKembalian.setText(String.format("%.2f", kembalian));
                }
            } catch (ParseException e) {
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

    private void btncheckstokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncheckstokActionPerformed
       ListJumlahStock b = null;
             try {
                 b = new ListJumlahStock();
             } catch (SQLException ex) {
                 Logger.getLogger(PenjualanView.class.getName()).log(Level.SEVERE, null, ex);
             }
        b.setVisible(true);
    }//GEN-LAST:event_btncheckstokActionPerformed
    
    public void loadReport(int id){
        try {
     // Load kedua desain laporan
        JasperDesign jd = JRXmlLoader.load("C:\\Users\\User\\Desktop\\JAVA_UAS_PBO\\UAS_OOP_POS\\src\\Kasir_report\\Cetak_Struk.jrxml");
        JasperDesign jd2 = JRXmlLoader.load("C:\\Users\\User\\Desktop\\JAVA_UAS_PBO\\UAS_OOP_POS\\src\\Kasir_report\\Cetak_Struk_!discount.jrxml");

        // SQL query yang digunakan di kedua laporan
        String sql = "SELECT \n" +
                "    sd.id_sale,\n" +
                "    DATE_FORMAT(j.sale_date, '%e %M %Y') AS sale_date_formatted,\n" +
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
                "    penjualan j ON sd.id_sale = j.id_sale \n" +
                "WHERE sd.id_sale = $P{id_sale}";

        // Ambil nilai discount dari database
        SaleController sale = new SaleController();
        BigDecimal discount = sale.getdiscoundSale(id); // pastikan metode ini return BigDecimal

        // Set query untuk kedua desain
        JRDesignQuery newQuery = new JRDesignQuery();
        newQuery.setText(sql);
        jd.setQuery(newQuery);
        jd2.setQuery(newQuery);

        // Kompilasi sesuai kondisi discount
        JasperReport js;
        if (discount.compareTo(BigDecimal.ZERO) == 0) {
            js = JasperCompileManager.compileReport(jd2); // tanpa discount
        } else {
            js = JasperCompileManager.compileReport(jd); // dengan discount
        }

        // Koneksi ke database
        Connection conn = DBConnection.getConnection();

        // Parameter ke report
        Map<String, Object> param = new HashMap<>();
        param.put("id_sale", id);

        // Cetak laporan
        JasperPrint jp = JasperFillManager.fillReport(js, param, conn);
        JasperViewer.viewReport(jp, false);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat membuka form cetak struk.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
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
    private javax.swing.JButton btncheckstok;
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
