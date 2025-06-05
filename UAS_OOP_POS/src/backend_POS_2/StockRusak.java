/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend_POS_2;

/**
 *
 * @author user
 */
public class StockRusak {
    private int id_stock;
    private int id_product;
    private int stock_rusak;
    private String product_code;
    private String product_name;
    private String product_unit;
    
    public StockRusak() {}
    
    // Add Stock Rusak
    public static StockRusak forAdd(int id_product, int stock_rusak) {
        StockRusak stockRusak = new StockRusak();
        stockRusak.id_product = id_product;
        stockRusak.stock_rusak = stock_rusak;
        return stockRusak;
    }
    
    // Display Stock Rusak
    public static StockRusak forDisplay(int id_stock, int id_product, String product_code, String product_name, String product_unit, int stock_rusak) {
        StockRusak stockRusak = new StockRusak();
        stockRusak.id_stock = id_stock;
        stockRusak.id_product = id_product;
        stockRusak.product_code = product_code;
        stockRusak.product_name = product_name;
        stockRusak.product_unit = product_unit;
        stockRusak.stock_rusak = stock_rusak;
        return stockRusak;
    }
    
    // Update Stock Rusak
    public static StockRusak forUpdate(int id_stock, int stock_rusak) {
        StockRusak stockRusak = new StockRusak();
        stockRusak.id_stock = id_stock;
        stockRusak.stock_rusak = stock_rusak;
        return stockRusak;
    }
    
    public int getId_stock() { return id_stock; } 
    public void setId_Stock(int id_stock) { this.id_stock = id_stock; }
    
    public int getId_product() { return id_product; }
    public void setIdProduct(int id_product) { this.id_product = id_product; }
    
    public int getStockRusak() { return stock_rusak; }
    public void setStockRusak(int stock_rusak) { this.stock_rusak = stock_rusak; }
    
    public String getProduct_code() { return product_code; }
    public void setProduct_code(String product_code) { this.product_code = product_code; }

    public String getProduct_name() { return product_name; }
    public void setProduct_name(String product_name) { this.product_name = product_name; }
    
    public String getProduct_unit() { return product_unit; } 
    public void setProduct_unit(String product_unit) { this.product_unit = product_unit; }
}
