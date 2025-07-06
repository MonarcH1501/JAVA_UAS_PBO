/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin.Model;

/**
 *
 * @author user
 */
public class PergerakanStock {
    private String tanggal;
    private String productCode;
    private String productName;
    private String productUnit;
    private String jenisTransaksi;
    private int jumlah;
    
    public PergerakanStock(String tanggal, String productCode, String productName, String productUnit, String jenisTransaksi, int jumlah) {
        this.tanggal = tanggal;
        this.productCode = productCode;
        this.productName = productName;
        this.productUnit = productUnit;
        this.jenisTransaksi = jenisTransaksi;
        this.jumlah = jumlah;
    }

    public String getTanggal() { return tanggal; }
    public String getProductCode() { return productCode; }
    public String getProductName() { return productName; }
    public String getProductUnit() { return productUnit; }
    public String getJenisTransaksi() { return jenisTransaksi; }
    public int getJumlah() { return jumlah; }
}
