/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin.Controller;
import Admin.Model.*;
import Assets.DBConnection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

/**
 *
 * @author user
 */
public class ProductCRUD {
    Connection c;
    
    public ProductCRUD() throws SQLException {
        c = DBConnection.getConnection();
    }
    
    // untuk Menambah Product
    public int insertProduct(Product product) throws SQLException {
        String insertQuery = "INSERT INTO product (id_supplier, product_code, product_name, price_buy, price_sell, product_unit) VALUES (?, ?, ?, ?, ?, ?)";
        try(PreparedStatement ps = c.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, product.getId_supplier());
            ps.setString(2, product.getProduct_code());
            ps.setString(3, product.getProduct_name());
            ps.setBigDecimal(4, product.getPrice_buy());
            ps.setBigDecimal(5, product.getPrice_sell());
            ps.setString(6, product.getProduct_unit());
            
            int affectedRows = ps.executeUpdate();
            
            if(affectedRows > 0) {
                try(ResultSet rs = ps.getGeneratedKeys()) {
                    if(rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }
            return -1; // Jika gagal mendapatkan ID produk
        } 
    }
    
    // Untuk Mengupdate Product
    public int updateProduct(Product product) throws SQLException {
        String updateQuery = "UPDATE product SET id_supplier = ?, product_code = ?, product_name = ?, price_buy = ?, price_sell = ?, product_unit = ? WHERE id_product = ?";
        try(PreparedStatement ps = c.prepareStatement(updateQuery)) {
            ps.setInt(1, product.getId_supplier());
            ps.setString(2, product.getProduct_code());
            ps.setString(3, product.getProduct_name());
            ps.setBigDecimal(4, product.getPrice_buy());
            ps.setBigDecimal(5, product.getPrice_sell());
            ps.setString(6, product.getProduct_unit());
            ps.setInt(7, product.getId_product());
            
            int affectedRows = ps.executeUpdate();
            return affectedRows;
        }
    }
    
    // Untuk Menghapus Product
    public int deleteProduct(Product product) throws SQLException {
        String deleteQuery = "DELETE FROM product WHERE id_product = ?";
        try(PreparedStatement ps = c.prepareStatement(deleteQuery)) {
            ps.setInt(1, product.getId_product());
            
            int affectedRows = ps.executeUpdate();
            return affectedRows;
        }
    }
    
    // Menampilkan Data Produk ke tabel
    public List<Product> getProduct() throws SQLException {
        List<Product> products = new ArrayList<>();
        String queryProduct = "SELECT pr.id_product AS id_product, pr.id_supplier AS id_supplier, sp.supp_name AS supp_name, pr.product_code AS product_code, pr.product_name AS product_name, pr.price_buy AS price_buy, pr.price_sell AS price_sell, pr.product_unit AS product_unit FROM product pr JOIN supplier sp ON pr.id_supplier = sp.id_supplier";
        
        try(PreparedStatement ps = c.prepareStatement(queryProduct);
            ResultSet rs = ps.executeQuery();) {
            while(rs.next()) {
                int idProduct = rs.getInt("id_product");
                int idSupplier = rs.getInt("id_supplier");
                String suppName = rs.getString("supp_name");
                String code = rs.getString("product_code");
                String name = rs.getString("product_name");
                BigDecimal buy = rs.getBigDecimal("price_buy");
                BigDecimal sell = rs.getBigDecimal("price_sell");
                String unit = rs.getString("product_unit");
                
                products.add(new Product(idProduct, idSupplier, suppName, code, name, buy, sell, unit));
            }
        }
        return products;
    }
    
    // Menampilkan Produk dan Stok Produk Melalui Perhitungan ke tabel
    public List<Product> getProductStock() throws SQLException {
        List<Product> productStock = new ArrayList<>();
        String queryProductStock = "SELECT pr.id_product AS id_product, pr.id_supplier AS id_supplier, sp.supp_name AS supp_name, pr.product_code AS product_code, pr.product_name AS product_name, pr.product_unit AS product_unit, COALESCE(pb.total_purchase, 0) as total_purchase, COALESCE(sd.total_sale, 0) as total_sale, COALESCE(s.total_stok_rusak, 0) as total_stok_rusak, COALESCE(pb.total_purchase, 0) - COALESCE(sd.total_sale, 0) - COALESCE(s.total_stok_rusak, 0) as total_stok FROM product pr JOIN supplier sp ON pr.id_supplier = sp.id_supplier LEFT JOIN(SELECT id_product, SUM(purchase_qty) as total_purchase FROM pembelian GROUP BY id_product) pb ON pr.id_product = pb.id_product LEFT JOIN(SELECT id_product, SUM(sale_qty) as total_sale FROM sale_details GROUP BY id_product) sd ON pr.id_product = sd.id_product LEFT JOIN(SELECT id_product, sum(stok_rusak) as total_stok_rusak FROM stock GROUP BY id_product) s ON pr.id_product = s.id_product";
        
        try(PreparedStatement ps = c.prepareStatement(queryProductStock); 
            ResultSet rs = ps.executeQuery();) {
            while(rs.next()) {
                int idProduct = rs.getInt("id_product");
                int idSupplier = rs.getInt("id_supplier");
                String suppName = rs.getString("supp_name");
                String code = rs.getString("product_code");
                String name = rs.getString("product_name");
                String unit = rs.getString("product_unit");
                int totalPurchase = rs.getInt("total_purchase");
                int totalSale = rs.getInt("total_sale");
                int totalStokRusak = rs.getInt("total_stok_rusak");
                int totalStok = rs.getInt("total_stok");
                
                productStock.add(new Product(idProduct, idSupplier, suppName, code, name, unit, totalPurchase, totalSale, totalStokRusak, totalStok));
            }
        }
        return productStock;
    }
    
    // Fungsi untuk mereset stok produk menjadi 0
public boolean resetProductStock(int productId) throws SQLException {
    String resetStockQuery = "UPDATE stock SET stok_rusak = 0 WHERE id_product = ?";
    try (PreparedStatement ps = c.prepareStatement(resetStockQuery)) {
        ps.setInt(1, productId);
        int affectedRows = ps.executeUpdate();
        return affectedRows > 0;
    }
}

    public List<StockRusak> getStockRusak() throws SQLException {
        List<StockRusak> stockRusak = new ArrayList<>();
        String queryUpdateStock = "SELECT s.id_stock AS id_stock, s.id_product AS id_product, pr.product_code AS product_code, pr.product_name AS product_name, pr.product_unit AS product_unit, s.stok_rusak AS stok_rusak FROM stock s JOIN product pr ON s.id_product = pr.id_product";
        
        try(PreparedStatement ps = c.prepareStatement(queryUpdateStock); 
            ResultSet rs = ps.executeQuery();) {
            while(rs.next()) {
                int iS = rs.getInt("id_stock");
                int iP = rs.getInt("id_product");
                String pC = rs.getString("product_code");
                String pN = rs.getString("product_name");
                String pU = rs.getString("product_unit");
                int sR = rs.getInt("stok_rusak");
                
                stockRusak.add(StockRusak.forDisplay(iS, iP, pC, pN, pU, sR));
            }
        }
        return stockRusak;
    }
    
    public List<String> getSupplierList() throws SQLException {
        List<String> supplierList = new ArrayList<>();
        String querySupplier = "SELECT id_supplier, supp_name FROM supplier";
        
        try(PreparedStatement ps = c.prepareStatement(querySupplier);
            ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                int id = rs.getInt("id_supplier");
                String name = rs.getString("supp_name");
                supplierList.add(id + " - " + name);
            }
        }
        return supplierList;
    }
    
    public int inputStokRusak(StockRusak stockRusak) throws SQLException {
        String insertStokQuery = "INSERT INTO stock (id_product, stok_rusak) VALUES (?, ?)";
        try(PreparedStatement ps = c.prepareStatement(insertStokQuery)) {
            ps.setInt(1, stockRusak.getId_product());
            ps.setInt(2, stockRusak.getStockRusak());
            
            int affectedRows = ps.executeUpdate();
            return affectedRows;
        }
    }
    
    // Untuk Update Stock Rusak
    public int updateStokRusak(StockRusak stockRusak) throws SQLException {
        String updateStokQuery = "UPDATE stock SET stok_rusak = ? WHERE id_stock = ?";
        try(PreparedStatement ps = c.prepareStatement(updateStokQuery)) {
            ps.setInt(1, stockRusak.getStockRusak());
            ps.setInt(2, stockRusak.getId_stock());
            
            int affectedRows = ps.executeUpdate();
            return affectedRows;
        }
    }
    
    
    public List<Product> searchDataProduct(String text, String filter) throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT pr.id_product, pr.id_supplier, sp.supp_name, pr.product_code, pr.product_name, pr.price_buy, pr.price_sell, pr.product_unit FROM product pr JOIN supplier sp ON pr.id_supplier = sp.id_supplier WHERE " + filter + " LIKE ?";
        
        try(PreparedStatement ps = c.prepareStatement(query)) {
                ps.setString(1, "%" + text + "%");
            
            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    int idProduct = rs.getInt("pr.id_product");
                    int idSupplier = rs.getInt("pr.id_supplier");
                    String suppName = rs.getString("sp.supp_name");
                    String code = rs.getString("pr.product_code");
                    String name = rs.getString("pr.product_name");
                    BigDecimal buy = rs.getBigDecimal("pr.price_buy");
                    BigDecimal sell = rs.getBigDecimal("pr.price_sell");
                    String unit = rs.getString("pr.product_unit");

                    products.add(new Product(idProduct, idSupplier, suppName, code, name, buy, sell, unit));
                }
            }
        }
        
        return products;
    }
    
    public List<Product> searchStockProduct(String text, String filter) throws SQLException {
        List<Product> productStock = new ArrayList<>();
        String queryProductStock = "SELECT pr.id_product, pr.id_supplier, sp.supp_name, pr.product_code, pr.product_name, pr.product_unit, COALESCE(pb.total_purchase, 0) as total_purchase, COALESCE(sd.total_sale, 0) as total_sale, COALESCE(s.total_stok_rusak, 0) as total_stok_rusak, COALESCE(pb.total_purchase, 0) - COALESCE(sd.total_sale, 0) - COALESCE(s.total_stok_rusak, 0) as total_stok FROM product pr JOIN supplier sp ON pr.id_supplier = sp.id_supplier LEFT JOIN(SELECT id_product, SUM(purchase_qty) as total_purchase FROM pembelian GROUP BY id_product) pb ON pr.id_product = pb.id_product LEFT JOIN(SELECT id_product, SUM(sale_qty) as total_sale FROM sale_details GROUP BY id_product) sd ON pr.id_product = sd.id_product LEFT JOIN(SELECT id_product, sum(stok_rusak) as total_stok_rusak FROM stock GROUP BY id_product) s ON pr.id_product = s.id_product WHERE " + filter + " LIKE ?";
        
        try(PreparedStatement ps = c.prepareStatement(queryProductStock)) {
                ps.setString(1, "%" + text + "%");
        
            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    int idProduct = rs.getInt("pr.id_product");
                    int idSupplier = rs.getInt("pr.id_supplier");
                    String suppName = rs.getString("sp.supp_name");
                    String code = rs.getString("pr.product_code");
                    String name = rs.getString("pr.product_name");
                    String unit = rs.getString("pr.product_unit");
                    int totalPurchase = rs.getInt("total_purchase");
                    int totalSale = rs.getInt("total_sale");
                    int totalStokRusak = rs.getInt("total_stok_rusak");
                    int totalStok = rs.getInt("total_stok");

                    productStock.add(new Product(idProduct, idSupplier, suppName, code, name, unit, totalPurchase, totalSale, totalStokRusak, totalStok));
                }
            }
            return productStock;
        }
    }

    public void updateStock(int initialStock, int selectedProductId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

    
