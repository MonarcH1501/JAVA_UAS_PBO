/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin.Model;
import java.math.BigDecimal;
import jdk.jfr.Unsigned;

/**
 *
 * @author user
 */
public class Product {
    private int id_product;
    private int id_supplier;
    private String supp_name;
    private String product_code;
    private String product_name;
    private BigDecimal price_buy;
    private BigDecimal price_sell;
    private String product_unit;
    private int purchase_qty;
    private int sale_qty;
    private int stok_rusak;
    private int total_stok;

    
    // Untuk Insert Product
    public Product(int id_supplier, String product_code, String product_name, BigDecimal price_buy, BigDecimal price_sell, String product_unit) {
        this.id_supplier = id_supplier;
        this.product_code = product_code;
        this.product_name = product_name;
        this.price_buy = price_buy;
        this.price_sell = price_sell;
        this.product_unit = product_unit;
    }
    
    // Untuk Update Product
    public Product(int id_product, int id_supplier, String product_code, String product_name, BigDecimal price_buy, BigDecimal price_sell, String product_unit) {
        this.id_product = id_product;
        this.id_supplier = id_supplier;
        this.product_code = product_code;
        this.product_name = product_name;
        this.price_buy = price_buy;
        this.price_sell = price_sell;
        this.product_unit = product_unit;
    }
    
    // Untuk Display Table Product
    public Product(int id_product, int id_supplier, String supp_name, String product_code, String product_name, BigDecimal price_buy, BigDecimal price_sell, String product_unit) {
        this.id_product = id_product;
        this.id_supplier = id_supplier;
        this.supp_name = supp_name;
        this.product_code = product_code;
        this.product_name = product_name;
        this.price_buy = price_buy;
        this.price_sell = price_sell;
        this.product_unit = product_unit;
    }
    
    // Untuk Delete Product
    public Product(int id_product) {
        this.id_product = id_product;
    }
    
    // Untuk Display Table Stock Product
    public Product(int id_product, int id_supplier, String supp_name, String product_code, String product_name, String product_unit, int purchase_qty, int sale_qty, int stok_rusak, int total_stok) {
        this.id_product = id_product;
        this.id_supplier = id_supplier;
        this.supp_name = supp_name;
        this.product_code = product_code;
        this.product_name = product_name;
        this.product_unit = product_unit;
        this.purchase_qty = purchase_qty;
        this.sale_qty = sale_qty;
        this.stok_rusak = stok_rusak;
        this.total_stok = total_stok;
    }

    public int getId_product() { return id_product; }
    public void setId_product(int id_product) { this.id_product = id_product; }
    
    public int getId_supplier() { return id_supplier; }
    public void setId_supplier(int id_supplier) { this.id_supplier = id_supplier; }
    
    public String getSupp_name() { return supp_name; }
    public void setSupp_name(String supp_name) { this.supp_name = supp_name; }
    
    public String getProduct_code() { return product_code; }
    public void setProduct_code(String product_code) { this.product_code = product_code; }

    public String getProduct_name() { return product_name; }
    public void setProduct_name(String product_name) { this.product_name = product_name; }

    public BigDecimal getPrice_buy() { return price_buy; }
    public void setPrice_buy(BigDecimal price_buy) { this.price_buy = price_buy; }

    public BigDecimal getPrice_sell() { return price_sell; }
    public void setPrice_sell(BigDecimal price_sell) { this.price_sell = price_sell; }

    public String getProduct_unit() { return product_unit; } 
    public void setProduct_unit(String product_unit) { this.product_unit = product_unit; }
    
    public int getPurchase_qty() { return purchase_qty; }
    public void setPurchase_qty(int purchase_qty) { this.purchase_qty = purchase_qty; }
    
    public int getSale_qty() { return sale_qty; }
    public void setSale_qty(int sale_qty) { this.sale_qty = sale_qty; }
    
    public int getStok_rusak() { return stok_rusak; }
    public void setStok_rusak(int stok_rusak) { this.stok_rusak = stok_rusak; }
    
    public int getTotal_stok() { return total_stok; }
    public void setTotal_stok(int total_stok) { this.total_stok = total_stok; }
}
